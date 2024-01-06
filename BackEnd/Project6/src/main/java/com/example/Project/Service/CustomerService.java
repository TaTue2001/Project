package com.example.Project.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Entity.Account;
import com.example.Project.Entity.Address;
import com.example.Project.Entity.Delivery;
import com.example.Project.Entity.Line;
import com.example.Project.Entity.Order;
import com.example.Project.Entity.Payment;
import com.example.Project.Entity.Product;
import com.example.Project.Entity.RequestBuy;
import com.example.Project.Entity.Condition;
import com.example.Project.Entity.Customer;
import com.example.Project.Interface.Repository.IAccountRepository;
import com.example.Project.Interface.Repository.IAddressRepository;
import com.example.Project.Interface.Repository.IConditionRepository;
import com.example.Project.Interface.Repository.IDeliveryRepository;
import com.example.Project.Interface.Repository.ILineRepository;
import com.example.Project.Interface.Repository.IOrderRepository;
import com.example.Project.Interface.Repository.IPaymentRepository;
import com.example.Project.Interface.Repository.IProductRepository;
import com.example.Project.Interface.Service.ICustomerService;

@Service
public class CustomerService extends BaseService<Customer> implements ICustomerService {
	@Autowired
	private ILineRepository iLineRepository;
	@Autowired
	private IProductRepository iProductRepository;
	@Autowired
	private IAccountRepository iAccountRepository;
	@Autowired
	private IOrderRepository iOrderRepository;
	@Autowired
	private IPaymentRepository iPaymentRepository;
	@Autowired
	private IDeliveryRepository iDeliveryRepository;
	@Autowired
	private IAddressRepository iAddressRepository;
	@Autowired
	private IConditionRepository iConditionRepository;
	@PersistenceContext
	private EntityManager entityManager;

	public String createLine(Line line) {
		Product product = iProductRepository.FindById(Product.class, line.getProductId().toString());
		Optional<Account> optionalAccount = iAccountRepository.findById(line.getAccountId());
		Account account = optionalAccount.orElseThrow();
		Order order = null;
		if (line.getOrderId() != null) {
		 Optional<Order> orderOption = iOrderRepository.findById(line.getOrderId());
		 order=orderOption.orElseThrow();
		}
		if (product != null && account != null) {
			line.setAccount(account);
			line.setProduct(product);
			if (order != null) {
				line.setOrder(order);
				iLineRepository.save(line);
				return ("wait valify order");
			}
			line.setOrder(null);
				iLineRepository.save(line);
			return ("Add product to card success");
		} else {
			return ("Add product to card fail");
		}
	}

	public Order validateOrder(Order order) {
		Payment payment = iPaymentRepository.FindByField(Payment.class, "PaymentName", order.getPaymentName());
		Delivery delivery = iDeliveryRepository.FindByField(Delivery.class, "DeliveryName", order.getDeliveryName());
		Address address = iAddressRepository.FindById(Address.class, order.getAddressId().toString());
		if (payment != null && delivery != null && address != null) {
			Condition condition = iConditionRepository.FindById(Condition.class,"6e23e489-68ad-499d-9ceb-456e3692ba7a");
			order.setAddress(address);
			order.setCondition(condition);
			order.setDelivery(delivery);
			order.setPayment(payment);
			return order;
		}
		return null;
	}
	@Transactional
	public String buyNow(RequestBuy requestBuy) {
		Order order=validateOrder(requestBuy.getOrder());
		Line line=requestBuy.getLine();
		entityManager.persist(order);
		entityManager.flush();
//		UUID orderId = order.getOrderId();
		line.setOrder(order);
		try {
			String rsLine = createLine(line);
			return "buy now success";
		} catch (Exception e) {
			e.printStackTrace();
			return "buy now fail";
		}
	}
	@Transactional
	public String PayItemInCard(Order order, String lineId) {
		try {
			Order order2=validateOrder(order);
			entityManager.persist(order2);
			entityManager.flush();
			UUID lineID=UUID.fromString(lineId);
			Line line=iLineRepository.findById(lineID).get();
			line.setOrder(order);
			iLineRepository.save(line);
			return ("this order waiting verify");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Transactional
//	public String test(Order order,String lineId) {
//		Order order2=validateOrder(order);
//	    entityManager.persist(order2);
//	    entityManager.flush();
//		UUID lineID=UUID.fromString(lineId);
//		Optional<Line> lineOption=iLineRepository.findById(lineID);
//		Line line=lineOption.orElseThrow();
//		line.setOrder(order);
//		iLineRepository.save(line);
//		return ("this order waiting verify");
//	}

	public String CancelOrder(String orderId) {
		try {
			Optional<Order> orderOption = iOrderRepository.findById(UUID.fromString(orderId));
			Order order=orderOption.orElseThrow();
			Condition condition = iConditionRepository.FindById(Condition.class,"84831315-6d99-45bc-a395-605237679376");
			order.setCondition(condition);
			iOrderRepository.save(order);
			return "Cancel success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Cancel false";
	}

}

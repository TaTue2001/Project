package com.example.Project.Interface.Service;

import org.springframework.stereotype.Repository;

import com.example.Project.Entity.Customer;
import com.example.Project.Entity.Line;
import com.example.Project.Entity.Order;
import com.example.Project.Entity.Payment;
import com.example.Project.Entity.RequestBuy;
@Repository
public interface ICustomerService extends IBaseService<Customer> {
	String createLine(Line line);
	Order validateOrder(Order order);
	String buyNow(RequestBuy requestBuy);
	String PayItemInCard(Order order, String LineId);
	String CancelOrder(String orderId );
}

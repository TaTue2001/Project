package com.example.Project.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Address;
import com.example.Project.Entity.Condition;
import com.example.Project.Entity.Customer;
import com.example.Project.Entity.Delivery;
import com.example.Project.Entity.Line;
import com.example.Project.Entity.Order;
import com.example.Project.Entity.Payment;
import com.example.Project.Entity.RequestBuy;
import com.example.Project.Entity.RequestSignUp;
import com.example.Project.Interface.Service.IAccountService;
import com.example.Project.Interface.Service.ICustomerService;
import com.example.Project.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController<Customer> {
	@Autowired
	private ICustomerService iCustomerService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private IAccountService iAccountService;
	
	public CustomerController() {
		super(Customer.class);
	}

	@GetMapping("/details")
	public Customer getDetails(@RequestParam String username) {
		Customer c=null;
		return c;
	}
	@PostMapping("/addtoline")
	public String addItemToCard(@RequestBody Line line) {
		String rs=iCustomerService.createLine(line);
		return rs;
	}
	@PostMapping("/buynow")
	public String buynow(@RequestBody RequestBuy requestBuy) {
		String rs=iCustomerService.buyNow(requestBuy);
		return rs;
	}
	@PostMapping("/payitemincard/{lineId}")
	public String payItem(@RequestBody Order order,@PathVariable String lineId) {
		String rs=iCustomerService.PayItemInCard(order, lineId);
		return rs;
	}
//    @PostMapping("/sign-up-customer")
//    public String signUp(@RequestBody RequestSignUp requestSignUp) {
//    	iAccountService.SignUpEmployee(requestSignUp);
//    	return "SignUp Customer success";
//    }
//	@PostMapping("/test/{lineId}")
//	public String test(@RequestBody Order order,@PathVariable String lineId) {
//		return customerService.test(order,lineId);
//	}
}

package com.example.Project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Payment;

import io.swagger.annotations.Api;

@Api(tags = "Payment")
@RestController
@RequestMapping("/payment")
public class PaymentController  extends BaseController<Payment> {
	public PaymentController() {
		super(Payment.class);
	}
}

package com.example.Project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Order;

import io.swagger.annotations.Api;

@Api(tags = "Order")
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController<Order> {
	public OrderController() {
		super(Order.class);
	}
}
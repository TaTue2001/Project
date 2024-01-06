package com.example.Project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Delivery;

import io.swagger.annotations.Api;

@Api(tags = "Delivery")
@RestController
@RequestMapping("/delivery")
public class DeliveryController  extends BaseController<Delivery> {
	public DeliveryController() {
		super(Delivery.class);
	}
}

package com.example.Project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Rate;

import io.swagger.annotations.Api;

@Api(tags = "Rate")
@RestController
@RequestMapping("/rate")
public class RateController  extends BaseController<Rate> {
	public RateController() {
		super(Rate.class);
	}
}
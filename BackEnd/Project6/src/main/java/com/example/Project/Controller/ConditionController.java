package com.example.Project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Condition;

import io.swagger.annotations.Api;

@Api(tags = "Condition")
@RestController
@RequestMapping("/condition")
public class ConditionController extends BaseController<Condition> {
	public ConditionController() {
		super(Condition.class);
	}
}
package com.example.Project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Delivery;
import com.example.Project.Entity.Rank;

import io.swagger.annotations.Api;

@Api(tags = "Rank")
@RestController
@RequestMapping("/rank")
public class RankController  extends BaseController< Rank> {
	public RankController() {
		super( Rank.class);
	}
}

package com.example.Project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Category;
import com.example.Project.Entity.Line;

import io.swagger.annotations.Api;

@Api(tags = "Line")
@RestController
@RequestMapping("/line")
public class LineController  extends BaseController<Line> {
	public LineController() {
		super(Line.class);
	}
}
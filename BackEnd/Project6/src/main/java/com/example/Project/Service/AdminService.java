package com.example.Project.Service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Entity.Condition;
import com.example.Project.Entity.Line;
import com.example.Project.Entity.Order;
import com.example.Project.Interface.Repository.IConditionRepository;
import com.example.Project.Interface.Repository.ILineRepository;
import com.example.Project.Interface.Repository.IOrderRepository;
import com.example.Project.Interface.Service.IAdminService;

@Service
public class AdminService implements IAdminService {
	@Autowired
	private IOrderRepository iOrderRepository;
	@Autowired
	private IConditionRepository iConditionRepository;
	@Autowired
	private ILineRepository iLineRepository;
	public String SetConditionOfOrder(String OrderId, String ConditionId) {
		try {
			Optional<Order> orderOption = iOrderRepository.findById(UUID.fromString(ConditionId));
			Order order = orderOption.orElseThrow();
			Condition condition = iConditionRepository.FindById(Condition.class, ConditionId);
			order.setCondition(condition);
			iOrderRepository.save(order);
			return "Change Condition Success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void isComplete(String OrderId) {
		try {
			Optional<Line> lineOption=iLineRepository.findById(UUID.fromString(OrderId));
			Line line=lineOption.orElseThrow();
			line.setIsComplete(1);
			iLineRepository.save(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

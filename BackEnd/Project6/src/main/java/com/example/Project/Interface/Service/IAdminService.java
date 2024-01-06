package com.example.Project.Interface.Service;

import org.springframework.stereotype.Repository;

@Repository
public interface IAdminService {
	String SetConditionOfOrder(String OrderId, String ConditionId);
	void isComplete(String OrderId);
}

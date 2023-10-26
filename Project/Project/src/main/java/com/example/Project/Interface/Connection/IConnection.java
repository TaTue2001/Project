package com.example.Project.Interface.Connection;

import java.sql.Connection;

import org.springframework.stereotype.Component;

@Component
public interface IConnection {
	Connection openConnection();
	void closeConnection();
}

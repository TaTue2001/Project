package com.example.Project.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.example.Project.Interface.Connection.IConnection;


@Component
public class ConnectionJDBC implements IConnection{
	Connection connection=null;
	@Override
	public Connection openConnection() {
		
		String url="jdbc:mysql://localhost:3306/misa_web";
		String username="root";
		String password="tue@2001";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, username, password);
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		return connection;
	}

	@Override
	public void closeConnection() {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

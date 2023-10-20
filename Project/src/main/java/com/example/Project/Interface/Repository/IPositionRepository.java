package com.example.Project.Interface.Repository;

import java.util.ArrayList;
import java.util.List;

import com.example.Project.Entity.Position;


public interface IPositionRepository {
	ArrayList <Position> getAll();
	Position getById(String Id);
	int Delete(String Id);
	int Insert(Position position);
	int Update(Position position, String positionId );
	List <Position> FindAll(String entityClass);
}

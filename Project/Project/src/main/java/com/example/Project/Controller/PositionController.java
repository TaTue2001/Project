package com.example.Project.Controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Position;
import com.example.Project.Interface.Connection.IConnection;
import com.example.Project.Interface.Repository.IPositionRepository;

@RestController
@RequestMapping("/position")
public class PositionController {
	@Autowired
	private IPositionRepository repo;
	@Autowired
	private IConnection connect;


	@GetMapping("/all")
	public ArrayList<Position> getAllPosition() {
		ArrayList<Position> positions = new ArrayList<>();
		positions = repo.getAll();
		return positions;
	}

	@GetMapping("/all2")
	public List<Position> getAll() {
		ArrayList<Position> positions = new ArrayList<>();
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = connect.openConnection().createStatement();
			rs = statement.executeQuery("select * from position");
			while (rs.next()) {
				// Nếu datatype của Id UUID, bạn phải getString, sau đó convert thành UUID
				String Id = rs.getString("PositionId");
				UUID positionId = UUID.fromString(Id);
				String positionCode = rs.getString("PositionCode");
				String positionName = rs.getString("PositionName");
				Date createDate = rs.getDate("CreateDate");
				String CreateBy = rs.getString("CreateBy");
				Date modifyDate = rs.getDate("ModifiedDate");
				String modifyBy = rs.getString("ModifiedBy");
				positions.add(new Position(positionId, positionCode, positionName, createDate, CreateBy, modifyDate,
						modifyBy));
			}
			rs.close();
			statement.close();
//			connect.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return positions;
	}

	@GetMapping("/all3")
	public List<Position> getAll2(){
		List<Position> positions=repo.FindAll("Position");
		return positions;
	}	
	@GetMapping("/id/{Id}")
	public Position getPositionById(@PathVariable String Id) {
		Position position = repo.getById(Id);
		return position;
	}

	@DeleteMapping("/delete/{Id}")
	public int Delete(@PathVariable String Id) {
		int a = repo.Delete(Id);
		return a;
	}

	@PostMapping(value = "/post", produces = "application/json")
	public int Insert(@RequestBody Position position) {
		int a = repo.Insert(position);
		return a;
	}
	
	@PutMapping(value = "/put/{Id}", produces = "application/json")
	public int Update(@RequestBody Position position, @PathVariable String Id) {
		int a = repo.Update(position, Id);
		return a;

	}
}

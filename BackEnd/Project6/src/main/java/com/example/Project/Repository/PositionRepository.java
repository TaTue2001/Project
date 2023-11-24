package com.example.Project.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.example.Project.Entity.Position;
import com.example.Project.Interface.Connection.IConnection;
import com.example.Project.Interface.Repository.IPositionRepository;



@Service
public class PositionRepository implements IPositionRepository  {
	@PersistenceContext
	private EntityManager entityManager;
	private IConnection connect;
	public PositionRepository(IConnection connect) {
		this.connect=connect;
	}
	@Override
	public ArrayList<Position> getAll() {
		ArrayList <Position> positions=new ArrayList<>();
		Statement statement=null;
		ResultSet rs=null;
		try {
			statement = connect.openConnection().createStatement();
			rs =statement.executeQuery("select * from position");
			while (rs.next()) {
				//Nếu datatype của Id UUID, bạn phải getString, sau đó convert thành UUID
				String Id = rs.getString("PositionId");
				UUID positionId=UUID.fromString(Id);
				String positionCode = rs.getString("PositionCode");
				String positionName = rs.getString("PositionName");
				Date createDate = rs.getDate("CreateDate");
				String CreateBy=rs.getString("CreateBy");
				Date  modifyDate=rs.getDate("ModifiedDate");
				String modifyBy=rs.getString("ModifiedBy");
				positions.add(new Position(positionId, positionCode, positionName, createDate, CreateBy, modifyDate, modifyBy));
			}
			rs.close();
			statement.close();
			connect.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return positions;
	}
	@Override
	public Position getById(String id) {
		Position position=new Position();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String query="select * from position where PositionId =? ";
			ps = connect.openConnection().prepareStatement(query);
			ps.setString(1, id);
			rs =ps.executeQuery();
			while (rs.next()) {
				//Nếu datatype của Id UUID, bạn phải getString, sau đó convert thành UUID
				String Id = rs.getString("PositionId");
				UUID positionId=UUID.fromString(Id);
				String positionCode = rs.getString("PositionCode");
				String positionName = rs.getString("PositionName");
				Date createDate = rs.getDate("CreateDate");
				String CreateBy=rs.getString("CreateBy");
				Date  modifyDate=rs.getDate("ModifiedDate");
				String modifyBy=rs.getString("ModifiedBy");
				position=new Position(positionId, positionCode, positionName, createDate, CreateBy, modifyDate, modifyBy);
			}
			rs.close();
			ps.close();
			connect.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return position;
	}
	@Override
	public int Delete(String Id) {
		PreparedStatement ps=null;
		int rs=0;
		try {
			String query="delete from position where PositionId =? ";
			ps = connect.openConnection().prepareStatement(query);
			ps.setString(1, Id);
			rs =ps.executeUpdate();
			
			ps.close();
			connect.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public int Insert( Position position) {
		PreparedStatement ps=null;
		int rs=0;
		try {
			UUID positionId=UUID.randomUUID();
			String query="Insert into misa_web.position(PositionId,PositionCode, PositionName,CreateDate,CreateBy,ModifiedDate,ModifiedBy) values(?,?,?,?,?,?,?)" ;
//			"Call AddPosition (?,?,?,?,?,?)"
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Date createDate=position.getCreateDate();
			String stCreateDate=null;
			if (createDate!=null) {
				stCreateDate =dateFormat.format(createDate);
			}	

			Date modifyDate=position.getModifiedDate();
			String stModifyDate=null;
			if (modifyDate!=null) {
				stModifyDate =dateFormat.format(modifyDate);
			}
			ps = connect.openConnection().prepareStatement(query);
			ps.setString(1, positionId.toString());
			ps.setString(2, position.getPositionCode());
			ps.setString(3, position.getPositionName());
			ps.setString(4, stCreateDate);
			ps.setString(5,position.getCreateBy());
			ps.setString(6,stModifyDate);
			ps.setString(7, position.getModifiedBy());
			rs =ps.executeUpdate();
			
			ps.close();
			connect.closeConnection();
		}
		catch(Exception e) {
			e.printStackTrace();;
		}
		return rs;
	}
	
	@Override
	public int Update(Position position, String positionId) {
		PreparedStatement ps=null;
		int rs=0;
		try {
			String query="Call UpdatePosition (?,?,?,?,?,?,?)" ;	
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Date createDate=position.getCreateDate();
			String stCreateDate=null;
			if (createDate!=null) {
				stCreateDate =dateFormat.format(createDate);
			}

			Date modifyDate=position.getModifiedDate();
			String stModifyDate=null;
			if (modifyDate!=null) {
				stModifyDate =dateFormat.format(modifyDate);
			}
			ps = connect.openConnection().prepareStatement(query);
			ps.setString(1, positionId);
			ps.setString(2, position.getPositionCode());
			ps.setString(3, position.getPositionName());
			ps.setString(4, stCreateDate);
			ps.setString(5,position.getCreateBy());
			ps.setString(6,stModifyDate);
			ps.setString(7, position.getModifiedBy());
			rs =ps.executeUpdate();
			
			ps.close();
			connect.closeConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public List<Position> FindAll(String entityClass) {
		String query = "from " + entityClass;
		List<Position> list = entityManager.createQuery(query).getResultList();
		return list;
	}
}

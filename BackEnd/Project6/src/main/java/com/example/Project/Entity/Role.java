package com.example.Project.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "Role")
public class Role {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID RoleId;
	private int RoleCode;
	private String RoleName;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	@ManyToMany(mappedBy = "Roles")
	@Fetch(value = FetchMode.SELECT)
	@JsonIgnore
	private Set<Account> Account=new HashSet<>();
	
	public Role() {
	}

	public Role(UUID roleId, int roleCode, String roleName, Date createDate, String createBy, Date modifiedDate,
			String modifiedBy, Set<Account> account) {
		super();
		RoleId = roleId;
		RoleCode = roleCode;
		RoleName = roleName;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
		this.Account = account;
	}

	public UUID getRoleId() {
		return RoleId;
	}

	public void setRoleId(UUID roleId) {
		RoleId = roleId;
	}

	public int getRoleCode() {
		return RoleCode;
	}

	public void setRoleCode(int roleCode) {
		RoleCode = roleCode;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public String getCreateBy() {
		return CreateBy;
	}

	public void setCreateBy(String createBy) {
		CreateBy = createBy;
	}

	public Date getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return ModifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}

	public Set<Account> getAccount() {
		return Account;
	}

	public void setAccount(Set<Account> account) {
		this.Account = account;
	}

	
}

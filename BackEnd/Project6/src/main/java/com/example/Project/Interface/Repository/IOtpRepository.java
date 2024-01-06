package com.example.Project.Interface.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Project.Entity.OtpEntity;
@Repository
public interface IOtpRepository extends CrudRepository<OtpEntity, String>{

}

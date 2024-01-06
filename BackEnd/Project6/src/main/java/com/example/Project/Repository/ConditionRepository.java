package com.example.Project.Repository;

import org.springframework.stereotype.Service;

import com.example.Project.Entity.Condition;
import com.example.Project.Interface.Repository.IConditionRepository;
@Service
public class ConditionRepository extends BaseRepository<Condition> implements IConditionRepository {

}

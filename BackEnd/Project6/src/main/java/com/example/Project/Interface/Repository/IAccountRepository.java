package com.example.Project.Interface.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Project.Entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, UUID> {
}

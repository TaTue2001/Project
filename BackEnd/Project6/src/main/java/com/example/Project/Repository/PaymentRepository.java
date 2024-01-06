package com.example.Project.Repository;

import org.springframework.stereotype.Service;

import com.example.Project.Entity.Payment;
import com.example.Project.Interface.Repository.IPaymentRepository;
@Service
public class PaymentRepository extends BaseRepository<Payment> implements IPaymentRepository {

}

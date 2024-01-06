package com.example.Project.Repository;

import org.springframework.stereotype.Service;

import com.example.Project.Entity.Delivery;
import com.example.Project.Interface.Repository.IDeliveryRepository;
@Service
public class DeliveryRepository extends BaseRepository<Delivery> implements IDeliveryRepository {

}

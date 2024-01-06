package com.example.Project.Repository;

import org.springframework.stereotype.Service;

import com.example.Project.Entity.Address;
import com.example.Project.Interface.Repository.IAddressRepository;

@Service
public class AddressRepository extends BaseRepository< Address> implements IAddressRepository {

}

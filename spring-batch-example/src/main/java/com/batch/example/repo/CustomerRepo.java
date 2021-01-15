package com.batch.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batch.example.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}

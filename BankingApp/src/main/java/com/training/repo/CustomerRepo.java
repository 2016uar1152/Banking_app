package com.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}

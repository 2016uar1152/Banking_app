package com.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

}

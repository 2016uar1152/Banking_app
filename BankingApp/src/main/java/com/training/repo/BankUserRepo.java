package com.training.repo;

import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.entity.BankUser;

@Repository
public interface BankUserRepo extends JpaRepository<BankUser, String>{
	
}

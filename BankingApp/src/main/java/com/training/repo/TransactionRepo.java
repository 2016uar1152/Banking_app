package com.training.repo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.entity.Account;
import com.training.entity.Transaction;


@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	
	@Query("from Transaction t where ((t.date >= :fromdate) and (t.date<= :todate)) and ( (t.from_account_no = :accno) or (t.to_account_no = :accountno) )")
	List<Transaction> findByDateBetween(@Param("fromdate") LocalDate fromDate, @Param("todate") LocalDate toDate, @Param("accno") long accountNo1, @Param("accountno") long accountNo2);
}
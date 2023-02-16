package com.kurovskyiartem.repository;

import com.kurovskyiartem.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
}

package com.kurovskyiartem.repository;

import com.kurovskyiartem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

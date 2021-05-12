package com.group.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}

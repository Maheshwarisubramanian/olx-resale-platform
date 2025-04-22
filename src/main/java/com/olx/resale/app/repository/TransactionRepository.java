package com.olx.resale.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olx.resale.app.entity.TransactionEntity;


@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}

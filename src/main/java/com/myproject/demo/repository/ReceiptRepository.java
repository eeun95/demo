package com.myproject.demo.repository;

import com.myproject.demo.domain.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
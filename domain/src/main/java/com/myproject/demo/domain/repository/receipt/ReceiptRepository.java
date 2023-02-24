package com.myproject.demo.domain.repository.receipt;

import com.myproject.demo.domain.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long>, ReceiptRepositoryCustom {

}

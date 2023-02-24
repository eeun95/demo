package com.myproject.demo.domain.repository.receipt;

import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReceiptRepositoryCustom {

    List showHotMenu(@Param("before") LocalDateTime before, @Param("now") LocalDateTime now);
}

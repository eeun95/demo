package com.myproject.demo.repository.Receipt;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReceiptRepositoryCustom {

    List showHotMenu(@Param("before") LocalDateTime before, @Param("now") LocalDateTime now);
}

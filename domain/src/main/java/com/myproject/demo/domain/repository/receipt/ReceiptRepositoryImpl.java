package com.myproject.demo.domain.repository.receipt;

import com.myproject.demo.domain.entity.Orders;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.List;

import static com.myproject.demo.domain.QOrders.orders;
import static com.myproject.demo.domain.QReceipt.receipt;

public class ReceiptRepositoryImpl implements ReceiptRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ReceiptRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List showHotMenu(LocalDateTime before, LocalDateTime now) {

        List<Orders> ordersList = queryFactory.selectFrom(orders)
                .where(orders.orderDate.between(before, now))
                .fetch();

        List<String> list = queryFactory
                .select(receipt.coffeeName)
                .from(receipt)
                .where(receipt.orders.in(ordersList))
                .groupBy(receipt.coffeeName)
                .orderBy(receipt.count.sum().asc())
                .limit(3)
                .fetch();

        return list;
    }
}

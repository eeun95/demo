package com.myproject.demo.service;

import com.myproject.demo.domain.Menu.Coffee;
import com.myproject.demo.domain.Menu.CoffeeCategory;
import com.myproject.demo.domain.Orders;
import com.myproject.demo.repository.MenuRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static com.myproject.demo.domain.QOrders.orders;
import static com.myproject.demo.domain.QReceipt.receipt;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MenuServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    MenuRepository menuRepository;

    JPAQueryFactory queryFactory;

    @BeforeEach
    public void before() {
        queryFactory = new JPAQueryFactory(em);
    }

    @Test
    void 커피_메뉴_조회() {
        List<Coffee> coffeeList = menuRepository.findAll();
        assertThat(coffeeList.size()).isEqualTo(CoffeeCategory.class.getFields().length);
    }

    @Test
    void 인기_메뉴_조회() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime before = LocalDateTime.now().minusDays(7);

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


        assertThat(list.size()).isEqualTo(3);
    }
}
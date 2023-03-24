package com.myproject.demo.domain.repository;

import com.myproject.demo.domain.entity.menu.HotMenu;
import org.springframework.data.repository.CrudRepository;

public interface HotMenuRedisRepository extends CrudRepository<HotMenu, String> {

}

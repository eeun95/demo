package com.myproject.demo.application.service;

import com.myproject.demo.domain.entity.menu.Coffee;

import java.util.List;

public interface MenuServiceInterface {

    List<Coffee> show();

    List<String> hot();

}

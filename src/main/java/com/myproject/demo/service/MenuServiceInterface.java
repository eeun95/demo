package com.myproject.demo.service;

import com.myproject.demo.domain.Menu.Coffee;

import java.util.List;

public interface MenuServiceInterface {

    List<Coffee> show();
    List<String> hot();

}

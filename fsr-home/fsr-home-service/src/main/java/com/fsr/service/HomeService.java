package com.fsr.service;

import com.fsr.domain.Category;
import com.fsr.domain.Home;

import java.util.List;

/**
 * Created by Hasee on 2017/5/11.
 */
public interface HomeService {
    List<Home> getAllHomes();

    Home getHomeById(Long id);
}

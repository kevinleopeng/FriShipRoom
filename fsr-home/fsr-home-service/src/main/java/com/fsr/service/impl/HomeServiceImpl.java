package com.fsr.service.impl;

import com.fsr.domain.Home;
import com.fsr.repository.mybatis.HomeMapper;
import com.fsr.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hasee on 2017/5/11.
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper homeMapper;

    @Override
    public List<Home> getAllHomes() {
        return this.homeMapper.getAllHomes();
    }

    @Override
    public Home getHomeById(Long id) {
        return homeMapper.getHomeById(id);
    }

    public HomeServiceImpl(){
        System.out.println("homeservice init");
    }
}

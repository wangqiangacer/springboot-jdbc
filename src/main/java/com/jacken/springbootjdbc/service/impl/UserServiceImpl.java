package com.jacken.springbootjdbc.service.impl;

import com.jacken.springbootjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void findUser() {
        String sql="select * from t_user";
        List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql);
        System.out.println(queryForList);
    }
}

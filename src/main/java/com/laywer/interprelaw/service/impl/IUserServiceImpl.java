package com.laywer.interprelaw.service.impl;

import com.laywer.interprelaw.mapper.UserMapper;
import com.laywer.interprelaw.model.User;
import com.laywer.interprelaw.model.UserExample;
import com.laywer.interprelaw.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userservice")
public class IUserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User checkUser(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());

        List<User> users = userMapper.selectByExample(userExample);
        if (users.isEmpty()){
            return null;
        }else if (users.size() == 1){
            return users.get(0);
        }
        return null;
    }

    @Override
    public int register(User user) {
        //默认权限
        user.setRid(0);
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User selectById(int userId) {
        return null;
    }
}

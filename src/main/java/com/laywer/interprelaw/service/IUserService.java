package com.laywer.interprelaw.service;

import com.laywer.interprelaw.model.User;

public interface IUserService {
    public User checkUser(User user);

    public int register(User user);

    public int update(User user);

    public User selectById(int userId);
}

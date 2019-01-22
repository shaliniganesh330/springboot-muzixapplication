package com.stackroute.service;

import com.stackroute.domain.User;

import java.util.List;

public interface MuzixService {

    public User saveUser(User user);

    public List<User> getAllUsers();

    public List<User> deleteById(int trackId);

    public User updateUser(User user);}

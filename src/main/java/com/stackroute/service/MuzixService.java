package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface MuzixService {

    public User saveUser(User user) throws TrackAlreadyExistsException;

    public List<User> getAllUsers() ;

    public List<User> deleteById(int trackId) throws TrackNotFoundException;

    public User updateUser(User user) ;

    public User findTrackByName(String trackName);
}

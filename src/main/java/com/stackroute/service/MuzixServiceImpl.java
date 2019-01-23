package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuzixServiceImpl implements MuzixService {
    private MuzixRepository muzixRepository;

    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository){
        this.muzixRepository=muzixRepository;
    }
    @Override
    public User saveUser(User user) throws TrackAlreadyExistsException {
        if(muzixRepository.existsById(user.getTrackId())){
            throw new TrackAlreadyExistsException("User already exists");
        }
        User savedUser = muzixRepository.save(user);
        if(savedUser == null){
            throw new TrackAlreadyExistsException("User already exists");
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return muzixRepository.findAll();
    }

    @Override
    public List<User> deleteById(int trackId) throws TrackNotFoundException {
        if(trackId==0){
        throw new TrackNotFoundException("User not found");}
        muzixRepository.deleteById(trackId);
        return muzixRepository.findAll();
    }
    @Override
    public User updateUser(User user){
        User updateUser = muzixRepository.save(user);
        return updateUser;
    }
    @Override
    public User findTrackByName(String trackName){
        User findTrackByName = muzixRepository.findTrackByName(trackName);
        return findTrackByName;
    }
}

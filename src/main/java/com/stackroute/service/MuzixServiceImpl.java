package com.stackroute.service;

import com.stackroute.domain.Track;
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
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(muzixRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track savedTrack = muzixRepository.save(track);
        if(savedTrack == null){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return muzixRepository.findAll();
    }

    @Override
    public void deleteById(String trackId) throws TrackNotFoundException {
        int temp = new Integer(trackId);
        if(!muzixRepository.existsById(temp)){
        throw new TrackNotFoundException("Track not found");
        }
         muzixRepository.deleteById(temp);
    }
    @Override
    public Track updateTrack(Track track){
        Track updateTrack = muzixRepository.save(track);
        return updateTrack;
    }
    @Override
    public Track findTrackByName(String trackName){
        Track findTrackByName = muzixRepository.findTrackByName(trackName);
        return findTrackByName;
    }
}

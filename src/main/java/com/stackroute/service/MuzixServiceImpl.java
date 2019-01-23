package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceImpl implements MuzixService {
    //Created a variable of MuzixRepository//
    private MuzixRepository muzixRepository;

    //Autowired the constructor//
    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository) {
        this.muzixRepository = muzixRepository;
    }

    //Overrided method for saving all tracks//
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (muzixRepository.existsById(track.getTrackId())) {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track savedTrack = muzixRepository.save(track);
        if (savedTrack == null) {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return savedTrack;
    }

    //Overriden method to get all the tracks//
    @Override
    public List<Track> getAllTracks() throws TrackNotFoundException {
        if (muzixRepository.findAll().isEmpty()) {
            throw new TrackNotFoundException("No tracks available");
        }
        return muzixRepository.findAll();
    }

    //Overided method for deleteById//
    @Override
    public void deleteById(String trackId) throws TrackNotFoundException {
        int temp = new Integer(trackId);
        if (!muzixRepository.existsById(temp)) {
            throw new TrackNotFoundException("Track not found");
        }
        muzixRepository.deleteById(temp);
    }

    //Overrided method for updateTrack //
    @Override
    public Track updateTrack(int trackId, String comment) throws TrackNotFoundException {
        if (muzixRepository.findById(trackId).isEmpty()) {
            throw new TrackNotFoundException("Track not found to update");
        }
        Optional<Track> muzix = muzixRepository.findById(trackId);
        Track muzix1 = muzix.get();
        muzix1.setTrackComments(comment);
        Track savedMuzix = muzixRepository.save(muzix1);
        return savedMuzix;
    }

    //Overrided method for findTrackByName//
    @Override
    public Track findTrackByName(String trackName) {
        Track findTrackByName = muzixRepository.findTrackByName(trackName);
        return findTrackByName;
    }
}

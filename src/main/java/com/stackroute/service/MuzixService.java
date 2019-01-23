package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import java.util.List;

public interface MuzixService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> getAllTracks() throws TrackNotFoundException;
    public void deleteById(String trackId) throws TrackNotFoundException;
    public Track updateTrack(int trackId,String trackComments) throws TrackNotFoundException;
    public Track findTrackByName(String trackName);
}

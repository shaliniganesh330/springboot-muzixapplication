package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {
    @Id
    private int trackId;
    private  String trackName;
    private  String trackComments;
//    public int getTrackId() {
//        return trackId;
//    }
//
//    public void setTrackId(int trackId) {
//        this.trackId = trackId;
//    }
//    //constructor class//
//    public Track()
//    {
//
//    }
//
//    public Track(int trackId, String trackName, String trackComments) {
//        this.trackId = trackId;
//        this.trackName = trackName;
//        this.trackComments = trackComments;
//    }
//    //Overriding toString method//
//    @Override
//    public String toString() {
//        return "Track{" +
//                "trackId=" + trackId +
//                ", trackName='" + trackName + '\'' +
//                ", trackComments='" + trackComments + '\'' +
//                '}';
//    }
//    //setter and getter methods//
//    public String getTrackName() {
//        return trackName;
//    }
//
//    public void setTrackName(String trackName) {
//        this.trackName = trackName;
//    }
//
//    public String getTrackComments() {
//        return trackComments;
//    }
//
//    public void setTrackComments(String trackComments) {
//        this.trackComments = trackComments;
//    }
}
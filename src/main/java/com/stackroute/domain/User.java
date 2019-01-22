package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    int trackId;
    String trackName;
    String trackComments;
//    public int getTrackId() {
//        return trackId;
//    }
//
//    public void setTrackId(int trackId) {
//        this.trackId = trackId;
//    }
//    //constructor class//
//    public User()
//    {
//
//    }
//
//    public User(int trackId, String trackName, String trackComments) {
//        this.trackId = trackId;
//        this.trackName = trackName;
//        this.trackComments = trackComments;
//    }
//    //Overriding toString method//
//    @Override
//    public String toString() {
//        return "User{" +
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
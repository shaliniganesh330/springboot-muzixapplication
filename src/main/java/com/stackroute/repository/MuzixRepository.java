package com.stackroute.repository;

import com.stackroute.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MuzixRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT m FROM User m where m.trackName = ?1")
    public User findTrackByName(String trackName);
}



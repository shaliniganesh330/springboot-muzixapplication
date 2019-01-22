package com.stackroute.repository;

import com.stackroute.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuzixRepository extends JpaRepository<User,Integer> {

}



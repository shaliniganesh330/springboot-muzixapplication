package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.service.MuzixService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/muzix")
public class MuzixController {
    MuzixService muzixService;

    public MuzixController(MuzixService muzixService){
        this.muzixService=muzixService;
    }
    //Saving track information such as trackId,trackcomments,trackname//
    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        try {
            muzixService.saveUser(user);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    //Displaying saved track.//
    @GetMapping("users")
    public ResponseEntity<?> getAllUsers() {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<List<User>>(muzixService.getAllUsers(),HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //Removing track.//
    @DeleteMapping("user/{trackId}")
    public ResponseEntity<?> deleteById(@PathVariable int trackId) {
        ResponseEntity responseEntity;
        try {
            muzixService.deleteById(trackId);
            responseEntity = new ResponseEntity<List<User>>(muzixService.getAllUsers(),HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //Update track.//
    @PutMapping("update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        try {
            muzixService.updateUser(user);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}

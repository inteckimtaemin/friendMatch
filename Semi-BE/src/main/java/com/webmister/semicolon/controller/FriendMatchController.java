package com.webmister.semicolon.controller;

import com.webmister.semicolon.request.FriendMatchRequest;
import com.webmister.semicolon.service.FriendMatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class FriendMatchController {
    final FriendMatchService friendMatchService;

    public FriendMatchController(FriendMatchService friendMatchService){
        this.friendMatchService = friendMatchService;
    }

    @PostMapping("/friend/friendMatch/{postFriendNickname}")
    public ResponseEntity<Boolean> friendMatch(@PathVariable("postFriendNickname") String postFriendNickname,
                                                   @RequestBody FriendMatchRequest friendMatchRequest) {
        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");
        try {
            friendMatchService.FriendMatchSave(postFriendNickname, friendMatchRequest);
        }catch (Exception e){
            return new ResponseEntity<>(Boolean.FALSE, resHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(Boolean.TRUE, resHeaders, HttpStatus.OK);
    }

    @DeleteMapping("/friend/friendDelete/{postFriendNickname}")
    public ResponseEntity<Boolean> friendDelete(@PathVariable("postFriendNickname") String postFriendNickname,
                                               @RequestBody FriendMatchRequest friendMatchRequest) {
        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");
        try {
            friendMatchService.FriendMatchDelete(postFriendNickname, friendMatchRequest);
        }catch (Exception e){
            return new ResponseEntity<>(Boolean.FALSE, resHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<>(Boolean.TRUE, resHeaders, HttpStatus.OK);
    }
}

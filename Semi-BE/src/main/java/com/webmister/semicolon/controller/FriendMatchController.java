package com.webmister.semicolon.controller;

import com.webmister.semicolon.domain.FriendMatch;
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

    @PostMapping("/friend/friendMatch/{postFriendId}")
    public ResponseEntity<FriendMatch> friendMatch(@PathVariable("postFriendId") Long postFriendId,
                                                   @RequestBody FriendMatchRequest friendMatchRequest) {
        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");
        FriendMatch friendMatch = friendMatchService.FriendMatchSave(postFriendId, friendMatchRequest);
        return new ResponseEntity<>(friendMatch, resHeaders, HttpStatus.OK);
    }
}

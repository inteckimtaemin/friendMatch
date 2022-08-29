package com.webmister.semicolon.service;

import com.webmister.semicolon.domain.FriendMatch;
import com.webmister.semicolon.domain.UserInfo;
import com.webmister.semicolon.repository.FriendMatchRepository;
import com.webmister.semicolon.repository.UserInfoRepository;
import com.webmister.semicolon.request.FriendMatchRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendMatchService {
    final FriendMatchRepository friendMatchRepository;

    final UserInfoRepository userInfoRepository;

    public FriendMatchService(FriendMatchRepository friendMatchRepository, UserInfoRepository userInfoRepository)  {
        this.friendMatchRepository = friendMatchRepository;
        this.userInfoRepository = userInfoRepository;
    }

//    @Transactional
    public FriendMatch FriendMatchSave(Long userInfoId, FriendMatchRequest friendMatchRequest){
            UserInfo postFriendId = userInfoRepository.findUserInfoByUserInfoId(userInfoId);
            UserInfo receiveFriendId = userInfoRepository.findUserInfoByUserNickName(friendMatchRequest.getReceiveFriendNickname());
            return friendMatchRepository.save(FriendMatch.builder()
                    .postFriendId(postFriendId)
                    .receiveFriend(receiveFriendId)
                    .friendStatus(friendMatchRequest.getFriendStatus())
                    .build());
    }


}
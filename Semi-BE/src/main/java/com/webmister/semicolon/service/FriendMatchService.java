package com.webmister.semicolon.service;

import com.webmister.semicolon.domain.FriendMatch;
import com.webmister.semicolon.domain.UserInfo;
import com.webmister.semicolon.enumclass.FriendStatus;
import com.webmister.semicolon.repository.FriendMatchRepository;
import com.webmister.semicolon.repository.UserInfoRepository;
import com.webmister.semicolon.request.FriendMatchRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FriendMatchService {
    final FriendMatchRepository friendMatchRepository;

    final UserInfoRepository userInfoRepository;

    public FriendMatchService(FriendMatchRepository friendMatchRepository, UserInfoRepository userInfoRepository)  {
        this.friendMatchRepository = friendMatchRepository;
        this.userInfoRepository = userInfoRepository;
    }

    public Boolean FriendMatchSave(String userInfoNickname, FriendMatchRequest friendMatchRequest){
            UserInfo postFriend = userInfoRepository.findUserInfoByUserNickName(userInfoNickname);
            UserInfo receiveFriend = userInfoRepository.findUserInfoByUserNickName(friendMatchRequest.getReceiveFriendNickname());
            FriendStatus friendStatus = friendMatchRequest.getFriendStatus();
            try {
                friendMatchRepository.save(FriendMatch.builder()
                        .postFriendId(postFriend)
                        .receiveFriendId(receiveFriend)
                        .friendStatus(friendStatus)
                        .build());
            }catch (Exception e){
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
    }

    public Boolean FriendMatchDelete(String userInfoNickname, FriendMatchRequest friendMatchRequest){
        UserInfo postFriend = userInfoRepository.findUserInfoByUserNickName(userInfoNickname);
        UserInfo receiveFriend = userInfoRepository.findUserInfoByUserNickName(friendMatchRequest.getReceiveFriendNickname());
        FriendStatus friendStatus = friendMatchRequest.getFriendStatus();
        try {
            if (friendStatus == FriendStatus.UNFOLLOW) {
                Long unFollow = friendMatchRepository.findFriendMatchByPostFriendIdAndReceiveFriendId(postFriend, receiveFriend).getFriendMatchId();
                friendMatchRepository.deleteById(unFollow);
            }
        }catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public List<UserInfo> FriendList(String userNickname){
        Long postFriendId = userInfoRepository.findUserInfoByUserNickName(userNickname).getUserInfoId();
        List<FriendMatch> allFriendMatchList = friendMatchRepository.findAll();
        List<UserInfo> friendMatchList = new ArrayList<>();
        for(FriendMatch friendMatch : allFriendMatchList){
            if(friendMatch.getFriendMatchId() == friendMatchRepository.findByPostFriendId(postFriendId).getFriendMatchId()){
                friendMatchList.add(friendMatch.getReceiveFriendId());
            }
        }
        return friendMatchList;
    }


}
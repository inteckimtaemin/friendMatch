package com.webmister.semicolon.service;

import com.webmister.semicolon.domain.FriendMatch;
import com.webmister.semicolon.domain.UserInfo;
import com.webmister.semicolon.enumclass.FriendStatus;
import com.webmister.semicolon.repository.FriendMatchRepository;
import com.webmister.semicolon.repository.UserInfoRepository;
import com.webmister.semicolon.request.FriendMatchRequest;
import org.springframework.stereotype.Service;

@Service
public class FriendMatchService {
    final FriendMatchRepository friendMatchRepository;

    final UserInfoRepository userInfoRepository;

    public FriendMatchService(FriendMatchRepository friendMatchRepository, UserInfoRepository userInfoRepository)  {
        this.friendMatchRepository = friendMatchRepository;
        this.userInfoRepository = userInfoRepository;
    }


//    @Transactional
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
                Long unFollow = friendMatchRepository.findFriendMatchByPostFriendIdAndReceiveFriendId(postFriend.getUserInfoId(), receiveFriend.getUserInfoId()).getFriendMatchId();
                friendMatchRepository.deleteById(unFollow);
            }
        }catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


}
package com.webmister.semicolon.repository;

import com.webmister.semicolon.domain.FriendMatch;
import com.webmister.semicolon.domain.UserInfo;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendMatchRepository extends JpaRepository<FriendMatch, Long> {
    FriendMatch findFriendMatchByPostFriendIdAndReceiveFriendId(Long postFriendId, Long receiveFriendId);
}

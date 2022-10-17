package org.tinder.api;

import org.tinder.model.Message;
import org.tinder.model.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Controller
public class TinderApiController implements TinderApi {

    private final NativeWebRequest request;

    @Autowired
    public TinderApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<User> addUser(User user) {
        return TinderApi.super.addUser(user);
    }

    @Override
    public ResponseEntity<Void> deleteMessage(Long userId, Long matchId, Long messageId, Message message) {
        return TinderApi.super.deleteMessage(userId, matchId, messageId, message);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        return TinderApi.super.deleteUser(userId);
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers(List<String> gender, Integer ageRangeStart, Integer ageRangeEnd, List<String> tags) {
        return TinderApi.super.getAllUsers(gender, ageRangeStart, ageRangeEnd, tags);
    }

    @Override
    public ResponseEntity<Object> getMatchForUser(Long userId, Long matchId) {
        return TinderApi.super.getMatchForUser(userId, matchId);
    }

    @Override
    public ResponseEntity<List<Object>> getMatchesForUser(Long userId) {
        return TinderApi.super.getMatchesForUser(userId);
    }

    @Override
    public ResponseEntity<User> getUser(Long userId) {
        return TinderApi.super.getUser(userId);
    }

    @Override
    public ResponseEntity<Void> loginUser(String login, String password) {
        return TinderApi.super.loginUser(login, password);
    }

    @Override
    public ResponseEntity<Void> logoutUser() {
        return TinderApi.super.logoutUser();
    }

    @Override
    public ResponseEntity<User> postLike(Long userId, Long likedUserId, Boolean likeStatus) {
        return TinderApi.super.postLike(userId, likedUserId, likeStatus);
    }

    @Override
    public ResponseEntity<Void> postMessage(Long userId, Long matchId, Message message) {
        return TinderApi.super.postMessage(userId, matchId, message);
    }

    @Override
    public ResponseEntity<Object> unmatchUser(Long userId, Long matchId) {
        return TinderApi.super.unmatchUser(userId, matchId);
    }

    @Override
    public ResponseEntity<User> updateUser(Long userId, User user) {
        return TinderApi.super.updateUser(userId, user);
    }
}

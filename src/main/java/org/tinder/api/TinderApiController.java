package org.tinder.api;

import org.springframework.web.bind.annotation.RestController;
import org.tinder.model.Message;
import org.tinder.model.UserEntity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.tinder.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class TinderApiController implements TinderApi {
    private final UserService userService;
    private final NativeWebRequest request;

    @Autowired
    public TinderApiController(UserService userService, NativeWebRequest request) {
        this.userService = userService;
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<UserEntity> addUser(UserEntity user) {
        return this.userService.addUser(user);
    }

    @Override
    public ResponseEntity<Void> deleteMessage(Long userId, Long matchId, Long messageId, Message message) {
        return TinderApi.super.deleteMessage(userId, matchId, messageId, message);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        return this.userService.deleteUser(userId);
    }

    @Override
    public ResponseEntity<Iterable<UserEntity>> getAllUsers(String gender,
                                                            Integer ageRangeStart,
                                                            Integer ageRangeEnd,
                                                            List<String> tags) {
        System.out.println(request.getParameterMap().toString());
        URI uri = new URI("http", null, "fedozvpn.duckdns.org", 8090, "/api/collections/users/records", request.getParameterMap().toString() , null);
//
//        HttpEntity<String> entity = new HttpEntity<>(req);
//
//        try {
//            ResponseEntity<String> responseEntity =
//                    restTemplate.exchange(uri, method, entity, String.class);
//            return responseEntity;
//        } catch (HttpClientErrorException ex) {
//            return ResponseEntity
//                    .status(ex.getStatusCode())
//                    .headers(ex.getResponseHeaders())
//                    .body(ex.getResponseBodyAsString());
//        }
        return this.userService.getAllUsers(gender, ageRangeStart, ageRangeEnd, tags);
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
    public ResponseEntity<UserEntity> getUser(Long userId) {
        return this.userService.getUserById(userId);
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
    public ResponseEntity<UserEntity> postLike(Long userId, Long likedUserId, Boolean likeStatus) {
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
    public ResponseEntity<UserEntity> updateUser(Long userId, UserEntity user) {
        return TinderApi.super.updateUser(userId, user);
    }
}

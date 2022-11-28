package org.tinder.api;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tinder.model.Message;
import org.tinder.model.UserEntity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.tinder.service.ProxyService;
import org.tinder.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class TinderApiController implements TinderApi {
    private final UserService userService;
    private final NativeWebRequest request;

    @Autowired
    ProxyService service;

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
    public ResponseEntity<Void> deleteUser(@Parameter(name = "userId", description = "ID of user", required = true) @PathVariable("userId") String userId, HttpMethod method, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {

        return this.service.processProxyRequestDelete(method,request,response, userId);
    }

    @Override
    public ResponseEntity<String> getAllUsers(
                                       HttpMethod method, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {
        return this.service.processProxyRequest(method,request,response);
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
    public ResponseEntity<String> getUser(String userId, HttpMethod method, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {
        return this.service.processProxyRequestGet(method,request,response,userId);
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

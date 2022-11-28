package org.tinder.api;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class TinderApiController implements TinderApi {
    private final UserService userService;
    private final NativeWebRequest request;

    @Autowired
    ProxyService proxyService;

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
    public ResponseEntity<String> addUser(String user,
                                              HttpMethod method, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {
        return this.proxyService.processProxyCreateUser(user, method, request, response);
    }

    @Override
    public ResponseEntity<Void> deleteMessage(Long userId, Long matchId, Long messageId, Message message) {
        return TinderApi.super.deleteMessage(userId, matchId, messageId, message);
    }

    @Override
    public ResponseEntity<Void> deleteUser(@Parameter(name = "userId", description = "ID of user", required = true) @PathVariable("userId") String userId, HttpMethod method, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {

        return this.proxyService.processProxyRequestDelete(method,request,response, userId);
    }

    @Override
    public ResponseEntity<String> getAllUsers(
            @Parameter(name = "preffered_gender", description = "Gender to filter by") @Valid @RequestParam(value = "gender", required = false) String gender,
            @Parameter(name = "preferred_age_start", description = "") @Valid @RequestParam(value = "age_range_start", required = false) Integer ageRangeStart,
            @Parameter(name = "preferred_age_end", description = "") @Valid @RequestParam(value = "age_range_end", required = false) Integer ageRangeEnd,
            @Parameter(name = "tags", description = "") @Valid @RequestParam(value = "tags", required = false) List<String> tags,
            HttpMethod method, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {
        return this.proxyService.processProxyRequest(method,request,response);
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
        return this.proxyService.processProxyRequestGet(method,request,response,userId);
    }

    @Override
    public ResponseEntity<String> loginUser(String body, HttpMethod method, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {
        // here is auth with password
        return this.proxyService.processProxyAuthWithPassword(body, method, request, response);
//        return TinderApi.super.loginUser(login, password);
    }


    //TODO: Logout
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


    //TODO: Fix update
    @Override
    public ResponseEntity<String> updateUser(String userId, String user, HttpMethod method, HttpServletRequest request, HttpServletResponse response)
            throws URISyntaxException {

        return this.proxyService.processProxyUpdateUser(userId, user, method, request, response);
    }
}

package org.tinder.api;

import org.springframework.http.HttpMethod;
import org.tinder.model.Message;
import org.tinder.model.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Validated
@RequestMapping("${openapi.openAPITinderLikeApp.base-path:/v2}")
public interface TinderApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /user : Add a new user
     * 
     *
     * @param userEntity User (required)
     * @return successful operation (status code 200)
     *         or Invalid input (status code 405)
     */

    @Operation(
        operationId = "addUser",
        summary = "Add a new user",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserEntity.class))
            }),
            @ApiResponse(responseCode = "405", description = "Invalid input")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<UserEntity> addUser(
        @Parameter(name = "User", description = "User", required = true) @Valid @RequestBody UserEntity userEntity
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"password\" : \"password\", \"preffered_age_start\" : 6, \"photo\" : [ \"photo\", \"photo\" ], \"location\" : \"location\", \"id\" : 0, \"login\" : \"fedos3d\", \"preffered_gender\" : \"male\", \"preffered_age_end\" : 1, \"email\" : \"memokek@kek.ru\", \"tags\" : [ \"tags\", \"tags\" ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /user/userId/match/matchId/message/messageId : delete message
     * 
     *
     * @param userId ID of user (required)
     * @param matchId ID of match (required)
     * @param messageId ID of message (required)
     * @param message Message (required)
     * @return successful operation (status code 200)
     */

    @Operation(
        operationId = "deleteMessage",
        summary = "delete message",
        tags = { "message" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/user/{userId}/match/{matchId}/message/{messageId}",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> deleteMessage(
        @Parameter(name = "userId", description = "ID of user", required = true) @PathVariable("userId") Long userId,
        @Parameter(name = "matchId", description = "ID of match", required = true) @PathVariable("matchId") Long matchId,
        @Parameter(name = "messageId", description = "ID of message", required = true) @PathVariable("messageId") Long messageId,
        @Parameter(name = "Message", description = "Message", required = true) @Valid @RequestBody Message message
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /user/userId : Delete an existing user
     * 
     *
     * @param userId ID of user to delete (required)
     * @return successful operation (status code 200)
     *         or User not found (status code 404)
     *         or Not authorized (status code 403)
     */
    @Operation(
        operationId = "deleteUser",
        summary = "Delete an existing user",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "403", description = "Not authorized")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/user/{userId}"
    )
    default ResponseEntity<Void> deleteUser(
            @Parameter(name = "userId", description = "ID of user", required = true) @PathVariable("userId") String userId, HttpMethod method, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /user : Get all users, also filter
     *
     * @param gender Gender to filter by (optional)
     * @param ageRangeStart  (optional)
     * @param ageRangeEnd  (optional)
     * @param tags  (optional)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "getAllUsers",
        summary = "Get all users, also filter",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserEntity.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user",
        produces = { "application/json" }
    )
    default ResponseEntity<String> getAllUsers(
                                              HttpMethod method, HttpServletRequest request, HttpServletResponse response)
            throws URISyntaxException {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }



    /**
     * GET /user/userId/match/matchId : get specified match
     * 
     *
     * @param userId ID of user (required)
     * @param matchId ID of match (required)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "getMatchForUser",
        summary = "get specified match",
        tags = { "match" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user/{userId}/match/matchId",
        produces = { "application/json" }
    )
    default ResponseEntity<Object> getMatchForUser(
        @Parameter(name = "userId", description = "ID of user", required = true) @PathVariable("userId") Long userId,
        @Parameter(name = "matchId", description = "ID of match", required = true) @PathVariable("matchId") Long matchId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /user/userId/match : get all matches for a user
     * 
     *
     * @param userId ID of user (required)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "getMatchesForUser",
        summary = "get all matches for a user",
        tags = { "match" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user/{userId}/match",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Object>> getMatchesForUser(
        @Parameter(name = "userId", description = "ID of user", required = true) @PathVariable("userId") Long userId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /user/userId : Get an existing user
     * 
     *
     * @param userId ID of user to get (required)
     * @return successful operation (status code 200)
     *         or User not found (status code 404)
     *         or Not authorized (status code 403)
     */
    @Operation(
        operationId = "getUser",
        summary = "Get an existing user",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserEntity.class))
            }),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "403", description = "Not authorized")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user/{userId}",
        produces = { "application/json" }
    )
    default ResponseEntity<String> getUser(
        @Parameter(name = "userId", description = "ID of user to get", required = true) @PathVariable("userId") String userId, HttpMethod method, HttpServletRequest request, HttpServletResponse response
    ) throws URISyntaxException {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /user/login : login user
     * 
     *
     * @param login login (required)
     * @param password password (required)
     * @return successful operation (status code 200)
     *         or Validation exception (status code 405)
     */
    @Operation(
        operationId = "loginUser",
        summary = "login user",
        tags = { "auth" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "405", description = "Validation exception")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user/login"
    )
    default ResponseEntity<Void> loginUser(
        @NotNull @Parameter(name = "login", description = "login", required = true) @Valid @RequestParam(value = "login", required = true) String login,
        @NotNull @Parameter(name = "password", description = "password", required = true) @Valid @RequestParam(value = "password", required = true) String password
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /user/logout : logout user
     * 
     *
     * @return successful operation (status code 200)
     *         or Validation exception (status code 405)
     */
    @Operation(
        operationId = "logoutUser",
        summary = "logout user",
        tags = { "auth" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "405", description = "Validation exception")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user/logout"
    )
    default ResponseEntity<Void> logoutUser(
        
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /user/userId/like : Post a like on existing user
     * 
     *
     * @param userId ID of user to update (required)
     * @param likedUserId ID of user to like (required)
     * @param likeStatus Status of like or dislike of user to like (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or User not found (status code 404)
     *         or Validation exception (status code 405)
     */
    @Operation(
        operationId = "postLike",
        summary = "Post a like on existing user",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user/{userId}/like",
        produces = { "application/json" }
    )
    default ResponseEntity<UserEntity> postLike(
        @Parameter(name = "userId", description = "ID of user to update", required = true) @PathVariable("userId") Long userId,
        @NotNull @Parameter(name = "liked_user_id", description = "ID of user to like", required = true) @Valid @RequestParam(value = "liked_user_id", required = true) Long likedUserId,
        @NotNull @Parameter(name = "like_status", description = "Status of like or dislike of user to like", required = true) @Valid @RequestParam(value = "like_status", required = true) Boolean likeStatus
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"password\" : \"password\", \"preffered_age_start\" : 6, \"photo\" : [ \"photo\", \"photo\" ], \"location\" : \"location\", \"id\" : 0, \"login\" : \"fedos3d\", \"preffered_gender\" : \"male\", \"preffered_age_end\" : 1, \"email\" : \"memokek@kek.ru\", \"tags\" : [ \"tags\", \"tags\" ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /user/userId/match/matchId/message : post a message
     * 
     *
     * @param userId ID of user (required)
     * @param matchId ID of match (required)
     * @param message Message (required)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "postMessage",
        summary = "post a message",
        tags = { "message" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user/{userId}/match/{matchId}/message",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> postMessage(
        @Parameter(name = "userId", description = "ID of user", required = true) @PathVariable("userId") Long userId,
        @Parameter(name = "matchId", description = "ID of match", required = true) @PathVariable("matchId") Long matchId,
        @Parameter(name = "Message", description = "Message", required = true) @Valid @RequestBody Message message
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /user/userId/match/matchId : unmatch user
     * 
     *
     * @param userId ID of user (required)
     * @param matchId ID of match (required)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "unmatchUser",
        summary = "unmatch user",
        tags = { "match" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/user/{userId}/match/{matchId}",
        produces = { "application/json" }
    )
    default ResponseEntity<Object> unmatchUser(
        @Parameter(name = "userId", description = "ID of user", required = true) @PathVariable("userId") Long userId,
        @Parameter(name = "matchId", description = "ID of match", required = true) @PathVariable("matchId") Long matchId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /user/userId : Update an existing user
     * 
     *
     * @param userId ID of user to update (required)
     * @param userEntity User (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or User not found (status code 404)
     *         or Validation exception (status code 405)
     */
    @Operation(
        operationId = "updateUser",
        summary = "Update an existing user",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/user/{userId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<UserEntity> updateUser(
        @Parameter(name = "userId", description = "ID of user to update", required = true) @PathVariable("userId") Long userId,
        @Parameter(name = "User", description = "User", required = true) @Valid @RequestBody UserEntity userEntity
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"password\" : \"password\", \"preffered_age_start\" : 6, \"photo\" : [ \"photo\", \"photo\" ], \"location\" : \"location\", \"id\" : 0, \"login\" : \"fedos3d\", \"preffered_gender\" : \"male\", \"preffered_age_end\" : 1, \"email\" : \"memokek@kek.ru\", \"tags\" : [ \"tags\", \"tags\" ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}

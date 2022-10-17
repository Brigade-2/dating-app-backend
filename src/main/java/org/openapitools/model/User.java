package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * User
 */

@Schema(name = "User", description = "User")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-17T13:37:18.633119Z[Etc/UTC]")
public class User {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("email")
  private String email;

  @JsonProperty("login")
  private String login;

  @JsonProperty("password")
  private String password;

  /**
   * Gets or Sets prefferedGender
   */
  public enum PrefferedGenderEnum {
    MALE("male"),
    
    FEMALE("female"),
    
    BOTH("both");

    private String value;

    PrefferedGenderEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PrefferedGenderEnum fromValue(String value) {
      for (PrefferedGenderEnum b : PrefferedGenderEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("preffered_gender")
  private PrefferedGenderEnum prefferedGender;

  @JsonProperty("preffered_age_start")
  private Long prefferedAgeStart;

  @JsonProperty("preffered_age_end")
  private Long prefferedAgeEnd;

  @JsonProperty("tags")
  @Valid
  private List<String> tags = null;

  @JsonProperty("location")
  private String location;

  @JsonProperty("photo")
  @Valid
  private List<String> photo = null;

  public User id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  
  @Schema(name = "email", example = "memokek@kek.ru", required = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User login(String login) {
    this.login = login;
    return this;
  }

  /**
   * Get login
   * @return login
  */
  @NotNull 
  @Schema(name = "login", example = "fedos3d", required = true)
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Password
   * @return password
  */
  @NotNull 
  @Schema(name = "password", description = "Password", required = true)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User prefferedGender(PrefferedGenderEnum prefferedGender) {
    this.prefferedGender = prefferedGender;
    return this;
  }

  /**
   * Get prefferedGender
   * @return prefferedGender
  */
  
  @Schema(name = "preffered_gender", required = false)
  public PrefferedGenderEnum getPrefferedGender() {
    return prefferedGender;
  }

  public void setPrefferedGender(PrefferedGenderEnum prefferedGender) {
    this.prefferedGender = prefferedGender;
  }

  public User prefferedAgeStart(Long prefferedAgeStart) {
    this.prefferedAgeStart = prefferedAgeStart;
    return this;
  }

  /**
   * Get prefferedAgeStart
   * @return prefferedAgeStart
  */
  
  @Schema(name = "preffered_age_start", required = false)
  public Long getPrefferedAgeStart() {
    return prefferedAgeStart;
  }

  public void setPrefferedAgeStart(Long prefferedAgeStart) {
    this.prefferedAgeStart = prefferedAgeStart;
  }

  public User prefferedAgeEnd(Long prefferedAgeEnd) {
    this.prefferedAgeEnd = prefferedAgeEnd;
    return this;
  }

  /**
   * Get prefferedAgeEnd
   * @return prefferedAgeEnd
  */
  
  @Schema(name = "preffered_age_end", required = false)
  public Long getPrefferedAgeEnd() {
    return prefferedAgeEnd;
  }

  public void setPrefferedAgeEnd(Long prefferedAgeEnd) {
    this.prefferedAgeEnd = prefferedAgeEnd;
  }

  public User tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public User addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Get tags
   * @return tags
  */
  
  @Schema(name = "tags", required = false)
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public User location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  */
  
  @Schema(name = "location", required = false)
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public User photo(List<String> photo) {
    this.photo = photo;
    return this;
  }

  public User addPhotoItem(String photoItem) {
    if (this.photo == null) {
      this.photo = new ArrayList<>();
    }
    this.photo.add(photoItem);
    return this;
  }

  /**
   * Get photo
   * @return photo
  */
  
  @Schema(name = "photo", required = false)
  public List<String> getPhoto() {
    return photo;
  }

  public void setPhoto(List<String> photo) {
    this.photo = photo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.login, user.login) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.prefferedGender, user.prefferedGender) &&
        Objects.equals(this.prefferedAgeStart, user.prefferedAgeStart) &&
        Objects.equals(this.prefferedAgeEnd, user.prefferedAgeEnd) &&
        Objects.equals(this.tags, user.tags) &&
        Objects.equals(this.location, user.location) &&
        Objects.equals(this.photo, user.photo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, login, password, prefferedGender, prefferedAgeStart, prefferedAgeEnd, tags, location, photo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    prefferedGender: ").append(toIndentedString(prefferedGender)).append("\n");
    sb.append("    prefferedAgeStart: ").append(toIndentedString(prefferedAgeStart)).append("\n");
    sb.append("    prefferedAgeEnd: ").append(toIndentedString(prefferedAgeEnd)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    photo: ").append(toIndentedString(photo)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


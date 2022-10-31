package org.tinder.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "user_entity")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Long id;

  @JsonProperty("email")
  private String email;

  @JsonProperty("login")
  private String login;

  @JsonProperty("password")
  private String password;

  @Column(name = "first_name")
  @JsonProperty("first_name")
  private String firstName;

  @Column(name = "second_name")
  @JsonProperty("second_name")
  private String secondName;

  @Column(name = "description")
  @JsonProperty("description")
  private String description;

  @Column(name = "creation_date")
  @JsonProperty("creation_date")
  private LocalDate creationDate;

  @Column(name = "preferred_gender")
  @Enumerated(EnumType.STRING)
  @JsonProperty("preferred_gender")
  private GenderEnum preferredGender;

  @Column(name = "preferred_age_start")
  @JsonProperty("preferred_age_start")
  private Long preferredAgeStart;

  @Column(name = "preferred_age_end")
  @JsonProperty("preferred_age_end")
  private Long preferredAgeEnd;

  @JsonProperty("location")
  private String location;

  @ManyToMany
  @JoinTable(
          name = "user_tags",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "tag_id"))
  private Set<Tag> tags;

  @OneToMany(mappedBy = "from")
  private List<Like> fromLikes;

  @OneToMany(mappedBy = "to")
  private List<Like> toLikes;

  @OneToMany(mappedBy = "userEntity")
  private List<Photo> photos;

  @Schema(name = "id", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  
  @Schema(name = "email", example = "memokek@kek.ru", required = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @NotNull
  @Schema(name = "login", example = "fedos3d", required = true)
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  @NotNull 
  @Schema(name = "password", description = "Password", required = true)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  @Schema(name = "preferred_gender", required = false)
  public GenderEnum getPreferredGender() {
    return preferredGender;
  }

  public void setPreferredGender(GenderEnum prefferedGender) {
    this.preferredGender = prefferedGender;
  }
  
  @Schema(name = "preferred_age_start", required = false)
  public Long getPreferredAgeStart() {
    return preferredAgeStart;
  }

  public void setPreferredAgeStart(Long prefferedAgeStart) {
    this.preferredAgeStart = prefferedAgeStart;
  }
  
  @Schema(name = "preferred_age_end", required = false)
  public Long getPreferredAgeEnd() {
    return preferredAgeEnd;
  }

  public void setPreferredAgeEnd(Long prefferedAgeEnd) {
    this.preferredAgeEnd = prefferedAgeEnd;
  }

  @Schema(name = "location", required = false)
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}

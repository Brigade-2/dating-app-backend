package org.tinder.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Match
 */

@Entity
public class Match {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Long id;

  @Column(name = "user1_id")
  private Long user1Id;

  @Column(name = "user2_id")
  private Long user2Id;

  @OneToMany(mappedBy = "match")
  private List<Message> messages;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Schema(name = "user1_id", required = true)
  public Long getUser1Id() {
    return user1Id;
  }

  public void setUser1Id(Long user1Id) {
    this.user1Id = user1Id;
  }

  @Schema(name = "user2_id", required = true)
  public Long getUser2Id() {
    return user2Id;
  }

  public void setUser2Id(Long user2Id) {
    this.user2Id = user2Id;
  }

  @Schema(name = "messages", required = false)
  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }
}


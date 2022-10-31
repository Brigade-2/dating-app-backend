package org.tinder.model;

import java.time.LocalDate;
import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Message
 */

@Entity
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Long id;

  @Column(name = "message")
  @JsonProperty("message")
  private String message;

  @Column(name = "message_date")
  @JsonProperty("message_date")
  private LocalDate messageDate;

  @Column(name = "message_time")
  @JsonProperty("message_time")
  private LocalTime messageTime;

  @ManyToOne
  @JoinColumn(name = "match_id")
  private Match match;

  @Schema(name = "id", required = true)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Schema(name = "message", required = true)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Schema(name = "message_date", required = true)
  public LocalDate getMessageDate() {
    return messageDate;
  }

  public void setMessageDate(LocalDate messageDate) {
    this.messageDate = messageDate;
  }

  @Schema(name = "message_time", required = true)
  public LocalTime getMessageTime() {
    return messageTime;
  }

  public void setMessageTime(LocalTime messageTime) {
    this.messageTime = messageTime;
  }

  @Schema(name = "match", required = true)
  public Match getMatch() {
    return match;
  }

  public void setMatch(Match match) {
    this.match = match;
  }
}


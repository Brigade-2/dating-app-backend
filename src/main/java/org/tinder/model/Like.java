package org.tinder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(name = "Like", description = "Like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_id")
    private UserEntity from;

    @ManyToOne
    @JoinColumn(name = "to_id")
    private UserEntity to;

    @Schema(name = "id", required = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Schema(name = "from_user", required = true)
    public UserEntity getFrom() {
        return from;
    }

    public void setFrom(UserEntity from) {
        this.from = from;
    }

    @Schema(name = "to_user", required = true)
    public UserEntity getTo() {
        return to;
    }

    public void setTo(UserEntity to) {
        this.to = to;
    }
}

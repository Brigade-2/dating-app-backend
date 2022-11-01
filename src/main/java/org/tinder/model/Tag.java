package org.tinder.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(name = "Tag", description = "Tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "tag_name")
    @JsonProperty("tag_name")
    private String tagName;

    @ManyToMany(mappedBy = "tags")
    private Set<UserEntity> userEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<UserEntity> getUsers() {
        return userEntities;
    }

    public void setUsers(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
}

package com.saurabhgitdev.todo.todo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.saurabhgitdev.todo.user.domain.User;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Postgres best practice
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdTime;

    @Column(nullable = false)
    private OffsetDateTime updatedTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_todo_user")
    )
    @JsonBackReference
    private User user;

    public Todo() {
    }

    @PrePersist
    protected void onCreate() {
        createdTime = OffsetDateTime.now(ZoneOffset.UTC);
        updatedTime = OffsetDateTime.now(ZoneOffset.UTC);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedTime = OffsetDateTime.now(ZoneOffset.UTC);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getCreatedTime() {
        return createdTime;
    }

    public OffsetDateTime getUpdatedTime() {
        return updatedTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

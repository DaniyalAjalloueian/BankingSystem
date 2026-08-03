package com.daniyal.bankingsystem.model;

import jakarta.persistence.*;


@Entity
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String apiKey;

    private Boolean active;

    @OneToOne
    @JoinColumn(name = "user_id",unique = true)
    private User user;

    public ApiKey() {
    }

    public ApiKey(Boolean active, User user) {
        this.active = active;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

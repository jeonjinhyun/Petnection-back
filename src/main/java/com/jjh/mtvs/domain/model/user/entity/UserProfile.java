package com.jjh.mtvs.domain.model.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class UserProfile {
    @Column(name = "user_name")
    private String name;

    @Setter
    @Column(name = "user_img_url")
    private String imgUrl;

    public UserProfile(String name) {
        this.name = name;
    }
}

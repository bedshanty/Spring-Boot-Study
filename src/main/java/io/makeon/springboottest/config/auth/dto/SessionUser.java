package io.makeon.springboottest.config.auth.dto;

import io.makeon.springboottest.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
// 직렬화를 구현하기 위해 DTO 와 별개로 클래스 생성
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getEmail();
    }
}

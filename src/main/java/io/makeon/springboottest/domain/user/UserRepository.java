package io.makeon.springboottest.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // email 로 이미 생성된 사용자인지 처음 가입한 사용자인지 판단
    Optional<User> findByEmail(String email);
}

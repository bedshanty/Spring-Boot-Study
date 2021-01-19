package io.makeon.springboottest.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// MyBatis DAO = JPA Repository
// JpaRepository<Entity, PK>
// Entity 와 같은 곳에 위치해야함
public interface PostsRepository extends JpaRepository<Posts, Long> {
}

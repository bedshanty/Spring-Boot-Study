package io.makeon.springboottest.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    // 테스트가 끝난 후 수행되는 메서드
    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void savePostsTest() {
        final String title = "테스트 게시글";
        final String content = "테스트 본문";

        // INSERT / UPDATE 쿼리 실행
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("bedshanty@gmail.com")
                .build());

        // SELECT *
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}

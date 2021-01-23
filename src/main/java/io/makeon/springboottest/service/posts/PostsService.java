package io.makeon.springboottest.service.posts;

import io.makeon.springboottest.domain.posts.Posts;
import io.makeon.springboottest.domain.posts.PostsRepository;
import io.makeon.springboottest.web.dto.PostsListResponseDto;
import io.makeon.springboottest.web.dto.PostsResponseDto;
import io.makeon.springboottest.web.dto.PostsSaveRequestDto;
import io.makeon.springboottest.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

    // readonly = true 를 통해 트랜잭션의 조회 기능만 남겨두어 조회 속도 개선
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        // JpaRepository 가 지원하는 delete 메서드
        // deleteById 메서드로 id 로 삭제 가능
        postsRepository.delete(posts);
    }
}

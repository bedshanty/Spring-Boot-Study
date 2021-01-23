package io.makeon.springboottest.web;

import io.makeon.springboottest.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    // Model => 서버 템플릿 엔진에서 사용 가능한 객체 저장
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        // 머스태치 스타터가 자동으로 문자열 앞 경로, 뒤 확장자를 지정
        // src/main/resources/templates/index.mustache 로 매핑
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}

package io.makeon.springboottest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        // 머스태치 스타터가 자동으로 문자열 앞 경로, 뒤 확장자를 지정
        // src/main/resources/templates/index.mustache 로 매핑
        return "index";
    }
}

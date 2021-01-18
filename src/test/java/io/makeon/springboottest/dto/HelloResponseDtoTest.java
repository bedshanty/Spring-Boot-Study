package io.makeon.springboottest.dto;

import io.makeon.springboottest.web.dto.HelloResponseDto;
import org.junit.Test;

// JUnit이 아닌 assertj 라이브러리 사용
// 자동완성 지원이 강함
// https://www.youtube.com/watch?v=zLx_fI24UXM&t=408s
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombokTest() {
        final String name = "test";
        final int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

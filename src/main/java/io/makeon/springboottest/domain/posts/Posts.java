package io.makeon.springboottest.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 모든 필드에 Getter 메서드 생성
// Entity 클래스에서는 절대 Setter 메서드를 만들지 않는다.
@Getter
// 생성자 자동 생성
@NoArgsConstructor
// 테이블과 자동 매칭되는 클래스
// 자동으로 snake case 로 변경
@Entity
public class Posts {
    // PK
    @Id
    // PK 규칙, Long(BIGINT), auto_increment 추천
    // .IDENTITY => auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 컬럼, 꼭 선언하지 않아도 됨
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 빌더 패턴 클래스 자동 생성
    // 생성자에 선언 시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

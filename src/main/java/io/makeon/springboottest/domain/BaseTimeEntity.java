package io.makeon.springboottest.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
// 이 클래스를 상속할 경우 모든 필드들을 Column 으로 인식
@MappedSuperclass
// 이 클래스에 Auditing 기능을 포함
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    // Entity 가 생성되어 저장되는 시간 저장
    // LocalDateTime => Java 8 에서 추가된 클래스, Calendar 의 문제점 보완
    @CreatedDate
    private LocalDateTime createdDate;

    // Entity 의 값이 변경되는 시간 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}

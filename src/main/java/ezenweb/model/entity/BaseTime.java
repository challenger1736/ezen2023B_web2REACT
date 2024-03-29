package ezenweb.model.entity;


import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 상속 필드 만들어 주기위해서
@EntityListeners(AuditingEntityListener.class) // 엔티티의 변화를 주시하는 역할
@Getter
public class BaseTime {

    // 1. 레코드/엔티티 등록날짜
    @CreatedDate // default now()
    private LocalDateTime cdate;
    // 2. 레코드/엔티티 수정날짜
    @LastModifiedDate // 마지막 수정 날짜.
    private LocalDateTime udate;
}
/*
    상속 : 여러곳에서 공통적인 멤버들 [코드 줄이려고]
 */

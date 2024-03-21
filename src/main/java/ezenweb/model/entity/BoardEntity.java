package ezenweb.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity // 해당 클래스와 연동 DB내 테이블과 매핑
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity { // DB의 테이블역할
    @Id // PK선언
    private int bno; // 게시물번호
    @Column(columnDefinition = "varchar(20)")
    private String btitle; // 게시물제목
}

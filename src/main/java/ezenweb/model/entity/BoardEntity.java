package ezenweb.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity // 해당 클래스와 연동 DB내 테이블과 매핑
@Table(name="board") // 테이블 명 정해줄수 있음
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity { // DB의 테이블역할
    @Id // PK선언
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int bno; // 게시물번호
    @Column(columnDefinition = "varchar(20)") // 세로 : 필드
    private String btitle; // 게시물제목

    private boolean field8;
    private byte field1;
    private short field2;
    private long field3;

    private char field4;
    private float field5;
    private double field6;

    private Date field9;
    private LocalDateTime field10;
    @Column(columnDefinition = "int unsigned ")
    private int field11;

}

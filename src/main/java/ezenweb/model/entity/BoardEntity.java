package ezenweb.model.entity;

import ezenweb.model.dto.BoardDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BoardEntity extends BaseTime{ // DB의 테이블역할
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;
    @Column(columnDefinition = "longtext")
    private String bcontent;
    @ColumnDefault("0")
    private int bview;

    //fk 필드
    @JoinColumn(name="mno_fk") // fk 필드명
    @ManyToOne // 해당 필드 참조하겠다.
    private MemberEntity memberEntity; // 해당 필드

    //양 방향 : 댓글들 넣어야함 @OneToMany(mappedBy 해당 테이블 fk [!자바!] 필드명
    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.ALL)
    @ToString.Exclude // 해당 객체 호출시 해당 필드는 호출하지 않는다.
    @Builder.Default
    private List<ReplyEntity> replyEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<BoardImgEntity> boardImgEntityList = new ArrayList<>();

    public BoardDto toDto(){
        return BoardDto.builder()
                .bno(this.bno)
                .bcontent(this.bcontent)
                .bview(this.bview)
                .mno_fk(this.memberEntity.getMno())
                .memail(this.memberEntity.getMemail())
                .cdate(this.getCdate())
                .udate(this.getUdate())
                .bimgList(this.boardImgEntityList.stream().map((imgEntity)->{return imgEntity.getFilename();}).collect(Collectors.toList())) //List<엔티티>를 쓸 수 없으니, List<String> 받는 걸 만들어서 넣어줘야함.
                .build();
    }
}

//    private boolean field8;
//    private byte field1;
//    private short field2;
//    private long field3;
//
//    private char field4;
//    private float field5;
//    private double field6;
//
//    private Date field9;
//    private LocalDateTime field10;
//    @Column(columnDefinition = "int unsigned ")
//    private int field11;
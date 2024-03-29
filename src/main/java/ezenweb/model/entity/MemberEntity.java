package ezenweb.model.entity;


import ezenweb.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;
    @Column(length = 50, unique = true) // varchar(50) unique
    private String memail;
    @Column(length = 30)
    private String mpassword;
    @Column(length = 20)
    private String mname;
    @Column(name = "mrol", nullable = true ) // not null 아님
    @ColumnDefault("'user'")//, columnDefinition = "varchar(255) default" 가능
    private String mrol;

    //양 방향 : 게시물fk @OneToMany(mappedBy 해당 테이블 fk [!자바!] 필드명
    @OneToMany(mappedBy = "memberEntity")
    @ToString.Exclude // 해당 객체 호출시 해당 필드는 호출하지 않는다.
    @Builder.Default // 빌더패턴 사용시 해당 필드의 초기값을 빌더 초기값으로 사용한다는 뜻.
    private List<BoardEntity> boardEntityList = new ArrayList<>();
    //양 방향 : 댓글fk
    @OneToMany(mappedBy = "memberEntity")
    @ToString.Exclude // 해당 객체 호출시 해당 필드는 호출하지 않는다.
    @Builder.Default
    private  List<ReplyEntity> replyEntityList = new ArrayList<>();

    // - 엔티티를 DTO로 변환하는
    public MemberDto toDto(){
        return MemberDto.builder()
                .mno(this.mno)
                .memail(this.memail)
                .mname(this.mname)
                .mrol(this.mrol)
                .build();
    }
}

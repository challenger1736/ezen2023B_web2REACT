package ezenweb.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno;

    private String rcontent;

    //fk 필드
    @JoinColumn(name="bno_fk")
    @ManyToOne // 해당 필드참조
    private BoardEntity boardEntity;

    //fk 필드
    @JoinColumn(name="mno_fk")
    @ManyToOne
    private MemberEntity memberEntity;


}

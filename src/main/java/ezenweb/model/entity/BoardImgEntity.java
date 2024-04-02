package ezenweb.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "boardimg")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardImgEntity extends BaseTime{

    @Id
    String filename; // 파일명 uuid 쓸거라 중복 없다-- // 식별이 가능

    @ManyToOne
    @JoinColumn(name = "bno")
    BoardEntity boardEntity;
}

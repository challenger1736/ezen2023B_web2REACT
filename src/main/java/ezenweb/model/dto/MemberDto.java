package ezenweb.model.dto;

import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.entity.ReplyEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberDto {

    private int mno;
    private String memail;
    private String mpassword;
    private String mname;
    private String mrol;

    // - DTO를 엔티티로 변환하는 메소드 // 저장을 하기 위해
    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .mno(this.mno)
                .memail(this.memail)
                .mname(this.mname)
                .mpassword(this.mpassword)
                .mrol(this.mrol)
                .build();
    }


}

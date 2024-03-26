package ezenweb.example;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class 게시물 {
    private int 번호;
    private String 게시물제목;
    private String 게시물내용;

    //    private int 작성자회원번호;
    private 회원 작성자;
    @Builder.Default @ToString.Exclude
    private List<댓글> 댓글목록 = new ArrayList<>();
}

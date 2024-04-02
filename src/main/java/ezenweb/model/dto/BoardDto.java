package ezenweb.model.dto;

import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.BoardImgEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class BoardDto extends BaseTimeDto{

    private int bno;
    private String bcontent;
    private int bview;
    private int mno_fk;
    private String memail;

    // 1. 출력용 게시물 이미지 필드 왜 스트링임? -> 출력만 하면 되니까
    private List<String> bimgList = new ArrayList<>();

    // 2. 등록용 게시물 이미지 필드 왜 멀티파트임? -> JS에서 받아와서 바꿔야하니까 바이트-->스프링
    private List<MultipartFile> uploadList = new ArrayList<>();

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .bcontent(this.bcontent)
                .build();
    }
}

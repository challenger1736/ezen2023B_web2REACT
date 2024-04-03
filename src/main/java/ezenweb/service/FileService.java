package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.BoardImgEntity;
import ezenweb.model.repository.BoardEntityRepository;
import ezenweb.model.repository.BoardImgRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FileService {

    @Autowired
    private HttpServletRequest request; // HTTP로 요청을 보낸 정보가 담긴 객체 ( 매개변수와 브라우저 정보 -> 세션 )
    @Autowired
    private HttpServletResponse response; // HTTP로 응답을 보낼 정보와 기능/메소드를 가지고 있는 객체
    @Autowired
    BoardImgRepository boardImgRepository;



    // 어디에(PATH) 누구를(파일객체)
    String uploadPath = "C:\\Users\\504\\Desktop\\ezen2023B_web2REACT\\build\\resources\\main\\static\\uploadimg\\";

    // 2. multipartFile 존재하는 파일 업로드
    public String fileUpload(MultipartFile multipartFile ){
        // 1. 파일 이름을 식별 가능한 uuid와 조합
        String uuid = UUID.randomUUID().toString(); // UUID란?? 고유한 id 난수성으로 생성
        // 2. 조합 ( uuid와 파일이름의 구분선을 _ 이기때문에 파일명에 _ 존재할수도 있기때문에 _를 - 로 치환 )
        String filename = uuid+"_"+multipartFile.getOriginalFilename().replaceAll( "_" ,"-");
        // 3.
        File file = new File( uploadPath + filename );
        // 4.
        try {   multipartFile.transferTo(file);}
        catch ( Exception e ){   System.out.println("e = " + e); return null;   }
        return filename;
    }
}

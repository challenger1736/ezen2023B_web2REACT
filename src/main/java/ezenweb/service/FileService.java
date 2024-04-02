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

    public boolean fileUpload(List<MultipartFile> multipartFiles,  BoardEntity boardEntity) { // MultipartFile은 업로드(매핑)잡을때 지원해주는 느낌.


        // * 파일 이름 조합하기 : 새로운 식별이름과 실제 파일 이름
        // 식별키와 실제 이름 구분 : 왜? 나중에 쪼개서 구분하려고 [ 다운로드시 식별키 빼고 제공하려고 ]
        // 혹시나 파일 이름이 구분문자 가 있을 경우 기준이 깨짐.
        // .replaceAll() : 문자열 치환/교체
        List<String> filenamelist = new ArrayList<>();
        for(int i =0 ; i<multipartFiles.size() ; i++){
            String uuid = UUID.randomUUID().toString(); // 산수생성 UUID!!
            filenamelist.add(uuid + "_" + multipartFiles.get(i).getOriginalFilename().replaceAll("_", "-"));//_ 이걸 다 바꾸게. -로
        }

//        memberDto.setUuidFile(filename); // 어차피 파일은 대개 고정이므로 filename만 있으면 됨,
// 얘는 할 수가 없음!! multipartFile로 바꿀수 없음


        // 1. 첨부파일 업로드 하기. [업로드란: 클라이언트의 바이트(대용량/파일)을 서버로 복사]
        // 1. 첨부파일을 저장할 경로
        // File 클래스 : 파일 관련된 메소드 제공
        // new File(파일경로)
//        File file = new File("c:\\java\\"+첨부파일.getOriginalFilename());
        List<File> upfiles = new ArrayList<>();
        for(int i =0 ; i <multipartFiles.size() ; i++){
            upfiles.add(new File(uploadPath + filenamelist.get(i)));
        }

        // 2. [무엇을] 첨부파일 객체
        // transferTo(경로) 경로: Path나 File 클래스로 줘야한다고 자바가 정해놓음.
        try {
            for(int i =0; i<multipartFiles.size();i++){
                multipartFiles.get(i).transferTo(upfiles.get(i));
                boardImgRepository.save(BoardImgEntity.builder()
                                .boardEntity(boardEntity)
                                .filename(filenamelist.get(i))
                        .build());
            }
            return true;
        } //실제로 서버에 저장하는 일.
        catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }
}

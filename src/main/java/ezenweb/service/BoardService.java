package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.MemberDto;
import ezenweb.model.dto.PageDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.BoardImgEntity;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.entity.ReplyEntity;
import ezenweb.model.repository.BoardEntityRepository;
import ezenweb.model.repository.BoardImgRepository;
import ezenweb.model.repository.MemberEntityRepository;
import ezenweb.model.repository.ReplyEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardService {

    @Autowired private BoardEntityRepository boardEntityRepository;

    @Autowired private MemberEntityRepository memberEntityRepository;

    @Autowired private ReplyEntityRepository replyEntityRepository;
    @Autowired private MemberService memberService;

    @Autowired private BoardImgRepository boardImgRepository;
    @Autowired
    FileService fileService;

    // 1. C
    @Transactional
    public boolean postBoard( BoardDto boardDto){ //  ======= 테스트 ==========
        MemberDto loginDto =  memberService.doLoginInfo();
        if( loginDto == null ) return false;
        // 1. 로그인된 회원 엔티티 찾기
        Optional< MemberEntity > optionalMemberEntity = memberEntityRepository.findById( loginDto.getMno() );
        // 2. 찾은 엔티티가 존재하지 않으면 실패;
        if( !optionalMemberEntity.isPresent() ) return false;
        // 3. 엔티티 꺼내기
        MemberEntity memberEntity = optionalMemberEntity.get();
        // - 글쓰기
        BoardEntity saveBoard = boardEntityRepository.save( boardDto.toEntity() ) ;
        // - FK 대입
        if( saveBoard.getBno() >= 1){ // 글쓰기를 성공했으면
            saveBoard.setMemberEntity( memberEntity );

            // 1. 하나씩 업로드 서비스에 업로드 요청
            boardDto.getUploadList().forEach( (file)->{
                // 2. 하나씩 업로드 된 파일명 반환 받기
                String filename = fileService.fileUpload( file );
                if( filename != null ){
                    // 3. 하나씩 업로드된 파일명으로 게시물파일엔티티 생성
                    BoardImgEntity boardImgEntity = BoardImgEntity.builder()
                            .filename( filename ) // 방금 위에서 업로드된 파일명을 엔티티에 대입
                            .boardEntity( saveBoard ) // FK : 게시물FK
                            .build();
                    // 4. 엔티티 영속성( 영속성이 필요한 이유 :  DB 저장할려고 => 서버가 종료되면 사라지니까 => 서버가 영구저장 )
                    boardImgRepository.save( boardImgEntity );
                }
            });
            return true;
        }
        return false;
    } // f end

    // 2. R
    @Transactional
    public PageDto getBoard(int page, int view){
        // =============================1번째 방법 ==========================
//        // 1. 리포지토리를 이용한 모든 엔티티( 테이블에 매핑 하기전 엔티티 )를 호출
//        List<BoardEntity> result = boardEntityRepository.findAll( );
//        // 2. Entity ---> Dto 변환한다
//        List<BoardDto> boardDtoList = new ArrayList<>();
//        // 1. 꺼내온 entity 을 순회한다
//        for( int i = 0 ; i < result.size() ; i++ ){
//            // 2. 하나씩 entity 꺼낸다
//            BoardEntity boardEntity = result.get(i);
//            // 3. 해당 엔티티를 dto로 변환한다.
//            BoardDto boardDto = boardEntity.toDto();
//            // 4. 변환된 dto를 리스트에 담는다.
//            boardDtoList.add( boardDto );
//        }
//        return boardDtoList;

        // =============================2번째 방법 ==========================
        // 1. pageable 인터페이스 이용한 페이징처리
//        Pageable pageable = PageRequest.of(현재페이지(0부터시작), 페이지당표시할레코드수 ) // 받아올 값들 = 현재 페이지, 페이지당 표시할 레코드 수
        // Repository.find~~(pageble)

        Pageable pageable = PageRequest.of(page-1,view);
        // 페이징 처리 된 게시물
//        boardEntityRepository.findAll(pageable) =====> 반환 타입 Page<>로 나옴
        Page<BoardEntity> boardEntityPage = boardEntityRepository.findAll(pageable);
        // 반환타입 List 아닌 Page 타입일 때 List 동일한 메소드 사용하고 추가 기능을 제공 해줌! (편하다)
        int count = boardEntityPage.getTotalPages(); // 전체 페이지수
        boardEntityPage.getTotalElements(); // 전체 레코드수

        List<Object> data = boardEntityPage.stream().map((board)->{return board.toDto();}).collect(Collectors.toList());

        // 페이지DTO 반환 값 구성(리턴)
        PageDto pageDto = PageDto.builder()
                .data(data)
                .page(page)
                .count(count)
                .build();
        return pageDto;
    }

    /// 3. U
    @Transactional
    public boolean putBoard(){
        BoardEntity boardEntity = boardEntityRepository.findById(1).get();
        boardEntity.setBcontent("JPA테스트중2");
        return false;
    }

    // 4. D
    @Transactional
    public boolean deleteBoard(int bno){

        MemberDto memberDto = memberService.doLoginInfo();
        if(memberDto==null){return false;}
        // 2. 내 게시물인지 확인
        Optional<BoardEntity> optionalBoardEntity =
                boardEntityRepository.findById(bno);
        if(optionalBoardEntity.isPresent()){
            if(optionalBoardEntity.get().getMemberEntity().getMno()==memberDto.getMno()){
                boardEntityRepository.deleteById(bno);
                return true;
            }
        }
        return false;
    }
}

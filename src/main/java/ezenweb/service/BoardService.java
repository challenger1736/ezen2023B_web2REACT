package ezenweb.service;

import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.entity.ReplyEntity;
import ezenweb.model.repository.BoardEntityRepository;
import ezenweb.model.repository.MemberEntityRepository;
import ezenweb.model.repository.ReplyEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class BoardService {

    @Autowired private BoardEntityRepository boardEntityRepository;

    @Autowired private MemberEntityRepository memberEntityRepository;

    @Autowired private ReplyEntityRepository replyEntityRepository;
    // 1. C
    @Transactional
    public boolean postBoard(){
        // ============ 테스트 =============
        // 1. 회원 가입 테스트
            // 1. 엔티티 객체 생성
        MemberEntity memberEntity = MemberEntity.builder()
                .memail("asdf@asdf.com")
                .mname("1234")
                .mname("유재석")
                .mpassword("1234")
                .build();
            // 2. 엔티티 조작!(db에 저장할 수 있도록 조작해주기)
        MemberEntity savememberEntity = memberEntityRepository.save(memberEntity);

        // 2. 회원가입의 회원으로 글쓰기
            // 1. 엔티티 객체 생성
        BoardEntity boardEntity = BoardEntity.builder()
                .bcontent("게시물글입니다.")
                .memberEntity(savememberEntity)
                .build();
            // 2. 엔티티 저장
        BoardEntity saveboardEntity = boardEntityRepository.save(boardEntity);

        // 3. 해당 글에 댓글 저장
            // 1. 엔티티 객체 생성
        ReplyEntity replyEntity = ReplyEntity.builder()
                .rcontent("댓글입니다.")
                .build();
            // 2. ====== fk 대입 작성자
        replyEntity.setMemberEntity(savememberEntity);
            // 2. ====== fk 대입 게시물
        replyEntity.setBoardEntity(saveboardEntity);
            // 3. 저장
        replyEntityRepository.save(replyEntity);
        return false;
    }

    // 2. R
    @Transactional
    public List<Object> getBoard(){
        List<BoardEntity> result = boardEntityRepository.findAll();
        System.out.println("result = " + result);
        return null;
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
    public boolean deleteBoard(){
        boardEntityRepository.deleteById(1);
        return false;
    }
}

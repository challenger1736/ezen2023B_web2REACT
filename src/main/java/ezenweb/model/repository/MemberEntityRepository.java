package ezenweb.model.repository;

import ezenweb.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface MemberEntityRepository extends JpaRepository<MemberEntity, Integer> {

    //1. 특정 필드를 찾는 레코드 검색 추상메소드 정의 [ 꼭 카멜 표기법으로 할 것 ]
    MemberEntity findByMemail(String memail);
    //2. 특정 레코드가 있는지 확인 / boolean [ 꼭 카멜 표기법으로 할 것 ]
    boolean existsByMemail(String memail);
    //3. 직접 native SQL 지원
    // select * from member where memail = ?;
//    @Query(value = "sql문 작성", nativeQuery = true)
    // SQL 매개변수 대입
        // :매개변수명을 쓰면 된다(Dao의 ps ?와 같음)
    @Query(value = "select * from member where memail = :memail", nativeQuery = true)
    MemberEntity findByMemailSQL(String memail);

    // -------------- 로그인 ----------------- //

    Optional<MemberEntity> findByMemailAndMpassword(String memail, String mpassword);

    boolean existsByMemailAndMpassword(String memail, String mpassword);

    @Query(value = "select * from member where memail = :memail and mpassword = :mpassword", nativeQuery = true)
    MemberEntity findByLoginSQL(String memail, String mpassword);

    // -------------- 내가 쓴 글 --------------- //
    // 1. 양방향일때는 회원 엔티티를 통해 게시물 호출 가능하다.

    // 2. 단방향일때는 회원 엔티티를 이용한 게시물 호출 할 때는 조인query
    @Query(value = "select * from member m inner join board b on m.mno = b.mno_fk where m.mno= :mno",nativeQuery = true)
    List<Map<Object,Object>> findByMyBoard(int mno);
    /*
        List : 여러개 레코드
        Map<> : 하나의 레코드 안에서 필드와 값
            Map<필드명,필드값>
         ex)
            mno mid mname
            1   qwe 유재석
            2   asd 강호동
     */
}

/*
    리포지토리 만드는 방법
    1. @Repository
    2. extends JpaRepository<조작할엔티티, PK의 필드 타입>

    - 리포지토리 이용한 CRUD 메소드
    1. .save(엔티티) : 해당 엔티티객체를 테이블에 삽입 insert into
 */

/*
    1. 특정 필드를 찾는 추상메소드 정의
    리포지토리.findById().get()

*/
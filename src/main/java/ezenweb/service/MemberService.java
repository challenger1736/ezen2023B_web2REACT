package ezenweb.service;

import ezenweb.model.dto.MemberDto;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService {
    @Autowired
    MemberEntityRepository memberEntityRepository;

    public boolean doSignUpPost( MemberDto memberDto){
        System.out.println("memberDto = " + memberDto);

        // -- Dao 아닌 엔티티 이용한 레코드 저장하는 방법
        // 1. 엔티티 만든다

        // 2. 리포지토리 통한 엔티티를 저장한다.
        memberEntityRepository.save(memberDto.toEntity());

        return false;
    }
}

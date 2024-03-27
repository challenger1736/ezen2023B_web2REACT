package ezenweb.controller;

import ezenweb.model.dto.MemberDto;
import ezenweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
//@CrossOrigin("http://localhost:3000") // 요청 근원지를 교차를 허용한다 port 3000번 ( 리액트 ) >> 프록시 서버 쓰면 안써도된다.
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup/post.do") // 1. 회원가입
    public boolean doSignUpPost(@RequestBody MemberDto memberDto){
        System.out.println("memberDto = " + memberDto);
        return memberService.doSignUpPost(memberDto);
    }

    @PostMapping("/login/post.do") // 2. 로그인
    public boolean doLoginPost(MemberDto memberDto){
        System.out.println("memberDto = " + memberDto);
        return memberService.doLoginPost(memberDto);
    }

    @GetMapping("/logout/get.do") // 3. 로그아웃
    public boolean doLogOutGet(){
        return memberService.doLogOutGet();
    }

    // 4. 현재 로그인 회원정보 호출 (세션 값 반환/호출)
    @GetMapping("/login/info/get.do")
    public MemberDto doLoginInfo(){
        return memberService.doLoginInfo();
    }
}

package ezenweb.example;

public class Main {
    public static void main(String[] args) {

        // 1. 회원가입
        // 회원 m1 = new 회원(1,"qwe","유재석")
        회원 m1 = 회원.builder().번호(1).아이디("qwe").이름("유재석").build();

        // 2. 게시물 // 컨셉 > 유재석이 게시물 작성하는 걸로
        게시물 b1 = 게시물.builder().번호(1).게시물내용("내용").게시물제목("제목").작성자(m1).build();
        
        // 3. 게시물 작성한 회원정보 호출
        System.out.println("b1.get작성자().get번호() = " + b1.get작성자().get번호());

        // ============================ 양방향 ============================ //
        m1.get내가쓴글().add(b1);
        System.out.println("m1.get내가쓴글() = " + m1.get내가쓴글());

        // 4. "유재석" 게시물 작성
        게시물 b2 = 게시물.builder().번호(2).게시물제목("제목").게시물내용("내용").작성자(m1).build();
        
        m1.get내가쓴글().add(b2);

        System.out.println("m1.get내가쓴글() = " + m1.get내가쓴글());
    }
}

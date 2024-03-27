import { useState } from "react"
import axios from 'axios'; // axios 라이브러리 호출

export default function Signup(){
    // 1. 상태변수
    const [memail,setMemail] = useState('');
    const [mpassword, setMpassword] = useState('');
    const [mname , setMname] = useState('');
    // 2. memail 수정함수.
    const onChangeMemail = (e)=>{
        setMemail(e.target.value);
        
    }
    // 3. 전송 함수
    const onSignup = (e)=>{
        console.log(memail);
        console.log(mpassword);
        console.log(mname);
        // *
        let info = {memail : memail , mpassword : mpassword , mname : mname}

        axios.post("/member/signup/post.do", info) // axios는 json으로 자동으로 보냄. Dto에 연결됨.
                        // 400번 대
            .then(response =>{console.log(response) //200번 대
                if(response.data){
                    alert('회원가입 성공')
                    window.location.href="/member/login"
                }else{
                    alert('회원가입 실패')
                }
            })
            .catch(error => {console.log(error)}) // 500번 대

        /*
         axios.HTTP메소드명(url,data).then(응답매개변수 => {응답 실행문})
        */
    }

    return(<>
        <form>
            아이디 : <input 
                        value={memail} 
                        type="text"
                        onChange={onChangeMemail}/>

            패스워드 : <input type="password" value={mpassword} onChange={(e)=>setMpassword(e.target.value)}/>

            이름 : <input type="text" value={mname} onChange={(e)=>setMname(e.target.value)}/>
            <button type="button" onClick={onSignup}>회원가입</button>
            {/* 챕터 11의 SignUp과 거의 동일하나 조금의 차이. */}
        </form>
    </>)
}
import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export default function Header(props){

    // 0. 로그인 정보 satae 변수 
    const [loginInfo, setLoginInfo] = useState('');

    // 컴포넌트 생성시 axios 실행해서 로그인 회원정보 호출(한 번만)
        // 회원 정보 가져오기.
    useEffect( ()=>{
        axios.get('/member/login/info/get.do')
        .then(r=>{console.log(r);
        setLoginInfo(r.data);})
        .catch(e=>{console.log(e)})
    }, [])

    return(<>
        <div>
            {loginInfo && <span>{loginInfo.memail} 님 </span>}
            <ul>
                <li><Link to="/">홈</Link></li>
                <li><Link to="/member/signup">회원가입</Link></li>
                <li><Link to="/member/login">Login</Link></li>
                <li><a href="javascript:void(0)" onClick={logout}>Logout</a></li>
                <li><Link to="/board/write">글쓰기</Link></li>
                <li><Link to="/board">전체글보기</Link></li>
            </ul>
        </div>
        </>)

function logout(props){
    axios.get('/member/logout/get.do')
    .then(r=>{console.log(r); 
        if(r){alert('로그아웃 성공'); window.location.href="/"}
        else{alert('로그아웃 실패');} 
        })
    .catch(e=>{console.log(e)})
}
}


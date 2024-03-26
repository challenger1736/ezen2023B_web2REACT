import React from "react";

export default function Toolbar(props){ // 객체에 boolean과 함수 2개가 들어간 props

    
    // 1. props 매개변수
    // const {isLoggedIn, onClickLogin, onClickLogout} = props;

    return(<>
        <div>
            {
                props.isLoggedIn && <span> 환영합니다. </span>
            }
            {
                props.isLoggedIn ? (<button onClick={props.onClickLogout}>로그아웃</button>):(<button onClick={props.onClickLogin}>로그인</button>)
            }
        </div>
    </>)
}
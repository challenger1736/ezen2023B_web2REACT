import React from "react";

// 어차피 리액트 환경이기에 파일명을 .jsx로 만들든 .js로 만들든 상관은 없긴함.

const user = {name:'강호동', age:10};

function formatName(user){
    return user.name + ' ' + user.age;
}

function JSX선언(props){    //JS 함수(=컴포넌트)

    let name = '유재석'; // 변수

    return (
    <div>
        Hello, World! <br/>
        hi, {name} <br/>
        {formatName(user)}
        {()=>{return '하하하하'}}
    </div>
    
    );
}
export default JSX선언;
import React from "react";

/*

    컴포넌트를 만드는 방법
        1. 첫글자를 대문자로하는 .jsx 파일 생성
        2. 함수형 컴포넌트 생성
            2-1.컴포넌트함수 선언
                    function 컴포넌트명(props){
                        return(JSX형식 문법)
                    }
            2-2.다른 곳에서 해당 파일 import 시 반환할 컴포넌트 명시
                    - 해당 파일에 여러개 함수가 존재 할 수 있으므로
                    export default 해당파일호출시반환컴포넌트명;
                합체
                export default  function 컴포넌트명(props){
                        return(JSX형식 문법)
                    }


    컴포넌트 호출하는 방법
                    1. 다른 컴포넌트에서 해당 컴포넌트 호출하는 방법
                    import 컴포넌트명 from 컴포넌트파일경로;

//엘리먼트 이란? p.118
// - 리액트 앱의 가장 작은 빌딩 블록들
// - 엘리먼트 종류 : 1. 본래HTML 엘리먼트(마크업/태그) , 2. 가상 리액트 엘리먼트
// - 가상 리액트 엘리먼트 --render--> 본래HTML 엘리먼트    순으로 렌더링 합니다.
// - 컴포넌트(JSX문법작성)1개 ---> 엘리먼트1( JS형태 ) ---> 본래HTML 엘리먼트
//                     ---> 엘리먼트2( JS형태 ) ---> 본래HTML 엘리먼트
//                     ---> 엘리먼트3( JS형태 ) ---> 본래HTML 엘리먼트
// - 불변성 특징 : 변하지 않는 성질
// - 변경하고 싶을때 : 재렌더링(새로고침)

*/

// function 컴포넌트명(props){
//     return(JSX형식문법);
// }

export default function Book(props){
    console.log(props);// 찍어보면 .연산자 뭘 찍을지 보임.
    return(
        <div>
            {/* <h1>이것이 자바입니다.</h1> */}
            <h1>{props.name}</h1>
            <h2>이 책은 총 {props.numOfPage}로 이뤄져 있습니다.</h2>
        </div>
    ); // 이 소괄호만 JSX 형식임.
}


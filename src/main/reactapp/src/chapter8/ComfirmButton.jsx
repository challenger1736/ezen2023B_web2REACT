import React, {useState} from "react";

export default function ConfirmButton(props){
    // 1. 상태(state) 관리 변수 // import React, {useState} from "react"; 해야함
    const [isConfirmed, setIsConfirmed] = useState(false);
        // useState : 리액트 훅
            // 사용/호출 : useState(초기값)
            // 반환 : 배열
                // [0] : 값이 저장된 변수
                // [1] : 값을 수정할 수 있는 set함수(세터)
                //             ( 세터 주소값 변경시 해당 컴포넌트 렌더링 )
                // 굳이 따지면
                // const resultArray = useState(false);
                // const isConfirmed = resultArray[0];
                // const setIsConfirmed = resultArray[1];


    // 2. JS 함수 정의 방법
    const handleConfirm = ()=>{
        setIsConfirmed((prevIsConfirmed)=>!prevIsConfirmed);
    };  // prevIsConfirmed?? : 매개변수로 기존 값(isConfirmed)을 전달, ()=> !isConfirmed와 같다.

    return(
        <button onClick={handleConfirm} disabled={isConfirmed}>
            {isConfirmed? "확인됨" : "확인하기"}
        </button>
    )
}

/*

    기존방식            리액트방식
    onclick=""          onClick={}
    handleConfirm()     handleConfirm 또는 (e) => handleConfirm(매개변수1, 매개변수2, e) e는 이벤트 자체의 정보

*/
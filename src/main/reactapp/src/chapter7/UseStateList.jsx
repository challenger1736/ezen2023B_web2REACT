import { useState } from "react";

export default function UseStateList(props){

     // =============== 리액트 방식 ================= //
        // 2. point 상태 관리 변수
            // 1. input 입력된 값을 저장하는 상태관리 변수
        let [pointInput, setPointInput] = useState('');
            // 2. input 입력된 값들을 저장하는 리스트 상태관리 변수
        let [pointList, setPointList] = useState([]);

    function 입력변경(e){
        
        setPointInput(e.target.value);
    }


    // 1. 등록 버튼 클릭시
    function 등록(){
        console.log('등록()')
        // ================= 리액트 전 방식 ================ //
        // 
        // // 1.
        // let value = document.querySelector('.pointInput').value;
        // // 2.
        // console.log(value);
        //================= 리액트 방식 ================== //


        let value2 = pointInput;
        console.log(value2);
        pointList.push(pointInput);
        // 새로운 배열 을 만들어서 주소값을 다르게 해줘야 재랜더링된다 ! setPointList()가 재랜더링 안되는 이유와 관련됨
        setPointList( [...pointList]); // 얘는 재 랜더링 X 안됨, 값의 기준이 변경이 안되서 // [...기존배열] 이게 기존배열을 복사해줌.(얕은 복사)

    }; // f end

    return (<>
    <div>
        <div>
            <input value={pointInput} className="pointInput" type="text" 
            onChange={입력변경}
            // onChange={(e)=>{e.target.value}} 과 같다.
            />
            <button type="button" onClick={등록}>등록</button>
        </div>
    </div>
    <div>
        {/* <div>87</div>
        <div>91</div> */}
        <div>{pointList.map((point)=>{return (<div>{point}</div>)})}</div>
    </div>
    </>)

}
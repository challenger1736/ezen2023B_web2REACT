import { useState } from "react";
        // 1. 일반 변수
        let countValue = 0;
export default function Counter(props){

        // 2. 함수
        function 클릭함수(){countValue++; console.log("함수 내부"+countValue);}

        console.log("컴포넌트 내부"+countValue);

        // 3. 상태관리변수 !!! : state 변화가 있으면 해당 컴포넌트 재호출/렌더링
            // import { useState } from "react";
            // useState('초기값')
                // [0](0번째 인덱스) : 초기값 또는 값;
                // [1](1번째 인덱스) : state의 set 함수 (state 값을 변경할 때 사용되는 함수)
        let 상태관리변수 = useState('훅이란 무엇인가?');
        console.log(상태관리변수);
        console.log(상태관리변수[0]); // state 값
        console.log(상태관리변수[1]); // state 변경 함수

        const [count, setCount] = useState(0);

        const [inputValue1, setInputValue1] = useState('')
        function inputValue1Update(e){
            console.log(e)

            // document.querySelector('.inputValue').value 로 인풋의 밸류를 가져오는 방법
            // object.value; 이벤트 함수의 (this)를 넣어서 직접 마크업을 가져오는 방법
            // e.target.value; 이벤트 함수의 event를 발생시킨 결과물e의 target의 value를 가져오는 방법 (e.target==this)

            setInputValue1(e.target.value); // state(inputValue1) 변경함수인 set함수를 호출해서 값 대입 그리고 재랜더링(컴포넌트 다시 호출)
        }


    return (<>
        <div>
            <p>총 {countValue}번 클릭했습니다.</p>
            <button onClick={()=>countValue++} type="button">
                클릭
            </button>
        </div>
        <div>
            <p>총 {count}번 클릭했습니다.</p>
            <button onClick={()=>setCount(count+1)} type="button">
                클릭
            </button>
        </div>
        <div>
            <input type="text" />
            <input type="text" value={inputValue1}/>
            <input type="text" value={inputValue1} onChange={inputValue1Update}/>
        </div>
    </>);
}

function Clock(props){ // 컴포넌트 함수는 첫 글자를 무조건 대문자로 : 근데 컴포넌트 함수가 뭐지?
    let name = "유재석";
    //JS
    // ================ JSX 문법 들어가는 곳 ==================
    return(
        <div>
        {/*두개 이상의 마크업을 쓰면 무조건 묶어주게 해놨다.*/}
        <h1>안녕하세요 여기는 JSX[JS+HTML 결합 문법] 구역입니다.</h1>
        <h2> {name} </h2>
        {/* <!-- HTML 주석 --> */} HTML 주석 이거 안된다.
        {/* // JS 주석 */}
        
        <h1>안녕 리액트</h1>
        <h2>현재 시간 : {new Date().toLocaleTimeString()}</h2>
        </div>
        
    )
    // ======================================================
    //JS
}


export default Clock    ;
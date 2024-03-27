import { BrowserRouter, Link, Route, Routes } from "react-router-dom"
import JSX선언 from "../chapter3/1_JSX선언"
import Library from "../chapter3/Library"
import Clock from "../chapter4/Clock"

export default function Route컴포넌트(props){
    
    return(<>
    <BrowserRouter >
        <div id="wrap" style={{display:'flex'}}>
            <고정형컴포넌트 />  
            <Routes > 
                {/* 그 해당 html의 경로 설정해줌. (가상 url의 path 를 정의하는 곳, 엘리멘트 뭐가 나올지 정의하는 곳)*/}
                <Route path="/chapter3/jsx선언" element={<JSX선언/>}/>
                <Route path="/chapter3/library" element={<Library />}/>
                <Route path="/chapter4/Clock" element={<Clock />}/>
            </Routes>
        </div>
    </BrowserRouter>
    </>)
}

function 고정형컴포넌트(props){ // 얘는 html 같은 역할은 여기서하고
    return (<>
    <div>
        <ul>
            <li><a href="/chapter3/jsx선언">jsx선언 a태그</a></li>
        </ul>
        <ul>
            <li><Link to="/chapter3/jsx선언">jsx선언 링크</Link></li>
            <li><Link to="/chapter3/library">library</Link></li>
            <li><Link to="/chapter4/Clock">Clock</Link></li>
        </ul>
    </div>
    </>)
}
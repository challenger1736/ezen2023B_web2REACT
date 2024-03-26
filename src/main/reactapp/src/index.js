import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// * 내가 만든 컴포넌트 import(가져오기) 호출
// import 컴포넌트 from 컴포넌트파일경로;
import JSX선언 from './chapter3/1_JSX선언';

// chapter3 실습
import Book from './chapter3/Book';
import Library from './chapter3/Library';
// chapter4 실습
import Clock from './chapter4/Clock';
// chapter5 실습
import CommentList from './chapter5/CommentList';
// chapter7 예제/실습
import Counter from './chapter7/Counter';
import UseStateList from './chapter7/UseStateList';
// chapter8 실습
import ConfirmButton from './chapter8/ComfirmButton'
// chapter9 실습
import LandingPage from './chapter9/LandingPage'
// chapter7 실습 useEffect 추가
import Counter2 from './chapter7/UseStateList2';
// chapter10 실습
import AttendanceBook from './chapter10/AttendanceBook';
// chapter11 실습
import NameForm from './chapter11/NameForm';
// import SignUp from './chapter11/SignUp';
// chapter12 실슬
import SignUp from './component/member/Signup';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
    {/* <CommentList /> */}
    {/* <Counter /> */}
    {/* <UseStateList /> */}
    {/* <ConfirmButton /> */}
    {/* <LandingPage />*/}
    {/* <Counter2 /> */}
    {/* <AttendanceBook /> */}
    {/* <NameForm/> */}
    <SignUp />
    </React.StrictMode>
)
// 뿌리에 render링 할 거야.
// root.render(
//   <React.StrictMode> // Strict 엄격한 (유효성 검사용), 마지막 배포용.
//     {/* <App /> */}
//     {/* <JSX선언 /> */}
//     {/* <Book /> */}
//     {/* <Library /> */}
//     <Clock />
//   </React.StrictMode>
// );
// 1. setInterval(함수(), 밀리초) : 밀리초마다 해당 함수 실행
// setInterval(()=>{root.render(<Clock />)},1000);
// <JSX선언을 import해서 컴포넌트를 불러옴>

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();


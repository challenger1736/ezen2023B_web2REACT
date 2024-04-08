import axios from "axios";
import { useRef, useState } from "react";

export default function Chatting(props){

    // ==========(클라이언트) 웹 소켓 구현 ==========
        // 1. let clientSocket = new WebSocket(서버소켓url);
    // let clientSocket = new WebSocket('ws://localhost:8080/chat');
    // 1. 해당 컴포넌트가 렌더링 될 때 소켓은 재렌더링 방지 useRef
        // useRef(초기값) : {current: 값}
        // - 컴포넌트가 렌더링 될 때 참조값 고정.
    let clientSocket = useRef(null);
        // 2. Ref에 참조가 없으면 웹 소켓을 연결하고
    if(!clientSocket.current){
        clientSocket.current = new WebSocket('ws://192.168.17.85:8080/chat');
        console.log(clientSocket.current);
        // onclose // onerror // onmessage // onopen : WebSocket객체에 포함된 메소드들
            // 각 메소드 정의
                //클라이언트 소켓이 close 되었을때 콜백함수 정리
        clientSocket.current.onclose = (e)=>{console.log(e); console.log('소켓 닫힘')}
                //클라이언트 소켓이 error 났을 때 콜백함수 정리
        clientSocket.current.onerror = (e)=>{console.log(e); console.log('소켓 에러')}
                //클라이언트 소켓이 message받았을 때 콜백함수 정리 // 얘는 채팅방이면 필수!
        clientSocket.current.onmessage = (e)=>{console.log(e); console.log('소켓 메세지받고');
        console.log(e.data);
        msgList.push(e.data);
        setMsgList([...msgList]);
        }
                //클라이언트 소켓이 open 발생했을 때 콜백함수 정리
        clientSocket.current.onopen = (e)=>{console.log(e); console.log('소켓 열림')}
            // 2. 연결된 서버소켓에게 메시지 보내기
        // clientSocket.send('서버소켓 안녕');
    }
        // 확인
    const Enter = (e)=>{
        // console.log(e);
        if(e.code=='Enter'){
            onSend();
        }
    }

    const onSend= ()=>{
        // 연결된 서버소켓에게 메세지 보내기
        clientSocket.current.send(msgInput); //입력받은 데이터 msgInput 보내기
        setMsgInput('');
    }
        // 3. 서버소켓으로 부터 메세지 받기
        // 4. 연결 종료
    //clientSocket.close();
    // ============================================
    // 채팅 내용 입력창
    const [ msgInput, setMsgInput] = useState('');
    // 채팅 창의 내용물 들
    const [ msgList, setMsgList]= useState([]);
    return(<>
    <div>
        <h3>채팅방</h3>
        <div>
            {
                msgList.map((msg)=>{return(<div>{msg}</div>)})
            }
        </div>
        <textarea value={msgInput} onChange={(e)=>{setMsgInput(e.target.value)}} onKeyUp={Enter}></textarea>
        <button type="button" onClick={onSend}>전송</button>
    </div>
    </>)
}
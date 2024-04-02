import axios from "axios";
import { useRef } from "react";


export default function BoardWrite(props){

    // 1. 재랜더링 고정함수 useRef()
    const boardWriteFormRef = useRef(); // {current: undefined} // current에 들어가있음
    console.log(boardWriteFormRef);

    const onWrite = () => {
        console.log(boardWriteFormRef); // 이건 Ref고
        console.log(boardWriteFormRef.current); // 여기 폼이 들어가있음

        //2.
        const boardWriteFormData = new FormData(boardWriteFormRef.current)

        //2.
        axios.post('/board/post.do', boardWriteFormData)
            .then(response =>{console.log(response)
                if(response.data){
                    alert('글쓰기 성공')
                    window.location.href = "/board";
                }else{
                    alert('글쓰기 실패')
                }
            })
            .catch(error => {console.log(error); alert('글쓰기 실패')})

    }

    return(<>
        <h3>게시물쓰기</h3>
        <form ref={boardWriteFormRef}>
            <input name="bcontent" type="type"/>
            <button type="button" onClick={onWrite}>등록</button>
        </form>
    </>)

}
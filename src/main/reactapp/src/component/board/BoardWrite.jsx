import axios from "axios";
import { useRef } from "react";
import MediaCard from "./MediaCard";


export default function BoardWrite(props){

    // 1. 재랜더링 고정함수 useRef() = 얘를 쓰는 애는 따로 바꿔주지 않는 이상 새로 재랜더링되도 고정이다.
    const boardWriteFormRef = useRef(); // {current: undefined} // current에 들어가있음
    // console.log(boardWriteFormRef);

    const onWrite = () => {
        // console.log(boardWriteFormRef); // 이건 Ref고
        // console.log(boardWriteFormRef.current); // 여기 폼이 들어가있음

        //2.
        // const boardWriteFormData = new FormData(boardWriteFormRef.current)

        //2.
        axios.post('/board/post.do', boardWriteFormRef.current)
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
            <input name="uploadList" type="file" multiple accept="image/*"/>
            <button type="button" onClick={onWrite}>등록</button>
        </form>
    </>)

}
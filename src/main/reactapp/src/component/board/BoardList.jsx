import axios from "axios"
import { useEffect, useState } from "react"

export default function BoardList(){
    // 1. useState 변수
    const [boardList, setBoardList] = useState([])

    // 2.
    useEffect(()=>{
        axios.get('/board/get.do')
            .then(response=>{console.log(response)
                setBoardList(response.data);
            })
            .catch(error=>{console.log(error)})
    },[])

    return(<>
        {boardList.map((board)=>{
            return(<div>
                    작성자 : <span> {board.memail} </span>
                    내용 : <span> {board.bcontent} </span>
            </div>)
        })}
    </>)
}
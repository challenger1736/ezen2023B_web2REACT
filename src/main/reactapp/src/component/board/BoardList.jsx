import axios from "axios"
import { useEffect, useState } from "react"
import MediaCard from "./MediaCard"

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
    <div style={{display:"flex"}}>
            {boardList.map((board)=>{
                
                    return(<div>
                        <MediaCard board={board}/>
                    </div>)
                
            })}
    </div>
    </>)
}
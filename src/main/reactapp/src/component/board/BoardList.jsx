import axios from "axios"
import React, { useEffect, useState } from "react"
import MediaCard from "./MediaCard"
import { Pagination } from "@mui/material";

export default function BoardList(){
    // 1. useState 변수
    const [pageDto, setPageDto] = useState({page:1,count:0,data:[]}); // 객체를 받을거니 {} 중괄호

    const handleChange = (event: e, value: value) => {
        pageDto.page = value;
        setPageDto({...pageDto});
      };

      const getBoard = () =>{
        const info = {page:pageDto.page , view:4}
        axios.get('/board/get.do',{params:info})
            .then(response=>{console.log(response)
                setPageDto(response.data);
            })
            .catch(error=>{console.log(error)})
      }
    // 2.
    useEffect(()=>{
        getBoard()
    },[ pageDto.page ])

    return(<>
    <div style={{display:"flex", flexWrap : "wrap"}}>
            {pageDto.data.map((board)=>{
                
                    return(<div>
                        <MediaCard board={board} getBoard={getBoard}/>
                    </div>)
                
            })}
    </div>
    <Pagination count={pageDto.count} page={pageDto.page} onChange={handleChange} />
    </>)
}
// count : 총 페이지수
// page : 현재 페이지
// handleChang : 콜백함수
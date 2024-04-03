import * as React from 'react';

// npm install @mui/material @emotion/react @emotion/styled 해야함!
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { useContext } from 'react';
import { LoginInfoContext } from '../Index';

export default function MediaCard(props) {
    console.log(props); // {board}


    const {loginInfo} = useContext(LoginInfoContext);

    const onDelete = (event, bno , mno)=>{
      console.log(bno);
      console.log(loginInfo);
      if(mno != loginInfo.mno){
        alert('불가능');
        return;
      }
      
      // const navigate = useNavigate();

      axios.delete('/board/delete.do', {params:{bno:bno}})
        .then(r=>{console.log(r);
         //1. get 방식
        //  window.location.href ="/board";
         //2. 라우터 방식
          // 1. useNavigate()훅이 필요함. , import { useNavigate } from 'react-router-dom';
        //  navigator('/board');
        //  setPageDto() ~~~<< 상위 useEffect 에 PageDto.아무것(속성) 넣어서 그거 바꿔주면서 재랜더링.
        // 3. props 방식
        props.getBoard();
        })
        .catch((error)=>{console.log(error)})
    }

  return (
    <Card sx={{ maxWidth: 400 }}>
      <CardMedia
        component="img"
        alt="green iguana"
        height="200"
        image={"/uploadimg/"+props.board.bimgList[0]}
      />
      <CardContent>
        <Typography gutterBottom variant="h5" component="div">
          {props.board.memail}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          {props.board.bcontent}
        </Typography>
      </CardContent>
      <CardActions>
        <Button size="small" onClick={(event)=>onDelete(event, props.board.bno, props.board.mno)}>삭제</Button>
        <Button size="small">Learn More</Button>
      </CardActions>
    </Card>
  );
}
// CSS 파일 호출 : import styles from css파일경로;
import styles from './Comment.css';
// ../ : 상위 , ./ : 현재
// 이미지 파일 호출 : import 이미지변수명 from 이미지파일경로;
import image from './567391.jpg'

export default function Comment(props){
    console.log("props 내용 : "); console.log(props);
    return(<div className="wrapper">
        <div>
            <img src={image} className="image"/>
        </div>
        <div className="contentContainer">
            <span className="nameText">{props.name}</span>
            <span className="commentText">{props.text}</span>
        </div>
    </div>
    )
}
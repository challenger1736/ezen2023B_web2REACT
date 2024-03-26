import { useState } from "react";
import Toolbar from "./Toolbar";


export default function LandingPage(props){

    const[isLoggedIn, setIsLoggedIn] = useState(false);

    const onClickLogin = () => { // 컴포넌트가 불변성이라 const써도 됨.
        setIsLoggedIn(true)
    }
    
    const onClickLogout = () => {
        setIsLoggedIn(false)
    }

    return(
        <div>
            <Toolbar 
            isLoggedIn={isLoggedIn} 
            onClickLogin={onClickLogin} 
            onClickLogout={onClickLogout}/>
            <div style={{padding:16}}>소플과 함께하는 리액트 공부!</div>
        </div>
        
    )
}
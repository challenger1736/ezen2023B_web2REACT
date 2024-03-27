import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./board/Header";
import Home from "./board/Home";
import Footer from "./board/Footer";
import Signup from "./member/Signup";
import Login from "./member/Login";

export default function Index(props){

    return(<>
    <BrowserRouter>
        <div id="wrap">
        <Header/>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/member/signup" element={<Signup/>}/>
                <Route path="/member/login" element={<Login/>}/>
            </Routes>
        <Footer/>
        </div>
    </BrowserRouter>
    </>)
}
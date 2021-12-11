import React from 'react';
import './App.css';
import {Route, Routes} from "react-router-dom";
import {Home} from "./pages/Home";
import {About} from "./pages/About";
import {Main} from "./pages/Main";
import {Help} from "./pages/Help";
import {PageOne} from "./pages/PageOne";
import {PageTwo} from "./pages/PageTwo";
import {ReduxInfo} from "./pages/ReduxInfo";
import {Chat} from "./pages/Chat";
import {Nav} from "./components/nav/Nav";
import {Statistics} from "./pages/Statistics";
import {Info} from "./pages/Info";

function App() {
    return (
        <div className="App">
            <Nav/>
            <div className="Content">
                <Routes>
                    <Route path="/" element={<Home/>}/>
                    <Route path="/home" element={<Home/>}/>
                    <Route path="about" element={<About/>}/>
                    <Route path="main" element={<Main/>}/>
                    <Route path="help" element={<Help/>}/>
                    <Route path="chat" element={<Chat/>}/>
                    <Route path="info" element={<Info/>}/>
                    <Route path="statistics" element={<Statistics/>}/>
                    <Route path="redux-info" element={<ReduxInfo/>}/>
                    <Route path="page/one" element={<PageOne/>}/>
                    <Route path="page/two" element={<PageTwo/>}/>
                </Routes>
            </div>
        </div>
    );
}

export default App;

import React, {useState} from 'react';
import {LoginRequestDto} from "../../dto/dto";
import {useAppDispatch} from "../../app/hooks";
import {loginRequestPost} from "./loginSlice";

export const Login = () => {
    const [login, setLogin] = useState<LoginRequestDto>({username: "", password: ""});
    const dispatch = useAppDispatch();

    const loginRequest = () => {
        dispatch(loginRequestPost(login))
        console.log(login)
    }

    return (
        <div style={{
            marginLeft: '2rem',
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'flex-end',
            width: '10rem'
        }}>
            <input placeholder={'login'} type={'text'} onChange={(f) => {
                setLogin(prevState => ({...prevState, username: f.target.value}));
            }}/>
            <br/>
            <input placeholder={'password'} type={'password'} onChange={(f) => {
                setLogin(prevState => ({...prevState, password: f.target.value}));
            }}/>
            <br/>
            <button onClick={loginRequest}>login</button>
        </div>
    );
};



import React from 'react';
import {useAppDispatch} from "../../app/hooks";
import {logoutRequestPost} from "../login/loginSlice";

export const Logout = () => {

    const dispatch = useAppDispatch();

    const logoutRequest = () => {
        dispatch(logoutRequestPost())
    }

    return (
        <div style={{
            marginLeft: '2rem',
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'flex-end',
            width: '10rem'
        }}>
            <button onClick={logoutRequest}>logout</button>
        </div>
    );
};



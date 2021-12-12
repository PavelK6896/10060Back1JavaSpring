import React, {useEffect, useState} from 'react';
import {ChatCom} from "../components/chat/ChatCom";
import SockJS from "sockjs-client";
import {Stomp} from "@stomp/stompjs";

export const Chat = () => {

    const [active, setActive] = useState({
        sendOne: () => {
        }, sendTwo: () => {
        }
    });

    useEffect(() => {
        let stompClient = Stomp.over(() => new SockJS('http://localhost:8080/ws'));
        stompClient.reconnectDelay = 5000
        stompClient.heartbeatIncoming = 4000
        stompClient.heartbeatOutgoing = 4000

        stompClient.connect(
            {'Authorization': 'Bearer eyJhbG'},
            (e: any) => {
                console.log('connect', e)
                stompClient.subscribe('/topic/message', response => {
                    console.log(response, response.body)
                });
                stompClient.subscribe('/chatroom/old.messages', (r) => {
                    console.log(r)
                });

            });

        let sendOne = () => {
            stompClient.send("/app/chat", {}, JSON.stringify({'from': "text1", 'text': "text2"}));
        }
        setActive(prevState => ({...prevState, sendOne}))
        return () => {
            stompClient.disconnect((e: any) => {
                console.log('disconnect', e)
            })
        }
    }, [])


    return (
        <div>
            <h2>Chat</h2>
            <div style={{}}>
                <ChatCom/>
            </div>
            <button onClick={active.sendOne}>sendOne</button>
        </div>
    );
};



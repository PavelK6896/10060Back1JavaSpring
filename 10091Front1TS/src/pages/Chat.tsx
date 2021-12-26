import React, {Dispatch, SetStateAction, useEffect, useState} from 'react';
import {ChatCom} from "../components/chat/ChatCom";
import SockJS from "sockjs-client";
import {Stomp} from "@stomp/stompjs";

let listInit: InstantMessage[] = [
    {username: 1, text: '1 r'} as unknown as InstantMessage,
    {username: 2, text: '2 r'} as unknown as InstantMessage,
    {username: 3, text: '3 t'} as unknown as InstantMessage,
    {username: 4, text: '4 y'} as unknown as InstantMessage,
    {username: 5, text: '5 y'} as unknown as InstantMessage,
    {username: 6, text: '6 i'} as unknown as InstantMessage,
]

export interface InstantMessage {
    username: string
    text: string
}

export const Chat = () => {

    const [listMessage, setListMessage]: [InstantMessage[], Dispatch<SetStateAction<InstantMessage[]>>] = useState(listInit);

    const update = (body: any) => {
        let parse = JSON.parse(body);
        listMessage.push({username: parse.username, text: parse.text} as unknown as InstantMessage)
        console.log(listMessage)
        setListMessage([...listMessage])
    }

    const [active, setActive] = useState({
        sendOne: () => {
        },
        sendTwo: () => {
        },
        sendThree: (text: string) => {
        }
    });

    const chatRoomId = 101

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

                stompClient.subscribe('/chatroom/connected.users', (r) => {
                    console.log('/chatroom/connected.users 1', r)
                });
                stompClient.subscribe('/chatroom/old.messages', (r) => {
                    console.log('/chatroom/old.messages 2', r)
                });

                stompClient.subscribe('/topic/' + chatRoomId + '.public.messages', (r) => {
                    console.log('/topic/' + chatRoomId + '.public.messages', r)
                    update(r.body)
                });
                stompClient.subscribe('/user/queue/' + chatRoomId + '.private.messages', (r) => {
                    console.log('/user/queue/' + chatRoomId + '.private.messages', r)
                });
                stompClient.subscribe('/topic/' + chatRoomId + '.connected.users', (r) => {
                    console.log('/topic/' + chatRoomId + '.connected.users', r)
                });

            });


        let sendOne = () => {
            let instantMessage = {
                'text': "text one"
            }
            stompClient.send("/chatroom/send.message", {}, JSON.stringify(instantMessage));
        }
        let sendTwo = () => {
            stompClient.send("/app/chat", {}, JSON.stringify({'from': "text1", 'text': "text2"}));
        }

        let sendThree = (text: string) => {
            let instantMessage = {
                'text': text
            }
            stompClient.send("/chatroom/send.message", {}, JSON.stringify(instantMessage));
        }

        setActive(prevState => ({...prevState, sendOne, sendTwo, sendThree}))
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
                <ChatCom listMessage={listMessage} sendThree={active.sendThree}/>
            </div>
            <button onClick={active.sendOne}>sendOne</button>
        </div>
    );
};



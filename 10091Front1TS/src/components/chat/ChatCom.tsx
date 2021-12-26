import React, {useState} from 'react';
import {InstantMessage} from "../../pages/Chat";


interface FullProps {
    listMessage: InstantMessage[]
    sendThree: (text: string) => void
}


export const ChatCom = ({listMessage, sendThree}: FullProps) => {


    const [input, setInput] = useState('');

    const iu = (e: any) => {
        setInput(e.target.value)
    }

    const key = (e: any) => {
        if (e.charCode === 13) {
            sendThree(input)
        }
    }

    return (
        <div
            style={{
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'flex-start'
            }}
        >
            <div style={{
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'flex-start',
                backgroundColor: '#525252',
                width: '400px',
                height: '400px',
                overflow: "auto"
            }}>
                {
                    listMessage.map((v, k) => {
                        return <div key={k}>{v.text}</div>
                    })
                }
            </div>
            <div>
                <input style={{
                    width: '350px',
                    height: '50px'
                }}
                       onChange={iu}
                       onKeyPress={key}
                />
                <button
                    style={{
                        width: '50px',
                        height: '50px'
                    }}
                    onClick={() => sendThree(input)}
                >send
                </button>
            </div>

        </div>
    )
}
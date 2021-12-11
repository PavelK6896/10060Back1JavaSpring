import React, {useState} from 'react';


let listInit = [
    {id: 1, text: '1 r'},
    {id: 2, text: '2 r'},
    {id: 3, text: '3 t'},
    {id: 4, text: '4 y'},
    {id: 5, text: '5 y'},
    {id: 6, text: '6 i'},
]

export const ChatCom = () => {

    const [list, setList] = useState(listInit);
    const [input, setInput] = useState('');

    const iu = (e: any) => {
        setInput(e.target.value)
    }

    const send = () => {
        list.push({id: list.length - 1, text: input})
        setList([...list])
    }

    const key = (e: any) => {
        if (e.charCode === 13) {
            send()
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
                height: '400px'
            }}>
                {
                    list.map((v, k) => {
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
                    onClick={send}

                >send
                </button>
            </div>

        </div>
    )
}
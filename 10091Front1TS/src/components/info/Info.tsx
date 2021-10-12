import React, {useState} from 'react';


let listInit = [
    {id: 1, name: '1 r', description: 'What is', count: 23},
    {id: 2, name: '2 r', description: 'new', count: 33},
    {id: 3, name: '3 r', description: 'That to', count: 55},
]

export const Info = () => {
    const [list, setList] = useState(listInit);


    return (
        <div
            style={{
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'flex-start',
            }}
        >
            <div style={{
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'flex-start',
                backgroundColor: '#ffffff',
                width: '400px',
                height: '400px'
            }}>
                <div style={{
                    display: 'flex',
                    flexDirection: 'column',
                    width: '400px',
                }}>
                    <div style={{
                        display: 'flex',
                        flexDirection: 'row',
                        justifyContent: 'space-between',
                        width: '300px',
                    }}>
                        <div>Name</div>
                        <div>Description</div>
                        <div>Count</div>
                    </div>
                    {
                        list.map((v, k) => {
                            return <div key={k} style={{
                                display: 'flex',
                                flexDirection: 'row',
                                justifyContent: 'space-between',
                                width: '400px',
                            }}>
                                <div>{v.name}</div>
                                <div>{v.description}</div>
                                <div>{v.count}</div>
                                <button>Join</button>
                            </div>
                        })
                    }

                </div>
            </div>
        </div>
    )
}
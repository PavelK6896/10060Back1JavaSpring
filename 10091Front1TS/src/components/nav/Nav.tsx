import React, {useState} from 'react';
import {NavLink} from "react-router-dom";
import {Login} from "../login/Login";
import {Logout} from "../logout/Logout";


interface LinkTypeOne {
    id: number
    type: number
    name: string
}

export const Nav = () => {
    const [link] = useState(() => {
        let map = new Map<string, LinkTypeOne>();
        map.set('home', {type: 1, id: 2, name: 'Home'} as LinkTypeOne)
        map.set('main', {type: 1, id: 1, name: 'Main'} as LinkTypeOne)
        map.set('help', {type: 1, id: 4, name: 'Help'} as LinkTypeOne)
        map.set('about', {type: 1, id: 3, name: 'About'} as LinkTypeOne)
        map.set('chat', {type: 1, id: 2, name: 'Chat'} as LinkTypeOne)
        map.set('statistics', {type: 1, id: 6, name: 'Statistics'} as LinkTypeOne)
        map.set('info', {type: 1, id: 7, name: 'Info'} as LinkTypeOne)
        map.set('redux-info', {type: 1, id: 10, name: 'Redux info'} as LinkTypeOne)
        return map;
    });

    return (
        <div className="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style={
            {
                width: '20%',
                maxWidth: '240px',
                minWidth: '100px',
                left: 0,
                top: 0,
                zIndex: 9
            }
        }>
            <ul className="nav nav-pills flex-column mb-auto">
                {
                    Array.from(link)
                        .filter(v => v[1].type === 1)
                        .sort((a, b) => (a[1].id - b[1].id))
                        .map(v => {
                            return (<li className="nav-item" key={v[0]}>
                                <NavLink to={'/' + v[0]}
                                         className={({isActive}) => 'nav-link ' + (isActive ? 'active' : 'inactive')}
                                >
                                    {v[1].name}
                                </NavLink>
                            </li>)
                        })
                }
            </ul>

            <div>
                <Login/>
                <Logout/>
            </div>

        </div>
    );
};


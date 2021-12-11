import React from 'react';
import {Info} from "../components/info/Info";

export const Main = () => {

    return (
        <div>
            <h2>Main</h2>
            <div style={{
                display: "flex",
                flexDirection: 'row',
            }}>
                <div
                    style={{
                        display: 'flex',
                        flexDirection: "column",
                        alignItems: 'flex-start',
                        alignContent: 'flex-start',
                        width: '20%'
                    }}
                >
                </div>
                <div style={{
                    marginLeft: '200px'
                }}>
                    <Info/>
                </div>
            </div>
        </div>
    );
};



import React, { useState, useEffect } from 'react'
import Team from './Team';

import SockJsClient from 'react-stomp';

const API_CONTEXT = process.env.REACT_APP_API_CONTEXT;
const SOCKET_URL = process.env.REACT_APP_WEBSOCKET_SCORE_ENDPOINT;


export default function ScoreBoard() {

    const [scores, setscores] = useState([])

    let onConnected = () => {
        console.log("Websocket connected!!")
    }

    let onMessageReceived = (updatedScore) => {
        console.log("Webscoket msg received :: ", updatedScore);
        // Pick and update the updatedScore from the Array
        let updatedScores = [...scores];
        const targetIdx = scores.findIndex(s => s.id === updatedScore.id);
        updatedScores[targetIdx] = updatedScore;
        setscores(updatedScores);
    }


    useEffect(() => {

        console.log(API_CONTEXT);
        fetch(API_CONTEXT + '/scores')
            .then(res => res.json())
            .then(data => {
                console.log('data : ', data);
                setscores(data)
            })
            .catch(error => {
                console.log('Error :::', error);
            })

    }, [])



    return (
        <div>
            <br></br>

            {scores.map((score, idx) =>
                <Team key={'score' + idx} score={score}></Team>
            )}

            <SockJsClient
                url={SOCKET_URL}
                topics={['/topic/message']}
                onConnect={onConnected}
                onDisconnect={console.log("Disconnected!")}
                onMessage={msg => onMessageReceived(msg)}
                debug={false}
            />

        </div>


    )
}

import React, { useEffect, useState } from 'react'
import PropTypes from 'prop-types'

import { Card } from 'react-bootstrap';


const Team = props => {

    const [listening, setListening] = useState(false);

    let score = props.score;
    // let eventSource = undefined;
    let ws = new WebSocket("ws://localhost:8080/hello");

    useEffect(() => {
        if (!listening) {

            ws.onopen = ((ws, e) => {
                console.log('onopen : ', e, ws);
            })

            ws.onmessage = (ev => {
                console.log('onmessage : ', ev);
            })


            ws.onerror = (ev => {
                console.log('onerror : ', ev);
            })

            // eventSource = new EventSource("http://localhost:8080/api/scores", { 'withCredentials': true });

            // eventSource.onopen = (event) => {
            //     console.log("connection opened")
            // }

            // eventSource.onmessage = (event) => {
            //     console.log("result", event.data);

            // }
            setListening(true);
        }

        return () => {
            // eventSource.close();
            // console.log("eventsource closed")
        }
    }, [])

    const send = () => {
        console.log('clicked...', ws);
        ws.send("hello ws");
    }

    return (
        <div>

            <Card style={{ width: '18rem' }} >
                <Card.Body>
                    <Card.Title>{score.team}</Card.Title>
                    <Card.Text >
                        <h1>{score.score}</h1>
                    </Card.Text>
                    <button onClick={send} >Send</button>
                </Card.Body>
            </Card>
        </div>
    )
}

Team.propTypes = {}

export default Team
import React, { useEffect, useState } from 'react'
import PropTypes from 'prop-types'
import { Card } from 'react-bootstrap';
import SockJsClient from 'react-stomp';

const SOCKET_URL = 'http://localhost:8080/ws-message';

const Team = props => {

    let score = props.score;

    const [listening, setListening] = useState(false);



    useEffect(() => {

        return () => {
            // eventSource.close();
            console.log("useeffect")
        }
    }, [])

    const send = () => {
        console.log('clicked...');

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
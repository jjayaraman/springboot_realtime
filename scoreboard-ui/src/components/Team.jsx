import React, { useEffect } from 'react'
import PropTypes from 'prop-types'

import { Card } from 'react-bootstrap';


const Team = props => {

    let score = props.score;
    let eventSource;
    useEffect(() => {
        eventSource = new EventSource("http://localhost:8080/api/scores");

        eventSource.onopen = (event) => {
            console.log("connection opened")
        }

        eventSource.onmessage = (event) => {
            console.log("result", event.data);

        }

    }, [])


    return (
        <div>

            <Card style={{ width: '18rem' }} >
                <Card.Body>
                    <Card.Title>{score.team}</Card.Title>
                    <Card.Text >
                        <h1>{score.score}</h1>
                    </Card.Text>
                </Card.Body>
            </Card>
        </div>
    )
}

Team.propTypes = {}

export default Team
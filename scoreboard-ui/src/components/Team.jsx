import React from 'react'
import PropTypes from 'prop-types'
import { Card } from 'react-bootstrap';


const Team = props => {

    let score = props.score;

    return (
        <div>

            <Card style={{ width: '18rem' }} >
                <Card.Body>
                    <Card.Header>{score.team}</Card.Header>
                    <Card.Text >
                        <h1>{score.score}</h1>
                    </Card.Text>
                </Card.Body>
            </Card>
        </div>
    )
}

Team.propTypes = {
    team: PropTypes.string,
    score: PropTypes.object
}

export default Team
import React from 'react'
import PropTypes from 'prop-types'

import { Card } from 'react-bootstrap';


const Team = props => {
    return (
        <div>

            <Card style={{ width: '18rem' }} >
                <Card.Body>
                    <Card.Title>{props.score.team}</Card.Title>
                    <Card.Text >
                        <h1>{props.score.score}</h1>
                    </Card.Text>
                </Card.Body>
            </Card>
        </div>
    )
}

Team.propTypes = {}

export default Team
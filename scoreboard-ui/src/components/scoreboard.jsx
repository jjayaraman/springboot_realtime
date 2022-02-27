import React, { useState, useEffect } from 'react'
import Team from './Team';

export default function ScoreBoard() {

    const [scores, setscores] = useState([])

    const API_CONTEXT = process.env.REACT_APP_API_CONTEXT;


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

        </div>


    )
}

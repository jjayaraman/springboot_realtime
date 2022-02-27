
const API_CONTEXT = process.env.REACT_APP_API_CONTEXT;

export async function getScore() {

    let score = await fetch(API_CONTEXT + "/scores", { method: 'GET' })
        .then(res => res.json)
        .then(data => {
            return data;
        })

    return score;
}
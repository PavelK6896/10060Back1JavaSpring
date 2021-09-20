export const get = async (url = '', data = {}) => {
    const response = fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getToken()
        },
        body: JSON.stringify(data)
    });
    return response.then(f => {
            console.log(f.status)
            const j = f.json()
            console.log("+", j)
            return j
        }
    ).catch(c => {
        console.log("-", c)
    })
}


export const post = async (url = '', data = {}) => {
    const response = fetch(url, {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
            'Content-Type': 'application/json',
            'Authorization': getToken()
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
        body: JSON.stringify(data)
    });
    return response.then(f => {
            console.log(f.status)
            const j = f.json()
            console.log("+", j)
            return j
        }
    ).catch(c => {
        console.log("-", c)
    })
}


const getToken = () => {
    const token = localStorage.getItem("token");
    return token == null ? '' : 'Bearer ' + token
}

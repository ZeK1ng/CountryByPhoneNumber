document.getElementById('sender').addEventListener('click', sendRequest);
function sendRequest(){
    const xhr = new XMLHttpRequest();
    xhr.open('GET','http://127.0.0.1:8080/getCountry')
    xhr.responseType = 'json'
    xhr.onload = () => {
        const data = xhr.response;
        console.log(data)
    }
    xhr.send()
}
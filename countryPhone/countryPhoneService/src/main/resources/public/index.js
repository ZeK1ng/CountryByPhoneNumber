const countryName = document.getElementById("countryHolder");
countryName.innerHTML = "Country: ";
document.getElementById('sender').addEventListener('click', sendRequest);

function sendRequest() {

    const phoneNumber = document.getElementById("phoneNumberInputField").value;

    if (phoneNumber.length !== 0) {
        const xhr = new XMLHttpRequest();
        let requestUrl = "http://127.0.0.1:8080/getCountry?phoneNumber=" + phoneNumber;
        console.log(requestUrl);
        xhr.open('GET', requestUrl);
        xhr.responseType = 'json'
        xhr.onload = () => {
            const data = xhr.response;
            console.log(data)
            if(data["errorMessage"] === null){
                countryName.innerHTML = "Country:" + data["name"]
            }else{
                countryName.innerHTML= "Error: "+ data["errorMessage"];
                countryName.style.color = 'red';
            }
        }
        xhr.send()
    } else {
        document.getElementById("phoneNumberInputField").style.borderColor = 'red';
    }

}
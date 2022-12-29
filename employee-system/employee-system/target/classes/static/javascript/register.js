
const registerForm = document.getElementById('register-form')
const registerFirstName = document.getElementById('register-firstName')
const registerLastName = document.getElementById('register-lastName')
const registerEmail = document.getElementById('register-email')
const registerUsername = document.getElementById('register-username')
const registerPassword = document.getElementById('register-password')

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/employees'


const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        firstName: registerFirstName.value,
        lastName: registerLastName.value,
        email: registerEmail.value,
        username: registerUsername.value,
        password: registerPassword.value
    }

    const response = await fetch(`${baseUrl}/register`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        window.location.replace(responseArr[0])
    }
}

registerForm.addEventListener("submit", handleSubmit)



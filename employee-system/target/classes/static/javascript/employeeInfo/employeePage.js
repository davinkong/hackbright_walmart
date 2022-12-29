const cookieArr = document.cookie.split("=")
const employeeId = cookieArr[1];
const infoContainer = document.getElementById("info-container")

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/info/"





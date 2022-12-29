
//Cookie
const cookieArr = document.cookie.split("=")
const employeeId = cookieArr[1];

//DOM Elements
const submitForm = document.getElementById("note-form")
const infoContainer = document.getElementById("info-container")

//Modal Elements
let streetInfo = document.getElementById(`street-info`)
let cityInfo = document.getElementById(`city-info`)
let stateInfo = document.getElementById(`state-info`)
let zipCodeInfo = document.getElementById(`zip-code-info`)
let phoneNumberInfo = document.getElementById(`phone-info`)
let updateNoteBtn = document.getElementById('update-note-button')

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/info/"

const handleSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
        street: document.getElementById("street-input").value,
        city: document.getElementById("city-input").value,
        state: document.getElementById("state-input").value,
        zipCode: document.getElementById("zip-code-input").value,
        phoneNumber: document.getElementById("phone-input").value
    }
    await addNote(bodyObj);
    document.getElementById("street-input").value = ''
    document.getElementById("city-input").value = ''
    document.getElementById("state-input").value = ''
    document.getElementById("zip-code-input").value = ''
    document.getElementById("phone-input").value = ''

}

async function addNote(obj) {
    const response = await fetch(`${baseUrl}employee/${employeeId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        return getNotes(employeeId);
    }
}

async function getNotes(employeeId) {
    await fetch(`${baseUrl}employee/${employeeId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => postInformation(data))
        .catch(err => console.error(err))
}
async function getNoteById(id){
    await fetch(baseUrl + id, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data => populateModal(data))
        .catch(err => console.error(err.message))
}

async function handleNoteEdit(id){
    let bodyObj = {
        id: id,
        street: streetInfo.value,
        city: cityInfo.value,
        state: stateInfo.value,
        zipCode: zipCodeInfo.value,
        phoneNumber: phoneNumberInfo.value
    }

    await fetch(baseUrl, {
        method: "PUT",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err))

    return getNotes(employeeId);
}
async function handleDelete(id){
    await fetch(`${baseUrl}employee/`+ id, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))

    return getNotes(employeeId);
}



const postInformation = (array) => {
    infoContainer.innerHTML = ''
    array.forEach(obj => {
        let infoForm = document.createElement("div")
        infoForm.classList.add("m-2")
        infoForm.innerHTML = `
            <div class="form-group">
                <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                    <p class="card-text"><strong>Street: </strong>${obj.street}</p>
                    <p class="card-text"><strong>City: </strong>${obj.city}</p>
                    <p class="card-text"><strong>State: </strong>${obj.state}</p>
                    <p class="card-text"><strong>Zip Code: </strong>${obj.zipCode}</p>
                    <p class="card-text"><strong>Phone number: </strong>${obj.phoneNumber}</p>

                    <div class="d-flex justify-content-between">
                    <!--<button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>-->  
                        <button onclick="getNoteById(${obj.id})" type="button" class="btn btn-primary"
                        data-bs-toggle="modal" data-bs-target="#note-edit-modal">
                        Edit
                        </button>
                    </div>
                </div>
            </div>
        `
        infoContainer.append(infoForm);
    })
}
function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

const populateModal = (obj) =>{
    streetInfo.innerText = ''
    streetInfo.innerText = obj.street
    cityInfo.innerText = ''
    cityInfo.innerText = obj.city
    stateInfo.innerText = ''
    stateInfo.innerText = obj.state
    zipCodeInfo.innerText = ''
    zipCodeInfo.innerText = obj.zipCode
    phoneNumberInfo.innerText = ''
    phoneNumberInfo.innerText = obj.phoneNumber

    updateNoteBtn.setAttribute('data-note-id', obj.id)
}

getNotes(employeeId);

submitForm.addEventListener("submit", handleSubmit)

updateNoteBtn.addEventListener("click", (e)=>{
    let id = e.target.getAttribute('data-note-id')
    handleNoteEdit(id);
})
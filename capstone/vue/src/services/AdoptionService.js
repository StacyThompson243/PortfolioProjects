import axios from 'axios';


export default{
    addAdoptionRequest(petId){
        return axios.post(`/pets/${petId}/adopt`)
    },
    viewAdoptionApplications(){
        return axios.get('/adoption_applications')
    },
    // ?? updateAdoptionStatus(id, pet){
    //     return axios.put(`/pet/${id}`, pet)
    // }
}

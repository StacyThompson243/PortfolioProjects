import axios from 'axios';



export default{

    getAllPetImages(id, pet){
        return axios.get(`/pets/${id}`, pet)
    },

    addPetImage(id, petImage){
        return axios.get(`/${id}/edit`, petImage)
    },

    addPet(pet){
        return axios.post('/pets/add', pet)
    },

    updatePet(id, pet){
        return axios.put(`/pets/${id}/edit`, pet)
    }
}

import axios from 'axios';



export default{

    //copied from petService for reference
    
    getAllPetImages(id){
        return axios.get(`/petImage/${id}`)
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

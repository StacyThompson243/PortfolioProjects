import axios from 'axios';



export default{

    getAdoptablePets(){
        return axios.get('/pets')
    },

    getPetById(id){
        return axios.get(`/pets/${id}`)
    }
}

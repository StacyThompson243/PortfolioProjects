import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    activePet: {},
    pets: [
//       {petId: 1,
//       img: 'https://res.cloudinary.com/difcq8eki/image/upload/v1675116167/Dogs/pexels-helena-lopes-1938126_dvvvya.jpg',
//       name: 'Fido',
//       type: 'dog',
//       age: 3,
//       gender: 'male',
//       weight: 35,
//       breed: 'mixed',
//       description: 'Sweet Dog Loves people, squirrels, and mailman',
//       adopted: false
// },
//     {petId: 2,
//       img: 'https://res.cloudinary.com/difcq8eki/image/upload/v1675116130/Dogs/pexels-pixabay-257519_ebxcag.jpg',
//       name: 'Jayna',
//       type: 'dog',
//       age: 3,
//       gender: 'female',
//       weight: 9,
//       breed: 'dachschund',
//       description: 'Looking for a home for this little abandoned guy',
//       adopted: false},
//     {petId: 3,
//       img: 'https://res.cloudinary.com/difcq8eki/image/upload/v1675116120/Dogs/pexels-ylanite-koppens-612813_oddfwy.jpg',
//       name: 'Frank',
//       type: 'dog',
//       age: 2,
//       gender: 'male',
//       weight: 40,
//       breed: 'mixed',
//       description: 'This guy will love you and protect your home forever!',
//       adopted: false},
//     {petId: 4,
//       img: 'https://res.cloudinary.com/difcq8eki/image/upload/v1675186216/Dogs/pexels-vadim-b-127028_byvb2r.jpg',
//       name: 'Peach',
//       type: 'cat',
//       age: 1,
//       gender: 'female',
//       weight: 5,
//       breed: 'scottish fold mix',
//       description: 'Just a baby',
//       adopted: false}
     ]
  },
    getters: {
      pet(state) {
        return state.pets.find(p => p.petId == state.activePet);
      }
  },
  mutations: {
    SET_PETS(state, payload){
      state.pets=payload;
    },
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      state.user.role = user.authorities[0].name;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_ACTIVE_PET(state, petId){
      state.activePet = petId;
    },
    
  }
})

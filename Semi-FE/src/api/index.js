import axios from 'axios';

function showMenuApi() {
    const BASE_URL = '/api';
    return axios.get(BASE_URL);
}

export { showMenuApi };
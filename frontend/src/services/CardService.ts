import ApiService from './ApiService';

const baseURL = "/card-user/"

const CardService = () => ({
  getAll: async () => {
      const {data} = await ApiService.get(baseURL);
      return data;
  },
})

export default CardService

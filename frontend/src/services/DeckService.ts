import CreateDeckDTO from '../models/Deck/CreateDeckDTO';
import ApiService from './ApiService';

const baseURL = "/deck/"

const DeckService = () => ({
  create: async (dto: CreateDeckDTO) => {
      const {data} = await ApiService.post(baseURL, dto);
      return data;
  },
})

export default DeckService

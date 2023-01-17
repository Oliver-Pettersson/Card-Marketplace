import ApiService from './ApiService';

const baseURL = "/user/"

const UserService = () => ({
  getSelf: async () => {
      const {data} = await ApiService.get(baseURL);
      return data;
  },
})

export default UserService

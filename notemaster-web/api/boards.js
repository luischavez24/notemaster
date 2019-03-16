export default class Boards {
  constructor({ $axios }) {
    this.$axios = $axios;
  }
  async getBoards() {
    try {
      return this.$axios.$get('/boards');
    } catch (error) {
      throw error;
    }
  }
}
export default {
  boardsResume(state) {
    return state.boards.map(({ id, name }) => ({ id, name }))
  }
}
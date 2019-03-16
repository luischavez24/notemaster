import { SET_BOARDS } from '@/util/mutations-types'

export default {
  [SET_BOARDS](state, boards) {
    state.boards = boards;
  }
}
import { FETCH_BOARDS } from '@/util/actions-types'
import { SET_BOARDS } from '@/util/mutations-types'
export default {
  async [FETCH_BOARDS] ({ commit }) {
    commit(SET_BOARDS, await this.$boards.getBoards());
  }
}
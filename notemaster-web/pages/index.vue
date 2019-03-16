<template>
  <v-layout wrap row>
    <v-flex v-for="board in boards" :key="board.id">
      <board-card :board="board"></board-card>
    </v-flex>
  </v-layout>
</template>

<script>
import { mapState } from 'vuex'

import BoardCard from '@/components/BoardCard'

import { FETCH_BOARDS } from '@/util/actions-types'


export default {
  components: {
    BoardCard
  },
  async fetch({ store, error }) {
    try {
      await store.dispatch(`boards/${FETCH_BOARDS}`);
    } catch({ status, message }) {
      error({ statusCode: status, message })
    }
  },
  computed: {
    ...mapState('boards', [
      'boards'
    ])
  }
}
</script>

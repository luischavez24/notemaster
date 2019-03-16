<template>
   <v-card class="board px-3 py-2 elevation-3">
    <v-card-title primary-title>
      <h1>{{ board.name }}</h1>
      <v-spacer></v-spacer>
      <span>
        <v-icon small class="mr-2 my-1">fa-calendar-alt</v-icon>
        <span>{{ board.savedAt | formatDate }}</span>
      </span>
    </v-card-title>
    <v-divider></v-divider>
    <v-card-text>
      <v-layout row wrap>
        <v-flex v-for="note in board.notes" :key="note.id"
          xs12 sm6 md4 xl3 px-2 py-2>
          <note-card :note="note"></note-card>
        </v-flex>
      </v-layout>
    </v-card-text>
  </v-card>
</template>

<script>
import NoteCard from '@/components/NoteCard'
export default {
  props: {
    board: Object
  },
  components:{
    NoteCard
  }
}
</script>
<style scoped>
  .board {
    border-top-left-radius: 12px;
    border-bottom-left-radius: 12px;
    border-bottom-right-radius: 12px;
  }
</style>

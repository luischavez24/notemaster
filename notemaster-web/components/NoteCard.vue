<template>
  <v-card class="note elevation-5" :color="note.color" :dark="note.dark">
    <v-card-title primary-title>
      <article>
        <h2>{{ note.title }}</h2>
        <p>{{ note.content }}</p>
      </article>
    </v-card-title>
    <v-divider></v-divider>
    <v-card-actions>
      <v-btn icon flat>
        <v-icon small>fa-star</v-icon>
      </v-btn>
      <v-spacer></v-spacer>
      <span>
        <v-icon size="12" class="mr-1 my-1">fa-calendar-alt</v-icon>
        {{ note.savedAt | formatDate }}
      </span>
    </v-card-actions>
  </v-card>
</template>

<script>

export default {
  props: {
    note: Object
  }
}
</script>

<style scoped>
  .note {
    border-top-left-radius: 12px;
    border-bottom-left-radius: 12px;
    border-bottom-right-radius: 12px;
  }
</style>

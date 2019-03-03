<template>
  <v-layout row wrap>
    <v-flex v-for="note in data" :key="note.id"
      text-xs-center sm6>
      <v-card class="mx-2 my-2" :color="note.color">
        <v-card-title primary-title>
          <h2>{{ note.title }}</h2>
        </v-card-title>
        <v-card-text>
          {{ note.content }}
        </v-card-text>
        <v-card-actions>
          Guardado en: {{ note.savedAt }}
          <br>
          Modificado en: {{ note.modifiedAt }}
        </v-card-actions>
      </v-card>
    </v-flex>
  </v-layout>
</template>
<script>
export default {
  async asyncData({ app }){
    
    let { totalElements, pageSize, currentPage, data } = 
      await app.$axios.$get("/notes/luis.chavez24", {
      params: {
        page: 1,
        size: 20
      }
    });

    return {
      totalElements,
      pageSize,
      currentPage,
      data
    };
  }
}
</script>

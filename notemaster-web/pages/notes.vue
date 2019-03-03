<template>
  <v-layout row wrap>
    <v-flex class="px-2 py-2" v-for="note in data" :key="note.id" sm6>
      <v-card :color="note.color" dark>
        <v-card-title primary-title>
          <div>
            <h3 class="headline mb-0">
              {{ note.title }}
            </h3>
            <div>
              {{ note.content }}
            </div>
          </div>
        </v-card-title>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-tooltip left>
            <template v-slot:activator="{ on }">
              <v-icon dark v-on="on">info</v-icon>
            </template>
            <div>
              <h5>Guardado en: {{ note.savedAt }}</h5>
              <h5>Modificado en: {{ note.modifiedAt }}</h5>
            </div>
          </v-tooltip>
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

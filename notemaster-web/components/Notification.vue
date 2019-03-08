<template>
  <v-alert dismissible type="error" :value="open" outline>
    {{ message || "Error desconocido"}}
  </v-alert>
</template>

<script>
export default {
  props: {
    message: String
  },
  data: () => ({
    open: true
  })
}
</script>

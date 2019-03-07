<template>
  <v-app>
    <v-navigation-drawer
      v-model="drawer"
      :mini-variant="miniVariant"
      :clipped="clipped"
      fixed
      app
    >
      <v-list>
        <v-list-tile avatar exact>
          <v-list-tile-avatar>
            <img :src="user.photoURL">
          </v-list-tile-avatar>
          <v-list-tile-content>
            <v-list-tile-title>
              {{ fullName }}
            </v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
        <v-divider></v-divider>
        <!-- Menu Items -->
        <v-list-tile
          v-for="(item, i) in items"
          :key="i"
          :to="item.to"
          router
          exact
        >
          <v-list-tile-action>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title v-text="item.title" />
          </v-list-tile-content>
        </v-list-tile>
        <!-- Menu Items -->
        <v-spacer></v-spacer>
        <v-list-tile @click.stop="miniVariant = !miniVariant">
          <v-list-tile-action>
            <v-icon>{{ `fa-chevron-${miniVariant ? 'right' : 'left'}`}}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>
              Contraer
            </v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    <v-toolbar
      :clipped-left="clipped"
      fixed
      app
      dark
      color="primary"
    >
      <v-toolbar-side-icon @click="drawer = !drawer" />
      <v-toolbar-title class="ml-1">
        <div class="d-flex align-center">
          <v-icon class="mr-2">{{ icon }}</v-icon>
          <h4>{{ title }}</h4>
        </div>
      </v-toolbar-title>
    </v-toolbar>
    <v-content>
      <v-container>
        <nuxt />
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import { mapState } from 'vuex'
import items from '@/util/menu-items';

export default {
  data() {
    return {
      clipped: true,
      drawer: false,
      fixed: false,
      items,
      miniVariant: false,
      right: true,
      title: 'Notemaster',
      icon: 'fa-sticky-note'
    }
  },
  computed: {
    ...mapState('auth',[
      'user'
    ]),
    fullName(){
      const { firstName, middleName, lastName } = this.user;
      return `${firstName} ${middleName} ${lastName}`
    }
  }
}
</script>

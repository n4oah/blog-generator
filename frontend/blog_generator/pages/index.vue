<template>
  <v-app>
    <v-navigation-drawer class="indigo lighten-1" v-model="drawer" app>
      <div class="text-xs-center">
        <v-btn depressed large flat class="white--text font-weight-bold">Menu List</v-btn>
      </div>
      <v-list>
        <v-list-tile v-for="item in items" :key="item.title">
          <v-list-tile-action>
            <v-icon color="white">{{ item.icon }}</v-icon>
          </v-list-tile-action>

          <v-list-tile-content class="white--text">
            <v-list-tile-title>{{ item.title }}</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>

    <v-toolbar color="indigo white--text" fixed app>
      <v-toolbar-side-icon @click.stop="drawer = !drawer">
        <v-icon color="white">more_vert</v-icon>
      </v-toolbar-side-icon>
      <v-toolbar-title>원 타치 블로그</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn>로그인</v-btn>
      <v-btn>로그아웃</v-btn>
      <v-btn icon>
        <v-icon>search</v-icon>
    </v-btn>
    </v-toolbar>
    
    <v-content>
      <v-container fluid fill-height>
        <v-layout justify-center align-center>
          <v-flex text-xs-center></v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    drawer: false,
    items: [
      { title: 'Dashboard', icon: 'dashboard' },
      { title: 'Account', icon: 'account_box' },
      { title: 'Admin', icon: 'gavel' }
    ]
  }),
  props: {
    source: String
  }
}
</script>
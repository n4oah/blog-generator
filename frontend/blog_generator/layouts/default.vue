<template>
  <v-app>
    <HeaderComponent>
    </HeaderComponent>
    <nuxt />
    <FooterComponent>
    </FooterComponent>
  </v-app>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import * as section from '@/components/'

@Component({
  components: {
    FooterComponent: section.FooterComponent,
    HeaderComponent: section.HeaderComponent
  }
})
class DefaultLayout extends Vue {

}

export default DefaultLayout
</script>

<template>
  <v-app>
    <nuxt />
    <FooterComponent>
    </FooterComponent>
  </v-app>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import FooterComponent from '@/components/Footer.vue'

@Component({
  components: {
    FooterComponent
  }
})
class DefaultLayout extends Vue {

}

export default DefaultLayout
</script>

<template>
  <v-app dark>
    <nuxt />
    <footerComponent>
    </footerComponent>
  </v-app>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import footerComponent from '@/components/footer.vue'

@Component({
  components: {
    footerComponent
  }
})
export default class Default extends Vue {

}
</script>

<!--<template>-->
<!--  &lt;!&ndash; Footer &ndash;&gt;-->

<!--  <mdb-footer class="font-small pt-4 mt-4">-->
<!--        <v-footer-->
<!--            dark-->
<!--            app bottom padless-->
<!--        >-->
<!--          <v-card-->
<!--              flat-->
<!--              tile-->
<!--              class="lighten-1 white&#45;&#45;text text-center"-->
<!--          >-->
<!--            <v-card-text>-->
<!--              <v-btn-->
<!--                  v-for="icon in icons"-->
<!--                  :key="icon"-->
<!--                  class="mx-4 white&#45;&#45;text"-->
<!--                  icon-->
<!--              >-->
<!--                <v-icon size="24px">-->
<!--                  {{ icon }}-->
<!--                </v-icon>-->
<!--              </v-btn>-->
<!--            </v-card-text>-->

<!--            <v-card-text class="white&#45;&#45;text pt-0">-->
<!--              Hello there! This web application is developed by group E. Please note that the social media icons above are useless because I-->
<!--              did not link them with anything 555. Anyway thanks for actually reading it XD. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est.-->
<!--              Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem.-->

<!--            </v-card-text>-->

<!--            <v-divider></v-divider>-->

<!--            <v-card-text class="white&#45;&#45;text">-->
<!--              &copy; {{ new Date().getFullYear() }} — <strong>Group E</strong>-->
<!--            </v-card-text>-->
<!--          </v-card>-->
<!--        </v-footer>-->
<!--  </mdb-footer>-->
<!--</template>-->

<template>
  <v-footer dark
      class="text-white text-center d-flex flex-column"
  >
         <v-card-text>
                  <v-btn
                      v-for="icon in icons"
                      :key="icon"
                      class="mx-4 white--text"
                      icon
                  >
                    <v-icon size="24px">
                      {{ icon }}
                    </v-icon>
                  </v-btn>
                </v-card-text>

    <div class="text-white pt-0">
      Hello there! This web application is developed by group E. Please note that the social media icons above are useless because I
      did not link them with anything 555. Anyway thanks for actually reading it XD. Warning dont click contact. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est.
      Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem.
    </div>

    <v-divider></v-divider>

    <div class="text-white">
      &copy;{{ new Date().getFullYear() }} — <strong>Group E</strong>
    </div>
  </v-footer>
</template>

<script>
export default {
  data: () => ({
    icons: [
      'mdi-facebook',
      'mdi-twitter',
      'mdi-linkedin',
      'mdi-instagram',
    ],
  }),
}
</script>
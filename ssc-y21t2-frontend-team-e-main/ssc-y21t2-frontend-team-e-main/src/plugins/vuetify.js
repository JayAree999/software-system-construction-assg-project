import '@fortawesome/fontawesome-free/css/all.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'
import Vue from "vue";
// import App from './App.vue';
import Vuetify from "vuetify/lib/framework";
import Carousel3d from 'vue-carousel-3d';
import colors from 'vuetify/lib/util/colors'
Vue.use(Vuetify);
Vue.use(Carousel3d);

// new Vue({
//     render: h => h(App),
// }).$mount('#app')

export default new Vuetify({
    icons: {
        iconfont: 'md' || 'fa'
    },
    theme: {
        themes: {
            light: {
                primary: colors.purple,
                secondary: colors.grey.darken1,
                accent: colors.shades.black,
                error: colors.red.accent3,
            },
            dark: {
                primary: colors.blue.lighten3,
            },
        },
    },
});

import moment from 'moment'

export default function(ctx, inject) {
  inject('moment', moment)
}

import Vue from 'vue'

Vue.filter('formatDate', date => moment(date).format("LLL"));
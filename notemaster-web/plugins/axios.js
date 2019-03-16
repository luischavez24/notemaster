import Boards from '@/api/boards'

export default function(ctx, inject) {
  if (!ctx.$axios) {
    console.error( 'Please make sure $axios module is added');
  } else {
    inject('boards',  new Boards(ctx))
  }
}
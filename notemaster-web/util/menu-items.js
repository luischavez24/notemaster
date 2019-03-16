const base = [
  {
    id: 'boards',
    icon: 'fa-chalkboard',
    title: 'Tableros',
    to: '/'
  },
  {
    id: 'favorites',
    icon: 'fa-star',
    title: 'Favoritos',
    to: '/favorites '
  }     
]

function buildItems(submenus = {}) {
  return base.map(item => {
    const subitems = submenus[item.id];
    return subitems ?  {...item, subitems } : item
  })
}

export {
  buildItems
}
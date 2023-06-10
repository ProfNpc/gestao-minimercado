
/* CARRINHO */
let shoppingCart = document.querySelector('.shopping-cart');

document.querySelector('#cart-btn').onclick = () => {
  shoppingCart.classList.toggle('active');
  navbar.classList.remove('active');
}


/* HAMBURGUER */
let navbar = document.querySelector('.navbar');

document.querySelector('#menu-btn').onclick = () => {
  navbar.classList.toggle('active');
  shoppingCart.classList.remove('active');
}

window.onscroll = () => {
  navbar.classList.remove('active');
  shoppingCart.classList.remove('active');
}
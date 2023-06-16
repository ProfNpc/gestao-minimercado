/* HAMBURGUER */
let navbar= document.querySelector('.navbar');

document.querySelector('#menu-btn').onclick = ()=>{ 
  navbar.classList.toggle('active');
  loginForm.classList.remove('active');
  /* searchForm.classList.remove('active'); */
  shoppingCart.classList.remove('active');
}

window.onscroll = () =>{ 
  navbar.classList.remove('active');
  /* searchForm.classList.remove('active'); */
  shoppingCart.classList.remove('active');
  loginForm.classList.remove('active');
}

/* PRODUTOS */
var swiper = new Swiper(".product-slider", {
  loop:true,
  spaceBetween: 20,
  autoplay: {
    delay: 7500,
    disableOnInteraction: false,
  },
  centeredSlides: true,
  breakpoints: {
    0: {
      slidesPerView: 1,
    },
    768: {
      slidesPerView: 2,
    },
    1020: {
      slidesPerView: 3,
    },
  },
});
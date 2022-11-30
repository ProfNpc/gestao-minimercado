class MobileNavber{
    constructor(MobileNavber, navList, navLinks){
        this.mobileMenu = document.querySelector(mobileMenu);
        this.navList = document.querySelector(navList);      
        this.navLinks = document.querySelectorAll(navLinks);      
        this.activeClass = "active";       

        this.hadleClick = thi.hadleClick.bing(this);
    }

animateLinks(){
    this.navLinks.array.forEach((link, index) => {
        link.style.animation
        ?(link.style.animation = "")
        :(link.style.animation = 'navLinkFade 0.5s ease forwards ${index / 7 + 0.3}s')
    });
}

handleClick(){
    this.navList.classList.toggle(this.activeClass);
    this.navMenu.classList.toggle(this.activeClass);
    this.animateLinks();
}

addClickEvent(){
    this.mobileMenu.addEventListener("click", this.handleClick);
  }


init(){
    if(this.mobileMenu){
        this.addClickEvent();
    }
    return this;
}
}

const mobileNavbar = new mobileNavbar(
    ".mobile-menu",
    ".nav-list",
    ".nav-list li",
);
mobileNavbar.init();


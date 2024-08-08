if (document.querySelector('#carouselExampleControls')) {
    lanzarCarrousel("#carouselExampleControls");
}

if (document.querySelector('#carouselExampleCaptions')) {
    lanzarCarrousel("#carouselExampleCaptions");
}

function lanzarCarrousel(nombreCarrousel) {
    var myCarrousel = document.querySelector(nombreCarrousel);

    var carouselHome = new bootstrap.Carousel(myCarrousel, {
        interval: 4000,
        wrap: true
    });
}
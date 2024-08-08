$(document).ready(function() {

    /*Producto*/

    $('#agregar-producto').click(function(event) {
        event.preventDefault();
        loadContent('modulos/form-producto.html');
    });

    $('#volver-producto').click(function(event) {
        event.preventDefault();
        loadContent('modulos/productos.html');
    });

    /*Cliente*/

    $('#agregar-cliente').click(function(event) {
        event.preventDefault();
        loadContent('modulos/form-cliente.html');
    });

    $('#volver-cliente').click(function(event) {
        event.preventDefault();
        loadContent('modulos/clientes.html');
    });


});

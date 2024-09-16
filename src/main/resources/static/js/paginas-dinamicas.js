$(document).ready(function() {

    function loadContent(page) {

        if(localStorage.getItem("session") == null) {
            window.location.href = "/app/index.html";
            return;
        }

        $('#contenido-principal').load(page, function(response, status, xhr) {
            if (status === "error") {
                var msg = "Lo sentimos, hubo un error: ";
                $("#contenido-principal").html(msg + xhr.status + " " + xhr.statusText);
            }
        });
    }

    $('#home').click(function(event) {
        event.preventDefault();
        loadContent('modulos/home.html');
    });
    
    $('#productos').click(function(event) {
        event.preventDefault();
        loadContent('modulos/productos.html');
    });
    
    
    $('#inventario').click(function(event) {
        event.preventDefault();
        loadContent('modulos/inventario.html');
    });
    
    
    $('#clientes').click(function(event) {
        event.preventDefault();
        loadContent('modulos/clientes.html');
    });

    
    loadContent('modulos/home.html');


});

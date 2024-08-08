
if(document.getElementById("btn-producto")) {
    document.getElementById("btn-producto").addEventListener("click", () => {
        crearProducto();
    });

}

function crearProducto() {

    const unidades_medida = document.getElementById("unidad_medida");
    let unidad_medida = unidades_medida.value;

    let producto = {
        cod_barras : document.getElementsByName("cod_barras")[0].value,
        nombre : document.getElementsByName("nombre")[0].value,
        unidad_medida : unidad_medida,
        precio : document.getElementsByName("precio")[0].value,
        fecha_vencimiento : document.getElementsByName("fecha_vencimiento")[0].value
    }

    fetch('http://localhost:8080/app/productos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(producto)
    })
        .then(response => response.json())
        .then(result => {

            if (Object.keys(result).length > 0 ) {
                showAlertModal("Producto creado correctamente", 'success', true);

                setTimeout(function() {
                    loadContent('modulos/productos.html');
                }, 2000); // 3000 milisegundos = 3 segundos

            } else {
                showAlertModal("No se pudo crear el producto", 'success', true);
            }
        })
        .catch(error =>
        {
            console.error('Error:', error);
            console.log('Error al crear el producto');
        });
}

function eliminarProducto(id = 0) {

    if(!confirm("Está seguro de eliminar el producto")) {
        return;
    }

   if (id != 0 && id != "undefined") {
       fetch('http://localhost:8080/app/productos/'+id, {
           method: 'DELETE',
           headers: {
               'Content-Type': 'application/json'
           }
       })
           .then(response => response.text())
           .then(result => {

               if (result == "ok") {
                   showAlertModal("Producto eliminado correctamente", 'success', true);

                   setTimeout(function() {
                       loadContent('modulos/productos.html');
                   }, 2000); // 3000 milisegundos = 3 segundos

               } else {
                   showAlertModal("No se pudo eliminar el producto", 'success', true);
               }
           })
           .catch(error =>
           {
               console.error('Error:', error);
               console.log('Error al eliminar el producto');
           });
   }
}
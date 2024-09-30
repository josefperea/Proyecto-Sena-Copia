
if(document.getElementById("btn-producto")) {
    document.getElementById("btn-producto").addEventListener("click", () => {
        crearProducto();
    });

}

function crearProducto() {
    let obligatorios = comprobarCamposObligatorios("producto-form")

    if( obligatorios.length > 0 ){
        showAlertModal("Los campos: " + obligatorios.join(",") + " son obligatorios", "danger", "Producto", false);
        return;
    }

    const unidades_medida = document.getElementById("unidad_medida");
    let unidad_medida = unidades_medida.value;

    let file = null;

    if (document.getElementsByName("imagen_url")[0].files[0]) {
        file = document.getElementsByName("imagen_url")[0].files[0];
    }

    let producto = {
        cod_barras : document.getElementsByName("cod_barras")[0].value,
        nombre : document.getElementsByName("nombre")[0].value,
        unidad_medida : unidad_medida,
        precio : document.getElementsByName("precio")[0].value,
        fecha_vencimiento : document.getElementsByName("fecha_vencimiento")[0].value,
        imagen_url : (file == null) ? "" : file.name
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
                showAlertModal("Producto creado correctamente", 'success', "Producto", true);

                setTimeout(function() {
                    if (file != null) {
                        subirImagen(result.id, file);
                    }
                }, 1000); // 3000 milisegundos = 3 segundos


                setTimeout(function() {
                    loadContent('modulos/productos.html');
                }, 2000); // 3000 milisegundos = 3 segundos

            } else {
                showAlertModal("No se pudo crear el producto", 'danger', "Producto", false);
            }
        })
        .catch(error =>
        {
            console.error('Error:', error);
            console.log('Error al crear el producto');
        });
}

function modificarProducto(id) {
    let reg = document.querySelectorAll("#tabla-productos tbody tr[data-id='"+id+"'] td:not(.able-action-buttons)");

    let prod = {};

    reg.forEach((td) => {
        let k = td.dataset;
        let v = "";

        if (td.querySelector('input')) {
            v = td.querySelector('input').value;
        } else {
            v = td.innerText;
        }

        prod[Object.keys(k)[0]] = v;
    });

    let obligatorios = comprobarCamposObligatorios("producto-form")

    if( obligatorios.length > 0 ){
        showAlertModal("Los campos: " + obligatorios.join(",") + " son obligatorios", "danger", "Productos", false);
        return;
    }

    fetch('http://localhost:8080/app/productos/'+id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(prod)
    })
        .then(response => response.json())
        .then(result => {

            if (Object.keys(result).length > 0 ) {

                showAlertModal("Producto modificado correctamente", 'success', "Productos", true);

                setTimeout(function() {
                    loadContent('modulos/productos.html');

                    // const backdrop = document.querySelector('.modal-backdrop');

                }, 2000); // 3000 milisegundos = 3 segundos

            } else {
                showAlertModal("No se pudo modificar el producto", 'success', "Productos", false);
            }
        })
        .catch(error =>
        {
            console.error('Error:', error);
            console.log('Error al modificar producto');
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
                   showAlertModal("No se pudo eliminar el producto", 'danger', false);
               }
           })
           .catch(error =>
           {
               console.error('Error:', error);
               console.log('Error al eliminar el producto');
           });
   }
}



function subirImagen(id, file){
    const formData  = new FormData();

    formData.append("imagen", file);

    fetch('http://localhost:8080/app/productos/subir-imagen/'+id, {
        method: 'POST',
        body:formData
    })
        .then(response => response.text())
        .then(result => {
            console.log(result);
        })
        .catch(error =>
        {
            console.error('Error:', error);
            console.log('Error al crear el producto');
        });
}
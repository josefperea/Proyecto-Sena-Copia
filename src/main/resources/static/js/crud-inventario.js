if (document.getElementById("btn-producto")) {
    document.getElementById("btn-producto").addEventListener("click", () => {
    });

    modificarInventario();
}


    function modificarInventario(id, fecha_registro, nota, productoId, nombreProducto, cantidad)
    {
        let inventario = {
            fecha_registro : fecha_registro,
            nota : nota,
            productoId : productoId,
            nombreProducto : nombreProducto,
            cantidad : cantidad
        }

        fetch('http://localhost:8080/app/inventario/'+id, {
        method: 'PUT',
        headers: {
        'Content-Type': 'application/json'
    },
        body:JSON.stringify(inventario)
    })
        .then(response => response.json())
        .then(result => {

        if (Object.keys(result).length > 0 ) {
        showAlertModal("Inventario actualizado", 'success', "Inventario", true);

        setTimeout(function() {
            loadContent('modulos/inventario.html');
        }, 2000);

    } else {
        showAlertModal("No se pudo actualizar el inventario", 'danger', "Inventario", false);
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
    showAlertModal("No se pudo eliminar el producto", 'danger', "Inventario", false);
}
})
    .catch(error =>
{
    console.error('Error:', error);
    console.log('Error al eliminar el producto');
});
}
}

    if(document.getElementById("tabla-productos")) {
        obtenerProductos();
    }

    function obtenerProductos() {
        fetch('http://localhost:8080/app/productos/getProductos', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.text()) // Leer la respuesta como texto
            .then(text => {
                try {
                    // Intentar parsear el texto como JSON
                    const result = JSON.parse(text);
                    if (Array.isArray(result) && result.length > 0) {
                        setTimeout(() => {
                            llenarTablaProductos(result);
                        }, 2000);
                    } else {
                        showAlertModal(result, 'success', true);
                    }
                } catch (error) {
                    showAlertModal(text, 'success', true);
                }
            })
            .catch(error => {
                console.error('Error:', error);
                console.log('Error al obtener productos');
            });
    }


    function llenarTablaProductos(productos) {

            let texto = "";

        productos.forEach((value) => {
            texto += `<tr>
            <td>${value.cod_barras}</td>
            <td>${value.nombre}</td>
            <td>${value.unidad_medida}</td>
            <td>${value.precio}</td>
            <td>${value.fecha_vencimiento}</td>
            <td class='able-action-buttons'>
                <button class='btn btn-warning btn-sm' title='Modificar'>
                    <i class='bi bi-pencil-square'></i>
                </button>
                <button class='btn btn-danger btn-sm' title='Eliminar' onclick='eliminarProducto(${value.id})'>
                    <i class='bi bi-trash-fill'></i>
                </button>
            </td>
        </tr>`;
        });

            $("#tabla-productos tbody").html(texto);

    }

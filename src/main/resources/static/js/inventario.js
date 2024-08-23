
    if(document.getElementById("tabla-inventario")) {
        obtenerInventario();
    }

    function obtenerInventario() {
        fetch('http://localhost:8080/app/inventario/getInventario', {
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
                            llenarTablaInventario(result);
                        }, 2000);
                    } else {
                        showAlertModal(result, 'danger', "Inventario", false);
                    }
                } catch (error) {
                    showAlertModal(text, 'danger', "Inventario", false);
                }
            })
            .catch(error => {
                console.error('Error:', error);
                console.log('Error al obtener el inventario');
            });
    }


    function llenarTablaInventario(inventario) {

        let texto = "";
        let odd = false;

        inventario.forEach((value) => {
            if (odd) { odd = false; clase_par = "par"; }
            else { odd = true; clase_par = "impar"; }

            texto += `<tr>
            <td class="${clase_par}">${value.fecha_registro}</td>
            <td class="${clase_par}" data-productoid="${value.productoId}">${value.nombreProducto}</td>
            <td class="${clase_par}" contenteditable="true">${value.nota}</td>
            <td class="${clase_par}" contenteditable="true" oninput="editableTDNumber(this);" onkeydown="testTDNumber(event);" onblur="">${value.cantidad}</td>
            <td class='able-action-buttons ${clase_par}'>
                <button class='btn btn-warning btn-sm' title='Modificar' onclick="modificarInventario(${value.id}, '${value.fecha_registro}', this.parentNode.parentNode.children[2].innerText, ${value.productoId}, '${value.nombreProducto}', this.parentNode.parentNode.children[3].innerText)">
                    <i class='bi bi-pencil-square'></i>
                </button>
            </td>
        </tr>`;
        });

            $("#tabla-inventario tbody").html(texto);

    }

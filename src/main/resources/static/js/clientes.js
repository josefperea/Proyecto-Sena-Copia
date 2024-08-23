if(document.getElementById("tabla-clientes")) {
    obtenerClientes();
}

function obtenerClientes() {
    fetch('http://localhost:8080/app/clientes/getClientes', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.text()) // Leer la respuesta como texto
        .then(text => {
            console.log("obtenerClientes");

            try {
                // Intentar parsear el texto como JSON
                const result = JSON.parse(text);
                if (Array.isArray(result) && result.length > 0) {
                    setTimeout(() => {
                        llenarTablaClientes(result);
                    }, 2000);
                } else {
                    showAlertModal(result, 'danger', "Clientes", false);
                }
            } catch (error) {
                showAlertModal(text, 'danger', "Clientes", false);
            }
        })
        .catch(error => {
            console.error('Error:', error);
            console.log('Error al obtener clientes');
        });
}


function llenarTablaClientes(clientes) {

    let texto = "";
    let odd = false;

    clientes.forEach((value) => {

        if (odd) { odd = false; clase_par = "par"; }
        else { odd = true; clase_par = "impar"; }

        texto += `<tr data-id='${value.id}'>
            <td class="${clase_par}" contenteditable="true" data-documento="ads">${value.documento}</td>
            <td class="${clase_par}" contenteditable="true" data-nombre="ads">${value.nombre}</td>
            <td class="${clase_par}" contenteditable="true" data-telefono="ads">${value.telefono}</td>
            <td class="${clase_par}" contenteditable="true" data-direccion="ads">${value.direccion}</td>
            <td class="${clase_par}" contenteditable="true" data-correo="ads">${value.correo}</td>
            <td class='able-action-buttons ${clase_par}'>
                <button class='btn btn-warning btn-sm' title='Modificar' onclick='modificarCliente(${value.id})'>
                    <i class='bi bi-pencil-square'></i>
                </button>
                <button class='btn btn-danger btn-sm' title='Eliminar' onclick='eliminarCliente(${value.id})'>
                    <i class='bi bi-trash-fill'></i>
                </button>
            </td>
        </tr>`;
    });

    $("#tabla-clientes tbody").html(texto);

}
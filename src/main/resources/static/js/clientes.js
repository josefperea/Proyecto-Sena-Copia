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
                    showAlertModal(result, 'success');
                }
            } catch (error) {
                showAlertModal(text, 'danger');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            console.log('Error al obtener clientes');
        });
}


function llenarTablaClientes(clientes) {

    let texto = "";

    clientes.forEach((value) => {
        texto += `<tr>
            <td>${value.documento}</td>
            <td>${value.nombre}</td>
            <td>${value.telefono}</td>
            <td>${value.direccion}</td>
            <td>${value.correo}</td>
            <td class='able-action-buttons'>
                <button class='btn btn-warning btn-sm' title='Modificar'>
                    <i class='bi bi-pencil-square'></i>
                </button>
                <button class='btn btn-danger btn-sm' title='Eliminar'>
                    <i class='bi bi-trash-fill'></i>
                </button>
            </td>
        </tr>`;
    });

    $("#tabla-clientes tbody").html(texto);

}
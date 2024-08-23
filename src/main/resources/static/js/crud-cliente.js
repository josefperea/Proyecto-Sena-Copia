if(document.getElementById("btn-cliente")) {
    document.getElementById("btn-cliente").addEventListener("click", () => {
        crearCliente();
    });

}

function crearCliente() {

    let obligatorios = comprobarCamposObligatorios("cliente-form")

    if( obligatorios.length > 0 ){
        showAlertModal("Los campos: " + obligatorios.join(",") + " son obligatorios", "danger", "Clientes", false);
        return;
    }

    let cliente = {
        documento : document.getElementsByName("documento")[0].value,
        nombre : document.getElementsByName("nombre")[0].value,
        telefono : document.getElementsByName("telefono")[0].value,
        direccion : document.getElementsByName("direccion")[0].value,
        correo : document.getElementsByName("correo")[0].value
    }

    fetch('http://localhost:8080/app/clientes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(cliente)
    })
        .then(response => response.json())
        .then(result => {

            if (Object.keys(result).length > 0 ) {
                showAlertModal("Cliente creado correctamente", 'success', "Clientes", true);

                setTimeout(function() {
                    loadContent('modulos/clientes.html');

                    const backdrop = document.querySelector('.modal-backdrop');

                }, 2000); // 3000 milisegundos = 3 segundos

            } else {
                showAlertModal("No se pudo crear el cliente", 'success', "Clientes", false);
            }
        })
        .catch(error =>
        {
            console.error('Error:', error);
            console.log('Error al crear cliente');
        });
}

function modificarCliente(id) {
    let reg = document.querySelectorAll("#tabla-clientes tbody tr[data-id='"+id+"'] td:not(.able-action-buttons)");

    let cli = {};

    reg.forEach((td) => {
        let k = td.dataset;
        let v = td.innerText;
        cli[Object.keys(k)[0]] = v;
    });

    let obligatorios = comprobarCamposObligatorios("cliente-form")

    if( obligatorios.length > 0 ){
        showAlertModal("Los campos: " + obligatorios.join(",") + " son obligatorios", "danger", "Clientes", false);
        return;
    }

    fetch('http://localhost:8080/app/clientes/'+id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(cli)
    })
        .then(response => response.json())
        .then(result => {

            if (Object.keys(result).length > 0 ) {
                showAlertModal("Cliente modificado correctamente", 'success', "Clientes", true);

                setTimeout(function() {
                    loadContent('modulos/clientes.html');

                    const backdrop = document.querySelector('.modal-backdrop');

                }, 2000); // 3000 milisegundos = 3 segundos

            } else {
                showAlertModal("No se pudo modificar el cliente", 'success', "Clientes", false);
            }
        })
        .catch(error =>
        {
            console.error('Error:', error);
            console.log('Error al modificar cliente');
        });
}

function eliminarCliente(id = 0) {

    if(!confirm("Está seguro de eliminar el cliente")) {
        return;
    }

    if (id != 0 && id != "undefined") {
        fetch('http://localhost:8080/app/clientes/'+id, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.text())
            .then(result => {

                if (result == "ok") {
                    showAlertModal("Cliente eliminado correctamente", 'success', "Clientes", true);

                    setTimeout(function() {
                        loadContent('modulos/clientes.html');
                    }, 2000); // 3000 milisegundos = 3 segundos

                } else {
                    showAlertModal("No se pudo eliminar el cliente", 'success', "Clientes", false);
                }
            })
            .catch(error =>
            {
                console.error('Error:', error);
                console.log('Error al eliminar el cliente');
            });
    }
}
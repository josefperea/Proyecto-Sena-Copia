if(document.getElementById("btn-cliente")) {
    document.getElementById("btn-cliente").addEventListener("click", () => {
        crearCliente();
    });

}

function crearCliente() {

    let cliente = {
        documento : document.getElementsByName("documento")[0].value,
        nombre : document.getElementsByName("nombre")[0].value,
        telefono : document.getElementsByName("telefono")[0].value,
        direccion : document.getElementsByName("direccion")[0].value,
        correo : document.getElementsByName("correo")[0].value
    }
    console.log("cliente");

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
                showAlertModal("Cliente creado correctamente", 'success', true);

                setTimeout(function() {
                    loadContent('modulos/clientes.html');

                    const backdrop = document.querySelector('.modal-backdrop');

                }, 2000); // 3000 milisegundos = 3 segundos

            } else {
                showAlertModal("No se pudo crear el cliente", 'success');
            }
        })
        .catch(error =>
        {
            console.error('Error:', error);
            console.log('Error al crear cliente');
        });
}

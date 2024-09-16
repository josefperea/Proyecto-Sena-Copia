document.addEventListener('DOMContentLoaded', function() {

    document.getElementById('login').addEventListener('click', function(event) {
        event.preventDefault();

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        let credenciales = {
            usuario:username,
            clave:password
        }

        login(credenciales);

    });

});


// Cuando se logra acceder se conservan los datos en local storage
function login(data) {
    fetch('http://localhost:8080/app/usuario/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(result => {
            if (result.status == "ok") {
                showAlertModal(result.message, "success", "Inicio", true);

                localStorage.setItem("session", true);
                localStorage.setItem("usuario", result.usuario);

                setTimeout(function() {
                    window.location.href = "http://localhost:8080/app/principal.html";
                }, 2000); // 3000 milisegundos = 3 segundos

            } else {
                showAlertModal(result.message, "danger", "Inicio", false)
            }
        })
        .catch(error => {
            console.error('Error:', error);
            console.log('Error al iniciar sesion');
        });
}


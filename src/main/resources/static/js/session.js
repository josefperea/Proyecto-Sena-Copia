function validateSession() {

    let session = localStorage.getItem("session");

    if(window.location.href.indexOf("index.html") > -1) {
        if(session) {
            window.location.href = '/app/principal.html';
        }
    } else {

        if(!session) {
            window.location.href = '/app/index.html';
        }

    }


    // try {
    //     const response = await fetch('/validate-session', {
    //         method: 'GET',
    //         credentials: 'include' // Asegura que las cookies (si las hay) se envíen con la solicitud
    //     });
    //
    //     if (response.ok) {
    //         const result = await response.json();
    //         if (result.valid) {
    //             console.log('Session is valid.');
    //             // Aquí puedes hacer lo que necesites si la sesión es válida
    //         } else {
    //             console.log('Session is not valid.');
    //             // Aquí puedes redirigir al usuario a la página de inicio de sesión o mostrar un mensaje
    //             window.location.href = '/login'; // Redirigir a la página de inicio de sesión
    //         }
    //     } else {
    //         console.error('Failed to validate session.');
    //         // Manejo de errores si la solicitud falla
    //     }
    // } catch (error) {
    //     console.error('Error validating session:', error);
    //     // Manejo de errores en caso de problemas con la solicitud
    // }
}

// Llamar a la función para validar la sesión al cargar la página
document.addEventListener('DOMContentLoaded', validateSession);

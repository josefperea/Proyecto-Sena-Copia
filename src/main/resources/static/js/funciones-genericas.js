// Cargar páginas dinámicamente
function loadContent(page) {

    if( localStorage.getItem("session") == null ) {
        window.location.href = "/app/index.html";
        return;
    }

    $('#contenido-principal').load(page, function (response, status, xhr) {
        if (status === "error") {
            var msg = "Lo sentimos, hubo un error: ";
            $("#contenido-principal").html(msg + xhr.status + " " + xhr.statusText);
        }
    });
}


// Función para crear y mostrar el modal
function showAlertModal(message, type = 'success', title = "Alerta", automodal) {
    // Crear el modal HTML
    const modalHTML = `
    <div class="modal fade" id="alertModalGenerica" tabindex="-1" aria-labelledby="alertModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="alertModalLabel">${title}</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="alert alert-${type}" role="alert">${message}</div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
  `;

    document.body.insertAdjacentHTML('beforeend', modalHTML);

    const modalElement = document.getElementById('alertModalGenerica');

    if (modalElement) {
        const modalInstance = new bootstrap.Modal(modalElement);
        modalInstance.show();

        // Remover el modal del DOM y limpiar estilos al cerrarse
        modalElement.addEventListener('hidden.bs.modal', () => {
            modalInstance.dispose();
            modalElement.remove();
            document.body.classList.remove('modal-open'); // Elimina la clase modal-open del body

            // Eliminar el backdrop si existe
            const backdrop = document.querySelector('.modal-backdrop');
            if (backdrop) {
                backdrop.remove();
            }
        });

        if (automodal) {
            setTimeout(function () {
                restoreBodyStyles(modalInstance, modalElement);
            }, 2000);
        }
    } else {
        console.error('Modal element not found');
    }
}

// Restaura los estilos de la página al ocltar la modal
function restoreBodyStyles(modalInstance, modalElement) {
    const backdrop = document.querySelector('.modal-backdrop');
    if (backdrop) {
        modalInstance.dispose();
        modalElement.remove();
        document.body.classList.remove('modal-open'); // Elimina la clase modal-open del body
        backdrop.remove();
        document.body.style.overflow = ''; // Restaurar el estilo de overflow
    }
}

// Se agrega evento para cerrar sesión
if (document.getElementById("logout")) {
    document.getElementById("logout").addEventListener("click", () => {
        localStorage.clear();
        window.location.href = "/app/index.html";
    });
}

// Se cambia el nombre del usuario dinámicamente
if (document.getElementById("titulo-usuario")) {
    document.getElementById("titulo-usuario").innerText = localStorage.getItem("usuario");
}

// Borra caracteres diferentes a númericos (Inventario)
function editableTDNumber(td) {
    td.textContent = td.textContent.replace(/[^0-9]/g, '');
}

// Evita que ingrese caracteres que no sean númericos (Inventario)
function testTDNumber(event) {
    const key = event.key;
    if (!/^[0-9\b]|Backspace|Delete|Tab|ArrowLeft|ArrowRight|ArrowUp|ArrowDown/.test(key)) {
        event.preventDefault();
    }
}

// Método para validar dinámicamente los campos obligatorios de los formularios
function comprobarCamposObligatorios(nombre_formulario) {

    let formulario = document.querySelectorAll("#" + nombre_formulario + " input, " + "#" + nombre_formulario + " select");

    let vacios = Array.from(formulario)
        .filter(fld => fld.required && (fld.tagName === 'SELECT' ? fld.value === '' : fld.value.trim() === ''))
        .map(fld => "<b>" + (fld.placeholder || fld.ariaLabel) + "</b>"); // Usa el placeholder o el nombre del campo

    return vacios;
}

// Restringe el uso del teclado (lista desplegable)
function evitarTeclas(campo, event) {
    campo.value="";
    event.preventDefault();
}


function loadContent(page) {
    $('#contenido-principal').load(page, function(response, status, xhr) {
        if (status === "error") {
            var msg = "Lo sentimos, hubo un error: ";
            $("#contenido-principal").html(msg + xhr.status + " " + xhr.statusText);
        }
    });
}


// Función para crear y mostrar el modal
function showAlertModal(message, type = 'success', automodal) {
    // Crear el modal HTML
    const modalHTML = `
    <div class="modal fade" id="alertModalGenerica" tabindex="-1" aria-labelledby="alertModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="alertModalLabel">Alert</h5>
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

        if(automodal) {
            setTimeout(function() {
                restoreBodyStyles(modalInstance, modalElement);
            }, 2000);
        }
    } else {
        console.error('Modal element not found');
    }
}

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

document.getElementById("logout").addEventListener("click", () => {
    localStorage.clear();
    window.location.href = "/app/index.html";
});

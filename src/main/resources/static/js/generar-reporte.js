document.getElementById('generar-reporte').addEventListener('click', function(event) {
    event.preventDefault();
    generarReporte();
});

function generarReporte(data) {
    fetch('http://localhost:8080/app/reportes/generar-excel', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/vnd.ms-excel'
        }
    })
        .then(response => response.blob())
        .then(result => {

            console.log(typeof result);

            if (typeof result == "object") {
                showAlertModal("Se generó el excel correctamente", "success", "Exportar", true);

                setTimeout(function() {
                    // Crear un enlace para descargar el archivo Excel
                    const url = window.URL.createObjectURL(new Blob([result]));
                    const a = document.createElement('a');
                    a.href = url;
                    a.download = 'reporte.xlsx';
                    document.body.appendChild(a);
                    a.click();
                    a.remove();
                }, 2000);

            } else {
                showAlertModal("Error al generar el excel", "danger", "Exportar", false)
            }
        })
        .catch(error => {
            console.error('Error:', error);
            console.log('Error al generar el excel');
        });
}
chartInstance = null;

document.getElementById('cargar-grafico').addEventListener('click', function(event) {
    event.preventDefault();
    cargarGrafico();
});

function cargarGrafico(){
    fetch('http://localhost:8080/app/inventario/getInventario', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/vnd.ms-excel'
        }
    })
        .then(response => response.json())
        .then(result => {

            if (typeof result == "object") {
                // showAlertModal("Se generó el excel correctamente", "success", "Exportar", true);

                setTimeout(function() {
                    pintarGrafico(result.slice(0, 10));
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

function pintarGrafico(datos){

    document.getElementById('grafico-inventario').innerText = "";

    const nombres = datos.map(producto => producto.nombreProducto);
    const cantidades = datos.map(producto => producto.cantidad);
    const colores = nombres.map(() => generarColorAleatorio());

    console.log(nombres);
    console.log(cantidades);
    console.log(colores);

    const ctx = document.getElementById('grafico-inventario');

    if (chartInstance !== null) {
        chartInstance.destroy();
    }

    chartInstance  = new Chart(ctx, {
        type: 'doughnut',
        data : {
            labels: nombres,
            datasets: [{
                labels: nombres,
                data: cantidades,
                backgroundColor: colores,
                hoverOffset: 4
            }]
        },
        options: {}
    });
}



// Generar un color aleatorio en los rangos de azules, grises, y beiges
function generarColorAleatorio() {
    // Seleccionamos aleatoriamente entre los tres rangos de colores
    const tipoColor = Math.floor(Math.random() * 4); // 0 -> azul, 1 -> gris, 2 -> beige

    let color;
    if (tipoColor === 0) {
        // Azul: rango RGB (54, 162, 235) -> (0, 0, 255)
        const r = Math.floor(Math.random() * 55);  // 0 - 54
        const g = Math.floor(Math.random() * 163 + 70);  // 70 - 162
        const b = Math.floor(Math.random() * 56 + 200);  // 200 - 255
        color = `rgb(${r}, ${g}, ${b})`;
    } else if (tipoColor === 1) {
        // Gris: rango RGB (128, 128, 128) -> (192, 192, 192)
        const shade = Math.floor(Math.random() * 65 + 128);  // 128 - 192
        color = `rgb(${shade}, ${shade}, ${shade})`;
    } else if (tipoColor === 2) {
        // Beige: rango RGB (245, 245, 220) -> (255, 255, 240)
        const r = Math.floor(Math.random() * 10 + 200);  // 245 - 255
        const g = Math.floor(Math.random() * 10 + 245);  // 245 - 255
        const b = Math.floor(Math.random() * 20 + 220);  // 220 - 240
        color = `rgb(${r}, ${g}, ${b})`;
    } else {
        // Beige: rango RGB (245, 245, 220) -> (255, 255, 240)
        const r = Math.floor(Math.random() * 40);  // 245 - 255
        const g = Math.floor(Math.random() * 50 + 34);  // 245 - 255
        const b = Math.floor(Math.random() * 70 + 37);  // 220 - 240
        color = `rgb(${r}, ${g}, ${b})`;
    }

    return color;
}


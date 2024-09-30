package com.prueba.prueba_apiN2.controllers;

import com.prueba.prueba_apiN2.config.ProductoMapper;
import com.prueba.prueba_apiN2.controllers.dtos.ProductoDTO;
import com.prueba.prueba_apiN2.services.ProductoService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReportController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    public ReportController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/generar-excel")
    public ResponseEntity<byte[]> generateExcel() {

        List<ProductoDTO> productos = ProductoMapper.toDTOList(productoService.getProductos());

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
            Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Productos");

            // Crear estilo para el encabezado con color #001f3f
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Crear fuente blanca para el encabezado
            Font headerFont = workbook.createFont();
            headerFont.setColor(IndexedColors.WHITE.getIndex());
            headerStyle.setFont(headerFont);

            // Crear estilos alternados para filas pares e impares
            CellStyle evenRowStyle = workbook.createCellStyle();
            evenRowStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            evenRowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle oddRowStyle = workbook.createCellStyle();
            oddRowStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
            oddRowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);


            // Crear la fila de encabezado
            Row headerRow = sheet.createRow(0);
            String[] columns = {"ID", "Nombre", "Precio"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerStyle);  // Aplicar el estilo del encabezado
            }

            // Añadir los productos como filas de datos
            int rowNum = 1;
            for (ProductoDTO producto : productos) {
                Row dataRow = sheet.createRow(rowNum);

                // Crear celdas para cada propiedad de ProductoDTO
                dataRow.createCell(0).setCellValue(producto.getId());
                dataRow.createCell(1).setCellValue(producto.getNombre());
                dataRow.createCell(2).setCellValue(producto.getPrecio());

                // Aplicar estilos alternados en filas pares e impares
                CellStyle rowStyle = (rowNum % 2 == 0) ? evenRowStyle : oddRowStyle;
                for (int i = 0; i < columns.length; i++) {
                    dataRow.getCell(i).setCellStyle(rowStyle);
                }

                rowNum++;
            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);

            workbook.write(out);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "reporte.xlsx");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(out.toByteArray());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}

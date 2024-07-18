package com.prueba.prueba_apiN2.controllers;

import com.prueba.prueba_apiN2.config.InventarioMapper;
import com.prueba.prueba_apiN2.controllers.dtos.InventarioDTO;
import com.prueba.prueba_apiN2.services.InventarioService;
import com.prueba.prueba_apiN2.services.models.InventarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @PostMapping
    public ResponseEntity<InventarioDTO> saveInventario(@RequestBody InventarioDTO request) {
        InventarioDTO response = InventarioMapper.toDTO(
                inventarioService.saveInventario(
                        InventarioModel.create(request.getNombre(),
                                request.getFecha_registro())
                )
        );

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{inventarioId}")
    public ResponseEntity<InventarioDTO> updateInventario(@PathVariable Long inventarioId, @RequestBody InventarioDTO request) {
        InventarioDTO response = InventarioMapper.toDTO(
                inventarioService.updateInventario(
                        inventarioId, request.getNombre(),
                        request.getFecha_registro()
                        )
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{inventarioId}")
    public ResponseEntity<InventarioDTO> searchInventario(
            @PathVariable Long inventarioId
    ) {
        InventarioDTO response = InventarioMapper.toDTO(
                inventarioService.searchInventario(inventarioId)
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getInventario")
    public ResponseEntity<List<InventarioDTO>> getInventario() {
        List<InventarioDTO> response = InventarioMapper.toDTOList(inventarioService.getInventarios());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{inventarioId}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Long inventarioId) {
        inventarioService.deleteInventario(inventarioId);
        return ResponseEntity.ok().build();
    }
}

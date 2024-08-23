package com.prueba.prueba_apiN2.controllers;

import com.prueba.prueba_apiN2.config.ClienteMapper;
import com.prueba.prueba_apiN2.config.ProductoMapper;
import com.prueba.prueba_apiN2.controllers.dtos.ClienteDTO;
import com.prueba.prueba_apiN2.controllers.dtos.ProductoDTO;
import com.prueba.prueba_apiN2.services.ClienteService;
import com.prueba.prueba_apiN2.services.models.ClienteModel;
import com.prueba.prueba_apiN2.services.models.ProductoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<?>  saveCliente(@RequestBody ClienteDTO request) {
        try {
            // Intentar guardar el producto
            ClienteDTO response = ClienteMapper.toDTO(
                    clienteService.saveCliente(
                            ClienteModel.create(request.getDocumento(), request.getNombre(), request.getTelefono(),
                                    request.getDireccion(), request.getCorreo())
                    )
            );

            // Si se guarda correctamente, retorna un mensaje de éxito
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al guardar el producto: " + e.getMessage());
        }
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long clientId, @RequestBody ClienteDTO request) {
        ClienteDTO response = ClienteMapper.toDTO(
                clienteService.updateCliente(
                        clientId, request.getDocumento(), request.getNombre(), request.getTelefono(),
                        request.getDireccion(), request.getCorreo()
                )
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteDTO> searchCliente(
            @PathVariable Long clienteId
    ) {
        ClienteDTO response = ClienteMapper.toDTO(
                clienteService.searchCliente(clienteId)
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getClientes")
    public ResponseEntity<?> getClientes() {
        try {
            List<ClienteDTO> response = ClienteMapper.toDTOList(clienteService.getClientes());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long clienteId) {
        try {
            clienteService.deleteCliente(clienteId);
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}

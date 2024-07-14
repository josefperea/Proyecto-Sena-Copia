package com.prueba.prueba_apiN2.controllers;

import com.prueba.prueba_apiN2.config.ClienteMapper;
import com.prueba.prueba_apiN2.controllers.dtos.ClienteDTO;
import com.prueba.prueba_apiN2.services.ClienteService;
import com.prueba.prueba_apiN2.services.models.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<ClienteDTO> saveCliente(@RequestBody ClienteDTO request) {
        ClienteDTO response = ClienteMapper.toDTO(
                clienteService.saveCliente(
                        ClienteModel.create(request.getDocumento(), request.getNombre(), request.getTelefono(),
                                request.getDireccion(), request.getCorreo())
                )
        );

        return ResponseEntity.ok(response);
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
    public ResponseEntity<List<ClienteDTO>> getClientes() {
        List<ClienteDTO> response = ClienteMapper.toDTOList(clienteService.getClientes());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long clienteId) {
        clienteService.deleteCliente(clienteId);
        return ResponseEntity.ok().build();
    }
}

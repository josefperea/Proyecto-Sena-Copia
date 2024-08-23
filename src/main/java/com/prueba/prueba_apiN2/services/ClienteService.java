package com.prueba.prueba_apiN2.services;

import com.prueba.prueba_apiN2.services.models.ClienteModel;
import com.prueba.prueba_apiN2.services.models.NotFoundException;
import com.prueba.prueba_apiN2.services.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel saveCliente(ClienteModel clienteModel) {
        return clienteRepository.saveCliente(clienteModel);
    }

    public ClienteModel updateCliente(Long clienteId, String documento, String nombre, String telefono, String direccion, String correo) {
        Optional<ClienteModel> optionalClienteModel = clienteRepository.getCliente(clienteId);

        if (optionalClienteModel.isEmpty()) {
            throw new NotFoundException("Cliente no encontrado");
        }

        return clienteRepository.updateCliente(clienteId, ClienteModel.fromData(
                clienteId,
                documento,
                nombre,
                telefono,
                direccion,
                correo
        ));
    }

    public ClienteModel searchCliente(Long clienteId) {

        Optional<ClienteModel> optionalClienteModel = clienteRepository.getCliente(clienteId);

        if (optionalClienteModel.isEmpty()) {
            throw new NotFoundException("Cliente no encontrado");
        }

        return optionalClienteModel.get();
    }

    public void deleteCliente(Long clienteId) {
        clienteRepository.deleteCliente(clienteId);
    }

    public List<ClienteModel> getClientes() {
        List<ClienteModel> optionalClienteModel = clienteRepository.getAllClientes();

        if (optionalClienteModel.isEmpty()) {
            throw new NotFoundException("No se encontraron clientes");
        }

        return optionalClienteModel;
    }
}

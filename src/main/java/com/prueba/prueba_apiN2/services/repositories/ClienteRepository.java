package com.prueba.prueba_apiN2.services.repositories;

import com.prueba.prueba_apiN2.services.models.ClienteModel;
import java.util.List;
import java.util.Optional;


public interface ClienteRepository {
//    ClienteModel changeClienteStatus(Long clienteId, String newStatus);
    ClienteModel saveCliente(ClienteModel clienteModel);
    ClienteModel updateCliente(Long clienteId, ClienteModel clienteModel);

    Optional<ClienteModel> getCliente(Long id);

    void deleteCliente(Long clienteId);

    List<ClienteModel> getAllClientes();

}
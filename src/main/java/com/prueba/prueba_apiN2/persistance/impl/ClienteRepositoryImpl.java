package com.prueba.prueba_apiN2.persistance.impl;

import com.prueba.prueba_apiN2.config.ClienteMapper;
import com.prueba.prueba_apiN2.persistance.entities.ClienteEntity;
import com.prueba.prueba_apiN2.persistance.impl.jpa.JPAClienteRepository;
import com.prueba.prueba_apiN2.services.models.NotFoundException;
import com.prueba.prueba_apiN2.services.models.ClienteModel;
import com.prueba.prueba_apiN2.services.repositories.ClienteRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;


@Component
public class ClienteRepositoryImpl implements ClienteRepository {

    private JPAClienteRepository jpaClienteRepository;

    public ClienteRepositoryImpl (JPAClienteRepository jpaClienteRepository) {
        this.jpaClienteRepository = jpaClienteRepository;
    }

    @Override
    public Optional<ClienteModel> getCliente(Long clienteId) {
        Optional<ClienteEntity> clienteEntity = jpaClienteRepository.findById(clienteId);
        return clienteEntity.isPresent() ? Optional.of(ClienteMapper.toModel(clienteEntity.get())) : Optional.empty();
    }

    @Override
    public ClienteModel saveCliente(ClienteModel clienteModel) {
        ClienteEntity clienteEntity = ClienteMapper.toEntity(clienteModel);
        clienteEntity = jpaClienteRepository.save(clienteEntity);
        return ClienteMapper.toModel(clienteEntity);
    }

    @Override
    public ClienteModel updateCliente(Long taskId, ClienteModel updatedTask) {
        ClienteEntity existingClienteEntity = jpaClienteRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException("Task not found"));

        existingClienteEntity.setDocumento(updatedTask.getDocumento());
        existingClienteEntity.setNombre(updatedTask.getNombre());
        existingClienteEntity.setTelefono(updatedTask.getTelefono());
        existingClienteEntity.setDireccion(updatedTask.getDireccion());
        existingClienteEntity.setCorreo(updatedTask.getCorreo());

        ClienteEntity savedClienteEntity = jpaClienteRepository.save(existingClienteEntity);

        return ClienteMapper.toModel(savedClienteEntity);
    }

    @Override
    public void deleteCliente(Long taskId) {
        jpaClienteRepository.deleteById(taskId);
    }

    @Override
    public List<ClienteModel> getAllClientes() {
        List<ClienteEntity> tasks = jpaClienteRepository.findAll();

        return (!tasks.isEmpty()) ? ClienteMapper.toModelList(tasks) : new ArrayList<>();
    }
}
package com.DriveThru.DriveThru.service;

import com.DriveThru.DriveThru.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.DriveThru.DriveThru.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteSevice {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> listarCliente(){
        return clienteRepository.findAll();
    }

    public Cliente criar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

}

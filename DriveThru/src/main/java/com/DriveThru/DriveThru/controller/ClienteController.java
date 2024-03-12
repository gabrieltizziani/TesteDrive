package com.DriveThru.DriveThru.controller;

import com.DriveThru.DriveThru.model.Cliente;
import com.DriveThru.DriveThru.service.ClienteSevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired // é usada para realizar a injeção de dependência automática em beans gerenciados pelo contêiner Spring
    ClienteSevice clienteSevice;

    @GetMapping
    public List<Cliente> listarCliente(){
        return clienteSevice.listarCliente();
    }

    @PostMapping
    public Cliente criar(@Valid @RequestBody Cliente cliente){
        return clienteSevice.criar(cliente);
    }





}

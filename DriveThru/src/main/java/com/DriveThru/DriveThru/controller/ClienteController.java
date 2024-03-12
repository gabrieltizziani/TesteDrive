package com.DriveThru.DriveThru.controller;

import com.DriveThru.DriveThru.model.Cliente;
import com.DriveThru.DriveThru.service.ClienteSevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Cliente criarCliente(@Valid @RequestBody Cliente cliente){
        return clienteSevice.criarCliente(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (clienteSevice.editarCliente(id, cliente) == null) {
            String mensagem = " o id informado nao existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirCliente(@PathVariable Long id) {
        if (clienteSevice.excluirCliente(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = " o id informado nao existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }
}

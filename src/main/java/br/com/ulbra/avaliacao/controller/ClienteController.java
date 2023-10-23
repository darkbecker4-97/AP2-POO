package br.com.ulbra.avaliacao.controller;

import br.com.ulbra.avaliacao.model.Cliente;
import org.springframework.web.bind.annotation.*;
import br.com.ulbra.avaliacao.services.ClienteService;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping()
    public ArrayList<Cliente> getAll(@RequestParam(name = "idade", required = false) Integer idade) {
        return this.clienteService.getAll(idade);
    }

    @GetMapping("/{id}")
    public Cliente getById(@PathVariable int id) {
        return this.clienteService.getById(id);
    }

    @PostMapping
    public String post(@RequestBody Cliente cliente) {
        return this.clienteService.post(cliente);
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Cliente cliente, @PathVariable int id) {
        return this.clienteService.update(cliente, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return this.clienteService.delete(id);
    }
}


package br.com.ulbra.avaliacao.services;

import br.com.ulbra.avaliacao.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class ClienteService {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private AtomicInteger proximoId = new AtomicInteger(1);
    public ArrayList<Cliente> getAll(Integer idade){
        ArrayList<Cliente> consultaCliente = new ArrayList();
        if(idade != null){
            for(int i = 0; i < this.clientes.size();i++){
                if(this.clientes.get(i).idade() == idade){
                    consultaCliente.add(this.clientes.get(i));
                }
            }
            return consultaCliente;
        }
        return this.clientes;
    }

    public Cliente getById(int clienteId){
        for(int i = 0; i < this.clientes.size();i++){
            if(this.clientes.get(i).id() == clienteId){
                return this.clientes.get(i);
            }
        }
        return null;
    }


    public String post(Cliente cliente) {
        cliente = new Cliente(proximoId.getAndIncrement(), cliente.nome(), cliente.idade(), cliente.profissao());
        clientes.add(cliente);
        return "Cliente adicionado!" + cliente;
    }


    public String update(Cliente cliente, int clientId) {
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).id() == clientId) {
                cliente = new Cliente(clientId, cliente.nome(), cliente.idade(), cliente.profissao());
                this.clientes.set(i, cliente);
                return "Cliente atualizado!" + cliente;
            }
        }
        return "Cliente não encontrado!";
    }


    public String delete(int clientId) {
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).id() == clientId) {
                this.clientes.remove(i);
                return "Cliente removido!";
            }
        }
        return "Cliente não encontrado!";
    }
}

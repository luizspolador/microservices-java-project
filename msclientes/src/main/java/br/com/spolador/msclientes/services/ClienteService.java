package br.com.spolador.msclientes.services;

import br.com.spolador.msclientes.domain.Cliente;
import br.com.spolador.msclientes.infra.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> getByCPF(String cpf){
        return clienteRepository.findByCpf(cpf);
    }
}

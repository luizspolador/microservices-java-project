package br.com.spolador.mscartoes.service;

import br.com.spolador.mscartoes.domain.ClienteCartao;
import br.com.spolador.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}

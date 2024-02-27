package br.com.spolador.msclientes.controllers;

import br.com.spolador.msclientes.domain.Cliente;
import br.com.spolador.msclientes.dto.ClienteSaveRequestDto;
import br.com.spolador.msclientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity save(@RequestBody ClienteSaveRequestDto dto){
        Cliente cliente = dto.toModel();
        clienteService.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosDoCliente(@RequestParam("cpf") String cpf){
        var cliente = clienteService.getByCPF(cpf);
        if(cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }
}

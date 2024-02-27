package br.com.spolador.msclientes.dto;

import br.com.spolador.msclientes.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequestDto {
    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModel(){
        return new Cliente(cpf, nome, idade);
    }
}

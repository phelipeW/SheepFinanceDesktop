/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author abelo
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Entrada extends Transacao implements Serializable {
    private Conta Conta;
    
    public Entrada(String data, Conta conta, Double valor){
        Descricao = conta.getNome();
        super.Data = data;
        super.Valor = valor;
        Conta = conta;
    }
    
    @Override
    public void Movimentar(Double valor) {
        Conta.Credito(valor);
    }
}

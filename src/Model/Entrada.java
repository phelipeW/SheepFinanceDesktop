/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author abelo
 */
public class Entrada extends Transacao {
    public Conta Conta;
    
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author abelo
 */
public class Saida extends Transacao implements Serializable {
    public int Id;
    public Conta Conta;
    
    public Saida(String data, Conta conta, Double valor){
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

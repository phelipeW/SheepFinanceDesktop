/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author abelo
 */
public class Conta implements Serializable {
    private String Nome;   
    private Double Saldo;
    
    public Conta(String nome, Double saldo){
        Nome = nome;
        Saldo = saldo;
    }
    
    public String getNome(){
        return Nome;
    }
    
    public Double getSaldo(){
        return Saldo;
    }

    public void Credito(Double valor) {
        Saldo += valor;
    }

    public void Debto(Double valor) {
        Saldo -= valor;
    }
}

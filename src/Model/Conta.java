/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author abelo
 */
public class Conta {
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

    void Credito(Double valor) {
        Saldo += valor;
    }

    void Debto(Double valor) {
        Saldo -= valor;
    }
}

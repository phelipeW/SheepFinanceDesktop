/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author abelo
 */
public class LocalDatabase {
    Persistencia bd = new Persistencia();
    
    private static ArrayList<Conta> Contas;
    private static ArrayList<Entrada> Entradas;
    private static ArrayList<Saida> Saidas;
    
    public LocalDatabase(){
        Contas = (ArrayList<Conta>)bd.Le("contas.txt");
        Entradas = (ArrayList<Entrada>)bd.Le("entradas.txt");
        Saidas = (ArrayList<Saida>)bd.Le("entradas.txt");
    }
    
    public ArrayList<Conta> getContas(){
        return Contas;
    }
    
    public void addConta(Conta conta){
        Contas.add(conta);
        bd.Escreve(getContas(), "contas.txt");
    }
    
    public void deleteConta(Conta conta){
        Contas.remove(conta);
    }
    
    public Conta getConta(String nome){
        Conta conta = Contas.stream()
            .filter(c -> nome.equals(c.getNome()))
            .findAny()
            .orElse(null);
        
        return conta;
    }
    
    public ArrayList<Entrada> getEntradas(){
        return Entradas;
    }
    
    public void addEntrada(Entrada entrada){
        Entradas.add(entrada);
        bd.Escreve(getEntradas(), "entradas.txt");
    }
        
    public void deleteEntrada(Entrada entrada){
        Entradas.remove(entrada);
    }
    
    public ArrayList<Saida> getSaidas(){
        return Saidas;
    }
    
    public void addSaida(Saida saida){
        Saidas.add(saida);
        bd.Escreve(getSaidas(), "saidas.txt");
    }
    
    public void deleteSaida(Saida saida){
        Saidas.remove(saida);
    }
}

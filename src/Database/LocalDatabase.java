/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author abelo
 */
public class LocalDatabase {
    private static ArrayList<Conta> Contas;
    private static ArrayList<Entrada> Entradas;
    private static ArrayList<Saida> Saidas;
    
    public LocalDatabase(){
        Conta c = Contas.get(0);
        
        addConta(c);
        addEntrada(new Entrada(Date.from(Instant.MIN), c, 200.00));
        addSaida(new Saida(Date.from(Instant.MIN), c, 15.0));
    }
    
    public ArrayList<Conta> getContas(){
        return Contas;
    }
    
    public void addConta(Conta conta){
        Contas.add(conta);
    }
    
    public void deleteConta(Conta conta){
        Contas.remove(conta);
    }
    
    public ArrayList<Entrada> getEntradas(){
        return Entradas;
    }
    
    public void addEntrada(Entrada entrada){
        Entradas.add(entrada);
    }
    
    
    public void deleteEntrada(Entrada entrada){
        Entradas.remove(entrada);
    }
    
    public ArrayList<Saida> getSaidas(){
        return Saidas;
    }
    
    public void addSaida(Saida saida){
        Saidas.add(saida);
    }
    
    public void deleteSaida(Saida saida){
        Saidas.remove(saida);
    }
}

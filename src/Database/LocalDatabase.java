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
    
    private static LocalDatabase instancia;
    
    private static Persistencia bd;
    
    private static ArrayList<Conta> Contas;
    private static ArrayList<Entrada> Entradas;
    private static ArrayList<Saida> Saidas;
 
    private LocalDatabase(){}
    
    public static LocalDatabase GetInstance(){
        if(instancia == null)
        {
            bd = new Persistencia();
            instancia = new LocalDatabase();
            
            Contas = bd.LeContas("contas.txt");
            Entradas = bd.LeEntradas("entradas.txt");
            Saidas = bd.LeSaidas("saidas.txt");

            if(Contas == null)
                Contas = new ArrayList<>();        
            if(Entradas == null)
                Entradas = new ArrayList<>();
            if(Saidas == null)
                Saidas = new ArrayList<>();
        }
        
        return instancia;
    }
    
    public ArrayList<Conta> getContas(){
        return Contas;
    }
    
    public void addConta(Conta conta){
        Contas.add(conta);
        bd.EscreveConta(getContas(), "contas.txt");
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
        //bd.Escreve(getEntradas(), "entradas.txt");
    }
        
    public void deleteEntrada(Entrada entrada){
        Entradas.remove(entrada);
    }
    
    public ArrayList<Saida> getSaidas(){
        return Saidas;
    }
    
    public void addSaida(Saida saida){
        Saidas.add(saida);
        //bd.Escreve(getSaidas(), "saidas.txt");
    }
    
    public void deleteSaida(Saida saida){
        Saidas.remove(saida);
    }
}

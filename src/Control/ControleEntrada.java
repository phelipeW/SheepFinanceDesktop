/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Database.LocalDatabase;
import Model.Conta;
import Model.Entrada;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author pheli
 */
public class ControleEntrada {
    
    LocalDatabase localDataBase = LocalDatabase.GetInstance();
    
    public void SalvarEntrada(double valor, String data, Object conta){
        
        Conta c = localDataBase.getConta((String) conta);
        c.Credito(valor);
        Entrada entrada = new Entrada(data,c,valor);
        localDataBase.addEntrada(entrada);
    }
    
    
    public ArrayList<String> BuscarNomeContas(){
        ArrayList<String> nomesContas = new ArrayList<String>();
        ArrayList<Conta> contas = new ArrayList<Conta>();
        contas = localDataBase.getContas();
        
        for(Conta x : contas){
            String nome;
            nome = x.getNome();
            nomesContas.add(nome);
        }
        
        return nomesContas;
    }
    
    public ArrayList<Conta> BuscarContas(){
        ArrayList<Conta> contas = new ArrayList<Conta>();
        contas = localDataBase.getContas();
                
        return contas;
    }
    
    

}

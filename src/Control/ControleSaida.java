/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Database.LocalDatabase;
import Model.Saida;
import Model.Conta;
import java.util.ArrayList;
/**
 *
 * @author pheli
 */
public class ControleSaida {
    
    LocalDatabase localDataBase = LocalDatabase.GetInstance();
    
    public void SalvarSaida(double valor, String data, Object conta){
        
        Conta c = localDataBase.getConta((String) conta);
        c.Debto(valor);
        Saida s = new Saida(data,c,valor);
        localDataBase.addSaida(s);
    }
    
    public ArrayList<String> BuscarNomeConta(){
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
    
    public ArrayList<Saida> BuscarSaidas(){
        return localDataBase.getSaidas();
    }
}

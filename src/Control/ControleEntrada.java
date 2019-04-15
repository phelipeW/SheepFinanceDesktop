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
    
    LocalDatabase localDataBase = new LocalDatabase();
    
    public void SalvarEntrada(double valor, String data, Object conta){
        Conta c = (Conta) conta;
        Entrada entrada = new Entrada(data,c,valor);
        localDataBase.addEntrada(entrada);
    }
    
    /*
    public List<String> BuscarConta(){
        ArrayList<String> nomesContas = new ArrayList<String>();
        ArrayList<Conta> contas = new ArrayList<Conta>();
        contas = database.getContas();
        
        for(Conta x : contas){
            String nome;
            nome = x.getNome();
            nomesContas.add(nome);
        }
        
        return nomesContas;
    }
*/
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Database.LocalDatabase;
import Model.Conta;
import java.util.ArrayList;
/**
 *
 * @author pheli
 */
public class ControleConta {
    
    LocalDatabase localDataBase = LocalDatabase.GetInstance();
    
    public void SalvarConta(String nome, double valorInicial ){
        Conta c = new Conta(nome,valorInicial);
        localDataBase.addConta(c);
    }
    
    public ArrayList<Conta> BuscarContas(){
        return localDataBase.getContas();
    }
    
    
    
}

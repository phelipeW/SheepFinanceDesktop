/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Database.LocalDatabase;
import Model.Saida;
import Model.Conta;
/**
 *
 * @author pheli
 */
public class ControleSaida {
    
    LocalDatabase localDataBase = new LocalDatabase();
    
    public void SalvarSaida(double valor, String data, Object conta){
        
        Conta c = (Conta) conta;
        Saida s = new Saida(data,c,valor);
        localDataBase.addSaida(s);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Database.ContaDAO;
import Model.Conta;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author pheli
 */
public class ControleConta {
    public void SalvarConta(String nome, double valorInicial ){
        
    }
    
    public List<Conta> BuscarContas(){
        ContaDAO contaDAO = new ContaDAO();
        return contaDAO.listarTodos();
//        return null;
    }
    
    
    
}

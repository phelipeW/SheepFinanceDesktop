/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Database.ContaDAO;
import Database.EntradaDAO;
import Model.Conta;
import Model.Entrada;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


/**
 *
 * @author pheli
 */
public class ControleEntrada {
    public void SalvarEntrada(double valor, String data, Object conta){
        ContaDAO contaDAO = new ContaDAO();
        List<Conta> contaDTO = contaDAO.retornaUm((String)conta);
        
        Entrada entrada = new Entrada();
        entrada.setDescricao(contaDTO.get(0).getNome());
        entrada.setData(data);
        entrada.setValor(valor);
        entrada.setConta(contaDTO.get(0));
        contaDTO.get(0).Credito(valor);
        
        EntradaDAO entradaDAO = new EntradaDAO();
        entradaDAO.incluir(entrada);
        
        
    }
        
    public List<String> BuscarNomeContas(){
        ControleConta controle = new ControleConta();
        List<Conta> contas = controle.BuscarContas();
        List<String> nomes = new ArrayList<String>();
        for(int i = 0; i<contas.size() ;i++){
            nomes.add(contas.get(i).getNome());
        }
        
        return nomes;
    }
        
    public List<Entrada> BuscarEntradas(){
        EntradaDAO entradaDAO = new EntradaDAO();
        return entradaDAO.listarTodos();
    }
    
     public void ExcluirEntrada(int id){
         EntradaDAO entradaDAO = new EntradaDAO();
         entradaDAO.excluir(id);
         
     }
    

}

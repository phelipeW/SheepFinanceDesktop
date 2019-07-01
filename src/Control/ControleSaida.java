/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Database.SaidaDAO;
import Model.Saida;
import Model.Conta;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author pheli
 */
public class ControleSaida {
        
    public void SalvarSaida(double valor, String data, Object conta){
        Conta contaDTO = (Conta)conta;
        
        Saida saida = new Saida();
        saida.setDescricao(contaDTO.getNome());
        saida.setData(data);
        saida.setValor(valor);
        saida.setConta(contaDTO);
        
        SaidaDAO saidaDAO = new SaidaDAO();
        saidaDAO.incluir(saida);
    }
    
    public List<String> BuscarNomeConta(){
        ControleConta controle = new ControleConta();
        List<Conta> contas = controle.BuscarContas();
        List<String> nomes = new ArrayList<String>();
        for(int i = 0; i<contas.size() ;i++){
            nomes.add(contas.get(i).getNome());
        }
        
        return nomes;
    }
    
    public List<Saida> BuscarSaidas(){
        SaidaDAO entradaDAO = new SaidaDAO();
        return entradaDAO.listarTodos();
    }
    
   public void ExcluirSaida(int id){
         SaidaDAO saidaDAO = new SaidaDAO();
         saidaDAO.excluir(id);
         
     }
}

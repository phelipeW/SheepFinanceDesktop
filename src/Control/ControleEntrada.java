/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
        Conta contaDTO = (Conta)conta;
        
        Entrada entrada = new Entrada();
        entrada.setDescricao(contaDTO.getNome());
        entrada.setData(data);
        entrada.setValor(valor);
        entrada.setConta(contaDTO);
        
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
    

}

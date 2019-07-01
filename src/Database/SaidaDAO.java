/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Conta;
import Model.Saida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author abelo
 */
public class SaidaDAO extends AbstractDAO<Saida> {

    @Override
    protected String getStringSQLIncluir() {
        return "INSERT INTO public.\"Entrada\" (conta_id, descricao, data, valor) VALUES (?, ?, ?, ?)";
    }
    
    @Override
    protected String getStringSQLListar() {
        return "SELECT * FROM public.\"Entrada\"";
    }

    @Override
    protected String getStringSQLExcluir() {
        return "DELETE FROM public.\"Entrada\" WHERE id=?";
    }

    @Override
    protected String getStringSQLAlterar() {
        return "UPDATE public.\"Entrada\" SET nome=?, saldo=? WHERE id=?";
    }
    
    @Override
    protected void mapeamentoObjetoRelationalIncluir(PreparedStatement statement, Saida entidade) throws Exception {
        statement.setInt(1, entidade.getConta().getId());
        statement.setString(2, entidade.getDescricao());
        statement.setString(3, entidade.getData());
        statement.setDouble(4, entidade.getValor());
    }

    @Override
    protected Saida populaObjetoListar(ResultSet result) throws Exception {
        return Saida.builder()
            .Id(result.getInt("id"))
            .Conta(Conta.builder().Id(result.getInt("conta_id")).build())
            .Descricao(result.getString("descricao"))
            .Data(result.getString("data"))
            .Valor(result.getDouble("valor"))
            .build();
    }

    @Override
    protected void mapeamentoObjetoRelationalAlterar(PreparedStatement statement, Saida entidade) throws Exception {
        statement.setString(1, entidade.getDescricao());
        statement.setDouble(2, entidade.getValor());
        statement.setString(3, entidade.getDescricao());
        statement.setInt(4, entidade.getConta().getId());
        statement.setInt(5, entidade.getId());
    }

    @Override
    protected Saida populaObjetoOne(ResultSet result) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getStringSQLOne(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

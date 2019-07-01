/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Entrada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author abelo
 */
public class EntradaDAO extends AbstractDAO<Entrada> {

    @Override
    protected String getStringSQLIncluir() {
        return "INSERT INTO public.\"Entrada\" (conta_id, descricao, data, valor) VALUES (?, ?, ?, ?)";
    }

    @Override
    protected void mapeamentoObjetoRelationalIncluir(PreparedStatement statement, Entrada entidade) throws Exception {
        statement.setInt(1, entidade.getConta().getId());
        statement.setString(2, entidade.getDescricao());
        statement.setString(3, entidade.getData());
        statement.setDouble(4, entidade.getValor());
    }

    @Override
    protected String getStringSQLListar() {
        return "SELECT * FROM public.\"Entrada\"";
    }

    @Override
    protected Entrada populaObjetoListar(ResultSet result) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getStringSQLExcluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getStringSQLAlterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void mapeamentoObjetoRelationalAlterar(PreparedStatement statement, Entrada entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

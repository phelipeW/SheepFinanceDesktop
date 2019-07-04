/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Conta;
import Model.Saida;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author abelo
 */
public class SaidaDAO extends AbstractDAO<Saida> {

        public SaidaDAO(){
        try ( Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/sheepfinancedesktop")) {

            //log.info("Criando tabela cliente ...");
//            conn.createStatement().executeUpdate(
//                    "CREATE TABLE cliente ("
//                    + "id int NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT id_cliente_pk PRIMARY KEY,"
//                    + "nome varchar(255),"
//                    + "telefone varchar(30),"
//                    + "idade int,"
//                    + "limiteCredito double,"
//                    + "id_pais int)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    protected String getStringSQLIncluir() {
        return "INSERT INTO saida (conta_id, descricao, data, valor) VALUES (?, ?, ?, ?)";
    }
    
    @Override
    protected String getStringSQLListar() {
        return "SELECT * FROM saida";
    }

    @Override
    protected String getStringSQLExcluir() {
        return "DELETE FROM saida WHERE id=?";
    }

    @Override
    protected String getStringSQLAlterar() {
        return "UPDATE saida SET nome=?, saldo=? WHERE id=?";
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

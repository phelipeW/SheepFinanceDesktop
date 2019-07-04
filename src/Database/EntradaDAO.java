/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Conta;
import Model.Entrada;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author abelo
 */
public class EntradaDAO extends AbstractDAO<Entrada> {
    
        public EntradaDAO(){
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
        return "INSERT INTO entrada (conta_id, descricao, data, valor) VALUES (?, ?, ?, ?)";
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
        return "SELECT * FROM entrada";
    }

    @Override
    protected Entrada populaObjetoListar(ResultSet result) throws Exception {
        return Entrada.builder()
            .Id(result.getInt("id"))
            .Conta(Conta.builder().Id(result.getInt("conta_id")).build())
            .Descricao(result.getString("descricao"))
            .Data(result.getString("data"))
            .Valor(result.getDouble("valor"))
            .build();
    }

    @Override
    protected String getStringSQLExcluir() {
        return "DELETE FROM entrada WHERE id=?";
    }

    @Override
    protected String getStringSQLAlterar() {
        return "UPDATE entrada SET nome=?, saldo=? WHERE id=?";
    }

    @Override
    protected void mapeamentoObjetoRelationalAlterar(PreparedStatement statement, Entrada entidade) throws Exception {
        statement.setString(1, entidade.getDescricao());
        statement.setDouble(2, entidade.getValor());
        statement.setString(3, entidade.getDescricao());
        statement.setInt(4, entidade.getConta().getId());
        statement.setInt(5, entidade.getId());
    }

    @Override
    protected Entrada populaObjetoOne(ResultSet result) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    protected String getStringSQLOne(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

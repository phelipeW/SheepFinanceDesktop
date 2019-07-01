/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;

import Model.Conta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.java.Log;

/**
 *
 * @author abelo
 */
public class ContaDAO extends AbstractDAO<Conta> {

    public ContaDAO(){
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
        return "INSERT INTO public.\"Conta\" (nome, saldo) VALUES (?, ?)";
    }

    @Override
    protected void mapeamentoObjetoRelationalIncluir(PreparedStatement statement, Conta entidade) throws Exception {
        statement.setString(1, entidade.getNome());
        statement.setDouble(2, entidade.getSaldo());
    }

    @Override
    protected String getStringSQLListar() {
        return "SELECT * FROM public.\"Conta\"";
    }

    @Override
    protected Conta populaObjetoListar(ResultSet result) throws Exception {
         return Conta.builder()
            .Id(result.getInt("id"))
            .Nome(result.getString("nome"))
            .Saldo(result.getDouble("saldo"))
            .build();
    }

    @Override
    protected String getStringSQLExcluir() {
        return "DELETE FROM public.\"Conta\" WHERE id=?";
    }

    @Override
    protected String getStringSQLAlterar() {
        return "UPDATE public.\"Conta\" SET nome=?, saldo=? WHERE id=?";
    }

    @Override
    protected void mapeamentoObjetoRelationalAlterar(PreparedStatement statement, Conta entidade) throws Exception {
        statement.setString(1, entidade.getNome());
        statement.setDouble(2, entidade.getSaldo());
        statement.setInt(3, entidade.getId());
    }

    @Override
    protected String getStringSQLOne(String nome) {
        return "SELECT * FROM public.\"Conta\" WHERE nome='"+nome+"'";
    }
    
    @Override
    protected Conta populaObjetoOne(ResultSet result) throws Exception {
        return Conta.builder()
            .Id(result.getInt("id"))
            .Nome(result.getString("nome"))
            .Saldo(result.getDouble("saldo"))
            .build();
    }
    
}

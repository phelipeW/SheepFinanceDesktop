package Database;

import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author abelo
 */
public abstract class AbstractDAO<T> {
    static final String DB_URL = "jdbc:postgresql://localhost/sheepfinancedesktop";
   
    static final String USER = "postgres";
    static final String PASS = "root";
    
    protected abstract String getStringSQLIncluir();
    protected abstract void mapeamentoObjetoRelationalIncluir(PreparedStatement statement, T entidade) throws Exception;
    
    public boolean incluir(T entidade) {
        try ( Connection conn = (Connection)DriverManager.getConnection("jdbc:postgresql://localhost/sheepfinancedesktop", USER, PASS)) {

            String sql = getStringSQLIncluir();

            PreparedStatement statement = conn.prepareStatement(sql);
            mapeamentoObjetoRelationalIncluir(statement, entidade);
            
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) 
                return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    protected abstract String getStringSQLListar();
    protected abstract T populaObjetoListar(ResultSet result) throws Exception;
    
    public List<T> listarTodos() {

        List<T> resultado = new ArrayList<>();

        try ( Connection conn = DriverManager.getConnection("jdbc:derby:memory:database")) {

            String sql = getStringSQLListar();

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next())
                resultado.add(populaObjetoListar (result));


        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    protected abstract String getStringSQLExcluir();
    
    public boolean excluir(int id) {

        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database")) {

            String sql = getStringSQLExcluir();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) 
                return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    protected abstract String getStringSQLAlterar();
    protected abstract void mapeamentoObjetoRelationalAlterar(PreparedStatement statement, T entidade) throws Exception;
    
    public boolean alterar(T entidade) {
        try ( Connection conn = DriverManager.getConnection("jdbc:derby:memory:database")) {

            String sql = getStringSQLAlterar();

            PreparedStatement statement = conn.prepareStatement(sql);
            
            mapeamentoObjetoRelationalAlterar(statement, entidade);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public static AbstractDAO GetInstance() {
        return null;
//        Connection conn = null;
//        Statement stmt = null;
//
//        try{
//            Class.forName("org.postgresql.Driver");
//
//            System.out.println("Connecting to database...");
//            conn = (Connection) DriverManager.getConnection(DB_URL,USER, PASS);
//
//            System.out.println("Creating statement...");
//            stmt = (Statement) conn.createStatement();
//            String sql;
//            sql = "SELECT id FROM Conta";
//            ResultSet rs = (ResultSet) stmt.executeQuery(sql);
//
//            while(rs.next()){
//               int id  = rs.getInt("id");
//               int age = rs.getInt("age");
//               String first = rs.getString("first");
//               String last = rs.getString("last");
//
//               System.out.print("ID: " + id);
//               System.out.print(", Age: " + age);
//               System.out.print(", First: " + first);
//               System.out.println(", Last: " + last);
//            }
//
//            rs.close();
//            stmt.close();
//            conn.close();
//        }catch(SQLException se){
//           se.printStackTrace();
//        }catch(Exception e){
//           e.printStackTrace();
//        }finally{
//           try{
//              if(stmt!=null)
//                 stmt.close();
//           }catch(SQLException se2){
//           }
//           try{
//              if(conn!=null)
//                 conn.close();
//           }catch(SQLException se){
//              se.printStackTrace();
//           }
//        }
//        System.out.println("Goodbye!");
    }
}

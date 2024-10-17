package models;

// Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import models.ConnectDB;

public class Class {
    // Atributes
    
    // Constructor
    public Class(){}

    // Setters

    // Getters

    // Methods
    //@Override
    //public String toString(){}
    
    // DATABASE Methods
    public void inserir(Connection conn){// INSERT INTO table(values, ...) VALUES(?, ...)
        String sqlInsert = "INSERT INTO ...(...) VALUES (...)";
        PreparedStatement stm = null;

        try{
            stm = conn.prepareStatement(sqlInsert);

            // Values to be added on the TABLE
            //stm.setString();
            //stm.setInt();
            //stm.setDouble();
            //stm.setChar();
            stm.execute();
        }
        catch(Exception e){
            e.printStackTrace();;
        }
        try{
            conn.rollback();
        }
        catch(SQLException e1){
            System.out.print(e1.getStackTrace());
        }
    }

    public void alterar(Connection conn){// UPDATE table SET value = ?, ... WHERE VALUE = ?
        String sqlUpdate = "UPDATE ... SET ... = ?, ... WHERE ...";
        PreparedStatement stm = null;
        try{
            stm = conn.prepareStatement(sqlUpdate);
            // Values to be added on the TABLE
            //stm.setString();
            //stm.setInt();
            //stm.setDouble();
            //stm.setChar();
            stm.executeUpdate();
        } 
        catch(SQLException e){
            e.printStackTrace();
            try {
                conn.rollback();
            } 
            catch(SQLException e1){
                e1.printStackTrace();
            }
        } 
        finally{
            try{
                if(stm != null){
                    stm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } 
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void excluir(Connection conn){// DELETE FROM table WHERE value = ?
        String sqlDelete = "DELETE FROM ... WHERE ... = ?";
        PreparedStatement stm = null;
        try{
            stm = conn.prepareStatement(sqlDelete);
            // TABLE with value to be deleted
            //stm.setInt();
            stm.executeUpdate();
        } 
        catch(SQLException e){
            e.printStackTrace();
            try{
                conn.rollback();
            } 
            catch(SQLException e1){
                e1.printStackTrace();
            }
        } 
        finally{
            try{
                if(stm != null){
                    stm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void carregar(Connection conn){// SELECT value, ... FROM table WHERE VALUE = ?
        String sqlSelect = "SELECT ... FROM . WHERE ... = ?";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            stm = conn.prepareStatement(sqlSelect);
            // WHERE value
            //stm.setInt();
            rs = stm.executeQuery();
            if(rs.next()){
                // GET VALUES
                //this.atribute = rs.get'value1'(rs.getString("value1"));
                //this.atribute = rs.get'value2'(rs.getInt("value2"));
            }
        } 
        catch(SQLException e){
            e.printStackTrace();
        } 
        finally{
            try{
                if(rs != null){
                    rs.close();
                }
                else if(stm != null){
                    stm.close();
                }
                else if(conn != null){
                    conn.close();
                }
            } 
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import controllers.ComunicacaoBanco;

/**
 *
 * @author Fernando-PC
 */
public class EstruturaBanco {    
    public void criaBanco() {
        String userName = "root";
        String password = "root";
        String sql = "CREATE DATABASE IF NOT EXISTS db_cursos ";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); /* Aqui registra */
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstruturaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String url = "jdbc:mysql://localhost:3502/mysql?zeroDateTimeBehavior=convertToNull&useTimezone=true&serverTimezone=UTC";
        
        try {        
            Connection connection = DriverManager.getConnection(url,userName, password);
            java.sql.Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(EstruturaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void criarTabelas(){
        ComunicacaoBanco com = new ComunicacaoBanco();
        Connection conexao = com.Conexao();
        try {
            String sql = " CREATE TABLE IF NOT EXISTS curso ("
                        + "  codigo int primary key unique AUTO_INCREMENT, "
                        + "  descricao varchar(50),"
                        + "  ementa text); "; 
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.execute();
            
            sql = " CREATE TABLE IF NOT EXISTS aluno ("
                + "  codigo int primary key unique AUTO_INCREMENT, "
                + "  nome varchar(50) );";
            ps = conexao.prepareStatement(sql);
            ps.execute();            
            
            sql = " CREATE TABLE IF NOT EXISTS curso_aluno( "
                + "  codigo int primary key unique AUTO_INCREMENT, "
                + "  codigo_aluno int, "
                + "  FOREIGN KEY(codigo_aluno)" 
                + "   REFERENCES aluno(codigo)"
                + "   ON UPDATE CASCADE, "
                + "  codigo_curso int,  "
                + "  FOREIGN KEY(codigo_curso) "
                + "   REFERENCES curso(codigo) "
                + "   ON UPDATE CASCADE); ";
            
            ps = conexao.prepareStatement(sql);
            ps.execute(); 
            
        } catch (SQLException ex) {
            Logger.getLogger(EstruturaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}

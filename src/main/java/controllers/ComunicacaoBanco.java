/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Curso;

public class ComunicacaoBanco {
    public Connection Conexao(){
        String userName = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); /* Aqui registra */
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstruturaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:mysql://localhost:3502/db_cursos?zeroDateTimeBehavior=convertToNull&useTimezone=true&serverTimezone=UTC";
        try {        
            Connection connection = DriverManager.getConnection(url,userName, password);
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(EstruturaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}

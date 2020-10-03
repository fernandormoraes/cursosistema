/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando-PC
 */
public class ControllerCurso {
    public Connection Conexao(){
        ComunicacaoBanco com = new ComunicacaoBanco();
        return com.Conexao();
    }
    
    public ResultSet repositoryCursos(){
        Connection conexao = Conexao();
        String sql = "SELECT * FROM curso; ";
        try {
            PreparedStatement stt = (PreparedStatement)conexao.prepareStatement(sql);
            ResultSet rs = stt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ComunicacaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insereCurso(models.Curso curso) throws SQLException{
        Connection conexao = Conexao();
        String sql = "INSERT INTO curso(descricao,ementa) VALUES(?,?) ";
        PreparedStatement stmt = conexao.prepareStatement(sql); 
        
        stmt.setString(1, curso.getDescricao());  
        stmt.setString(2, curso.getEmenta());  
        stmt.execute(); 
        stmt.close();
        
    }
    
    public void alteraCurso(models.Curso curso) throws SQLException{
        Connection conexao = Conexao();
        String sql = "UPDATE curso SET descricao = ?, ementa = ? WHERE codigo = ? ";
        PreparedStatement stmt = conexao.prepareStatement(sql); 
        
        stmt.setString(1, curso.getDescricao());  
        stmt.setString(2, curso.getEmenta());  
        stmt.setInt(3, curso.getCodigo());
        stmt.execute(); 
        stmt.close();        
    }    
}

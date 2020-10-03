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
public class ControllerAluno {
    public Connection Conexao(){
        ComunicacaoBanco com = new ComunicacaoBanco();
        return com.Conexao();
    }
    
    public ResultSet repositoryAlunos(){
        Connection conexao = Conexao();
        String sql = "SELECT aluno.*, curso.descricao, curso.codigo as codigocurso FROM aluno "
                   + "LEFT OUTER JOIN curso_aluno ON curso_aluno.codigo_aluno = aluno.codigo "
                   + "LEFT OUTER JOIN curso ON curso.codigo = curso_aluno.codigo_curso ";
        try {
            PreparedStatement stt = (PreparedStatement)conexao.prepareStatement(sql);
            ResultSet rs = stt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ComunicacaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insereAluno(models.Aluno aluno) throws SQLException{
        int codigoAluno;
        Connection conexao = Conexao();
        String sql = "INSERT INTO aluno(nome) VALUES(?) ";
        PreparedStatement stmt = conexao.prepareStatement(sql); 
        
        stmt.setString(1, aluno.getNome());   
        stmt.execute(); 
        stmt.close();
        
        sql = "SELECT MAX(codigo) AS CODIGO FROM aluno ";
        PreparedStatement stt = (PreparedStatement)conexao.prepareStatement(sql);
        ResultSet rs = stt.executeQuery(sql);
        if(rs.next()){
            codigoAluno = rs.getInt("CODIGO");
            stmt.close();

            sql = "INSERT INTO curso_aluno(codigo_aluno, codigo_curso) VALUES(?, ?) ";
            stmt = conexao.prepareStatement(sql); 

            stmt.setInt(1, codigoAluno);   
            stmt.setInt(2, aluno.getCodigoCurso());   
            stmt.execute(); 
            stmt.close();   
        }
     
        
    }
    
    public void alteraAluno(models.Aluno aluno) throws SQLException{
        Connection conexao = Conexao();
        String sql = "UPDATE aluno SET nome = ? WHERE codigo = ? ";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getCodigo());
            stmt.execute();
        }        
    }   
    
    public String repositoryDescricaoCurso(int codigo) throws SQLException{
        Connection conexao = Conexao();
        String sql = "SELECT descricao FROM curso WHERE codigo = ?";

        try (PreparedStatement stt = conexao.prepareStatement(sql)) {
            stt.setInt(1, codigo);
            ResultSet rs = stt.executeQuery();
            if(rs.next()){
                return rs.getString("descricao");
            }else{
                return "";
            }               
        }
  
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.ControllerAluno;
import controllers.ControllerCurso;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fernando-PC
 */
public class Aluno {
    private String nome;
    private String curso;
    private int codigo;
    private int CodigoCurso;
    
    public String getNome(){
        return this.nome;
    }
    
    public int getCodigoCurso(){
        return this.CodigoCurso;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    private String getCurso(){
        return this.curso;
    }
    
    public void setCurso(String curso){
        this.curso = curso;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void setCodigoCurso(int codigoCurso){
        this.CodigoCurso = codigoCurso;
    }
    
    public ResultSet getAlunos(){
        ControllerAluno aluno = new ControllerAluno();
        return aluno.repositoryAlunos();
    }
    
    public String getDescricaoCurso(int codigo) throws SQLException{
        ControllerAluno aluno = new ControllerAluno();
        return aluno.repositoryDescricaoCurso(codigo);
    }
    
}

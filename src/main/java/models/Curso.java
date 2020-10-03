/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.ComunicacaoBanco;
import controllers.ControllerCurso;
import java.sql.ResultSet;

/**
 *
 * @author Fernando-PC
 */
public class Curso {
    private String descricao;
    private String ementa;
    private int codigo;
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public String getEmenta(){
        return this.ementa;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public void setEmenta(String ementa){
        this.ementa = ementa;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public ResultSet getCursos(){
        ControllerCurso curso = new ControllerCurso();
        return curso.repositoryCursos();
    }
}

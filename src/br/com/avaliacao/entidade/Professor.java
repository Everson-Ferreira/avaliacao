/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avaliacao.entidade;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Professor extends PessoaSenac implements Serializable{
    
    private String cracha;
    private Endereco endereco;
    
    
    public Professor() {
    }

    public Professor(Integer id, String cracha,  String nome, String cpf, String rg, String email) {
        super(id, nome, cpf, rg, email);
        
        this.cracha = cracha;
        
    }

    

   

    public String getCracha() {
        return cracha;
    }

    public void setCracha(String cracha) {
        this.cracha = cracha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

  
   
    
    
}

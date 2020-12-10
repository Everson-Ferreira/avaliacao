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
public class PessoaSenac implements Serializable{
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private String email;
    private List<Telefone> telefone;
    private Endereco endereco;
    
    public PessoaSenac() {
    }

    public PessoaSenac(Integer id, String nome, String cpf, String rg, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
    }

    

   

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}

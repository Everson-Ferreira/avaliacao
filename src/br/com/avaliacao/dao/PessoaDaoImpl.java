/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avaliacao.dao;

import br.com.avaliacao.entidade.Aluno;
import br.com.avaliacao.entidade.PessoaSenac;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LENOVO
 */
public class PessoaDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvarProfessor(PessoaSenac pessoa) throws SQLException {
        String sql = "INSERT INTO pessoasenac(nome, cpf, rg, email) "
                + "VALUES(?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setString(1, pessoa.getNome());
            preparando.setString(2, pessoa.getCpf());
            preparando.setString(3, pessoa.getRg());
            preparando.setString(4, pessoa.getEmail());
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            pessoa.setId(resultSet.getInt(1));

        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar pessoa " + eSQL.getMessage());
        }
    }

    public void alterar(PessoaSenac pessoa) throws SQLException {
        String sql = "UPDATE pessoasenac SET nome = ?, cpf = ?, rg = ?, email = ? WHERE id = ?";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, pessoa.getNome());
            preparando.setString(2, pessoa.getCpf());
            preparando.setString(3, pessoa.getRg());
            preparando.setString(4, pessoa.getEmail());
            preparando.setInt(5, pessoa.getId());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar pessoa " + e.getMessage());

        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM pessoasenac WHERE id = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

}

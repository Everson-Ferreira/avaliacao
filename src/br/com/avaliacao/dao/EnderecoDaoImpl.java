/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avaliacao.dao;

import br.com.avaliacao.entidade.Endereco;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LENOVO
 */
public class EnderecoDaoImpl implements Serializable {

    private PreparedStatement preparando;

    public void salvarEndereco(Endereco endereco, int id, Connection conexao) throws SQLException {
        String sql = "INSERT INTO endereco(logradouro, numero, bairro, cidade, estado, complemento, idPessoa) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, endereco.getLogradouro());
            preparando.setString(2, endereco.getNumero());
            preparando.setString(3, endereco.getBairro());
            preparando.setString(4, endereco.getCidade());
            preparando.setString(5, endereco.getEstado());
            preparando.setString(6, endereco.getComplemento());
            preparando.setInt(7, id);
            preparando.executeUpdate();
        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar endereço " + eSQL.getMessage());
            conexao.rollback();
        }
    }

    public void alterarEndereco(Endereco endereco, Connection conexao) {
        String sql = "UPDATE endereco SET logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, complemento = ? WHERE id = ?";
        try {
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, endereco.getLogradouro());
            preparando.setString(2, endereco.getNumero());
            preparando.setString(3, endereco.getBairro());
            preparando.setString(4, endereco.getCidade());
            preparando.setString(5, endereco.getEstado());
            preparando.setString(6, endereco.getComplemento());
            preparando.setInt(7, endereco.getId());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar " + e.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avaliacao.dao;

import br.com.avaliacao.entidade.Telefone;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TelefoneDaoImpl implements Serializable {

    private PreparedStatement preparando;

    public void salvarTelefone(List<Telefone> telefones, int chaveEstrangeira, Connection conn) throws SQLException {
        String sql = "INSERT INTO telefone(numero, tipo, operadora, idPessoa) VALUES(?, ?, ?, ?)";

        for (Telefone telefone : telefones) {

            salvar(conn, sql, telefone, chaveEstrangeira);

        }

    }

    private void salvar(Connection conexao, String sql, Telefone telefone, int idEstrangeiro) throws SQLException {
        try {
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, telefone.getTipo());
            preparando.setString(2, telefone.getNumero());
            preparando.setString(3, telefone.getOperadora());
            preparando.setInt(4, idEstrangeiro);
            preparando.executeUpdate();
        } catch (SQLException eSQL) {
            System.err.println("Erro ao salvar telofone " + eSQL.getMessage());
        }
    }

   
}

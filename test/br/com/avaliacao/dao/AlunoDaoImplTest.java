/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avaliacao.dao;

import br.com.avaliacao.entidade.Aluno;
import br.com.avaliacao.entidade.Endereco;
import br.com.avaliacao.entidade.Professor;
import br.com.avaliacao.entidade.Telefone;
import br.com.utilitario.UtilGerador;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author LENOVO
 */
public class AlunoDaoImplTest {

    private Aluno alu;
    private AlunoDaoImpl alunoDaoImpl;

    public AlunoDaoImplTest() {
        alunoDaoImpl = new AlunoDaoImpl();

    }

   @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        alu = alunoDaoImpl.pesquisarPorId(7);
        mostrarAluno(alu);

    }

    private void mostrarAluno(Aluno aluno) {
        System.out.println("Id Aluno: " + aluno.getId());
        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("CPF: " + aluno.getCpf());
        System.out.println("RG: " + aluno.getRg());
        System.out.println("E-mail: " + aluno.getEmail());
        System.out.println("Matricula: " + aluno.getMatricula());
        System.out.println("");
        System.out.println("ID Endereço: " + aluno.getEndereco().getId());
        System.out.println("Logradouro: " + aluno.getEndereco().getLogradouro());
        System.out.println("Número: " + aluno.getEndereco().getNumero());
        System.out.println("Bairro: " + aluno.getEndereco().getBairro());
        System.out.println("Cidade: " + aluno.getEndereco().getCidade());
        System.out.println("Estado: " + aluno.getEndereco().getEstado());
        System.out.println("Complemento: " + aluno.getEndereco().getComplemento());
        System.out.println("");
        for (Telefone telefone : aluno.getTelefone()) {
            System.out.println("");
            System.out.println("Id Telefone " + telefone.getId());
            System.out.println("Numero " + telefone.getNumero());
            System.out.println("Tipo " + telefone.getTipo());
            System.out.println("Operadora " + telefone.getOperadora());
        }

    }

//    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");

        alu = new Aluno(
                "Matricula " + UtilGerador.gerarCaracter(5),
                null,
                "Nome " + UtilGerador.gerarNome(),
                "Cpf " + UtilGerador.gerarCaracter(11),
                "RG " + UtilGerador.gerarCaracter(5),
                "Email " + UtilGerador.gerarEmail());

        Endereco endereco = new Endereco(
                null,
                "Logradouro " + UtilGerador.gerarCaracter(10),
                "Numero " + UtilGerador.gerarCaracter(5),
                "Bairro " + UtilGerador.gerarCidade(),
                "Cidade " + UtilGerador.gerarCidade(),
                "Estado " + UtilGerador.gerarNome(),
                "Complemento " + UtilGerador.gerarCaracter(10));
        alu.setEndereco(endereco);
        List<Telefone> telefones = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            telefones.add(gerarTelefone());
        }

        alu.setTelefone(telefones);

        alunoDaoImpl.salvarProfessor(alu);
    }

    private Telefone gerarTelefone() {
        Telefone tel = new Telefone(null,
                UtilGerador.gerarTelefoneFixo(),
                "Fixo",
                "Vivo");

        return tel;

    }

    @Test
    public void testPesquisarPorNome() throws Exception {
        System.out.println("pesquisarPorNome");
        System.out.println("pesquisarPorNome");
        System.out.println("");
        List<Aluno> alunos = alunoDaoImpl.pesquisarPorNome("Nome");
        for (Aluno aluno : alunos) {
            mostrarAluno(aluno);

        }
    }

    
    @Test

    public void testExcluir() throws Exception {
        System.out.println("Excluir ");
        alunoDaoImpl.excluir(8);

    }

    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        alu = alunoDaoImpl.pesquisarPorId(7);
        alu.setEmail("Alterado");
        alu.setMatricula("00000");
        alu.getEndereco().setLogradouro("Bem longe");
        alunoDaoImpl.alterarAluno(alu);

    }
}

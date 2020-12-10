/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avaliacao.dao;

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
public class ProfessorDaoImplTest {
    
    private ProfessorDaoImpl professorDaoImpl;
    private Professor prof;
    
    public ProfessorDaoImplTest() {
        professorDaoImpl = new ProfessorDaoImpl();
    }
    
    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        
        prof = new Professor(
                null,
                "Cracha " + UtilGerador.gerarCaracter(5),
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
        prof.setEndereco(endereco);
        List<Telefone> telefones = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            telefones.add(gerarTelefone());
        }
        
        prof.setTelefone(telefones);
        professorDaoImpl = new ProfessorDaoImpl();
        
        professorDaoImpl.salvarProfessor(prof);
    }
    
    private Telefone gerarTelefone() {
        Telefone tel = new Telefone(null,
                UtilGerador.gerarTelefoneFixo(),
                "Fixo",
                "Vivo");
        
        return tel;
        
    }
//    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        prof = professorDaoImpl.pesquisarPorId(9);
        mostrarProfessor(prof);

    }

//    @Test
    public void testPesquisarPorNome() throws Exception {
        System.out.println("pesquisarPorNome");
        System.out.println("");
        List<Professor> prof = professorDaoImpl.pesquisarPorNome("Nome");
        for (Professor professor : prof) {
            mostrarProfessor(professor);
            
        }
        
    }
    
    private void mostrarProfessor(Professor prof) {
        System.out.println("Id Professor: " + prof.getId());
        System.out.println("Professor: " + prof.getNome());
        System.out.println("CPF: " + prof.getCpf());
        System.out.println("RG: " + prof.getRg());
        System.out.println("E-mail: " + prof.getEmail());
        System.out.println("Cracha: " + prof.getCracha());
        System.out.println("");
        System.out.println("ID Endereço: " + prof.getEndereco().getId());
        System.out.println("Logradouro: " + prof.getEndereco().getLogradouro());
        System.out.println("Número: " + prof.getEndereco().getNumero());
        System.out.println("Bairro: " + prof.getEndereco().getBairro());
        System.out.println("Cidade: " + prof.getEndereco().getCidade());
        System.out.println("Estado: " + prof.getEndereco().getEstado());
        System.out.println("Complemento: " + prof.getEndereco().getComplemento());
        System.out.println("");
        for (Telefone telefone : prof.getTelefone()) {
            System.out.println("");
            System.out.println("Id Telefone " + telefone.getId());
            System.out.println("Numero " + telefone.getNumero());
            System.out.println("Tipo " + telefone.getTipo());
            System.out.println("Operadora " + telefone.getOperadora());
        }
        
    }
//    @Test
    public void testExcluir() throws Exception {
        System.out.println("Excluir ");
        professorDaoImpl.excluir(8);
        
}
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        prof = professorDaoImpl.pesquisarPorId(9);
        prof.setEmail("Alterado");
        prof.setCracha("00000");
        prof.getEndereco().setLogradouro("Bem longe");
        professorDaoImpl.alterarProfessor(prof);
}
}
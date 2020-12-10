/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utilitario;

/**
 *
 * @author LENOVO
 */
public class UtilGerador {

    public static String gerarCaracter(int qtd) {
        String palavra = "";
        int indice;
        String[] caracteres = {"a", "b", "c", "d",
            "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for (int i = 0; i < qtd; i++) {
            indice = (int) (Math.random() * caracteres.length);
            palavra += caracteres[indice];
        }
        return palavra;
    }

    public static String gerarNome() {
        String nome;
        int indice;
        String[] nomes = {"João", "Maria", "Beatriz", "Antonio",
            "Jefferson", "Silvio", "Tatiana", "Soeli", "Joana", "Camilla", "kelly",
            "Venicius", "Marcos", "Pedro"};
        indice = (int) (Math.random() * nomes.length);
        nome = nomes[indice];
        nome = nome + " " + gerarSobreNome();
        return nome;
    }

    private static String gerarSobreNome() {
        String sobrenome;
        int indice;
        String[] nomes = {"Silva", "Motto", "Ribeiro", "May",
            "Junior", "Cionette", "Souza", "Aurelio", "Pereira", "Oliveira", "Araujo",
            "Matos", "Barbosa", "Nascimento"};
        indice = (int) (Math.random() * nomes.length);
        sobrenome = nomes[indice];
        return sobrenome;
    }

    public static String gerarCidade() {
        String cidade;
        int indice;
        String[] cidades = {"Florianópolis", "São José", "Palhoça", "São Bento",
            "Biguaçu", "Curitiba", "Urupema", "Tijucas", "Balneário", "Camboriú", "Santo Antônio",
            "Lapa", "Portal", "Matinhos"};
        indice = (int) (Math.random() * cidades.length);
        cidade = cidades[indice];
        return cidade;
    }

    public static String gerarNumero(int qtd) {
        String numero = "";
        for (int i = 0; i < qtd; i++) {
            numero += (int) (Math.random() * 10);
        }
        return numero;
    }

    public static String gerarEmail() {
        return gerarCaracter(8) + "@email.com";
    }

    public static String gerarTelefoneFixo() {
        return "(48)3" + gerarNumero(3) + "-" + gerarNumero(4);
    }

    public static int criarNumeroAleatorioEntre2Valores(int menor, int maior) {
        int numero = (int) (Math.random() * (maior - menor));
        if (numero == 0) {
            numero++;
        }
        numero = numero + menor;
        return numero;
    }

    public static void main(String[] args) {
        System.out.println(gerarNome());
    }

    public static String criarPlacaDoVeiculo() {
        int numeroPlaca = 0;
        String letraPlaca = "";
        int indice;
        String[] caracteres = {"a", "b", "c", "d",
            "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for (int i = 0; i < 3; i++) {
            indice = (int) (Math.random() * caracteres.length);
            letraPlaca += caracteres[indice];
        }
        for (int i = 0; i < 4; i++) {
            numeroPlaca += (int) (Math.random() * 10);

        }

        return letraPlaca + " -" + numeroPlaca;
    }
    
}

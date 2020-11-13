package br.com.vinicius;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GincanaAcampamento {
    
    /**
     * Desafio
     * Nas férias de Dezembro, várias escolas se organizam e levam seus alunos para um acampamento de férias por uma semana.
     * Nestes acampamentos os alunos são divididos em cabanas coletivos por gênero e idade, sempre com um adulto que, além de dormir com o grupo no cabana,
     * também são responsáveis por criar e executar várias atividades, como por exemplo jogos, excursões, Gincanas Noturnas, etc.
     *
     * No primeiro dia foi realizada uma gincana em que a atividade constituia em agrupar os alunos em um círculo
     * (organizado no sentido anti-horário) do qual seriam retiradas uma a uma até que sobrasse apenas um aluno, que seria o vencedor.
     *
     * No momento em que entra no círculo, cada aluno recebe uma pequena ficha que contém um valor de 1 a 500.
     * Depois que o círculo é formado, conta-se, iniciando no aluno que está ao lado da primeira que entrou no círculo,
     * o número correspondente à ficha que o primeiro detém. O aluno onde o número contado cair, deve ser retirado do grupo,
     * e a contagem inicia novamente segundo a ficha do aluno que acabou de ser eliminado. Para ficar mais interessante,
     * quando o valor que consta na ficha é par, a contagem é feita no sentido horário e quando o valor que consta na ficha é ímpar,
     * a contagem é feita no sentido anti-horário.
     *
     * Desenvolva um programa para que no próximo evento o responsável pela brincadeira saiba previamente qual criança irá ser a vencedora de cada grupo,
     * com base nas informações fornecidas.
     *
     * Exemplo de Entrada
     * 3
     * Fernanda 7
     * Fernando 9
     * Gustavo 11
     * 5
     * Maria 7
     * Pedro 9
     * Joao_Vitor 5
     * Isabel 12
     * Laura 8
     * 3
     * Maria 4
     * Pedro 3
     * Joao 2
     * 0
     *
     * Exemplo de Saída
     * Vencedor(a): Fernanda
     * Vencedor(a): Pedro
     * Vencedor(a): Pedro
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //pra ler de arquivo Files.newBufferedReader(Paths.get("/home/vinicius/test.txt"));
    
        int linhas = Integer.parseInt(br.readLine());
        List<Aluno> alunos = new ArrayList<>();
    
        while(linhas > 0) {
            for (int i = 0; i < linhas; i++) {
                var next = br.readLine();
                Aluno aluno = new Aluno();
                var al = next.split(" ");
                aluno.setNome(al[0]);
                aluno.setValor(Integer.valueOf(al[1]));
                alunos.add(aluno);
            }
            calcularVencedor(alunos);
            alunos.clear();
            linhas = Integer.parseInt(br.readLine());
        }
        
    }
    
    private static void calcularVencedor(List<Aluno> alunos) {
        var lista = new CopyOnWriteArrayList<>(alunos);
        int i = retornaIndexEliminado(lista.get(0).getValor(), 0, lista.size()-1);
        while(lista.size() > 1) {
            var novoValor = lista.get(i).getValor();
            System.out.println("Eliminado: "+lista.get(i).getNome());
            lista.remove(i);
            i = retornaIndexEliminado(novoValor, (novoValor % 2 != 0 ? i-1 : i), lista.size()-1);
        }
        
        System.out.println("Vencedor(a): "+ lista.get(0).getNome());
    }
    
    private static int retornaIndexEliminado(int valor, int posicaoInicio, int sizeLista) {
        int index = posicaoInicio;
        if(valor % 2 != 0) {
            for (int i = 0; i < valor ; i++) {
                if(index == sizeLista) {
                    index = 0;
                } else {
                    index++;
                }
            }
        } else {
            for (int i = 0; i < valor ; i++) {
                if(index == 0) {
                    index = sizeLista;
                } else {
                    index--;
                }
            }
        }
        return index;
    }
    
    public static class Aluno {
        private String nome;
        private Integer valor;
    
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public Integer getValor() {
            return valor;
        }
    
        public void setValor(Integer valor) {
            this.valor = valor;
        }
    }
    
}

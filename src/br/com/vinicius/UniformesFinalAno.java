package br.com.vinicius;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class UniformesFinalAno {
    
    /**
     * Desafio
     * O professor Girafales organizou a confecção de um uniforme para as turmas da escola para comemorar o final do ano.
     * Após algumas conversas, ficou decidido com os alunos que eles poderiam escolher a cor do uniforme entre branco ou vermelho.
     * Assim sendo, Girafales precisa de sua ajuda para organizar as listas de quem quer o uniforme em cada uma das turmas,
     * relacionando estas camisetas pela cor, tamanho (P, M ou G) e por último pelo nome.
     *
     * Exemplo de Entrada
     * 9
     * Maria Jose
     * branco P
     * Mangojata Mancuda
     * vermelho P
     * Cezar Torres Mo
     * branco P
     * Baka Lhau
     * vermelho P
     * JuJu Mentina
     * branco M
     * Amaro Dinha
     * vermelho P
     * Adabi Finho
     * branco G
     * Severina Rigudinha
     * branco G
     * Carlos Chade Losna
     * vermelho P
     * 0
     *
     * Exemplo de Saída
     * branco P Cezar Torres Mo
     * branco P Maria Jose
     * branco M JuJu Mentina
     * branco G Adabi Finho
     * branco G Severina Rigudinha
     * vermelho P Amaro Dinha
     * vermelho P Baka Lhau
     * vermelho P Carlos Chade Losna
     * vermelho P Mangojata Mancuda
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int linhas = Integer.parseInt(st.nextToken());
        List<Uniforme> uniformes = new ArrayList<>();
        
        for (int i = 0; i <= linhas; i++) {
            var next = br.readLine();
            if(next.equals("0")) {
                break;
            }
            Uniforme uniforme = new Uniforme();
            uniforme.setNomeEstudante(next);
            var camiseta = br.readLine().split(" ");
            uniforme.setCorUniforme(camiseta[0]);
            uniforme.setTamUniforme(camiseta[1]);
            uniformes.add(uniforme);
        }
        
        Comparator<Uniforme> comparator = Comparator
                .comparing(Uniforme::getCorUniforme).reversed()
                .thenComparing(Uniforme::getTamUniforme).reversed()
                .thenComparing(Uniforme::getNomeEstudante);
        
        uniformes.stream().sorted(comparator).forEach(System.out::println);
        
    }
    
    public static class Uniforme {
        private String nomeEstudante;
        private String corUniforme;
        private String tamUniforme;
        
        @Override
        public String toString() {
            return corUniforme + " " + tamUniforme + " "+ nomeEstudante;
        }
        
        public String getNomeEstudante() {
            return nomeEstudante;
        }
        
        public void setNomeEstudante(String nomeEstudante) {
            this.nomeEstudante = nomeEstudante;
        }
        
        public String getCorUniforme() {
            return corUniforme;
        }
        
        public void setCorUniforme(String corUniforme) {
            this.corUniforme = corUniforme;
        }
        
        public String getTamUniforme() {
            return tamUniforme;
        }
        
        public void setTamUniforme(String tamUniforme) {
            this.tamUniforme = tamUniforme;
        }
    }
}

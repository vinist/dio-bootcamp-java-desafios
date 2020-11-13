package br.com.vinicius;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class OrdenandoNumerosParesImpares {
    
    /**
     * Desafio
     * Crie um programa onde você receberá valores inteiros não negativos como entrada.
     *
     * Ordene estes valores de acordo com o seguinte critério:
     *
     * Primeiro os Pares
     * Depois os Ímpares
     * Você deve exibir os pares em ordem crescente e na sequência os ímpares em ordem decrescente.
     *
     * Exemplo de Entrada	Exemplo de Saída
     * 10                   4
     * 4                    10
     * 32                   32
     * 34                   34
     * 543                  98
     * 3456                 654
     * 654                  3456
     * 567                  6789
     * 87                   567
     * 6789                 543
     * 98                   87
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int linhas = Integer.parseInt(st.nextToken());
        List<Integer> listaNumeros = new ArrayList<>();
        
        for (int i = 0; i < linhas; i++) {
            st = new StringTokenizer(br.readLine());
            listaNumeros.add(Integer.parseInt(st.nextToken()));
        }
        
        var pares = listaNumeros.stream().filter(l -> l % 2 == 0).sorted().collect(Collectors.toList());
        var impares = listaNumeros.stream().filter(l -> l % 2 != 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> total = new ArrayList<>();
        total.addAll(pares);
        total.addAll(impares);
        total.forEach(System.out::println);
    }
}

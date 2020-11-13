package br.com.vinicius;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ComprasSupermercado {
    
    /**
     * Desafio
     * Pedro trabalha sempre até tarde todos os dias, com isso tem pouco tempo tempo para as tarefas doméstica.
     * Para economizar tempo ele faz a lista de compras do supermercado em um aplicativo e costuma anotar cada item
     * na mesma hora que percebe a falta dele em casa.
     *
     * O problema é que o aplicativo não exclui itens duplicados, como Pedro anota o mesmo item mais de uma vez e a
     * lista acaba ficando extensa. Sua tarefa é melhorar o aplicativo de notas desenvolvendo um código que exclua os
     * itens duplicados da lista de compras e que os ordene alfabeticamente.
     *
     * Exemplo de Entrada
     * 2
     * carne laranja suco picles laranja picles
     * laranja pera laranja pera pera
     *
     * Exemplo de Saída
     * carne laranja picles suco
     * laranja pera
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int linhas = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> lista = new LinkedHashSet<>();
        
        for (int i = 0; i < linhas; i++) {
            LinkedHashSet<String> set = new LinkedHashSet<>(List.of(br.readLine().split(" ")));
            var linha = set.stream().sorted().collect(Collectors.joining(" "));
            lista.add(linha);
        }
        
        lista.forEach(System.out::println);
    }
}



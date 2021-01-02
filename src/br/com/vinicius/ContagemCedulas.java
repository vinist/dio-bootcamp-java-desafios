package br.com.vinicius;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ContagemCedulas {
    
    /**
     * Desafio
     * Faça a leitura de um valor inteiro. Em seguida, calcule o menor número de notas possíveis (cédulas) onde o valor pode ser decomposto. As notas que você deve considerar são de 100, 50, 20, 10, 5, 2 e 1. Na sequência mostre o valor lido e a relação de notas necessárias.
     *
     * Entrada
     * Você receberá um valor inteiro N (0 < N < 1000000).
     *
     * Saída
     * Exiba o valor lido e a quantidade mínima de notas de cada tipo necessárias, seguindo o exemplo de saída abaixo. Após cada linha deve ser imprimido o fim de linha.
     *
     * Exemplo de Entrada
     * 576
     *
     * Exemplo de Saída
     * 576
     * 5 nota(s) de R$ 100,00
     * 1 nota(s) de R$ 50,00
     * 1 nota(s) de R$ 20,00
     * 0 nota(s) de R$ 10,00
     * 1 nota(s) de R$ 5,00
     * 0 nota(s) de R$ 2,00
     * 1 nota(s) de R$ 1,00
     *
     * 11257
     *
     * Exemplo de Saída
     * 11257
     * 112 nota(s) de R$ 100,00
     * 1 nota(s) de R$ 50,00
     * 0 nota(s) de R$ 20,00
     * 0 nota(s) de R$ 10,00
     * 1 nota(s) de R$ 5,00
     * 1 nota(s) de R$ 2,00
     * 0 nota(s) de R$ 1,00
     *
     * 503
     *
     * Exemplo de Saída
     * 503
     * 5 nota(s) de R$ 100,00
     * 0 nota(s) de R$ 50,00
     * 0 nota(s) de R$ 20,00
     * 0 nota(s) de R$ 10,00
     * 0 nota(s) de R$ 5,00
     * 1 nota(s) de R$ 2,00
     * 1 nota(s) de R$ 1,00
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException { int notaDeCem = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int valor = Integer.parseInt(st.nextToken());
        int valorTotal = valor;
        int[] notas = {100, 50, 20, 10, 5, 2, 1};
        Map<Integer, Integer> mapCedulas = new LinkedHashMap<>();
        
        for (int nota : notas) {
            int quociente = valor/nota;
            valor = valor % nota;
            mapCedulas.put(nota, quociente);
        }
        
        System.out.println(valorTotal);
        mapCedulas.forEach((key, value) -> System.out.println(value + " nota(s) de R$ " + key+",00"));
    }
}

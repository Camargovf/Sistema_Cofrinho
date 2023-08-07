package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
    private List<Moeda> moedas;

    public Cofrinho() {
        moedas = new ArrayList<>();
    }

    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda);
    }

    public boolean removerMoeda(Moeda moeda) {
        return moedas.remove(moeda);
    }

    public List<Moeda> getMoedas() {
        return moedas;
    }

    public double getValorTotalConvertido() {
        double valorTotalConvertido = 0;
        for (Moeda moeda : moedas) {
            valorTotalConvertido += moeda.converter();
        }
        return valorTotalConvertido;
    }

    public boolean indiceValido(int indice) {
        return indice >= 0 && indice < moedas.size();
    }
}

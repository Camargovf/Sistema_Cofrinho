package org.example;

public class Euro extends Moeda {
    private static final double TAXA_CAMBIO_EURO = 4.0;

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Euro - Valor: €" + valor);
    }

    @Override
    public double converter() {
        return valor * TAXA_CAMBIO_EURO;
    }
}

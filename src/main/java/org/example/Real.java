package org.example;

public class Real extends Moeda {
    private static final double TAXA_CAMBIO_REAL = 2.5;

    public Real(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Real - Valor: R$" + valor);
    }

    @Override
    public double converter() {
        return valor * TAXA_CAMBIO_REAL;
    }
}

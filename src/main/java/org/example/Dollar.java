package org.example;

public class Dollar extends Moeda {
    private static final double TAXA_CAMBIO_DOLLAR = 3.5;

    public Dollar(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Dólar - Valor: $" + valor);
    }

    @Override
    public double converter() {
        return valor * TAXA_CAMBIO_DOLLAR;
    }
}

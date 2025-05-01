public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria (String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if(valor < 0) {
            throw new RuntimeException("Deposite um valor maior que 0!");
        }
            saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new RuntimeException("Retire um valor maior que 0!");
        }

        if(saldo < valor) {
            throw new RuntimeException("Saldo Insuficiente!");
        }
        saldo -= valor;
    }
}

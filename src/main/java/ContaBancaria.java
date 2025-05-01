public class ContaBancaria {
    private String titular;
    private double saldo;
    private double taxaDeposito = 0.005;
    private double taxaSaque = 0.002;

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
        if(valor <= 0) {
            throw new IllegalArgumentException("Deposite um valor maior que 0!");
        }
            double valorMenosTaxa = valor - (valor * taxaDeposito);
            saldo += valorMenosTaxa;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new RuntimeException("Retire um valor maior que 0!");
        }

        if (valor > 3000.00) {
            throw new RuntimeException("O saque não pode ser superior á R$3000.00");
        }

        double valorMaisTaxa = valor + (valor * taxaSaque);
        if(saldo < valorMaisTaxa) {
            throw new RuntimeException("Saldo Insuficiente!");
        }

        saldo -= valorMaisTaxa;
    }

    public void transferir(ContaBancaria destino, double valor) {
        if(valor <= 0) {
            throw new IllegalArgumentException("Valor da transferência deve ser maior que 0!");
        }

        if(this.saldo < valor) {
            throw new RuntimeException("Saldo Insuficiente!");
        }
        this.saldo -= valor;
        destino.saldo += valor;
    }
}

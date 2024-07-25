import java.util.Random;

public class Main {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Cliente leticia = new Cliente("Leticia");

        Conta cc = new ContaCorrente(leticia, RANDOM.nextDouble() * 1000);
        Conta poupanca = new ContaPoupanca(leticia);

        double valorDeposito = RANDOM.nextDouble() * 1000;
        cc.depositar(valorDeposito);

        double valorTransferencia = RANDOM.nextDouble() * valorDeposito;
        cc.transferir(valorTransferencia, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}

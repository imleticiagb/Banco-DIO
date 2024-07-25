public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(Cliente cliente, double limiteChequeEspecial) {
        super(cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && getSaldo() + limiteChequeEspecial >= valor) {
            double saldoAtual = getSaldo();
            if (saldoAtual >= valor) {
                super.sacar(valor);
            } else {
                double valorUtilizarCheque = valor - saldoAtual;
                super.sacar(saldoAtual);
                limiteChequeEspecial -= valorUtilizarCheque;
                System.out.println("Cheque especial utilizado: R$" + valorUtilizarCheque);
            }
        } else {
            System.out.println("Saldo insuficiente, incluindo cheque especial, ou valor de saque inválido.");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }
}

import java.util.Random;

public class Cliente {
    private String nome;
    private String cpf;
    private static final Random RANDOM = new Random();

    public Cliente(String nome) {
        this.nome = nome;
        this.cpf = gerarCpfAleatorio();
    }

    private String gerarCpfAleatorio() {
        int numero1 = RANDOM.nextInt(100000000);
        return String.format("%09d", numero1);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

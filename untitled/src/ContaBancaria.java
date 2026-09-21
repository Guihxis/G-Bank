

public class ContaBancaria {
    private Pessoa titular;
    private int numeroDaConta;
    private double saldo;



    public ContaBancaria(Pessoa titular) {
        this.titular = titular;
        this.saldo = 0.0; // Toda conta começa zerada
    }

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    void sacar (double valor) {
        if (valor > 0 && valor <= saldo){
            saldo -= valor;
            System.out.println("Voce sacou: " + valor);
        }else if(valor < 0) {
            System.out.println("Valor invalido");
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

    double consultarSaldo () {
       return saldo;
    }

    public Pessoa getTitular (){
        return titular;
    }



}

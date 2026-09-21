public class Pessoa {
    private String nome;
    private String cpf;
    private String senha;
    private ContaBancaria conta;

   public Pessoa(String nome, String cpf, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }


}

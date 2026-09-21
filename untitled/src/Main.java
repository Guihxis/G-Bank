import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<ContaBancaria> listaDeContas = new ArrayList<>();

        int opcao;
        ContaBancaria contaLogada = null;


        while (true) {

            System.out.println("===== G BANK ===== ");
            System.out.println("1 - Login ");
            System.out.println("2 - Cadastrar-se");
            opcao = scanner.nextInt();
            scanner.nextLine();


            //LOGIN 👌😁
            if (opcao == 1) {

                if (listaDeContas.isEmpty()) {
                    System.out.println("Nenhum cliente cadastrado ainda no banco.");
                    continue;
                }

                System.out.print("Digite seu CPF: ");
                String cpfLogin = scanner.nextLine();

                System.out.print("Digite sua senha: ");
                String senhaLogin = scanner.nextLine();

                boolean achouConta = false;
                for (ContaBancaria contaTemp : listaDeContas){
                    if (contaTemp.getTitular().getCpf().equals(cpfLogin) &&
                    contaTemp.getTitular().getSenha().equals(senhaLogin)){
                        contaLogada = contaTemp; //ACHOU 😏
                        achouConta = true;
                        break; // PARA DE PROCURAR POR CONTAS 🛑

                    }
                }

                if (achouConta){
                    System.out.println("Login realizado com sucesso! Bem vindo(a), " +
                            contaLogada.getTitular().getNome());
                    break; // Sai do menu principal e vai pro menu de saque/depósito
                } else{
                    System.out.println("Cpf ou senha incorretos!!");
                }

                // CADASTRO 🚹🚺
            } else if (opcao == 2) {

                System.out.println("===== G BANK =====");

                System.out.print("Digite seu nome: ");
                String nome = scanner.nextLine();


                System.out.print("Digite seu CPF: ");
                String cpf = scanner.nextLine();

                System.out.print("Digite sua senha: ");
                String senha = scanner.nextLine();

                // Cria a Pessoa, depois a Conta (com o new!) e salva na lista

                Pessoa novaPessoa = new Pessoa(nome, cpf, senha);
                ContaBancaria novaConta = new ContaBancaria(novaPessoa);

                listaDeContas.add(novaConta);

                System.out.println("Voce foi cadastrado com sucesso \uD83D\uDE01!");

            } else {
                System.out.println("Opcao invalida");
            }


        }

        //  MENU DA CONTA 💸💸🤑
        boolean opcoes = true;
        while (opcoes == true) {

            System.out.println("===== G BANK =====");
            System.out.println("1 - Visualizar o saldo atual");
            System.out.println("2 - Sacar ");
            System.out.println("3 - Deposito");
            System.out.println("4 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Seu saldo atual e: " + contaLogada.consultarSaldo());
                    break;

                case 2:
                    System.out.println("Quanto deseja sacar?");
                    contaLogada.sacar(scanner.nextDouble());
                    break;

                case 3:
                    System.out.println("Digite o valor que deseja deposita: ");
                    contaLogada.depositar(scanner.nextDouble());

                    break;

                case 4:
                    System.out.println("Finalizando....");
                    opcoes = false;
                    break;

            }
        }
    }
}

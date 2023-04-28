import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // criação de contas
    Conta c1 = new Conta();
    c1.setAgencia("123");
    c1.setConta("456");
    c1.setSaldo(500);

    Conta c2 = new Conta();
    c2.setAgencia("234");
    c2.setConta("567");
    c2.setSaldo(1000);
    
    // adiciona as contas em um ArrayList
    ArrayList<Conta> contas = new ArrayList<Conta>();
    contas.add(c1);
    contas.add(c2);
    
    Scanner teclado = new Scanner(System.in);

    // loop para interação com o usuário
    int flag = 0;
    while (flag != 1) {
      System.out.println("\nDigite qual conta deseja acessar (1 ou 2): ");
      int numConta = teclado.nextInt();
      
      // verifica se o número da conta é válido
      if (numConta < 1 || numConta > 2) {
        System.out.println("Número de conta inválido!");
        continue;
      }
      
      // seleciona a conta correspondente ao número digitado
      Conta conta = contas.get(numConta-1);
      System.out.println("\tVocê está acessando a conta: "+conta.getConta());
      System.out.println("\nEscolha uma opção:");
      System.out.println("1 - Ver saldo");
      System.out.println("2 - Sacar");
      System.out.println("3 - Depositar");
      System.out.println("4 - Transferir");
      System.out.println("5 - Sair");
      System.out.println("\n");
      
      int opcao = teclado.nextInt();
      
      if (opcao == 1){
          conta.VerSaldo();
      }
      else if(opcao == 2){
          System.out.println("Digite o valor a sacar: ");
          double valorSaque = teclado.nextDouble();
          conta.Sacar(valorSaque);
      }
        else if(opcao == 3){
          System.out.println("Digite o valor a depositar: ");
          double valorDeposito = teclado.nextDouble();
          conta.Depositar(valorDeposito);
        }
        else if(opcao == 4){
          System.out.println("Digite o número da conta para transferir: ");
          int numContaDestino = teclado.nextInt();
          // verifica se o número da conta de destino é válido
          if (numContaDestino < 1 || numContaDestino > 2) {
            System.out.println("Número de conta inválido!");
          }
          // seleciona a conta de destino correspondente ao número digitado
          Conta contaDestino = contas.get(numContaDestino-1);
          System.out.println("Digite o valor a transferir: ");
          double valorTransferencia = teclado.nextDouble();
          conta.Transferir(valorTransferencia, contaDestino);
        }
        else if(opcao == 5){
          System.out.println("Encerrando programa...");
          flag = 1;
        }
        else{
          System.out.println("Opção inválida!");
        }
      }
    }
  }
public class Conta{
  private String agencia;
  private String conta;
  private double saldo;
  
public String getAgencia() {
	return this.agencia;
}
public void setAgencia(String agencia) {
	this.agencia = agencia;
}
public String getConta() {
	return this.conta;
}
public void setConta(String conta) {
	this.conta = conta;
}
public double getSaldo() {
	return this.saldo;
}
public void setSaldo(double saldo) {
	this.saldo = saldo;
}

public void VerSaldo(){
  System.out.println("Saldo atual: R$ "+this.getSaldo());
}

public boolean Sacar(double valor){
  boolean flag;
  if(valor < this.getSaldo()){
    this.setSaldo(this.getSaldo() - valor);
    System.out.println("Operação na conta "+this.getConta()+": Saque de R$ "+valor+" realizado!");
    System.out.println("Operação na conta "+this.getConta()+": Novo saldo: R$ "+this.getSaldo());
			flag = true;
  }
  else{
    System.out.println("Operação na conta "+this.getConta()+": Saldo insuficiente!");
		flag = false;
  }
  return flag;
}

public void Depositar(double valor){
  this.setSaldo(this.getSaldo()+valor);
	System.out.println("Operação na conta "+this.getConta()+": Depósito de R$ "+valor+" realizado!");
  System.out.println("Operação na conta "+this.getConta()+": Novo saldo: R$ "+this.getSaldo());
}

public Conta Transferir(double valor, Conta aux){
  if(this.Sacar(valor)){
    aux.Depositar(valor);
  }
  else{
    System.out.println("Operação na conta "+this.getConta()+": Transferência negada!");
  }
  return aux;
}
 
}
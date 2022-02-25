
import java.util.Scanner;

public class Main {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner leia = new Scanner (System.in);
        Funcionario f=new Funcionario();
        
        do{
            System.out.print("Insira o nome do funcionario: ");
            leia.nextLine();
            f.nome=leia.nextLine();   
            do{
                System.out.print("Insira o cpf do funcionario: ");
                f.cpf=leia.nextLine();
                if(f.cpf.length()!=11){
                    System.out.println("ERRO cpf invalido");
                }
            }while(f.cpf.length()!=11);
            
            System.out.print("Insira o cargo do funcionario: ");
            f.cargo=leia.nextLine();
            do{
                System.out.print("Insira o valor da hora: ");
                f.salarioHora=leia.nextDouble();
                if(f.salarioHora<=0){
                    System.out.println("!ERRO! valor invalido");
                }
            }while(f.salarioHora<=0);
            do{
                System.out.print("Insira a quantidade de horas trabalhadas: ");
                f.quantidadeHoras=leia.nextInt();
                if(f.quantidadeHoras<=0){
                    System.out.println("!ERRO! horario invalido");
                }
            }while(f.quantidadeHoras<=0);
            do{
                System.out.print("insira o valor gasto em passagens por mês: ");
                f.valorPassagem=leia.nextDouble();
                if(f.valorPassagem<=0){
                    System.out.println("!ERRO! valor invalido");
                }
            }while(f.valorPassagem<=0);
            do{
                System.out.print("Insira a quantidade de dependentes: ");
                f.dependentes=leia.nextByte();
                if(f.dependentes<0){
                    System.out.println("!ERRO! quantidade invalido");
                }
            }while(f.dependentes<0);
            do{
                System.out.print("1- Sem insalubridade");
                System.out.print("\n2- Mínimo de insaluibridade");
                System.out.print("\n3- Medio de insaluibridade");
                System.out.print("\n4- Maximo de insaluibridade");
                System.out.print("\nInsira a insalubridade: ");
                f.tipoInsalubridade=leia.nextByte();
                if(f.tipoInsalubridade<=0 || f.tipoInsalubridade>=5){
                    System.out.println("!ERRO! numero invalido");
                }
            }while(f.tipoInsalubridade<=0 || f.tipoInsalubridade>=5);
            
            System.out.println(f.verDados());
            System.out.printf("\nValor do beneficio por dependente: R$ %.2f",f.verSalarioFamilia());
            System.out.printf("\nAdicinal por insalubridade: R$ %.2f",f.verInsalubridade());
            System.out.print("\nSua passagem: "+f.verValeTransporte());
            System.out.printf("\nDesconto do INSS R$ %.2f",f.verInss());
            System.out.print("\nquer fazer uma nova pesquisa?");
            
            System.out.print("\ndigite 1 pra sim");
            System.out.print("\ndigite 2 pra não");

            f.gambi=leia.nextByte();
            if(f.gambi==2){
                System.out.println("sistema finalizado");
            }
        }while(f.gambi==1);  
    }
    
}
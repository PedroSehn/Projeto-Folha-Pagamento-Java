
public class Funcionario {
    public String nome; 
    public String cpf;
    public String cargo;
    public Byte gambi;
    
    public double salarioHora;
    public double quantidadeHoras;
    
    public double valorPassagem;
    
    public byte dependentes;    
    
    public byte tipoInsalubridade;
    
    public double valorRefeicao;
    
    public double horasExtras50;
    public double horasExtras100;
        
    //Salario Bruto
    public double verSalarioBruto(){
        return this.quantidadeHoras * this.salarioHora;      
    }
    
//Vale transporte
    public double verValeTransporte(){
        double valeTransporte;
        if(this.valorPassagem < (this.verSalarioBruto() * 0.06)){
            valeTransporte = this.verSalarioBruto() * 0.06;
        }else{
            valeTransporte = valorPassagem;
        }
        return valeTransporte;
    }
    
//Insalubridade
    public double verInsalubridade(){ 
       switch (this.tipoInsalubridade){   
        case 1:
            return 0;
        case 2:
            return  980 * 0.1;
        case 3:
            return 980 * 0.2;
        default:
            return 980 * 0.4;          
        }
    }
    
//INSS
    public double verInss(){
        double inss; 
        if(this.verSalarioBruto()<=1751.81){
            inss = this.verSalarioBruto() * 0.08;
        
        }else if(this.verSalarioBruto()>=1751.82 && this.verSalarioBruto()<=2919.72){
            inss = this.verSalarioBruto() * 0.09;
        
        }else if(verSalarioBruto()>=2919.73 && this.verSalarioBruto()<=5839.45){
            inss = this.verSalarioBruto() * 0.11;
        
        }else{
            inss = this.verSalarioBruto() * 0.27;
        }
        return inss;
    }
 
//Salario Familia
    public double verSalarioFamilia(){
        double salarioFamilia;
        if(this.verSalarioBruto() <= 725.02){
            salarioFamilia = (this.dependentes * 37.18);
        }else if(this.verSalarioBruto() >= 725.03 && this.verSalarioBruto() <= 1089.72){
            salarioFamilia = (this.dependentes * 26.20);
        }else{
            salarioFamilia = 0;
        }
        return salarioFamilia; 
    }
  
//Salario liquido
    public double verSalarioLiquido(){
    return this.verSalarioBruto() + this.verSalarioFamilia() + this.verInsalubridade() - this.verInss() - this.verValeTransporte();
}    
    public String verDados(){
        
        return "Nome do funcionario: "+this.nome
                + "\nSalario Bruto: "+this.verSalarioBruto()
                + "\nSeu cpf: "+this.cpf
                + "\nSeu cargo: "+this.cargo
                + "\nSeu ganho por hora: R$ "+this.salarioHora
                + "\nQuantidade de horas trabalhadas no mês: "+this.quantidadeHoras
                + "\nValor total de passagens por mês: "+this.valorPassagem
                + "\nQuantidade de dependentes em casa: "+this.dependentes
                + "\nNivel de insalubridade: "+this.tipoInsalubridade;
    }
            
    
    }

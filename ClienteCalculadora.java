import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClienteCalculadora {
  public static void main(String[] args) {
    try {
      // Localiza o registry. É possível usar endereço/IP porta
      //Registry registry = LocateRegistry.getRegistry("192.168.1.5",5080);
      // Consulta o registry e obtém o stub para o objeto remoto
      String url = "rmi://localhost:5080/calculadora";
      Calculadora calc = (Calculadora) Naming.lookup(url);

      // A partir deste momento, cahamadas à Caluladora podem ser
      // feitas como qualquer chamada a métodos

      //Numero num1 = new NumeroImpl(2);
     // Numero num2 = new NumeroImpl(1);
     // Numero num3 = new NumeroImpl(2.56);
     // Numero num4 = new NumeroImpl(1.86);
     // List<Numero> nums = Arrays.asList(num1, num2, num3, num4);
      Double indice = 2.0;
      double valor1, valor2;

      //Aqui são feitas diversas chamadas remotas
      /*
      Numero soma = calc.somar(num1, num2);
      Numero sub = calc.subtrair(num1, num2);
      Numero mult = calc.multiplicar(num1, num2);
      Numero div = calc.dividir(num1, num2);
      Numero potencia = calc.potenciar(num1, new NumeroImpl(3));
      Numero absoluto = calc.valorAbsoluto(num1);
      Numero acima = calc.arredondarAcima(num3);
      Numero abaixo = calc.arredondarAbaixo(num4);
      Numero fatorial = calc.fatorial(5);
      Numero minimo = calc.minimo(nums);
      Numero maximo = calc.maximo(nums);
      Numero media = calc.media(nums);
      Numero absolutoDaDiferenca = calc.absolutoDaDiferenca(num1, num2);
      Numero arredondar1 = calc.arredondarParaInteiro(num3);
      Numero arredondar2 = calc.arredondarParaInteiro(new NumeroImpl(6.12));
      Numero arredondar3 = calc.arredondarParaInteiro(new NumeroImpl(3));
      Numero raizQuadrada = calc.calculaRaiz(new NumeroImpl(9));
      Numero radiciacao = calc.radiciacao(new NumeroImpl(16), indice);
      Numero horaSegundo = calc.converterHorasEmSegundos(new NumeroImpl(2));
      Numero segundoHora = calc.converterSegundosEmHoras(new NumeroImpl(7200));
      Numero celsiusFahrenheit = calc.converterCelsiusParaFahrenheit(new NumeroImpl(25));
      Numero kgEmG = calc.converterKgParaGramas(new NumeroImpl(2.5));

       */
      //Leitura de dados e tela de comandos
      Scanner ler = new Scanner(System.in);
      int n;
      int operacao;

      TelaConsole telaConsole = new TelaConsole();
      String limpaTela = "\033\143";
      boolean program = true;
      while (program ){
        System.out.print(limpaTela);
        telaConsole.tela();
        operacao = ler.nextInt();
        switch (operacao){
          case 1:
            System.out.print(limpaTela);
            System.out.println("Número 1: ");
            valor1 = ler.nextDouble();
            System.out.println("+ : ");
            valor2 = ler.nextDouble();
            Numero soma = calc.somar(new NumeroImpl(valor1), new NumeroImpl(valor2));
            System.out.println("Soma: " + soma.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 2:
            System.out.print(limpaTela);
            System.out.println("Número 1: ");
            valor1 = ler.nextDouble();
            System.out.println("- : ");
            valor2 = ler.nextDouble();
            Numero subtracao = calc.somar(new NumeroImpl(valor1), new NumeroImpl(valor2));
            System.out.println("Subtração: " + subtracao.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 3:
            System.out.print(limpaTela);
            System.out.println("Número 1: ");
            valor1 = ler.nextDouble();
            System.out.println("X : ");
            valor2 = ler.nextDouble();
            Numero multiplicar = calc.multiplicar(new NumeroImpl(valor1), new NumeroImpl(valor2));
            System.out.println("Multiplicação: " + multiplicar);
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 4:
            System.out.print(limpaTela);
            System.out.println("Número 1: ");
            valor1 = ler.nextDouble();
            System.out.println("/ : ");
            valor2 = ler.nextDouble();
            try {
              Numero dividir = calc.dividir(new NumeroImpl(valor1), new NumeroImpl(valor2));
              System.out.println("Dividir: " + dividir);
            } catch (DivisaoPorZeroException e) {
              System.out.println("Tentou dividir por zero! Esta é uma exceção remota.");
            }
            break;
          case 5:
            System.out.print(limpaTela);
            System.out.println("Número 1: ");
            valor1 = ler.nextDouble();
            System.out.println("Expoente : ");
            valor2 = ler.nextDouble();
            Numero potencia = calc.potenciar(new NumeroImpl(valor1), new NumeroImpl(valor2));
            System.out.println("Potencia: " + potencia.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 6:
            System.out.print(limpaTela);
            System.out.println("Minuendo: ");
            valor1 = ler.nextDouble();
            System.out.println("Subtraendo : ");
            valor2 = ler.nextDouble();
            Numero absoluto = calc.absolutoDaDiferenca(new NumeroImpl(valor1), new NumeroImpl(valor2));
            System.out.println("Absoluto: " + absoluto.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 7:
            System.out.print(limpaTela);
            System.out.println("Número para arredondar acima: ");
            valor1 = ler.nextDouble();
            Numero arredondarAcima = calc.arredondarAcima(new NumeroImpl(valor1));
            System.out.println("Acima: " + arredondarAcima.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 8:
            System.out.print(limpaTela);
            System.out.println("Número para arredondar abaixo: ");
            valor1 = ler.nextDouble();
            Numero arredondarAbaixo = calc.arredondarAbaixo(new NumeroImpl(valor1));
            System.out.println("Abaixo: " + arredondarAbaixo.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 9:
            System.out.print(limpaTela);
            System.out.println("Número para arredondar acima: ");
            int numFac = ler.nextInt();
            Numero fatorial = calc.fatorial(numFac);
            System.out.println("Acima: " + fatorial.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 0:
            program = false;
            System.out.println("Programa encerrado.");
            break;
          default:
            System.out.println("Opção inválida. Tente novamente.");
            break;
        }
      }
/*
      System.out.println("Resultados obtidos do servidor:" +
                        "\n\t+:" + soma.getValor() +
                        "\n\t-:" + sub.getValor()  +
                        "\n\t*:" + mult.getValor() +
                        "\n\t/:" + div.getValor() + 
                        "\n\tpotencia:" + potencia.getValor() +
                        "\n\tabsoluto:" + absoluto.getValor() +
                        "\n\tacima:" + acima.getValor() +
                        "\n\tabaixo:" + abaixo.getValor() +
                        "\n\tfatorial:" + fatorial.getValor() +
                        "\n\tminimo:" + minimo.getValor() +
                        "\n\tmaximo:" + maximo.getValor() +
                        "\n\tmedia:" + media.getValor() +
                        "\n\tabsoluto da diferença:" + absolutoDaDiferenca.getValor() +
                        "\n\tarredondar para inteiro:" + arredondar1.getValor() + 
                        "\n\tarredondar para inteiro:" + arredondar2.getValor() +
                        "\n\tarredondar para inteiro:" + arredondar3.getValor() +
                        "\n\traiz Quadrada: " + raizQuadrada.getValor() +
                        "\n\tradiciação : " + indice + ": " + radiciacao.getValor() +
                        "\n\t2 horas em segundos: " + horaSegundo.getValor() + 
                        "\n\t7200 segundos em horas: " + segundoHora.getValor() +
                        "\n\t25 graus Celsius em Fahrenheit: " + celsiusFahrenheit.getValor() +
                        "\n\t2.5 kg em gramas: " + kgEmG.getValor()
                      );



      try {
        calc.dividir(new NumeroImpl(1), new NumeroImpl(0));
      } catch (DivisaoPorZeroException e) {
        System.out.println("Tentou dividir por zero! Esta é uma exceção remota.");
      }


 */
    } catch (Exception e) {
      System.err.println("Ocorreu um erro no cliente: " + e.toString());
    }
  }

}

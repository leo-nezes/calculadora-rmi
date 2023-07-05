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

      //Leitura de dados e tela de comandos
      Scanner ler = new Scanner(System.in);
      int n;
      int operacao;


      TelaConsole telaConsole = new TelaConsole();
      String limpaTela = "\033\143";
      boolean program = true;
      while (program ) {
        System.out.print(limpaTela);
        telaConsole.tela();
        operacao = ler.nextInt();
        switch (operacao) {
          case 1:
            System.out.print(limpaTela);
            System.out.println("Numero 1: ");
            double valor1 = ler.nextDouble();
            System.out.println("+ : ");
            double valor2 = ler.nextDouble();
            Numero soma = calc.somar(new NumeroImpl(valor1), new NumeroImpl(valor2));
            System.out.println("Soma: " + soma.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 2:
            System.out.print(limpaTela);
            System.out.println("Numero 1: ");
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
            System.out.println("Numero 1: ");
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
            System.out.println("Numero 1: ");
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
            System.out.println("Numero 1: ");
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
            System.out.println("Numero : ");
            valor1 = ler.nextDouble();
            Numero absoluto = calc.valorAbsoluto(new NumeroImpl(valor1));
            System.out.println("Absoluto: " + absoluto.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 7:
            System.out.print(limpaTela);
            System.out.println("Numero para arredondar acima: ");
            valor1 = ler.nextDouble();
            Numero arredondarAcima = calc.arredondarAcima(new NumeroImpl(valor1));
            System.out.println("Acima: " + arredondarAcima.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 8:
            System.out.print(limpaTela);
            System.out.println("Numero para arredondar abaixo: ");
            valor1 = ler.nextDouble();
            Numero arredondarAbaixo = calc.arredondarAbaixo(new NumeroImpl(valor1));
            System.out.println("Abaixo: " + arredondarAbaixo.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 9:
            System.out.print(limpaTela);
            System.out.println("Numero para arredondar acima: ");
            int numFac = ler.nextInt();
            Numero fatorial = calc.fatorial(numFac);
            System.out.println("Acima: " + fatorial.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 10:
            System.out.print(limpaTela);
            int loop1 = 1;
            List<Numero> numsMinimo = new ArrayList<>();
            while (loop1 == 1) {
              System.out.println("Numero para adicionar na lista: ");
              System.out.println("00 - Encerrar loop");
              int numMinimo = ler.nextInt();
              if (numMinimo != 00) {
                numsMinimo.add(new NumeroImpl(numMinimo));
              } else {
                loop1 = 200;
              }
            }
            Numero minimo = calc.minimo(numsMinimo);
            System.out.println("Minimo: " + minimo.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 11:
            System.out.print(limpaTela);
            int loop2 = 1;
            List<Numero> numsMin = new ArrayList<>();
            while (loop2 == 1) {
              System.out.println("Numero para adicionar na lista: ");
              System.out.println("00 - Encerrar loop");
              int numMaximo = ler.nextInt();
              if (numMaximo != 00) {
                numsMin.add(new NumeroImpl(numMaximo));
              } else {
                loop2 = 200;
              }
            }
            Numero maximo = calc.maximo(numsMin);
            System.out.println("Máximo: " + maximo.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 12:
            System.out.print(limpaTela);
            int loop3 = 1;
            List<Numero> numsMedia = new ArrayList<>();
            while (loop3 == 1) {
              System.out.println("Número para adicionar na lista: ");
              System.out.println("00 - Encerrar loop");
              int numMedia = ler.nextInt();
              if (numMedia != 00) {
                numsMedia.add(new NumeroImpl(numMedia));
              } else {
                loop3 = 200;
              }
            }
            Numero media = calc.media(numsMedia);
            System.out.println("Média: " + media.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 13:
            System.out.print(limpaTela);
            System.out.println("Num 1: ");
            valor1 = ler.nextDouble();
            System.out.println("Num 2 : ");
            valor2 = ler.nextDouble();
            Numero absolutoDaDiferenca = calc.absolutoDaDiferenca(new NumeroImpl(valor1), new NumeroImpl(valor2));
            System.out.println("Absoluto da Diferença: " + absolutoDaDiferenca.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 14:
            System.out.print(limpaTela);
            System.out.println("Numero para arredondar : ");
            valor1 = ler.nextDouble();
            Numero arredondar = calc.arredondarParaInteiro(new NumeroImpl(valor1));
            System.out.println("Arredondar para Inteiro: " + arredondar.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 15:
            System.out.print(limpaTela);
            System.out.println("Número : ");
            valor1 = ler.nextDouble();
            Numero raizQuadrada = calc.calculaRaiz(new NumeroImpl(valor1));
            System.out.println("Raiz Quadrada: " + raizQuadrada.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 16:
            System.out.print(limpaTela);
            System.out.println("Num : ");
            valor1 = ler.nextDouble();
            System.out.println("Indice : ");
            valor2 = ler.nextDouble();
            Numero radiciacao = calc.radiciacao(new NumeroImpl(valor1), valor2);
            System.out.println("Radiciacao: " + radiciacao.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 17:
            System.out.print(limpaTela);
            System.out.println("Hora : ");
            valor1 = ler.nextDouble();
            Numero horaSegundo = calc.converterHorasEmSegundos(new NumeroImpl(valor1));
            System.out.println("Hora  em Segundos: " + horaSegundo.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 18:
            System.out.print(limpaTela);
            System.out.println("Segundo : ");
            valor1 = ler.nextDouble();
            Numero segundoHora = calc.converterSegundosEmHoras(new NumeroImpl(valor1));
            System.out.println("Segundos  em Horas: " + segundoHora.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 19:
            System.out.print(limpaTela);
            System.out.println("Celsius : ");
            valor1 = ler.nextDouble();
            Numero celsiusFahrenheit = calc.converterCelsiusParaFahrenheit(new NumeroImpl(valor1));
            System.out.println("Celsius  em Fahrenheint: " + celsiusFahrenheit.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 20:
            System.out.print(limpaTela);
            System.out.println("KG : ");
            valor1 = ler.nextDouble();
            Numero kgEmG = calc.converterKgParaGramas(new NumeroImpl(valor1));
            System.out.println("Kg em g: " + kgEmG.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 21:
            System.out.print(limpaTela);
            System.out.println("Decimal : ");
            valor1 = ler.nextDouble();
            Numero deciBinario = calc.decimalParaBinario(new NumeroImpl(valor1));
            System.out.println("Decimal para binario: " + deciBinario.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 22:
            System.out.print(limpaTela);
            System.out.println("Decimal : ");
            valor1 = ler.nextDouble();
            Numero hexadecimal = calc.decimalHexadecimal(new NumeroImpl(valor1));
            System.out.println("Decimal para hexadecimal:  " + hexadecimal.getValor());
            System.out.println("Aperte 1 para continuar");
            ler.next();
            break;
          case 23:
            System.out.print(limpaTela);
            System.out.println("Binario : ");
            valor1 = ler.nextDouble();
            Numero binarioDecimal = calc.binarioDecimal(new NumeroImpl(valor1));
            System.out.println("Binario para decimal: " + binarioDecimal.getValor());
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
    } catch (Exception e) {
      System.err.println("Ocorreu um erro no cliente: " + e.toString());
    }
  }

}

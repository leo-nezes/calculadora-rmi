import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.List;

public class ClienteCalculadora {
  public static void main(String[] args) {
    try {
      // Localiza o registry. É possível usar endereço/IP porta
      Registry registry = LocateRegistry.getRegistry(null);
      // Consulta o registry e obtém o stub para o objeto remoto
      Calculadora calc = (Calculadora) registry.lookup("calculadora");

      // A partir deste momento, cahamadas à Caluladora podem ser
      // feitas como qualquer chamada a métodos

      Numero num1 = new NumeroImpl(2);
      Numero num2 = new NumeroImpl(1);
      Numero num3 = new NumeroImpl(2.56);
      Numero num4 = new NumeroImpl(1.86);
      List<Numero> nums = Arrays.asList(num1, num2, num3, num4);
      Double indice = 2.0;

      //Aqui são feitas diversas chamadas remotas
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
      Numero deciBinario = calc.decimalParaBinario(new NumeroImpl(56));
      Numero hexadecimal = calc.decimalHexadecimal(new NumeroImpl(56));
      Numero binarioDecimal = calc.binarioDecimal(new NumeroImpl(101010));

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
                        "\n\t2.5 kg em gramas: " + kgEmG.getValor() +
                        "\n\tDecimal para binario: " + deciBinario.getValor() +
                         "\n\tDecimal para hexadecimal: " + hexadecimal.getValor() +
                         "\n\tbinario para decimal: " + binarioDecimal.getValor()
                         
                      );

      try {
        calc.dividir(new NumeroImpl(1), new NumeroImpl(0));
      } catch (DivisaoPorZeroException e) {
        System.out.println("Tentou dividir por zero! Esta é uma exceção remota.");
      }

    } catch (Exception e) {
      System.err.println("Ocorreu um erro no cliente: " + e.toString());
    }
  }
}

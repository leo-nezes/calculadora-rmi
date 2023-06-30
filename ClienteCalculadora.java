import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.List;

public class ClienteCalculadora {
  public static void main(String[] args) {
    try {
      // Localiza o registry. É possível usar endereço/IP porta
      Registry registry = LocateRegistry.getRegistry(null, 5080);
      // Consulta o registry e obtém o stub para o objeto remoto
      Calculadora calc = (Calculadora) registry.lookup("calculadora");
      // A partir deste momento, cahamadas à Caluladora podem ser
      // feitas como qualquer chamada a métodos

      Numero num1 = new NumeroImpl(2);
      Numero num2 = new NumeroImpl(1);
      Numero num3 = new NumeroImpl(2.56);
      Numero num4 = new NumeroImpl(1.86);
      List<Numero> nums = Arrays.asList(num1, num2, num3, num4);

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
                        "\n\tmedia:" + media.getValor());

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

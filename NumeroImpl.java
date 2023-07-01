public class NumeroImpl implements Numero {
  private double num;

  public NumeroImpl (double val) {
    num = val;
  }

  public double getValor() {
    return num;
  }

  public double raizQuadrada() {
        return Math.sqrt(num);
    }

  public double radiciacao(double indice) {
        return Math.pow(num, 1.0 / indice);
    }

  public double converterHorasEmSegundos() {
        return num * 3600; // 1 hora = 3600 segundos
    }
}

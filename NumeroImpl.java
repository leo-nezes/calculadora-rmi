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
        return num * 3600; 
    }

  public double converterSegundosEmHoras() {
        return num / 3600; 
    }

   public double converterCelsiusParaFahrenheit() {
        return (num * 9/5) + 32;
    }
}

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
}

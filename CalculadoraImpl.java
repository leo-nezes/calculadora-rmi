import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculadoraImpl implements Calculadora {
  public Numero somar(Numero a, Numero b) {
    return new NumeroImpl (a.getValor() + b.getValor());
  };

  public Numero subtrair(Numero a, Numero b) {
    return new NumeroImpl (a.getValor() - b.getValor());
  };

  public Numero multiplicar(Numero a, Numero b)  {
    return new NumeroImpl (a.getValor() * b.getValor());
  };

  public Numero dividir(Numero a, Numero b) throws DivisaoPorZeroException {
    if (b.getValor() == 0)
      throw new DivisaoPorZeroException();

    return new NumeroImpl (a.getValor() / b.getValor());
  };

  public Numero potenciar(Numero base, Numero expoente) throws DivisaoPorZeroException {
    return new NumeroImpl (Math.pow(base.getValor(), expoente.getValor()));
  };

  public Numero valorAbsoluto(Numero numero) throws DivisaoPorZeroException {
    return new NumeroImpl (Math.abs(numero.getValor()));
  };

  public Numero arredondarAcima(Numero numero) throws DivisaoPorZeroException {
    return new NumeroImpl (Math.ceil(numero.getValor()));
  };

  public Numero arredondarAbaixo(Numero numero) throws DivisaoPorZeroException {
    return new NumeroImpl (Math.floor(numero.getValor()));
  };

  public Numero fatorial(int fatorial) throws DivisaoPorZeroException {
    int resultado = 1;
    
    for (int i = fatorial; i > 1; i--)
      resultado *= i;
    
    return new NumeroImpl(resultado);
  };

  public Numero minimo(List<Numero> numeros) throws DivisaoPorZeroException {
    List<Double> numerosValores = new ArrayList<Double>();
    
    for (Numero numero : numeros)
      numerosValores.add(numero.getValor());

    Double minimo = Collections.min(numerosValores);
    
    return new NumeroImpl(minimo);
  };

  public Numero maximo(List<Numero> numeros) throws DivisaoPorZeroException {
    List<Double> numerosValores = new ArrayList<Double>();
    
    for (Numero numero : numeros)
      numerosValores.add(numero.getValor());

    Double maximo = Collections.min(numerosValores);
    
    return new NumeroImpl(maximo);
  };
  
}

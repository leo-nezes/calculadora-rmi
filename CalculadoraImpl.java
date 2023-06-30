import java.rmi.RemoteException;
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

  public Numero potenciar(Numero base, Numero expoente) throws RemoteException {
    return new NumeroImpl (Math.pow(base.getValor(), expoente.getValor()));
  };

  public Numero valorAbsoluto(Numero numero) throws RemoteException {
    return new NumeroImpl (Math.abs(numero.getValor()));
  };

  public Numero arredondarAcima(Numero numero) throws RemoteException {
    return new NumeroImpl (Math.ceil(numero.getValor()));
  };

  public Numero arredondarAbaixo(Numero numero) throws RemoteException {
    return new NumeroImpl (Math.floor(numero.getValor()));
  };

  public Numero fatorial(int fatorial) throws RemoteException {
    int resultado = 1;
    
    for (int i = fatorial; i > 1; i--)
      resultado *= i;
    
    return new NumeroImpl(resultado);
  };

  public Numero minimo(List<Numero> numeros) throws RemoteException {
    List<Double> numerosValores = new ArrayList<Double>();
    
    for (Numero numero : numeros)
      numerosValores.add(numero.getValor());

    Double minimo = Collections.min(numerosValores);
    
    return new NumeroImpl(minimo);
  };

  public Numero maximo(List<Numero> numeros) throws RemoteException {
    List<Double> numerosValores = new ArrayList<Double>();
    
    for (Numero numero : numeros)
      numerosValores.add(numero.getValor());

    Double maximo = Collections.max(numerosValores);
    
    return new NumeroImpl(maximo);
  };

  public Numero media(List<Numero> numeros) throws RemoteException {
    double somatorio = 0;
    
    for (Numero numero : numeros)
      somatorio += numero.getValor();

    return new NumeroImpl(somatorio / numeros.size());
  }

  public Numero absolutoDaDiferenca(Numero minuendo, Numero subtraendo) throws RemoteException {
    Numero resultado = this.subtrair(minuendo, subtraendo);

    return this.valorAbsoluto(resultado);
  };
  
  public Numero arredondarParaInteiro(Numero numero) throws RemoteException {
    int inteiro = (int) numero.getValor();
    double decimal = ((numero.getValor() - inteiro) * 10);
    int primeiraCasaDecimal = (int) decimal;
    int resultado = 0;

    if ((primeiraCasaDecimal == 0) || (primeiraCasaDecimal > 0 && primeiraCasaDecimal < 5))
      resultado = inteiro;
    else if (primeiraCasaDecimal >= 5)
      resultado = ++inteiro;

    return new NumeroImpl(resultado);
  };
  
}

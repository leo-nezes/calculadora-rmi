import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Calculadora extends Remote {
  public Numero somar (Numero a, Numero b) throws RemoteException;
  public Numero subtrair (Numero a, Numero b) throws RemoteException;
  public Numero multiplicar (Numero a, Numero b) throws RemoteException;
  public Numero dividir (Numero a, Numero b) throws RemoteException, DivisaoPorZeroException;
  public Numero potenciar(Numero base, Numero expoente) throws RemoteException;
  public Numero valorAbsoluto(Numero numero) throws RemoteException;
  public Numero arredondarAcima(Numero numero) throws RemoteException;
  public Numero arredondarAbaixo(Numero numero) throws RemoteException;
  public Numero fatorial(int fatorial) throws RemoteException;
  public Numero minimo(List<Numero> numeros) throws RemoteException;
  public Numero maximo(List<Numero> numeros) throws RemoteException;
  public Numero media(List<Numero> numeros) throws RemoteException;
}

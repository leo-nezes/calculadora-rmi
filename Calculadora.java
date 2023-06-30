import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {
  public Numero somar (Numero a, Numero b)
    throws RemoteException;

  public Numero subtrair (Numero a, Numero b)
    throws RemoteException;

  public Numero multiplicar (Numero a, Numero b)
    throws RemoteException;

  public Numero dividir (Numero a, Numero b)
    throws RemoteException, DivisaoPorZeroException;
}

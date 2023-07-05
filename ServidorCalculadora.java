import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
public class ServidorCalculadora {
  public static void main(String args[]) {
    try {
      // Crio o objeto servidor
            CalculadoraImpl calc = new CalculadoraImpl();

            // Criamos o stub do objeto que será registrado
            Calculadora calcStub = (Calculadora) UnicastRemoteObject.exportObject(calc, 5080);

            // Registra (binds) os stubs no registry
            //Registry registry = LocateRegistry.getRegistry();
            Registry registry = LocateRegistry.createRegistry(5080);
            registry.bind("calculadora", calcStub);

            System.out.println("Servidor iniciado.");
    } catch (Exception e) {
      System.err.println("Ocorreu um erro no servidor: " + e.toString());
    }
  }
}

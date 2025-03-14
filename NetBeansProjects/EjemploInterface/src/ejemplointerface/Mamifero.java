package ejemplointerface;

/**
 *
 * @author Gon
 */
public class Mamifero implements Animal{

    @Override
    public void nombreEspecie(String nombre) {
        System.out.println("Especie: " + nombre);
    }

    @Override
    public void continente() {
        System.out.println("Texto o código correspondiente a este método");
    }
    
}

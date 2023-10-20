import java.util.ArrayList;

public class Route {
    private Planet origin;
    private Planet destination;
    private ArrayList<Products> cargo;

    public Route (Planet origin, Planet destination, ArrayList<Products> products) {
        this.cargo = products;
        this.origin = origin;
        this.destination = destination;
    }

    public String toString() {
        return origin.toString()+" -> "+destination.toString() + cargo;
    }



}

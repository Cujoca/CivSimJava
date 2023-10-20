import java.util.ArrayList;
import java.util.Map;

public class Industry {
    private String type;
    private Map<Products, Integer> output;
    private Map<Products, Integer> input;

    public Industry (String type) {
        this.type = type;
    }

    public void addOutput (Products product) {
        output.put(product, product.getAmount());
    }
    public void addInput (Products product) {
        input.put(product, product.getAmount());
    }

    public String toString() {
        return type;
    }

    public Map<Products,Integer> getInput() { return input; }
    public Map<Products,Integer> getOutput() {
        return output;
    }
}

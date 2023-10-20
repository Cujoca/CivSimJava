public class Products {
    private String name;
    private int baseCost;
    private int amount;

    public void changeAmount (int change) {
        amount += change;
    }

    public Products (String name, int baseCost) {
        this.name = name;
        this.baseCost = baseCost;
    }

    public void setAmount(int amount) {this.amount = amount;}

    public String toString() {
        return name+" "+amount;
    }

    public int getAmount() { return amount; }
    public int getBaseCost() { return baseCost; }
    public String getName() { return name; }
}

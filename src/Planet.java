import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Planet {
    private String name;
    private Faction owner;
    private ArrayList<Industry> industries;
    private HashMap<Products, Integer> totalConsumption;
    private HashMap<Products, Integer> totalProduction;
    private HashMap<Products, Integer> exports;
    private HashMap<Products, Integer> inports;
    private HashMap<Products, Integer> needed;
    private HashMap<Products, Integer> excess;
    private ArrayList<Route> tradeRoutes;
    private ArrayList<Planet> tenLightYears;
    private ArrayList<Planet> twentyLightYears;
    private ArrayList<Planet> thirtyLightYears;
    private ArrayList<Planet> fartherThanThirty;

    public Planet (String name, Faction owner) {
        this.name = name;
        this.owner = owner;
        this.industries = new ArrayList<Industry>();
        this.totalConsumption = new HashMap<>();
        this.totalProduction = new HashMap<>();
        this.exports = new HashMap<>();
        this.inports = new HashMap<>();
        this.needed = new HashMap<>();
        this.excess = new HashMap<>();
        this.tradeRoutes = new ArrayList<Route>();
        this.tenLightYears = new ArrayList<Planet>();
        this.twentyLightYears = new ArrayList<Planet>();
        this.thirtyLightYears = new ArrayList<Planet>();
        this.fartherThanThirty = new ArrayList<Planet>();
    }

    public void addPlanet (Planet planet, int distance) {

        //list of planets nearby, this is kind of dumb and would be a hindrance in a grid system

        if (distance <= 10)
            this.tenLightYears.add(planet);
        else if (distance > 10 && distance <= 20)
            this.twentyLightYears.add(planet);
        else if (distance > 20 && distance <= 30)
            this.thirtyLightYears.add(planet);
        else
            this.fartherThanThirty.add(planet);
        if (!this.tenLightYears.contains(planet) &&
                !this.twentyLightYears.contains(planet) &&
                !this.thirtyLightYears.contains(planet) &&
                !this.fartherThanThirty.contains(planet))
            planet.addPlanet(this, distance);
        if (!planet.tenLightYears.contains(this) &&
                !planet.twentyLightYears.contains(this) &&
                !planet.thirtyLightYears.contains(this) &&
                !planet.fartherThanThirty.contains(this)) {
            planet.addPlanet(this, distance);
        }
    }

    //TODO - figure out what the fuck is going on here

    /**
     *
     * @param have  yeehaw
     * @param required hawyee
     */
    public void getDifference (HashMap<Products, Integer> have, HashMap<Products, Integer> required) {

        have.forEach((product, amount) ->  {
            if (required.containsKey(product)) {
                if (have.get(product) > required.get(product)) {
                    if (this.excess.containsKey(product)) {

                    }
                }
            }

        });

    }


    /**
     * figure out total net of products, negative is inadequate, positive means excess
     */
    public void balanceProduction() {

        needed.clear();
        excess.clear();
        HashMap<Products, Integer> tempCon = new HashMap<>();
        HashMap<Products, Integer> tempPro = new HashMap<>();
        tempCon.putAll(this.getTotalConsumption());
        tempPro.putAll(this.getTotalProduction());

        getDifference(tempCon, totalProduction);
        getDifference(tempPro, totalConsumption);
        getDifference(tempCon, inports);
        getDifference(tempPro, exports);

        needed = tempCon;
        excess = tempPro;
    }

    //figure out who this planet should trade with

    public void findTradePartners () {
        ArrayList<Products> temp = new ArrayList<Products>();
        temp.addAll(excess);
        //check planets in close proximity, then move outward depending on need
        //TODO - should come up with some calculation that takes distance, products, and relation into account
        //TODO - though this is kind of sufficient, should make something cooler if going to elaborate

        for (Planet i : tenLightYears) {
            System.out.println("Checking planet "+i);
            System.out.println(i.getOwner().getRelationToFaction(this.owner));
            if (i.getOwner().getRelationToFaction(this.owner) > -25) {
                System.out.println("Is not hostile");
                if (temp.size() != 0) {
                    for (Products j : temp) {
                        createTradeRoutes(i, j, true);
                    }
                }
            }
            temp.addAll(excess);

        }
        //TODO - actually create second and third stages of planet finding

        temp.clear();
        temp.addAll(needed);
        for (Planet i : tenLightYears) {
            System.out.println("Checking planet "+i);
            if (i.getOwner().getRelationToFaction(this.owner) > -25) {
                System.out.println("Is not hostile");
                if (temp.size() != 0) {
                    for (Products j : temp) {
                        System.out.println("Adding "+j+" to trade route");
                        createTradeRoutes(i, j, false);
                    }
                }
            }
            temp.addAll(needed);
        }
    }

    //initialization of trade routes

    public void createTradeRoutes (Planet partner, Products product, Boolean inportExport) {
        //export = false
        //inport == true
        if (inportExport)
            inports.add(product);
        else
            exports.add(product);
        ArrayList<Products> products = new ArrayList<>();
        products.add(product);
        Route newRoute = new Route (this, partner, products);
        this.tradeRoutes.add(newRoute);
        balanceProduction();

    }

    //menial and simple fuctions to be reused
    //TODO - change to support hashmaps instead of arraylists

    public void addIndustry (Industry addition) {
        industries.add(addition);
        totalConsumption.addAll(addition.getInput());
        totalProduction.addAll(addition.getOutput());
        balanceProduction();
    }

    public String toString() {
        return name;
    }

    public ArrayList<String> listIndustries () {
        ArrayList<String> output = new ArrayList<String>();
        for (Industry i : industries) {
            output.add(i.toString());
        }
        return output;
    }
    public ArrayList<String> listNeeded () {
        ArrayList<String> output = new ArrayList<String>();
        for (Products i : needed) {
            output.add(i.toString());
        }
        return output;
    }
    public ArrayList<String> listExcess () {
        ArrayList<String> output = new ArrayList<String>();
        for (Products i : excess) {
            output.add(i.toString());
        }
        return output;
    }
    public ArrayList<String> listExports () {
        ArrayList<String> output = new ArrayList<String>();
        for (Products i : exports) {
            output.add(i.toString());
        }
        return output;
    }
    public ArrayList<String> listInports () {
        ArrayList<String> output = new ArrayList<String>();
        for (Products i : inports) {
            output.add(i.toString());
        }
        return output;
    }
    public ArrayList<String> listTP () {
        ArrayList<String> output = new ArrayList<String>();
        for (Products i : totalProduction) {
            output.add(i.toString());
        }
        return output;
    }
    public ArrayList<String> listTC () {
        ArrayList<String> output = new ArrayList<String>();
        for (Products i : totalConsumption) {
            output.add(i.toString());
        }
        return output;
    }
    public ArrayList<String> listRoutes () {
        ArrayList<String> output = new ArrayList<String>();
        for (Route i : tradeRoutes) {
            output.add(i.toString());
        }
        return output;
    }








    //java get/set

    public String getName() { return name; }
    public ArrayList<Industry> getIndustries() { return industries; }
    public HashMap<Products, Integer> getExcess() { return excess; }
    public HashMap<Products, Integer> getExports() { return exports; }
    public HashMap<Products, Integer> getInports() { return inports; }
    public HashMap<Products, Integer> getNeeded() { return needed; }
    public HashMap<Products, Integer> getTotalConsumption() { return totalConsumption; }
    public HashMap<Products, Integer> getTotalProduction() { return totalProduction; }
    public ArrayList<Route> getTradeRoutes() { return tradeRoutes; }
    public Faction getOwner() { return owner; }
}

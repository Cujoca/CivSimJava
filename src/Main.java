public class Main {

    public static void main (String[] args) {

        Products drugs = new Products ("Drugs", 250);
        Products ore = new Products ("Ore", 10);
        Products rareOre = new Products ("Rare Ore", 50);
        Products metal = new Products ("Metal", 20);
        Products rareMetal = new Products ("Rare Metal", 100);
        Products fungus = new Products ("Fungus", 50);
        Products food = new Products("food", 25);


        Industry mining = new Industry ("mining");
        mining.addInput(drugs);
        mining.addOutput(ore);
        mining.addOutput(rareOre);

        Industry processing = new Industry ("Processing");
        processing.addInput(ore);
        processing.addInput(rareOre);
        processing.addOutput(metal);
        processing.addOutput(rareMetal);

        Industry farms = new Industry ("Farms");
        farms.addOutput(food);
        farms.addOutput(fungus);

        Industry drugsProcessing = new Industry ("Drugs Processing");
        drugsProcessing.addInput(fungus);
        drugsProcessing.addOutput(drugs);

        Faction federation = new Faction("Federation");
        Faction empire = new Faction ("Empire");
        Faction alliance = new Faction ("Alliance");

        Planet earth = new Planet("earth", federation);
        earth.addIndustry(processing);
        earth.addIndustry(drugsProcessing);
        Planet siriusB = new Planet("Sirius B", alliance);
        siriusB.addIndustry(mining);
        siriusB.addIndustry(farms);
        Planet aldebaraan = new Planet ("aldebaraan", empire);
        aldebaraan.addIndustry(mining);
        aldebaraan.addIndustry(farms);
        aldebaraan.addPlanet(earth, 10);
        aldebaraan.addPlanet(siriusB, 10);
        earth.addPlanet(siriusB, 10);

        federation.addFaction(new Relation (alliance, 30));
        federation.addFaction(new Relation (empire, -30));
        System.out.println("FEDERATION   "+federation.listFactions());
        System.out.println("EMPIRE       "+empire.listFactions());
        System.out.println("ALLIANCE     "+alliance.listFactions());

        System.out.println(earth.listIndustries());
        System.out.println(siriusB.listIndustries());
        System.out.println(aldebaraan.listIndustries());
        System.out.println("Production   "+earth.listTP());
        System.out.println("Consumption  "+earth.listTC());
        System.out.println("Excess       "+earth.listExcess());
        System.out.println("Needed       "+earth.listNeeded());
        System.out.println();
        System.out.println("AFTER TRADE ROUTE CREATED");
        System.out.println();
        earth.findTradePartners();
        System.out.println();
        System.out.println("Needed       "+earth.listNeeded());
        System.out.println("Excess       "+earth.listExcess());
        System.out.println("Imports      "+earth.listInports());
        System.out.println("Exports      "+earth.listExports());
        System.out.println("Routes       "+earth.getTradeRoutes());
        siriusB.balanceProduction();


    }
}

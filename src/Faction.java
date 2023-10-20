import javax.print.DocFlavor;
import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Faction {
    private String name;
    private ArrayList<Planet> planets;
    private ArrayList<Relation> relations;

    //change relation with other factions based on flat number

    public void changeRelation (Faction faction, int change) {
        for (Relation i : relations) {
            if (i.getFaction().equals(faction)) {
                i.changeRelation(change);
                break;
            }
        }
    }

    //simple ordering of factions by relation

    public void sortByRelation () {
        Collections.sort(relations);
    }

    //search through list to find faction and return faction
    //TODO - change faction lists to maps because using arraylists and iterating every time is dumb

    public int getRelationToFaction (Faction faction) {
        for (Relation i : this.relations) {
            if (i.getFaction().equals(faction))
                return i.getRelation();
        }
        return -101;
    }

    //add faction with relation

    public boolean addFaction (Relation newRelation) {
        for (Relation i : relations) {
            if (i.getFaction().equals(newRelation.getFaction()))
                return false;
        }
        relations.add(newRelation);
        newRelation.getFaction().addFaction(new Relation(this, newRelation.getRelation()));
        return true;
    }

    //constructor

    public Faction (String name) {
        this.name = name;
        this.relations = new ArrayList<Relation>();
        this.planets = new ArrayList<Planet>();
    }

    //menial and simple reused functions

    public ArrayList<String> listPlanets() {
        ArrayList<String> output = new ArrayList<String>();
        for (Planet i : planets) {
            output.add(i.toString());
        }
        return output;
    }

    public ArrayList<String> listFactions() {
        ArrayList<String> output = new ArrayList<String>();
        for (Relation i : relations) {
            output.add(i.toString()+" "+i.getRelation());
        }
        return output;
    }

    //java bullshit

    public String getName() { return name; }
    public ArrayList<Planet> getPlanets() { return planets; }
    public ArrayList<Relation> getRelations() { return relations; }
}

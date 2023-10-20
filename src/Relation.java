
public class Relation implements Comparable<Relation>{
    private Faction faction;
    private int relation;

    public Relation (Faction faction, int relation) {
        this.faction = faction;
        this.relation = relation;
    }

    @Override
    public int compareTo (Relation relation) {
        int compareRelation=((Relation)relation).getRelation();
        return this.relation-compareRelation;
    }

    public String toString() {
        return faction.getName();
    }

    public void changeRelation (int change) { relation += change; }
    public Faction getFaction() { return faction; }
    public int getRelation() { return relation; }
}

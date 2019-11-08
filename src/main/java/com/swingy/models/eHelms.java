package models;

public class eHelms {

    HELM1("Helm1", 23),
    HELM2("Helm2", 45),
    HELM3("Helm3", 34);

    private String type;
    private int hitPoints;

    public eHelms( int hitPoints, String type ) {
        this.hitPoints = hitPoints;
        this.type = type;
    }

    void setType( String hitPoints ) {
        this.hitPoints = hitPoints;
    }

    String getType() {
        return ( this.type );
    }

    void setHitPoints( String hp ) {
        this.hitPoints = hp;
    }

    int hitPoints() {
        return ( this.hitPoints );
    }


}
package com.swingy.models;

public enum eHelms {

    HELM1("Helm1", 23),
    HELM2("Helm2", 45),
    HELM3("Helm3", 34);

    private String type;
    private int hitPoints;

    eHelms(  String type ,int hitPoints ) {
        this.hitPoints = hitPoints;
        this.type = type;
    }

    void setType( String type ) {
        this.type = type;
    }

    String getType() {
        return ( this.type );
    }

    void setHitPoints( int hp ) {
        this.hitPoints = hp;
    }

    int getHitPoints() {
        return ( this.hitPoints );
    }


}
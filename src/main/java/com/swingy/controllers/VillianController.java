package com.swingy.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.swingy.models.Hero;
import com.swingy.utils.Point;

public class VillianController {
    /**
     * places Villians int the field and takes care of collision
     * @param pl - current hero
     * @return - new Villian added
     */
    public static List<Point> villianPos( Hero pl ) {
        List<Point> villians = new ArrayList<>();
        //size of square
        int len = ((pl.getLevel() - 1) * 5 + 10 - (pl.getLevel() % 2));
        while( villians.size() < len) {
            Point loc = new Point(new Random().nextInt(len), new Random().nextInt(len) );
            //check villians ontop of others or a player on instantiation
            //might need to change pl.getLocation
            if ( (!villians.contains( loc )) && ( loc.getX() != pl.getLocation().getX() && loc.getY() != pl.getLocation().getY())) {
                villians.add( loc );
            }
        }
        return ( villians );
    }
}
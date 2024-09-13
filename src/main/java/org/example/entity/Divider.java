package org.example.entity;

import java.util.Vector;

/**
 * <p>Title: Island</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** Az y tengely skálázásához használt osztály */
public class Divider {

    /** A felbontások értékeit tároló vektor */
    Vector divides = new Vector();

    /** Az aktuális felbontás */
    Double actualDividing;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public Divider(double actualDividing) {
        this.actualDividing = new Double(actualDividing);
        initSizes();
    }

    //----------------------------------------------------------------------

    /** Feltölti a felbontásokat tároló vektort */
    private void initSizes() {
        divides.add(new Double(0.025));
        divides.add(new Double(0.05));
        divides.add(new Double(0.1));
        divides.add(new Double(0.2));
        divides.add(new Double(0.4));
        divides.add(new Double(0.8));
        divides.add(new Double(1.6));
        divides.add(new Double(3.2));
    }

    //----------------------------------------------------------------------

    /** Eggyel nagyobb felbontást ad vissza, ha még lehetséges nagyobb */
    public double moreDividing() {
        int index = divides.indexOf(actualDividing);
        if (index < divides.size() - 1)
            return ((Double) divides.get(index + 1)).doubleValue();
        return ((Double) divides.get(index)).doubleValue();
    }

    //----------------------------------------------------------------------

    /** Eggyel kisebb felbontást ad vissza, ha még lehetséges kisebb */
    public double lessDividing() {
        int index = divides.indexOf(actualDividing);
        if (index > 0)
            return ((Double) divides.get(index - 1)).doubleValue();
        return ((Double) divides.get(index)).doubleValue();
    }

}
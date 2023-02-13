package com.example.classtask;
import java.util.ArrayList;
import java.util.Date;
public class Prayer {
    private String name;
    private boolean isOffered;
    private boolean isWithJamaat;
    private int rakats;
    private String rakat;

    public Prayer(String name) {
        this.name = name;
    }

    public Prayer()
    {

    }

    public Prayer(boolean isoff, boolean isjmt, int rakats)
    {
        this.isOffered = isoff;
        this.isWithJamaat = isjmt;
        this.rakats = rakats;
    }



    public String getName() {
        return name;
    }

    public boolean isOffered() {
        return isOffered;
    }

    public void setOffered(boolean offered) {
        isOffered = offered;
    }

    public boolean isWithJamaat() {
        return isWithJamaat;
    }



    public int getRakats() {
        return rakats;
    }


    public void setOfferPrayer(boolean isOffered) {
        this.isOffered = isOffered;
    }

    public void setWithJamaat(boolean isWithJamaat) {
        this.isWithJamaat = isWithJamaat;
    }


    public void setRakat(String rakats) {
        this.rakat = rakats;
    }

    public void setRakats(int rakats) {
        this.rakats = rakats;
    }
}

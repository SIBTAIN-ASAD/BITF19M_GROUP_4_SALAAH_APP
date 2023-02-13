package com.example.classtask;
import java.util.ArrayList;
import java.util.Date;
public class Prayer {
    private String name;
    private boolean isOffered;
    private boolean isWithJamaat;
    private String rakats;

    public Prayer(String name) {
        this.name = name;
    }

    public Prayer()
    {
        name = "";
        isOffered = false;
        isWithJamaat = false;
        rakats = "1";
    }

    public Prayer(boolean isoff, boolean isjmt, String rakats)
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
        return Integer.parseInt(rakats);
    }


    public void setOfferPrayer(boolean isOffered) {
        this.isOffered = isOffered;
    }

    public void setWithJamaat(boolean isWithJamaat) {
        this.isWithJamaat = isWithJamaat;
    }

    public void setRakat(String rakats) {
        this.rakats = rakats;
    }
}

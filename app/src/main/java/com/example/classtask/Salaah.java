package com.example.classtask;

public class Salaah {
    private String name;
    private boolean offered;
    private boolean withJamaat;
    private int rakats;

    public Salaah(String name, boolean offered, boolean withJamaat, int rakats) {
        this.name = name;
        this.offered = offered;
        this.withJamaat = withJamaat;
        this.rakats = rakats;
    }

    public String getName() {
        return name;
    }

    public boolean isOffered() {
        return offered;
    }

    public boolean isWithJamaat() {
        return withJamaat;
    }

    public int getRakats() {
        return rakats;
    }
}

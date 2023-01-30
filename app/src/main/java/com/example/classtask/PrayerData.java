package com.example.classtask;

public class PrayerData {
    private String date;
    private Prayer fajar, zohar, asar, maghrib, isha;

    public PrayerData(String date, Prayer fajar, Prayer zohar, Prayer asar, Prayer maghrib, Prayer isha) {
        this.date = date;
        this.fajar = fajar;
        this.zohar = zohar;
        this.asar = asar;
        this.maghrib = maghrib;
        this.isha = isha;
    }

    public String getDate() {
        return date;
    }

    public Prayer getFajar() {
        return fajar;
    }

    public Prayer getZohar() {
        return zohar;
    }

    public Prayer getAsar() {
        return asar;
    }

    public Prayer getMaghrib() {
        return maghrib;
    }

    public Prayer getIsha() {
        return isha;
    }

    public void setOfferPrayer(String salaahName, boolean offered) {
        switch (salaahName) {
            case "Fajar":
                fajar.setOffered(offered);
                break;
            case "Zohar":
                zohar.setOffered(offered);
                break;
            case "Asar":
                asar.setOffered(offered);
                break;
            case "Maghrib":
                maghrib.setOffered(offered);
                break;
            case "Isha":
                isha.setOffered(offered);
                break;
            default:
                break;
        }
    }

    public void setWithJamaat(String salaahName, boolean withJamaat) {
        switch (salaahName) {
            case "Fajar":
                fajar.setWithJamaat(withJamaat);
                break;
            case "Zohar":
                zohar.setWithJamaat(withJamaat);
                break;
            case "Asar":
                asar.setWithJamaat(withJamaat);
                break;
            case "Maghrib":
                maghrib.setWithJamaat(withJamaat);
                break;
            case "Isha":
                isha.setWithJamaat(withJamaat);
                break;
            default:
                break;
        }
    }

    public void setRakat(String salaahName, int rakats) {
        switch (salaahName) {
            case "Fajar":
                fajar.setRakats(rakats);
                break;
            case "Zohar":
                zohar.setRakats(rakats);
                break;
            case "Asar":
                asar.setRakats(rakats);
                break;
            case "Maghrib":
                maghrib.setRakats(rakats);
                break;
            case "Isha":
                isha.setRakats(rakats);
                break;
            default:
                break;
        }
    }
}
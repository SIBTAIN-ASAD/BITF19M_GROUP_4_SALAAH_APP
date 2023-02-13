package com.example.classtask;

public class PrayerData {
    public String date;
    private Prayer fajar, zohar, asar, maghrib, isha;
    public boolean tahajjud;

    public PrayerData()
    {
        this.date = "0/0/0";
        fajar = new Prayer();
        zohar = new Prayer();
        asar = new Prayer();
        maghrib = new Prayer();
        isha = new Prayer();
        tahajjud = false;
    }



    public PrayerData(String date, Prayer fajar, Prayer zohar, Prayer asar, Prayer maghrib, Prayer isha,boolean tahajjud) {
        this.date = date;
        this.fajar = fajar;
        this.zohar = zohar;
        this.asar = asar;
        this.maghrib = maghrib;
        this.isha = isha;
        this.tahajjud = tahajjud;
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
}
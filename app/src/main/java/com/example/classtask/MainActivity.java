package com.example.classtask;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private CheckBox fajarOfferPrayerCheckBox;
    private CheckBox fajarWithJamaatCheckBox;
    private Spinner fajarRakatSpinner;

    private CheckBox zoharOfferPrayerCheckBox;
    private CheckBox zoharWithJamaatCheckBox;
    private Spinner zoharRakatSpinner;

    private CheckBox asarOfferPrayerCheckBox;
    private CheckBox asarWithJamaatCheckBox;
    private Spinner asarRakatSpinner;

    private CheckBox maghribOfferPrayerCheckBox;
    private CheckBox maghribWithJamaatCheckBox;
    private Spinner maghribRakatSpinner;

    private CheckBox ishaOfferPrayerCheckBox;
    private CheckBox ishaWithJamaatCheckBox;
    private Spinner ishaRakatSpinner;

    private ArrayList<Salaah> prayers = new ArrayList<>();
    private ArrayList<Integer> rakaatArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fajarOfferPrayerCheckBox = findViewById(R.id.fajar_offer_prayer);
        fajarWithJamaatCheckBox = findViewById(R.id.fajar_with_jamaat);
        fajarRakatSpinner = findViewById(R.id.fajar_rakat_spinner);

        zoharOfferPrayerCheckBox = findViewById(R.id.zohar_offer_prayer);
        zoharWithJamaatCheckBox = findViewById(R.id.zohar_with_jamaat);
        zoharRakatSpinner = findViewById(R.id.zohar_rakat_spinner);

        asarOfferPrayerCheckBox = findViewById(R.id.asar_offer_prayer);
        asarWithJamaatCheckBox = findViewById(R.id.asar_with_jamaat);
        asarRakatSpinner = findViewById(R.id.asar_rakat_spinner);

        maghribOfferPrayerCheckBox = findViewById(R.id.maghrib_offer_prayer);
        maghribWithJamaatCheckBox = findViewById(R.id.maghrib_with_jamaat);
        maghribRakatSpinner = findViewById(R.id.maghrib_rakat_spinner);

        ishaOfferPrayerCheckBox = findViewById(R.id.isha_offer_prayer);
        ishaWithJamaatCheckBox = findViewById(R.id.isha_with_jamaat);
        ishaRakatSpinner = findViewById(R.id.isha_rakat_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rakaat_array,
               android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fajarRakatSpinner.setAdapter(adapter);
        zoharRakatSpinner.setAdapter(adapter);
        asarRakatSpinner.setAdapter(adapter);
        maghribRakatSpinner.setAdapter(adapter);
        ishaRakatSpinner.setAdapter(adapter);
    }

    private void saveData() {
        Prayer fajar = new Prayer();
        fajar.setOfferPrayer(fajarOfferPrayerCheckBox.isChecked());
        fajar.setWithJamaat(fajarWithJamaatCheckBox.isChecked());
        fajar.setRakat((String) fajarRakatSpinner.getSelectedItem());

        Prayer zohar = new Prayer();
        zohar.setOfferPrayer(zoharOfferPrayerCheckBox.isChecked());
        zohar.setWithJamaat(zoharWithJamaatCheckBox.isChecked());
        zohar.setRakat((String) zoharRakatSpinner.getSelectedItem());
        Prayer asar = new Prayer();
        asar.setOfferPrayer(asarOfferPrayerCheckBox.isChecked());
        asar.setWithJamaat(asarWithJamaatCheckBox.isChecked());
        asar.setRakat((String) asarRakatSpinner.getSelectedItem());

        Prayer maghrib = new Prayer();
        maghrib.setOfferPrayer(maghribOfferPrayerCheckBox.isChecked());
        maghrib.setWithJamaat(maghribWithJamaatCheckBox.isChecked());
        maghrib.setRakat((String) maghribRakatSpinner.getSelectedItem());

        Prayer isha = new Prayer();
        isha.setOfferPrayer(ishaOfferPrayerCheckBox.isChecked());
        isha.setWithJamaat(ishaWithJamaatCheckBox.isChecked());
        isha.setRakat((String) ishaRakatSpinner.getSelectedItem());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(new Date());

        PrayerData prayerData = new PrayerData(date, fajar, zohar, asar, maghrib, isha);
        ArraySet<PrayerData> prayerDataArrayList = null;
        prayerDataArrayList.add(prayerData);
    }
}


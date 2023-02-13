package com.example.classtask;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;

import java.text.ParseException;
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

    private CheckBox tahajjud;

    public Button sav;
    public Button pre;
    public Button nxt;
    public TextView txtDate;

    private ArrayList<PrayerData> prayers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sav = findViewById(R.id.savebtn);
        pre = findViewById(R.id.prebtn);
        nxt = findViewById(R.id.nextbtn);
        txtDate = findViewById(R.id.mydate);

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

        tahajjud = findViewById(R.id.tahajat_offer_prayer);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rakaat_array,
               android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fajarRakatSpinner.setAdapter(adapter);
        zoharRakatSpinner.setAdapter(adapter);
        asarRakatSpinner.setAdapter(adapter);
        maghribRakatSpinner.setAdapter(adapter);
        ishaRakatSpinner.setAdapter(adapter);

        // Add a dummay Data
        Prayer f = new Prayer(true, true, 2);
        Prayer z = new Prayer(true, true, 4);
        Prayer a = new Prayer(false, true, 4);
        Prayer m = new Prayer(true, true, 3);
        Prayer i = new Prayer(true, false, 6);

//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String Date1 = "12/2/2023";
//        try {
//            sdf.parse(Date1);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        boolean t = true;
        PrayerData temp = new PrayerData(Date1, f,z,a,m,i,t);

        prayers.add(temp);
        setAttributes(0);

        sav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    private void setAttributes(int i)
    {
        PrayerData curr = prayers.get(i);

        fajarOfferPrayerCheckBox.setChecked(curr.getFajar().isOffered());
        fajarWithJamaatCheckBox.setChecked(curr.getFajar().isWithJamaat());
        fajarRakatSpinner.setSelection(curr.getFajar().getRakats());

        zoharOfferPrayerCheckBox.setChecked(curr.getZohar().isOffered());
        zoharWithJamaatCheckBox.setChecked(curr.getZohar().isWithJamaat());
        zoharRakatSpinner.setSelection(curr.getZohar().getRakats());

        asarOfferPrayerCheckBox.setChecked(curr.getAsar().isOffered());
        asarWithJamaatCheckBox.setChecked(curr.getAsar().isWithJamaat());
        asarRakatSpinner.setSelection(curr.getAsar().getRakats());

        maghribOfferPrayerCheckBox.setChecked(curr.getMaghrib().isOffered());
        maghribWithJamaatCheckBox.setChecked(curr.getMaghrib().isWithJamaat());
        maghribRakatSpinner.setSelection(curr.getMaghrib().getRakats());

        ishaOfferPrayerCheckBox.setChecked(curr.getIsha().isOffered());
        ishaWithJamaatCheckBox.setChecked(curr.getIsha().isWithJamaat());
        ishaRakatSpinner.setSelection(curr.getIsha().getRakats());

        tahajjud.setChecked(curr.tahajjud);

        txtDate.setText(curr.date);

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


        // SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String Date1 = "12/2/2023";

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            sdf.parse(Date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String date = sdf.format(new Date());

        boolean tjd = tahajjud.isChecked();

        PrayerData prayerData = new PrayerData(date, fajar, zohar, asar, maghrib, isha, tjd);

        boolean found = false;
        // store at specific location
        for(int i = 0; i < prayers.size(); i++)
        {
            if (prayers.get(i).date == date)
            {
                prayers.set(i, prayerData);
                found = true;
            }
        }

        if(found == false)
        {
            prayers.add(prayerData);
        }

    }
}


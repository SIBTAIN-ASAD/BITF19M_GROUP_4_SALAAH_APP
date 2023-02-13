package com.example.classtask;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
import java.util.Calendar;
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
    public Button repo;
    public Button clear;
    public TextView txtDate;

    private ArrayList<PrayerData> prayers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sav = findViewById(R.id.savebtn);
        pre = findViewById(R.id.prebtn);
        nxt = findViewById(R.id.nextbtn);
        repo = findViewById(R.id.repobtn);
        clear = findViewById(R.id.clearbtn);
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
        Prayer f = new Prayer(true, true, "2");
        Prayer z = new Prayer(true, true, "4");
        Prayer a = new Prayer(false, true, "4");
        Prayer m = new Prayer(true, true, "3");
        Prayer i = new Prayer(true, false, "6");

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


        // click listner for save button
        sav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    saveData();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });


        // click listner for next button
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Date1 = txtDate.getText().toString();
                String Date2 = null;
                try {
                    Date2 = getNextDate(Date1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int i = 0;
                try {
                    i = getIndex(Date2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                setAttributes(i);
                txtDate.setText(Date2);
            }
        });

        // click listner for previous button
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Date1 = txtDate.getText().toString();
                String Date2 = null;
                try {
                    Date2 = getPreDate(Date1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int i = 0;
                try {
                    i = getIndex(Date2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                setAttributes(i);
                txtDate.setText(Date2);
            }
        });

        // click listner for clear button
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Date1 = txtDate.getText().toString();
               setAttributes(-1);
               txtDate.setText(Date1);
            }
        });

            // click listner for repo button
            repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://github.com/SIBTAIN-ASAD/BITF19M_GROUP_4_SALAAH_APP";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    public static String getNextDate(String  curDate) throws ParseException {
        final SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        final Date date = format.parse(curDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return format.format(calendar.getTime());
    }


    public static String getPreDate(String  curDate) throws ParseException {
        final SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        final Date date = format.parse(curDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return format.format(calendar.getTime());
    }

    public boolean comapreDates(String D1, String D2) throws ParseException {
        SimpleDateFormat sdformat = new SimpleDateFormat("dd/mm/yyyy");
        Date d1 = sdformat.parse(D1);
        Date d2 = sdformat.parse(D2);
        if(d1.compareTo(d2) > 0) {
            return false;
        } else if(d1.compareTo(d2) < 0) {
            return false;
        } else {
            return true;
        }
    }



    private int getIndex(String date) throws ParseException {
        for(int i = 0; i < prayers.size(); i++)
        {
            Log.d("Index: ","->> "+ date + " " + prayers.get(i).date + " " + String.valueOf(i));
            if (comapreDates(prayers.get(i).date,date) == true)
            {
                return i;
            }
        }
        Log.d("Index: ","->> "+ date + String.valueOf(-1));
        return -1;
    }


    private void setAttributes(int i)
    {

        PrayerData curr;
        if (i == -1)
        {
            curr = new PrayerData();
        }
        else
        {
            curr = prayers.get(i);
        }

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


    private void saveData() throws ParseException {
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
        String Date1 = txtDate.getText().toString();

        boolean tjd = tahajjud.isChecked();

        PrayerData prayerData = new PrayerData(Date1, fajar, zohar, asar, maghrib, isha, tjd);

        int ind = getIndex(Date1);

        if(ind == -1)
        {
            prayers.add(prayerData);
        }
        else
        {
            prayers.set(ind, prayerData);
        }
    }
}


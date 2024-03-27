package com.pma212102375.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tampilTelepon(View view) {
        Intent TeleponIntent = new Intent(Intent.ACTION_DIAL);
        startActivity(TeleponIntent);
    }

    public void tampilSMS(View view) {
        Intent SMSIntent = new Intent(Intent.ACTION_MAIN);
        SMSIntent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(SMSIntent);
    }

    public void tampilKalender(View view) {
        Intent KalenderIntent = new Intent(Intent.ACTION_MAIN);
        KalenderIntent.addCategory(Intent.CATEGORY_APP_CALENDAR);
        startActivity(KalenderIntent);
    }

    public void tampilBrowser(View view) {
        Intent BrowserIntent = new Intent(Intent.ACTION_MAIN);
        BrowserIntent.addCategory(Intent.CATEGORY_APP_BROWSER);
        startActivity(BrowserIntent);
    }

    /*public void tampilKalkulator(View view)
    {
        try {
            Intent KalkulatorIntent = new Intent(Intent.ACTION_MAIN);
            KalkulatorIntent.addCategory(Intent.CATEGORY_LAUNCHER);

            ComponentName cn = new ComponentName("com.android.calculator2", "com.android.calculator2.Calculator");
            KalkulatorIntent.setComponent(cn);

            startActivity(KalkulatorIntent);
        }
        catch (ActivityNotFoundException anfe)
        {
            Toast.makeText(getApplicationContext(), "Aplikasi Tidak Ditemukan", Toast.LENGTH_LONG).show();
        }
    }*/

    public void tampilKontak(View view) {
        Intent KontakIntent = new Intent(Intent.ACTION_MAIN);
        KontakIntent.addCategory(Intent.CATEGORY_APP_CONTACTS);
        startActivity(KontakIntent);
    }

    public void tampilGaleri(View view) {
        Intent GaleriIntent = new Intent(Intent.ACTION_MAIN);
        GaleriIntent.addCategory(Intent.CATEGORY_APP_GALLERY);
        startActivity(GaleriIntent);
    }

    public void tampilWiFi(View view) {
        Intent WiFiIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        startActivity(WiFiIntent);
    }

    public void tampilSound(View view) {
        Intent SoundIntent = new Intent(Settings.ACTION_SOUND_SETTINGS);
        startActivity(SoundIntent);
    }

    public void tampilAirPlane(View view) {
        Intent AirPlaneIntent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        startActivity(AirPlaneIntent);
    }

    public void tampilAplikasi(View view) {
        Intent AplikasiIntent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
        startActivity(AplikasiIntent);
    }

    public void tampilBluetooth(View view) {
        Intent BluetoothIntent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(BluetoothIntent);
    }

    public void tampilKalkulator(View view)
    {
        ArrayList<HashMap<String,Object>> items = new ArrayList<HashMap<String,Object>>();
        final PackageManager pm = getPackageManager();

        List<PackageInfo> packs = pm.getInstalledPackages(0);

        for (PackageInfo pi : packs)
        {
            String packageName = pi.packageName.toString();

            String packageName_lowercase = packageName.toLowerCase();

            if (packageName_lowercase.contains("calcul"))
            {
                HashMap<String, Object> map = new HashMap<String, Object>();

                map.put("appName", pi.applicationInfo.loadLabel(pm));
                map.put("packageName", pi.packageName);

                items.add(map);
            }
        }

        int item_size = items.size();

        if (item_size >=1)
        {
            String packageName = (String) items.get(0).get("packageName");

            Intent i = pm.getLaunchIntentForPackage(packageName);

            if (i != null)
            {
                startActivity(i);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Tidak Ditemukan Aplikasi Kalkulator", Toast.LENGTH_SHORT).show();
            }
        }
    }

}

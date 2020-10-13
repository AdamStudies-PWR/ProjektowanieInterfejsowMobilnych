package com.amazeum.kryptor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity
{
    private final String PREFERENCE_FILE_KEY = "kryptoSettings";
    SharedPreferences preferences;
    SharedPreferences.Editor edit;

    Switch copySwitch;
    Switch shareSwitch;
    Switch removeSwitch;

    Spinner modeSpinner;
    Spinner langSpinner;
    Spinner themeSpinner;

    boolean reset = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(PREFERENCE_FILE_KEY, MODE_PRIVATE);
        edit = preferences.edit();

        if(preferences.getInt("lang", 0) == 0) setLocale("pl");
        else setLocale("en");

        int theme = preferences.getInt("theme", 0);

        switch(theme)
        {
            case 0: setTheme(R.style.AppTheme); break;
            case 1: setTheme(R.style.PinkTheme); break;
            default:
        }

        setContentView(R.layout.activity_settings);

        int temporaryInt;
        boolean temporaryBool;
        copySwitch = (Switch) findViewById(R.id.copy_switch);
        shareSwitch = (Switch) findViewById(R.id.share_switch);
        removeSwitch = (Switch) findViewById(R.id.remove_switch);

        modeSpinner = (Spinner) findViewById(R.id.modeBox);
        langSpinner = (Spinner) findViewById(R.id.langBox);
        themeSpinner = (Spinner) findViewById(R.id.themeBox);

        temporaryBool = preferences.getBoolean("autoSave", false);
        copySwitch.setChecked(temporaryBool);

        temporaryBool = preferences.getBoolean("autoShare", false);
        shareSwitch.setChecked(temporaryBool);

        temporaryBool = preferences.getBoolean("autoRemove", true);
        removeSwitch.setChecked(temporaryBool);

        temporaryInt = preferences.getInt("mode", 0);
        modeSpinner.setSelection(temporaryInt);

        temporaryInt = preferences.getInt("lang", 0);
        langSpinner.setSelection(temporaryInt);

        temporaryInt = preferences.getInt("theme", 0);
        themeSpinner.setSelection(temporaryInt);
    }

    public void returnCrypto(View view)
    {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("RESET", reset);
        setResult(1, returnIntent);
        finish();
    }

    public void switchCopy(View view)
    {
        edit.putBoolean("autoSave", copySwitch.isChecked());
        edit.apply();
    }

    public void switchShare(View view)
    {
        edit.putBoolean("autoShare", shareSwitch.isChecked());
        edit.apply();
    }

    public void switchRemove(View view)
    {
        edit.putBoolean("autoRemove", shareSwitch.isChecked());
        edit.apply();
    }

    public void openAbout(View view)
    {
        Intent launchIntent = new Intent(this, AboutActivity.class);
        startActivityForResult(launchIntent, 2);
    }

    public void applySettings(View view)
    {
        int theme = themeSpinner.getSelectedItemPosition();
        int lang = langSpinner.getSelectedItemPosition();
        int mode = modeSpinner.getSelectedItemPosition();

        if(lang != preferences.getInt("lang", 0))
        {
            switch(lang)
            {
                case 0:
                    setLocale("pl");
                    break;
                default:
                    setLocale("en");
            }
            reset = true;
        }

        edit.putInt("theme", theme);
        edit.putInt("lang", lang);
        edit.putInt("mode", mode);
        edit.apply();

        returnCrypto(view);
    }

    public void setLocale(String language)
    {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }
}

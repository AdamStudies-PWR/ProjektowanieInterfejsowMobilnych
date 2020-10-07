package com.amazeum.kryptor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

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

    boolean create = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(PREFERENCE_FILE_KEY, MODE_PRIVATE);
        edit = preferences.edit();

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
        modeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                edit.putInt("mode", modeSpinner.getSelectedItemPosition());
                edit.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) { }

        });

        langSpinner = (Spinner) findViewById(R.id.langBox);
        langSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                edit.putInt("lang", langSpinner.getSelectedItemPosition());
                edit.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) { }

        });

        themeSpinner = (Spinner) findViewById(R.id.themeBox);
        themeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                EditText text;
                Button apply;
                apply = findViewById(R.id.confirmButton);
                int temp = themeSpinner.getSelectedItemPosition();
                edit.putInt("theme", temp);
                edit.apply();

                /*if(temp == 3)
                {
                    text = (EditText) findViewById(R.id.mainColor);
                    text.setEnabled(true);
                    text = (EditText) findViewById(R.id.secondaryColor);
                    text.setEnabled(true);
                    text = (EditText) findViewById(R.id.accentColor);
                    text.setEnabled(true);
                    text = (EditText) findViewById(R.id.textColor);
                    text.setEnabled(true);
                    text = (EditText) findViewById(R.id.buttonColor);
                    text.setEnabled(true);
                    apply.setEnabled(true);
                }
                else
                {
                    text = (EditText) findViewById(R.id.mainColor);
                    text.setEnabled(false);
                    text = (EditText) findViewById(R.id.secondaryColor);
                    text.setEnabled(false);
                    text = (EditText) findViewById(R.id.accentColor);
                    text.setEnabled(false);
                    text = (EditText) findViewById(R.id.textColor);
                    text.setEnabled(false);
                    text = (EditText) findViewById(R.id.buttonColor);
                    text.setEnabled(false);
                    apply.setEnabled(false);
                }*/

                Context context = getApplicationContext();

                Toast toast = Toast.makeText(context, R.string.restartString, Toast.LENGTH_SHORT);
                if(!create) toast.show();
                create = false;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) { }

        });

        EditText settings;

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

        settings = (EditText) findViewById(R.id.mainColor);
        settings.setText(R.color.colorPrimary);

        settings = (EditText) findViewById(R.id.secondaryColor);
        settings.setText(R.color.colorPrimaryDark);

        settings = (EditText) findViewById(R.id.accentColor);
        settings.setText(R.color.colorAccent);

        settings = (EditText) findViewById(R.id.textColor);
        settings.setText(R.color.textColor);

        settings = (EditText) findViewById(R.id.buttonColor);
        settings.setText(R.color.buttonText);
    }

    public void returnCrypto(View view)
    {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
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

}

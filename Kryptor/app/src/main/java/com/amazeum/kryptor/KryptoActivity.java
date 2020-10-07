package com.amazeum.kryptor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class KryptoActivity extends AppCompatActivity
{
    private final String PREFERENCE_FILE_KEY = "kryptoSettings";
    SharedPreferences preferences;
    SharedPreferences.Editor edit;

    Converter converter;

    boolean autoShare = false;
    boolean autoCopy = false;
    boolean autoRemove = false;
    boolean encryption = true;

    ClipboardManager clipboard;
    ClipData clip;

    Switch modeSwitch;

    EditText outText;
    EditText inText;

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

        setContentView(R.layout.activity_krypto);

        converter = new Converter();

        modeSwitch = (Switch) findViewById(R.id.modeSiwtch);

        outText = (EditText) findViewById(R.id.outText);
        inText = (EditText) findViewById(R.id.inText);

        if(preferences.getBoolean("firstTime", false)) firstTime();
        else
        {
            if(preferences.getInt("mode", 0) == 0)
            {
                modeSwitch.setText(R.string.encryption_mode);
                modeSwitch.setChecked(false);
                encryption = true;
            }
            else
            {
                modeSwitch.setText(R.string.decryption_mode);
                modeSwitch.setChecked(true);
                encryption = false;
            }
            autoRemove = preferences.getBoolean("autoRemove", false);
            autoCopy = preferences.getBoolean("autoSave", false);
            autoShare = preferences.getBoolean("autoShare", false);
        }

        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public void firstTime()
    {
        edit.putBoolean("firstTime", true);
        edit.putBoolean("autoSave", false);
        edit.putBoolean("autoShare", false);
        edit.putBoolean("autoRemove", true);
        edit.putInt("mode", 0);
        edit.putInt("lang", 0);
        edit.putInt("theme", 0);

        edit.apply();
    }

    public void openSettings(View view)
    {
        Intent launchIntent = new Intent(this, SettingsActivity.class);
        startActivityForResult(launchIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1)
        {
            if (resultCode == Activity.RESULT_CANCELED)
            {
                autoRemove = preferences.getBoolean("autoRemove", false);
                autoCopy = preferences.getBoolean("autoSave", false);
                autoShare = preferences.getBoolean("autoShare", false);
            }
        }
    }

    public void switchMode(View view)
    {
        if(modeSwitch.isChecked())
        {
            modeSwitch.setText(R.string.decryption_mode);
            encryption = false;
        }
        else
        {
            modeSwitch.setText(R.string.encryption_mode);
            encryption = true;
        }
    }

    public void buttonCopy(View view) {copyFunction();}

    private void copyFunction()
    {
        String temp = outText.getText().toString();
        if(!temp.equals(""))
        {
            Context context = getApplicationContext();
            clip = ClipData.newPlainText("Result", temp);

            clipboard.setPrimaryClip(clip);

            Toast toast = Toast.makeText(context, R.string.copyString, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void buttonShare(View view) {shareFunction();}

    private void shareFunction()
    {
        String temp = outText.getText().toString();
        if(!temp.equals(""))
        {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, temp);
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        }
    }

    public void translate(View view)
    {
        if(encryption) outText.setText(converter.encryption(inText.getText().toString()));
        else outText.setText(converter.decryption(inText.getText().toString()));

        if(autoShare) shareFunction();
        if(autoCopy) copyFunction();
        if(autoRemove) inText.setText("");
    }

}

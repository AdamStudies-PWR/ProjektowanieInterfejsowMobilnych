package com.amazeum.kryptor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Converter converter = new Converter();

        TextView kryptoVersion = (TextView) findViewById(R.id.versionInfoLabel);
        kryptoVersion.setText(converter.getVersion());

        Context context = getApplicationContext();
        PackageManager manager = context.getPackageManager();
        PackageInfo info = null;
        try
        {
            info = manager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException error)
        {
            error.printStackTrace();
        }

        TextView appVersion = (TextView) findViewById(R.id.appDataLabel);
        appVersion.setText(info.versionName);
    }

    public void returnSettings(View view)
    {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
    }
}
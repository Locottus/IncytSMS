package herlich.gonzalez.incytsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

//http://www.gadgetsaint.com/android/read-sms-messages-android/
//HERLICH STEVEN GONZALEZ ZAMBRANO 2020


public class MainActivity extends AppCompatActivity {
    EditText u;
    EditText n;
    SavePrefs sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate()");
        sp = new SavePrefs(getApplicationContext());
        u = findViewById(R.id.urlText);
        n = findViewById(R.id.tiempoText);

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart()");
        loadSettings();
        checkAccess();
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop()");
    }


    public void startJobService(View view) {
        System.out.print("intenting to start job service");
        Intent i = new Intent(this, MyJobIntentService.class);
        //i.putExtra("tiempo", 25);
        MyJobIntentService.enqueuedWork(this, i);
    }

    private void loadSettings(){
        SettingData sd = sp.getPreferences();
        u.setText(sd.getUrlPost());
        n.setText(String.valueOf( sd.getDelayPeriod()));
    }


    public void saveSettings(View view) {
        if (u.getText().length() > 0 && n.getText().length() > 0) {
            SettingData sd = new SettingData(u.getText().toString(), Integer.valueOf(n.getText().toString()));
            sp.saveSettings(sd);
            Toast.makeText(getApplicationContext(),"Datos salvados correctamente.",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Hay un campo invalido, por favor, revisar.",Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkAccess() {
        boolean access = false;

        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {
                android.Manifest.permission.INTERNET,
                android.Manifest.permission.VIBRATE,
                Manifest.permission.READ_SMS,
                Manifest.permission.SEND_SMS,
                Manifest.permission.BROADCAST_SMS
        };

        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
            access = true;
        }
        return access;
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }


}

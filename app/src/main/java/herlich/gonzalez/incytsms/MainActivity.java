package herlich.gonzalez.incytsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;

//http://www.gadgetsaint.com/android/read-sms-messages-android/
//HERLICH STEVEN GONZALEZ ZAMBRANO 2020


public class MainActivity extends AppCompatActivity {

    //esta es la url del servicio web donde se envian los mensajitos

    String urlPost = "https://arcgis-web.url.edu.gt/incyt/api/sms/postSMS";
    SMSUtils msgSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAccess();
        System.out.println("iniciando MAIN");


        msgSMS = new SMSUtils(getApplicationContext());
        ArrayList<SMS> msgs = msgSMS.readSMS();
        JSONUtils jUtil = new JSONUtils(getApplicationContext(), urlPost);
        System.out.println(msgs.size());
        for (int i = 0; i < msgs.size(); i++) {
            jUtil.postMessage(msgs.get(i));
            //System.out.println(msgs.get(i));
        }
        //TODO delete sms from mobil

    }

    private void checkAccess() {
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
        }
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

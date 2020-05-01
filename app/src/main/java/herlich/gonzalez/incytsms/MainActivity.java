package herlich.gonzalez.incytsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

//http://www.gadgetsaint.com/android/read-sms-messages-android/
//HERLICH STEVEN GONZALEZ ZAMBRANO 2020

public class MainActivity extends AppCompatActivity {


    SMSUtils msgSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAccess();
        System.out.println("iniciando MAIN");

        msgSMS = new SMSUtils(getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null));
        msgSMS.readSMS();
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

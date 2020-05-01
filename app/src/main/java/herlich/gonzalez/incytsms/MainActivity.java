package herlich.gonzalez.incytsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.OnNmeaMessageListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.telephony.SmsMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//http://www.gadgetsaint.com/android/read-sms-messages-android/
//HERLICH STEVEN GONZALEZ ZAMBRANO 2020
public class MainActivity extends AppCompatActivity {

    //public static final String OTP_REGEX = "[0-9]{1,6}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAccess();
        System.out.println("iniciando MAIN");
        sms();
    }

    private void sms(){
        System.out.println("***********************************************LEYENDO SMS********************************************");
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
        if (cursor.moveToFirst()) { // must check the result to prevent exception
            do {
                String msgData = "";
                for(int idx=0;idx<cursor.getColumnCount();idx++)
                {
                    msgData += " " + cursor.getColumnName(idx) + ":" + cursor.getString(idx);
                    //System.out.println(" " + cursor.getColumnName(idx) + ":" + cursor.getString(idx));
                    //System.out.println("******************END OF LINE**************************");

                    //
                }
                // use msgData
                Toast.makeText(MainActivity.this,msgData.toString(),Toast.LENGTH_LONG);
                System.out.println(msgData);
            } while (cursor.moveToNext());
        } else {
            // empty box, no SMS
        }
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

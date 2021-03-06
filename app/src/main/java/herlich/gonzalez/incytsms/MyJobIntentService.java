package herlich.gonzalez.incytsms;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.JobIntentService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MyJobIntentService extends JobIntentService {


    private static final String TAG = MyJobIntentService.class.getSimpleName();

    public static void enqueuedWork(Context context, Intent intent) {
        enqueueWork(context, MyJobIntentService.class, 1179, intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate myJobIntentService Thread Name: " + Thread.currentThread().getName());
        Toast.makeText(this, "task Execution starts ", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onHandleWork(Intent intent) {
        thread();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy myJobIntentService Thread Name: " + Thread.currentThread().getName());
        //Toast.makeText(this, "task Execution ends ", Toast.LENGTH_LONG).show();
    }

    private void thread() {
        Date currentTime;
        SettingData sd;
        SavePrefs sp = new SavePrefs(this);
        while(true) {
            sd = loadSettings();//get settings on the fly
            try {
                Thread.sleep(60000 * sd.getDelayPeriod());//TODO MODIFICAR EL CALCULO
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            backgroundToast(getApplicationContext()," SMS INCYT BACKGROUND RUNNING");
            SMSUtils msgSMS  = new SMSUtils(getApplicationContext());
            ArrayList<SMS> msgs = msgSMS.readSMS();
            JSONUtils jUtil = new JSONUtils(getApplicationContext(), sd.getUrlPost());
            System.out.println(msgs.size());
            for (int i = 0; i < msgs.size(); i++) {
                System.out.println(msgs.get(i).get_id() + " " + msgs.get(i).getBody());
                jUtil.postMessage(msgs.get(i));//aqui envia sms por sms
            }
            currentTime = Calendar.getInstance().getTime();
            sp.setLastRun(currentTime.toString());
        }
    }

    private SettingData loadSettings(){
        SavePrefs sp = new SavePrefs(getApplicationContext());
        return sp.getPreferences();
    }


    public void backgroundToast(final Context context, final String msg) {
            if (context != null && msg != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                    }
                });
            }
    }

}

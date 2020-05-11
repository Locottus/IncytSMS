package herlich.gonzalez.incytsms;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;


import androidx.core.app.JobIntentService;

import java.util.ArrayList;

public class MyJobIntentService extends JobIntentService {

    //TODO LOAD SETTINGS FROM SAVE PREFERENCES
    String urlPost = "https://arcgis-web.url.edu.gt/incyt/api/sms/postSMS";
    SMSUtils msgSMS;
    private static final String TAG = MyJobIntentService.class.getSimpleName();

    public static void enqueuedWork(Context context, Intent intent) {
        enqueueWork(context, MyJobIntentService.class, 1137, intent);
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
        Toast.makeText(this, "task Execution ends ", Toast.LENGTH_LONG).show();
    }

    private void thread() {

        while(true) {
            backgroundToast(getApplicationContext()," SMS INCYT BACKGROUND MESSAGE RUNNING");
            try {
                Thread.sleep(60000);//TODO HACERLO DINAMICO
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            msgSMS = new SMSUtils(getApplicationContext());
            ArrayList<SMS> msgs = msgSMS.readSMS();
            JSONUtils jUtil = new JSONUtils(getApplicationContext(), urlPost);
            System.out.println(msgs.size());
            for (int i = 0; i < msgs.size(); i++) {
                jUtil.postMessage(msgs.get(i));//aqui envia sms por sms

            }
            //TODO delete sms from mobil
        }
    }

/*
    private void threadLoop() {
        try {
            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        backgroundToast(getApplicationContext()," SMS INCYT BACKGROUND MESSAGE RUNNING");
                        System.out.println("TODO SOMETHING AWESOME HERE INSIDE THE JOBINTENT");
                        try {
                            Thread.sleep(25000);//30 minuten Dienst
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            msgSMS = new SMSUtils(getApplicationContext());
                            ArrayList<SMS> msgs = msgSMS.readSMS();
                            JSONUtils jUtil = new JSONUtils(getApplicationContext(), urlPost);
                            System.out.println(msgs.size());

                            for (int i = 0; i < msgs.size(); i++) {
                                jUtil.postMessage(msgs.get(i));//aqui envia sms por sms
                            }
                            //TODO delete sms from mobil

                        } catch (Exception ex) {
                            System.out.println("HUBO UN ERROR EN LOS SMS " + ex.getMessage());
                        }

                    }
                }
            });
            t1.start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
*/

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

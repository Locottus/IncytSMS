package herlich.gonzalez.incytsms;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


import androidx.core.app.JobIntentService;

import java.util.ArrayList;

public class MyJobIntentService extends JobIntentService {

    String urlPost = "https://arcgis-web.url.edu.gt/incyt/api/sms/postSMS";
    SMSUtils msgSMS;
    private static final String TAG = MyJobIntentService.class.getSimpleName();

    public static void enqueuedWork(Context context, Intent intent){
        enqueueWork(context,MyJobIntentService.class,1137,intent);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate myJobIntentService Thread Name: " + Thread.currentThread().getName());
        Toast.makeText(this,"task Execution starts ",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onHandleWork( Intent intent) {

        System.out.println("TODO SOMETHING AWESOME HERE INSIDE THE JOBINTENT");
        msgSMS = new SMSUtils(getApplicationContext());
        ArrayList<SMS> msgs = msgSMS.readSMS();
        JSONUtils jUtil = new JSONUtils(getApplicationContext(), urlPost);
        System.out.println(msgs.size());
        for (int i = 0; i < msgs.size(); i++) {
            jUtil.postMessage(msgs.get(i));//aqui envia sms por sms
            //System.out.println(msgs.get(i));
        }
        //TODO delete sms from mobil
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy myJobIntentService Thread Name: " + Thread.currentThread().getName());
        Toast.makeText(this,"task Execution ends ",Toast.LENGTH_LONG).show();

    }

}

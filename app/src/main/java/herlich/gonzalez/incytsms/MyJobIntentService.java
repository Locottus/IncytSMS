package herlich.gonzalez.incytsms;

import android.content.Intent;

import androidx.annotation.NonNull;

public class MyJobIntentService extends androidx.core.app.JobIntentService {

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        System.out.println("TODO SOMETHING AWESOME HERE");
    }


}

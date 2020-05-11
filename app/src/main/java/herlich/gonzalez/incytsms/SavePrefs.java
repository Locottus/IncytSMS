package herlich.gonzalez.incytsms;

import android.content.Context;
import android.content.SharedPreferences;

public class SavePrefs {
    private Context context;
    private SettingData d;
    private static String URLPOST = "URLPOST";
    private static String TIMEDELAY = "TIMEDELAY";

    public SavePrefs(Context context) {
        this.context = context;
    }

    public SettingData getPreferences() {
        SharedPreferences prefs = context.getSharedPreferences(d.getStringSettingsID(), context.MODE_PRIVATE);
        String urlPost = prefs.getString(URLPOST, "https://arcgis-web.url.edu.gt/incyt/api/sms/postSMS");
        int timeDelay = prefs.getInt(TIMEDELAY, 60);//UNA HORA DEFAULT VALUE
        return new SettingData(urlPost, timeDelay);
    }


    public void saveSettings(SettingData d) {
        SharedPreferences.Editor editor = context.getSharedPreferences(d.getStringSettingsID(), context.MODE_PRIVATE).edit();
        editor.putString(URLPOST, d.getUrlPost());
        editor.putInt(TIMEDELAY, d.getDelayPeriod());
        editor.apply();
        editor.commit();
    }

}


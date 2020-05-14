package herlich.gonzalez.incytsms;

import android.content.Context;
import android.content.SharedPreferences;

public class SavePrefs {
    private Context context;
    private SettingData d;
    private static String URLPOST = "URLPOST";
    private static String TIMEDELAY = "TIMEDELAY";
    private static String LASTSMS = "LASTSMS";
    private static String LASTRUN = "LASTRUN";

    public SavePrefs(Context context) {
        this.context = context;
    }

    public SettingData getPreferences() {
        SharedPreferences prefs = context.getSharedPreferences(d.getStringSettingsID(), context.MODE_PRIVATE);
        String urlPost = prefs.getString(URLPOST, "https://arcgis-web.url.edu.gt/incyt/api/sms/postSMS");
        int timeDelay = prefs.getInt(TIMEDELAY, 10);//UNA HORA DEFAULT VALUE
        return new SettingData(urlPost, timeDelay);
    }


    public void saveSettings(SettingData d) {
        SharedPreferences.Editor editor = context.getSharedPreferences(d.getStringSettingsID(), context.MODE_PRIVATE).edit();
        editor.putString(URLPOST, d.getUrlPost());
        editor.putInt(TIMEDELAY, d.getDelayPeriod());
        editor.apply();
        editor.commit();
    }

    public int getLastSMS(){
        SharedPreferences prefs = context.getSharedPreferences(d.getStringSettingsID(), context.MODE_PRIVATE);
        return prefs.getInt(LASTSMS, 0);//DEVUELVE EL ULTIMO SMS ENVIADO
    }

    public void setLastSMS(int id){
        System.out.println("LAST SMS SENT: " + id);
        SharedPreferences.Editor editor = context.getSharedPreferences(d.getStringSettingsID(), context.MODE_PRIVATE).edit();
        editor.putInt(LASTSMS, id);
        editor.apply();
        editor.commit();
    }

    public void setLastRun(String date){
        System.out.println("LAST SMS RUN: " + date);
        SharedPreferences.Editor editor = context.getSharedPreferences(d.getStringSettingsID(), context.MODE_PRIVATE).edit();
        editor.putString(LASTRUN, date);
        editor.apply();
        editor.commit();
    }

    public String getLastRun(){
        SharedPreferences prefs = context.getSharedPreferences(d.getStringSettingsID(), context.MODE_PRIVATE);
        return prefs.getString(LASTRUN, "N/A");//DEVUELVE EL ULTIMO SMS ENVIADO
    }

}


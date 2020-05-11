package herlich.gonzalez.incytsms;

public class SettingData {
    private static String stringSettingsID = "incytSavePreferencesSMS_app";
    private String urlPost;
    private int delayPeriod;

    public SettingData(String urlPost, int delayPeriod) {
        this.urlPost = urlPost;
        this.delayPeriod = delayPeriod;
    }


    public static String getStringSettingsID() {
        return stringSettingsID;
    }

    public static void setStringSettingsID(String stringSettingsID) {
        SettingData.stringSettingsID = stringSettingsID;
    }

    public String getUrlPost() {
        return urlPost;
    }

    public void setUrlPost(String urlPost) {
        this.urlPost = urlPost;
    }

    public int getDelayPeriod() {
        return delayPeriod;
    }

    public void setDelayPeriod(int delayPeriod) {
        this.delayPeriod = delayPeriod;
    }
}

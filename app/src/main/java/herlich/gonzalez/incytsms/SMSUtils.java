package herlich.gonzalez.incytsms;

import android.database.Cursor;
import android.net.DnsResolver;


public class SMSUtils {
    Cursor cursor;
    public SMSUtils(Cursor c) {
        this.cursor = c;
    }


    public void readSMS(){
        System.out.println("***********************************************LEYENDO SMS********************************************");
        //Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
        if (cursor.moveToFirst()) { // must check the result to prevent exception
            do {
                String msgData = "";
                for(int idx=0;idx<cursor.getColumnCount();idx++)
                {
                    //TODO generate a json array with this info
                    msgData += " " + cursor.getColumnName(idx) + ":" + cursor.getString(idx);
                    //System.out.println(" " + cursor.getColumnName(idx) + ":" + cursor.getString(idx));
                    //System.out.println("******************END OF LINE**************************");
                    //
                }
                // use msgData
                //Toast.makeText(MainActivity.this,msgData.toString(),Toast.LENGTH_LONG);
                System.out.println(msgData);
            } while (cursor.moveToNext());
        } else {
            // empty box, no SMS
        }
    }


}

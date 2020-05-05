package herlich.gonzalez.incytsms;

import android.content.Context;
import android.database.Cursor;
import android.net.DnsResolver;
import android.net.Uri;

import java.util.ArrayList;


public class SMSUtils {
    private Cursor cursor;
    private Context context;
    private String uri = "content://sms/inbox/";

    public SMSUtils(Context context) {
        this.context = context;
        this.cursor = context.getContentResolver().query(Uri.parse(uri), null, null, null, null);
    }

    public ArrayList<SMS> readSMS() {
        ArrayList<SMS> msgs = new ArrayList<>();
        System.out.println("***********************************************LEYENDO SMS********************************************");
        //Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
        if (cursor.moveToFirst()) { // must check the result to prevent exception
            do {
                SMS msg = new SMS();
                //System.out.println("******************START of NEW SMS**************************");

                for (int idx = 0; idx < cursor.getColumnCount(); idx++) {
                    if ("_id".equals(cursor.getColumnName(idx)))
                        msg.set_id(cursor.getString(idx));
                    if ("thread_id".equals(cursor.getColumnName(idx)))
                        msg.setThread_id(cursor.getString(idx));
                    if ("address".equals(cursor.getColumnName(idx)))
                        msg.setAddress(cursor.getString(idx));
                    if ("person".equals(cursor.getColumnName(idx)))
                        msg.setPerson(cursor.getString(idx));
                    if ("date".equals(cursor.getColumnName(idx)))
                        msg.setDate(cursor.getString(idx));
                    if ("date_sent".equals(cursor.getColumnName(idx)))
                        msg.setDate_sent(cursor.getString(idx));
                    if ("protocol".equals(cursor.getColumnName(idx)))
                        msg.setProtocol(cursor.getString(idx));
                    if ("read".equals(cursor.getColumnName(idx)))
                        msg.setRead(cursor.getString(idx));
                    if ("status".equals(cursor.getColumnName(idx)))
                        msg.setStatus(cursor.getString(idx));
                    if ("type".equals(cursor.getColumnName(idx)))
                        msg.setType(cursor.getString(idx));
                    if ("reply_path_present".equals(cursor.getColumnName(idx)))
                        msg.setReply_path_present(cursor.getString(idx));
                    if ("subject".equals(cursor.getColumnName(idx)))
                        msg.setSubject(cursor.getString(idx));
                    if ("body".equals(cursor.getColumnName(idx)))
                        msg.setBody(cursor.getString(idx));
                    if ("service_center".equals(cursor.getColumnName(idx)))
                        msg.setService_center(cursor.getString(idx));
                    if ("locked".equals(cursor.getColumnName(idx)))
                        msg.setLocked(cursor.getString(idx));
                    if ("sub_id".equals(cursor.getColumnName(idx)))
                        msg.setSub_id(cursor.getString(idx));
                    if ("callback_number".equals(cursor.getColumnName(idx)))
                        msg.setCallback_number(cursor.getString(idx));
                    if ("error_code".equals(cursor.getColumnName(idx)))
                        msg.setError_code(cursor.getString(idx));

                }

                msgs.add(msg);

            } while (cursor.moveToNext());
        } else {
            // empty box, no SMS
            System.out.println("NO SMS TO READ");
        }
        return msgs;
    }


    //https://stackoverflow.com/questions/8614211/deleting-android-sms-programmatically

    public void deleteSMS(String message, String number) {
        try {
            //mLogger.logInfo("Deleting SMS from inbox");
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    long id = cursor.getLong(0);
                    long threadId = cursor.getLong(1);
                    String address = cursor.getString(2);
                    String body = cursor.getString(5);

                    if (message.equals(body) && address.equals(number)) {
                        //mLogger.logInfo("Deleting SMS with id: " + threadId);
                        context.getContentResolver().delete(
                                Uri.parse(uri + id), null, null);
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            //mLogger.logError("Could not delete SMS from inbox: " + e.getMessage());
            System.out.println("ERROR " + e.getMessage());
        }
    }


    public void deleteAllSMS() {
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    long id = cursor.getLong(0);
                    context.getContentResolver().delete(
                            Uri.parse(uri + id), null, null);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

}

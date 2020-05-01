package herlich.gonzalez.incytsms;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
    //https://www.itsalif.info/content/android-volley-tutorial-http-get-post-put
    /*private void postMessage(final ChatMessage cm) {

        String url2 = url + "postMessages";
        JSONObject postparams = new JSONObject();
        try {
            postparams.put("type", cm.getType());
            postparams.put("message", cm.getMessage());
            postparams.put("from", cm.getFrom());
            postparams.put("to", cm.getTo());
            postparams.put("dateTime", cm.getDateTime());
            postparams.put("msgType", cm.getMsgType());
            postparams.put("id", cm.getId());

            System.out.println("********************************************");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url2, postparams,
                new Response.Listener() {

                    @Override
                    public void onResponse(Object response) {
                        System.out.println("******************************************** YAY");
                        System.out.println(response.toString());
                        Gson gson = new Gson();
                        MsgAnswer answer = gson.fromJson(response.toString(), MsgAnswer.class);
                        if (answer.getMsg().equals("ok"))
                            dbo.updateMsgStatus(cm);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Failure Callback
                        System.out.println("********************************************BOOO!");
                        System.out.println("error at doing it!");
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonObjReq);
    }

    private void getMessages() {
        //final VolleyResponseListener listener = null;
        System.out.println("*********************CHECK MESSAGES*******************************");
        final int[] notification = {NotificationUtils.getReminderNotificationId()};
        String url2;
        url2 = url + "getMessages?id=" + this.id;
        System.out.println(url2);
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                        Gson gson = new Gson();
                        String from = "";
                        String msg = "";
                        ChatMessage[] cma = gson.fromJson(response, ChatMessage[].class);
                        for (int i = 0; i < cma.length; i++) {
                            System.out.println(cma[i].getMessage());
                            dbo.insertMessage(cma[i], 1, ChatMessage.MESSAGE);
                            dbo.checkIfNewUser(cma[i]);
                            from = cma[i].getFrom();
                            msg = cma[i].getMessage();
                        }
                        if (cma.length > 0) {
                            notification[0]++;
                            NotificationUtils.setReminderNotificationId(notification[0]);
                            NotificationUtils.remindUserBecauseCharging(context, from + " " + msg);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("didn't work!");
                System.out.println(error.toString());
            }
        }) {
            @Override
            protected void deliverResponse(String response) {
                super.deliverResponse(response);
            }
        };
        queue.add(stringRequest);
    } */
}

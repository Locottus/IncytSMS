package herlich.gonzalez.incytsms;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;


public class JSONUtils {

    private int   MY_SOCKET_TIMEOUT_MS = 10000;
    private Context context;
    private String url;

    public JSONUtils(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    //https://www.itsalif.info/content/android-volley-tutorial-http-get-post-put
    public void postMessage(final SMS msg) {

        JSONObject postparams = new JSONObject();
        try {
            postparams.put("_id", msg.get_id());
            postparams.put("thread_id", msg.getThread_id());
            postparams.put("address", msg.getAddress());
            postparams.put("person", msg.getPerson());
            postparams.put("date", msg.getDate());
            postparams.put("date_sent", msg.getDate_sent());
            postparams.put("protocol", msg.getProtocol());
            postparams.put("read", msg.getRead());
            postparams.put("status", msg.getStatus());
            postparams.put("type", msg.getType());
            postparams.put("reply_path_present", msg.getReply_path_present());
            postparams.put("subject", msg.getSubject());
            postparams.put("body", msg.getBody());
            postparams.put("service_center", msg.getService_center());
            postparams.put("locked", msg.getLocked());
            postparams.put("sub_id", msg.getSub_id());
            postparams.put("callback_number", msg.getCallback_number());
            postparams.put("error_code", msg.getError_code());

            //System.out.println("********************************************");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, postparams,
                new Response.Listener() {

                    @Override
                    public void onResponse(Object response) {
                        //System.out.println("******************************************** YAY");
                        System.out.println(response.toString());
                        Gson gson = new Gson();
                        MsgAnswer answer = gson.fromJson(response.toString(), MsgAnswer.class);
                        //System.out.println(answer.getId() + " " + answer.getMsg());
                        //System.out.println(response);
                        //if (answer.getMsg().equals("ok"))
                        //    dbo.updateMsgStatus(cm);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Failure Callback
                        //System.out.println("********************************************BOOO! error enviando json");
                        System.out.println(error);
                    }
                });

        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonObjReq);
    }

}

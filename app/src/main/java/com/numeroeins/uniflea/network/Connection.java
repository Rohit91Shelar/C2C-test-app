package com.numeroeins.uniflea.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;
import com.numeroeins.uniflea.utility.AppPreferences;
import com.numeroeins.uniflea.utility.Utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Connection {

    public static final String ACCESS_TOKEN = "access-token";

    private Context context;
    private Method method;
    private String page;
    HashMap<String, List<String>> params = new HashMap<String, List<String>>();

    public enum Method {
        GET,
        POST,
        PUT,
        DELETE
    }

    public Connection setMethod(Method method) {
        this.method = method;
        return this;
    }

    public Connection addParameter(String key, String value) {
        this.params.put(key, Collections.singletonList(value));
        return this;
    }

    public static Connection with(Context context, String page) {
        Connection connection = new Connection();
        connection.context = context;
        connection.method = Method.POST;
        connection.page = page;
        return connection;
    }

    private String handleError(Response<?> result) {
        String error = null;
        if (result.getHeaders().code() == 404) {
            error = "Method does not exist";
        } else if (result.getHeaders().code() == 401) {
            //error = result.getResult().get("description").toString();
            error = "Unauthorized";
        } else if (result.getHeaders().code() != 200) {
            error = "Error occured";
        }
        return error;
    }

    public void performNetworkCall(final ResponseCallback callback, final boolean showProgress) {
        final ProgressDialog dialog;
        if (showProgress) {
            dialog = new ProgressDialog(context);
            dialog.setMessage("Please wait...");
            dialog.setIndeterminate(false);
            dialog.setCancelable(false);
            dialog.show();
        } else {
            dialog = null;
        }


        Log.e("PARAMS", params.toString());
        Ion.with(context)
                .load(method.toString(), Utils.getUrlForPage(this.page))
                .setBodyParameters(params)
                .asJsonObject()
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonObject>>() {
                    @Override
                    public void onCompleted(Exception e, Response<JsonObject> result) {
                        if (showProgress) dialog.dismiss();

                        String error = null;
                        if (e != null) {
                            error = "Exception occured: " + e.getMessage();
                        } else {
                            error = handleError(result);
                        }

                        if (error != null) {
                            callback.onFailure(error);
                        } else {
                            callback.onSuccess(result.getResult());
                        }
                    }
                });
    }

    public void performNetworkCallForArray(final ArrayResponseCallback callback, final boolean showProgress) {
        final ProgressDialog dialog;
        if (showProgress) {
            dialog = new ProgressDialog(context);
            dialog.setMessage("Please wait...");
            dialog.setIndeterminate(false);
            dialog.setCancelable(false);
            dialog.show();
        } else {
            dialog = null;
        }

        Log.e("PARAMS", params.toString());
        Ion.with(context)
                .load(method.toString(), Utils.getUrlForPage(this.page))
                .setBodyParameters(params)
                .asJsonArray()
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonArray>>() {
                    @Override
                    public void onCompleted(Exception e, Response<JsonArray> result) {
                        if (showProgress) dialog.dismiss();

                        String error = null;
                        if (e != null) {
                            error = "Exception occured: " + e.getMessage();
                        } else {
                            error = handleError(result);
                        }

                        if (error != null) {
                            callback.onFailure(error);
                        } else {
                            callback.onSuccess(result.getResult());
                        }
                    }
                });
    }

}

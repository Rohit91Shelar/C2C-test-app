package com.numeroeins.uniflea.network;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public interface ResponseCallback {
    void onSuccess(JsonObject jsonObject);
    void onFailure(String error);
}


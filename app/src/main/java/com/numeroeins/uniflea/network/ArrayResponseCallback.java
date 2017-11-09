package com.numeroeins.uniflea.network;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public interface ArrayResponseCallback {
    void onSuccess(JsonArray jsonObject);
    void onFailure(String error);
}

package com.example.admincollegeapp.notification.api;

import static com.example.admincollegeapp.notification.Constants.CONTENT_TYPE;
import static com.example.admincollegeapp.notification.Constants.SERVER_KEY;

import android.telecom.Call;

import com.example.admincollegeapp.notification.model.PushNotification;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers({"Authorization: key="+SERVER_KEY, "Content-Type:"+CONTENT_TYPE})
    @POST("fcm/send")
    retrofit2.Call<PushNotification> sendNotification(@Body PushNotification notification);
}

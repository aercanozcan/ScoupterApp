package com.apptopus.scoupter;

import org.junit.Before;
import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

abstract public class BaseRestTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    public MockWebServer mockWebServer;

    public Retrofit retrofit;


    public void commonSetUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        retrofit = new Retrofit.Builder()
                .baseUrl(mockWebServer.url("/").toString())//retrofit requires a valid URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void commonTearDown() throws IOException {
        mockWebServer.shutdown();
        mockWebServer = null;
    }

}

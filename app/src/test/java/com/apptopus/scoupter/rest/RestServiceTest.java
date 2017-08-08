package com.apptopus.scoupter.rest;

import com.apptopus.scoupter.BaseRestTest;
import com.apptopus.scoupter.di.component.DaggerTestComponent;
import com.apptopus.scoupter.di.module.TestRestServiceModule;
import com.apptopus.scoupter.model.ScooterData;
import com.apptopus.scoupter.model.ScoupterResponse;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.mockwebserver.MockResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RestServiceTest extends BaseRestTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    String successfulResponse = "{\n" +
            "  \"meta\": {\n" +
            "    \"server_time\": \"2017-08-06T17:08:57.082Z\",\n" +
            "    \"status\": 0,\n" +
            "    \"key\": \"OK\"\n" +
            "  },\n" +
            "  \"data\": {\n" +
            "    \"scooters\": [\n" +
            "      {\n" +
            "        \"id\": \"ffe72af3-eb74-4ae7-8ed0-3f426aaddddd\",\n" +
            "        \"vin\": \"RHMGRSAN0GT1R0194\",\n" +
            "        \"model\": \"Gogoro 1st edition\",\n" +
            "        \"market_id\": \"fb7aadac-bded-4321-9223-e3c30c5e3ba5\",\n" +
            "        \"license_plate\": \"290ERE\",\n" +
            "        \"energy_level\": 89,\n" +
            "        \"distance_to_travel\": 53.4,\n" +
            "        \"location\": {\n" +
            "          \"lng\": 13.382387069023803,\n" +
            "          \"lat\": 52.50461774621666\n" +
            "        }\n" +
            "      }   ]\n" +
            "  }\n" +
            "}";

    @Inject
    RestService restService;


    @Before
    public void setUp() throws IOException {
        commonSetUp();
        DaggerTestComponent.builder()
                .testRestServiceModule(new TestRestServiceModule(retrofit))
                .build().inject(this);
    }

    @Test
    public void resultShouldotNullnorEmpty()  {

        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200).setBody(successfulResponse));
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        restService.getScoupterService().scooters().enqueue(new Callback<ScoupterResponse<ScooterData>>() {
            @Override
            public void onResponse(Call<ScoupterResponse<ScooterData>> call, Response<ScoupterResponse<ScooterData>> response) {
                assertNotNull("Response is null", response.body());
                assertNotNull(response.body().getData().getScooters());
                assertFalse(response.body().getData().getScooters().isEmpty());
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Call<ScoupterResponse<ScooterData>> call, Throwable t) {
                fail();
            }
        });
        try {
            countDownLatch.await(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
    }

    @After
    public void tearDown() throws IOException{
       commonTearDown();
    }

}

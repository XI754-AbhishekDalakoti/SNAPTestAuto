package com.liveperson.ephemerals.examples;

import com.liveperson.ephemerals.WireMockEphemeral;
import com.liveperson.ephemerals.junit.EphemeralResource;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;


public class WireMockEphemeralTest extends EphemeralAbstractTest {

    @Rule
    public EphemeralResource<URL> wireMockResource = new EphemeralResource(
            new WireMockEphemeral.Builder(getKubernetesDeploymentContext())
                    .withStubMapping("{ \"request\": { \"url\": \"/get/this\", \"method\": \"GET\" }, \"response\": { \"status\": 200 } }")
                    .build());

    @Test
    public void test() throws IOException {
        URL url = wireMockResource.get();
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url.toString()+"/get/this");
        HttpResponse response = client.execute(request);
        Assert.assertEquals(200,response.getStatusLine().getStatusCode());
    }
}

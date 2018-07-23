package com.liveperson.ephemerals.examples;

import com.liveperson.ephemerals.SeleniumEphemeral;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class SeleniumParallelEphemeralTest extends EphemeralAbstractTest {

    List<SeleniumEphemeral> seleniumEphemerals = new ArrayList<>();

    @Test
    public void test() throws Exception {

        //Define fixed thread pool with SIZE=10
        ExecutorService executor = Executors.newFixedThreadPool(10);

        //Submit Ephemeral deployment tasks to cluster using thread pool
        List<Future<RemoteWebDriver>> remoteWebDriverFutureList = new ArrayList<>();
        for(int i=0; i< 10; i++) {
            Future<RemoteWebDriver> future = executor.submit(callableTask);
            remoteWebDriverFutureList.add(future);
        }

        //Get result of all tasks
        for (Future<RemoteWebDriver> future : remoteWebDriverFutureList) {

            RemoteWebDriver remoteWebDriver = future.get();

            remoteWebDriver.get("http://yahoo.com");
            Assert.assertNotNull(remoteWebDriver.findElementById("uh-logo"));

            remoteWebDriver.quit();

        }

    }

    @After
    public void teardown() {
        for(SeleniumEphemeral seleniumEphemeral : seleniumEphemerals) {
            seleniumEphemeral.destroy();
        }
    }

    //A callable callableTask for launching browser session on cluster
    Callable<RemoteWebDriver> callableTask = () -> {

        SeleniumEphemeral seleniumEphemeral = new SeleniumEphemeral.Builder(getKubernetesDeploymentContext())
                .withDesiredCapabilities(RandomCapability.randomize()) //randomize between firefox and chrome
                .build();

        seleniumEphemerals.add(seleniumEphemeral);

        return seleniumEphemeral.get();
    };


    public final static class RandomCapability {

        final static Random rand = new Random();

        final static DesiredCapabilities[] desiredCapabilitiesArray = new DesiredCapabilities[]{DesiredCapabilities.firefox(),DesiredCapabilities.chrome()};

        public static DesiredCapabilities randomize() {
            return desiredCapabilitiesArray[rand.nextInt(desiredCapabilitiesArray.length)];
        }

    }



}

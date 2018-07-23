package com.liveperson.ephemerals.deploy;

public interface DeploymentHandler {

    DeploymentEndpoints deploy(Deployment deployment);

    void destroy(Deployment deployment);

}
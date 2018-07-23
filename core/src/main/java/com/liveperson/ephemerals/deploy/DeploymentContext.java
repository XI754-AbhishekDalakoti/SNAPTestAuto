package com.liveperson.ephemerals.deploy;


public class DeploymentContext  {

    private final DeploymentHandler deploymentHandler;

    private final DeploymentConfiguration deploymentConfiguration;

    public DeploymentContext(DeploymentHandler deploymentHandler, DeploymentConfiguration deploymentConfiguration) {
        this.deploymentHandler = deploymentHandler;
        this.deploymentConfiguration = deploymentConfiguration;
    }

    public DeploymentHandler getDeploymentHandler() {
        return deploymentHandler;
    }

    public DeploymentConfiguration getDeploymentConfiguration() {
        return deploymentConfiguration;
    }

}
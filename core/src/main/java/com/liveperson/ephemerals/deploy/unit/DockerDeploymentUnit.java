package com.liveperson.ephemerals.deploy.unit;


public class DockerDeploymentUnit extends ContainerizedDeploymentUnit {

    public DockerDeploymentUnit(Builder builder) {
        super(builder);
    }

    public static class Builder extends ContainerizedDeploymentUnit.Builder {

        public Builder(String name, String image) {
            super(name,image);
        }

        public DockerDeploymentUnit build() {
            return new DockerDeploymentUnit(this);
        }

    }
}
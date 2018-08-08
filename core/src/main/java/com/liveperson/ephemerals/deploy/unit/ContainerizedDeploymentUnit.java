package com.liveperson.ephemerals.deploy.unit;


public class ContainerizedDeploymentUnit extends DeploymentUnit {

    private String image;

    public ContainerizedDeploymentUnit(Builder builder) {
        super(builder);
        this.image = builder.image;
    }

    public String getImage() {
        return image;
    }

    public static class Builder extends DeploymentUnit.Builder {

        private String image;

        public Builder(String name, String image) {
            super(name);
            this.image = image;
        }

        public ContainerizedDeploymentUnit build() {
            return new ContainerizedDeploymentUnit(this);
        }

    }


}
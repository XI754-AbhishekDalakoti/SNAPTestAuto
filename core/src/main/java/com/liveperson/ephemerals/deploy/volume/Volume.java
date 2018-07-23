package com.liveperson.ephemerals.deploy.volume;


public abstract class Volume {

    public abstract static class Builder<T extends Volume> {

        public abstract T build();

    }

}
package com.liveperson.ephemerals.deploy;


public enum DeploymentStatus {

        /**
         * Deployment unit is in progress
         */
         IN_PROGRESS,

         /**
         * Deployment unit has been deployed
         */
        FINISHED,

        /**
         * Deployment unit has not been deployed
         */
        PARTIALLY,

        /**
         * Deployment unit has failed
         */
        FAILED,

        /**
         * Deployment unit status is unknown
         */
        UNKNOWN;

}

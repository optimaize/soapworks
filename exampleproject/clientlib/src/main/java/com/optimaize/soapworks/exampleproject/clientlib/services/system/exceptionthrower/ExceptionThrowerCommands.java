package com.optimaize.soapworks.exampleproject.clientlib.services.system.exceptionthrower;

/**
 * @author Fabian Kessler
 */
public class ExceptionThrowerCommands {

    public static ExceptionThrowerAccessDeniedNoSuchAccount accessDeniedNoSuchAccount() {
        return new ExceptionThrowerAccessDeniedNoSuchAccount();
    }

}

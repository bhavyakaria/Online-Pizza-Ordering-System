package com.bhavyakaria.pizza_system.exceptions;

import com.bhavyakaria.pizza_system.constants.Constants;

public class PizzaStoreException extends BaseException {

    String ERROR_MSG = Constants.CLOSED_FOR_ORDERS;
    int STATUS_CODE = Constants.STATUS_CODE;

    @Override
    public void printException() {
        System.out.printf("Msg: %s\nStatus: %d\n",ERROR_MSG, STATUS_CODE);
    }
}

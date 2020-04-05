package com.bhavyakaria.pizza_system.exceptions;

import com.bhavyakaria.pizza_system.constants.Constants;

public class PizzaOrderException extends BaseException {
    String ERROR_MSG = Constants.ORDER_REJECTED;
    int STATUS_CODE = Constants.STATUS_CODE;

    @Override
    public void printException() {
        System.out.printf("Msg: %s\nStatus: %d\n",ERROR_MSG, STATUS_CODE);
    }
}

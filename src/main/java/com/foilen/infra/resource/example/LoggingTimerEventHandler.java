/*
    Foilen Infra Resource Example
    https://github.com/foilen/foilen-infra-resource-example
    Copyright (c) 2018-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.resource.example;

import com.foilen.infra.plugin.v1.core.context.ChangesContext;
import com.foilen.infra.plugin.v1.core.context.CommonServicesContext;
import com.foilen.infra.plugin.v1.core.context.TimerEventContext;
import com.foilen.infra.plugin.v1.core.eventhandler.TimerEventHandler;
import com.foilen.smalltools.tools.AbstractBasics;

public class LoggingTimerEventHandler extends AbstractBasics implements TimerEventHandler {

    @Override
    public void timerHandler(CommonServicesContext services, ChangesContext changes, TimerEventContext event) {
        logger.info("Event {} triggered", event.getTimerName());
    }

}

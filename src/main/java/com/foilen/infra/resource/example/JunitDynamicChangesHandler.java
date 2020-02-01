/*
    Foilen Infra Resource Example
    https://github.com/foilen/foilen-infra-resource-example
    Copyright (c) 2018-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.resource.example;

import java.util.ArrayList;
import java.util.List;

import com.foilen.infra.plugin.v1.core.context.CommonServicesContext;
import com.foilen.infra.plugin.v1.core.eventhandler.ActionHandler;
import com.foilen.infra.plugin.v1.core.eventhandler.ChangesEventHandler;
import com.foilen.infra.plugin.v1.core.eventhandler.changes.ChangesInTransactionContext;

/**
 * Use this in your tests when you want to define some {@link ChangesEventHandler} dynamically.
 */
public class JunitDynamicChangesHandler implements ChangesEventHandler {

    private static List<ChangesEventHandler> dynamicChangesEventHandlers = new ArrayList<>();

    public static List<ChangesEventHandler> getDynamicChangesEventHandlers() {
        return dynamicChangesEventHandlers;
    }

    public static void setDynamicChangesEventHandlers(List<ChangesEventHandler> dynamicChangesEventHandlers) {
        JunitDynamicChangesHandler.dynamicChangesEventHandlers = dynamicChangesEventHandlers;
    }

    @Override
    public List<ActionHandler> computeActionsToExecute(CommonServicesContext services, ChangesInTransactionContext changesInTransactionContext) {
        List<ActionHandler> actions = new ArrayList<>();
        dynamicChangesEventHandlers.forEach(ceh -> actions.addAll(ceh.computeActionsToExecute(services, changesInTransactionContext)));
        return actions;
    }

}

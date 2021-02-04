/*
    Foilen Infra Resource Example
    https://github.com/foilen/foilen-infra-resource-example
    Copyright (c) 2018-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.resource.example;

import java.util.Arrays;
import java.util.Calendar;

import com.foilen.infra.plugin.v1.core.context.CommonServicesContext;
import com.foilen.infra.plugin.v1.core.context.internal.InternalServicesContext;
import com.foilen.infra.plugin.v1.core.plugin.IPPluginDefinitionProvider;
import com.foilen.infra.plugin.v1.core.plugin.IPPluginDefinitionV1;

/**
 * An example plugin.
 */
public class ExamplePluginDefinitionProvider implements IPPluginDefinitionProvider {

    @Override
    public IPPluginDefinitionV1 getIPPluginDefinition() {

        // Description
        IPPluginDefinitionV1 pluginDefinitionV1 = new IPPluginDefinitionV1("Infra", "Example", "An example of a plugin", "1.0.0");

        pluginDefinitionV1.addCustomResource(Ex1Resource.class, "Exemple 1", //
                Arrays.asList("name"));
        pluginDefinitionV1.addCustomResource(Ex2Resource.class, "Exemple 2", //
                Arrays.asList("id"));
        pluginDefinitionV1.addCustomResource(EmployeeResource.class, "Employee", //
                Arrays.asList("firstName", "lastName"));
        pluginDefinitionV1.addCustomResource(JunitResource.class, "Junit", //
                Arrays.asList(JunitResource.PROPERTY_TEXT, JunitResource.PROPERTY_ENUMERATION, JunitResource.PROPERTY_INTEGER_NUMBER) //
        );
        pluginDefinitionV1.addCustomResource(ConcreteLevel1.class, "Concrete Level 1", //
                Arrays.asList(AbstractParent.PROPERTY_NAME) //
        );
        pluginDefinitionV1.addCustomResource(ConcreteLevel2.class, "Concrete Level 2", //
                Arrays.asList(AbstractParent.PROPERTY_NAME));

        pluginDefinitionV1.addTranslations("/com/foilen/infra/resource/example/messages");

        pluginDefinitionV1.addResourceEditor(new EmployeeResourceRawForm(), "EmployeeResourceRawForm");
        pluginDefinitionV1.addResourceEditor(new EmployeeResourceSimpleForm(), "EmployeeResourceSimpleForm");

        LoggingTimerEventHandler loggingTimerEventHandler = new LoggingTimerEventHandler();
        pluginDefinitionV1.addTimer(loggingTimerEventHandler, "20 seconds timer", Calendar.SECOND, 20);
        pluginDefinitionV1.addTimer(loggingTimerEventHandler, "1 minute timer", Calendar.MINUTE, 1);

        pluginDefinitionV1.addChangesHandler(new JunitDynamicChangesHandler());

        return pluginDefinitionV1;
    }

    @Override
    public void initialize(CommonServicesContext commonServicesContext, InternalServicesContext internalServicesContext) {
    }

}

/*
    Foilen Infra Resource Example
    https://github.com/foilen/foilen-infra-resource-example
    Copyright (c) 2018 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.resource.example;

public class ConcreteLevel2 extends ConcreteLevel1 {

    public static final String PROPERTY_ON_LEVEL_2 = "onLevel2";

    private String onLevel2;

    public ConcreteLevel2() {
    }

    public ConcreteLevel2(String name, String onParent, String onLevel1, String onLevel2) {
        super(name, onParent, onLevel1);
        this.onLevel2 = onLevel2;
    }

    public String getOnLevel2() {
        return onLevel2;
    }

    public void setOnLevel2(String onLevel2) {
        this.onLevel2 = onLevel2;
    }

}

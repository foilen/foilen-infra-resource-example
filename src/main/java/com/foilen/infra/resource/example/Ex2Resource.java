/*
    Foilen Infra Resource Example
    https://github.com/foilen/foilen-infra-resource-example
    Copyright (c) 2018-2020 Foilen (http://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package com.foilen.infra.resource.example;

import com.foilen.infra.plugin.v1.model.resource.AbstractIPResource;
import com.foilen.infra.plugin.v1.model.resource.InfraPluginResourceCategory;

public class Ex2Resource extends AbstractIPResource {

    private Long id;
    private String name;
    private Integer year;

    public Ex2Resource() {
    }

    /**
     * Primary key.
     *
     * @param id
     *            the id
     */
    public Ex2Resource(Long id) {
        this.id = id;
    }

    public Ex2Resource(Long id, String name, Integer year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public InfraPluginResourceCategory getResourceCategory() {
        return InfraPluginResourceCategory.INFRASTRUCTURE;
    }

    @Override
    public String getResourceDescription() {
        return String.valueOf(year);
    }

    @Override
    public String getResourceName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}

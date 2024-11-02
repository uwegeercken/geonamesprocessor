package com.datamelt.geonames;

public enum FeatureClass
{
    A("country, state, region,..."),
    H("stream, lake, ..."),
    L("parks,area, ..."),
    P("city, village,..."),
    R("road, railroad"),
    S("spot, building, farm"),
    T("mountain,hill,rock,..."),
    U("undersea"),
    V("forest,heath,..."),
    UNDEFINED("[undefined]");

    private final String description;

    FeatureClass(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
}

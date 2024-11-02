package com.datamelt.geonames;

import java.util.List;

public class Geoname
{
    private long geonameid;
    private String name;
    private String asciiname;
    private List<String> alternatenames;
    private Position position;
    private FeatureClass featureClass;
    private FeatureCode featureCode;
    private String countryCode;
    private List<String> alternateCountryCodes;
    private String admin1Code;
    private String admin2Code;
    private String admin3Code;
    private String admin4Code;
    private long population;
    private int elevation;
    private int digitalElevationModel;
    private String timezone;
    private String modificationDate;

    public Geoname(long geonameid, String name, String asciiname, List<String> alternatenames, Position position, FeatureClass featureClass, FeatureCode featureCode, String countryCode, List<String> alternateCountryCodes, String admin1Code, String admin2Code, String admin3Code, String admin4Code, long population, int elevation, int digitalElevationModel, String timezone, String modificationDate)
    {
        this.geonameid = geonameid;
        this.name = name;
        this.asciiname = asciiname;
        this.alternatenames = alternatenames;
        this.position = position;
        this.featureClass = featureClass;
        this.featureCode = featureCode;
        this.countryCode = countryCode;
        this.alternateCountryCodes = alternateCountryCodes;
        this.admin1Code = admin1Code;
        this.admin2Code = admin2Code;
        this.admin3Code = admin3Code;
        this.admin4Code = admin4Code;
        this.population = population;
        this.elevation = elevation;
        this.digitalElevationModel = digitalElevationModel;
        this.timezone = timezone;
        this.modificationDate = modificationDate;
    }
}

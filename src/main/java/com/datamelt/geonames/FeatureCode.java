package com.datamelt.geonames;

public class FeatureCode
{
    private String code;
    private String name;
    private String description;
    private FeatureClass featureClass;

    public FeatureCode(String code, String name, String description)
    {
        this.name = name;
        this.description = description;
        parseFeatureCode(code);
    }

    public FeatureCode(String code, String name)
    {
        this(code,name, null);
    }

    private void parseFeatureCode(String code)
    {
        if(!code.equals("null"))
        {
            String[] parts = code.split("\\.");
            this.code = parts[1];
            this.featureClass = FeatureClass.valueOf(parts[0]);

        }
        else
        {
            this.code = "undefined";
            this.featureClass = FeatureClass.UNDEFINED;
        }
    }

    public String getCode()
    {
        return code;
    }

    public String getClassAndCode()
    {
        return featureClass + "." + code;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public FeatureClass getFeatureClass()
    {
        return featureClass;
    }
}

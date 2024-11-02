package com.datamelt.geonames;

public class Position
{
    private final float latitude;
    private final float longitude;

    public Position(float latitude, float longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude()
    {
        return latitude;
    }

    public float getLongitude()
    {
        return longitude;
    }
}

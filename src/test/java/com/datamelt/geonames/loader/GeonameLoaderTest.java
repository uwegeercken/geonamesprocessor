package com.datamelt.geonames.loader;

import com.datamelt.geonames.FeatureCode;
import com.datamelt.geonames.Geoname;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeonameLoaderTest
{
    @Test
    public void test1()
    {
        List<Geoname> geonames = GeonameLoader.loadGeonames("/home/uwe/Downloads/geonames/DE.txt");
        System.out.println("test");
        assert true;
    }
}
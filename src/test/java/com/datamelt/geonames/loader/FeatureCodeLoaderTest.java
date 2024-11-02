package com.datamelt.geonames.loader;

import com.datamelt.geonames.FeatureCode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FeatureCodeLoaderTest
{
    @Test
    public void test1()
    {
        List<FeatureCode> featureCodes = FeatureCodeLoader.loadFeatureCodes("/home/uwe/Downloads/geonames/featureCodes.txt");

        FeatureCode f1 = featureCodes.get(0);
        String fullCode = f1.getClassAndCode();
        System.out.println("test");
        assert  true;
    }


}
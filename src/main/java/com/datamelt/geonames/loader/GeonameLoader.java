package com.datamelt.geonames.loader;

import com.datamelt.geonames.FeatureClass;
import com.datamelt.geonames.FeatureCode;
import com.datamelt.geonames.Geoname;
import com.datamelt.geonames.Position;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class GeonameLoader
{
    private static final int GEONAME_ID   = 0;
    private static final int GEONAME_NAME = 1;
    private static final int GEONAME_ASCIINAME = 2;
    private static final int GEONAME_ALTERNATENAMES = 3;
    private static final int GEONAME_LATITUDE = 4;
    private static final int GEONAME_LONGITUDE = 5;
    private static final int GEONAME_FEATURE_CLASS = 6;
    private static final int GEONAME_FEATURE_CODE = 7;
    private static final int GEONAME_COUNTRY_CODE = 8;
    private static final int GEONAME_CC2 = 9;
    private static final int GEONAME_ADMIN1CODE = 10;
    private static final int GEONAME_ADMIN2CODE = 11;
    private static final int GEONAME_ADMIN3CODE = 12;
    private static final int GEONAME_ADMIN4CODE = 13;
    private static final int GEONAME_POPULATION = 14;
    private static final int GEONAME_ELEVATION = 15;
    private static final int GEONAME_DEM = 16;
    private static final int GEONAME_TIMEZONE = 17;
    private static final int GEONAME_MODIFICATION_DATE = 18;

    public static List<Geoname> loadGeonames(String filename)
    {
        final List<FeatureCode> featureCodes = FeatureCodeLoader.loadFeatureCodes("/home/uwe/Downloads/geonames/featureCodes.txt");
        try(Stream<String> lines = Files.lines(Paths.get(filename)))
        {
            return lines
                    .parallel()
                    .filter(line -> !line.isEmpty())
                    .map(line -> createGeoname(line, featureCodes))
                    .toList();
        }
        catch(IOException ioex)
        {
            ioex.printStackTrace();
        }
        return null;
    }

    private static Geoname createGeoname(String line, List<FeatureCode> featureCodes)
    {
        String[] parts = line.split("\t");

        Geoname geoname = new Geoname(
                Long.parseLong(parts[GEONAME_ID]),
                parts[GEONAME_NAME],
                parts[GEONAME_ASCIINAME],
                Arrays.asList(parts[GEONAME_ALTERNATENAMES].split(",")),
                new Position(Float.parseFloat(parts[GEONAME_LATITUDE]), Float.parseFloat(parts[GEONAME_LONGITUDE])),
                FeatureClass.valueOf(parts[GEONAME_FEATURE_CLASS]),
                getFeatureCode(featureCodes, FeatureClass.valueOf(parts[GEONAME_FEATURE_CLASS]), parts[GEONAME_FEATURE_CODE]),
                parts[GEONAME_COUNTRY_CODE],
                Arrays.asList(parts[GEONAME_CC2].split(",")),
                parts[GEONAME_ADMIN1CODE],
                parts[GEONAME_ADMIN2CODE],
                parts[GEONAME_ADMIN3CODE],
                parts[GEONAME_ADMIN4CODE],
                Long.parseLong(parts[GEONAME_POPULATION]),
                parts[GEONAME_ELEVATION].isEmpty()? 0 : Integer.parseInt(parts[GEONAME_ELEVATION]),
                Integer.parseInt(parts[GEONAME_DEM]),
                parts[GEONAME_TIMEZONE],
                parts[GEONAME_MODIFICATION_DATE]
        );
         return geoname;
    }

    private static FeatureCode getFeatureCode(List<FeatureCode> featureCodes, FeatureClass featureClass, String code)
    {
        return featureCodes.stream()
                .filter(featureCode -> featureCode.getFeatureClass()== featureClass && featureCode.getCode().equals(code))
                .findFirst().orElse(new FeatureCode("null", "undefined"));
    }


}

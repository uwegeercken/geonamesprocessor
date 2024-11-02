package com.datamelt.geonames.loader;

import com.datamelt.geonames.FeatureCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FeatureCodeLoader
{
    public static List<FeatureCode> loadFeatureCodes(String filename)
    {
        try(Stream<String> lines = Files.lines(Paths.get(filename)))
        {
            return lines
                    .filter(line -> !line.isEmpty())
                    .map(FeatureCodeLoader::createFeatureCode)
                    .toList();
        }
        catch(IOException ioex)
        {
            ioex.printStackTrace();
        }
        return null;
    }

    private static FeatureCode createFeatureCode(String line)
    {
        String[] parts = line.split("\t");
        if(parts.length == 3)
        {
            return new FeatureCode(parts[0], parts[1],parts[2]);
        }
        else if(parts.length == 2)
        {
            return new FeatureCode(parts[0], parts[1]);
        }
        else
        {
            throw new RuntimeException("error");
        }
    }
}

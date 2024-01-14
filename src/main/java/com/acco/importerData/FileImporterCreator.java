package com.acco.importerData;
import java.util.HashMap;
import java.util.List;

public class FileImporterCreator extends DataImporterCreator{

    @Override
    public IDataImporter create() {

        return new Text();
    }

}

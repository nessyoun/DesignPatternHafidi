package com.acco.importerData;
import java.util.List;

public abstract class DataImporterCreator {

    private List<IDataImporter> types;

    public abstract IDataImporter create();
    public  IFileDataImporter  fetchTypes(){
        return null;
    }
}

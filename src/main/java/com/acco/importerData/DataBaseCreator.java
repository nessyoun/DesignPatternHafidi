package com.acco.importerData;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DataBaseCreator extends DataImporterCreator{


    @Override
    public IDataImporter create() {
        return new MySQL();
    }
}

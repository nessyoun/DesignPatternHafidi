package com.acco.importerData;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface IDataImporter {

    public List<HashMap<String,Object>> read() throws IOException;
    public IDataImporter build();
}

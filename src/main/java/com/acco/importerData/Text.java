package com.acco.importerData;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Text implements IFileDataImporter{
    @Override
    public List<HashMap<String, Object>> read()  {
        String filePath = "file.txt";

        List<HashMap<String, Object>> dataList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String headerLine = bufferedReader.readLine();
            String[] columnNames = headerLine.split(",");

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                HashMap<String, Object> rowData = new HashMap<>();

                for (int i = 1; i < columnNames.length; i++) {
                    rowData.put(columnNames[i-1], values[i]);
                }

                dataList.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }







    @Override
    public IDataImporter build() {
        return null;
    }

    @Override
    public IFileDataImporter addPath() {
        Text text = new Text();
        return text;
    }
}

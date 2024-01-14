package com.acco.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map;

class ManualAlignement extends Alignement {
    private String pathFile;

    public ManualAlignement(String pathFile) {
        this.pathFile = pathFile;
        this.data = new ArrayList<>();
    }

    public void readFile() {
        try {
            Scanner scanner = new Scanner(new java.io.File(pathFile));
            if (scanner.hasNextLine()) {
                // Lire la première ligne pour obtenir les noms des champs
                String[] fieldNames = scanner.nextLine().split(",");

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] values = line.split(",");


                    String keyField = fieldNames[0];
                    HashMap<String, List<String>> rowData = new HashMap<>();
                    rowData.put(keyField, new ArrayList<>());

                    for (int i = 1; i < fieldNames.length; i++) {
                        rowData.get(keyField).add(fieldNames[i]);
                    }

                    // Ajouter le Map de données à la liste
                    data.add(rowData);
                }

                scanner.close();
            }
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HashMap<String, List<String>>> align() {
        return data;
    }
}
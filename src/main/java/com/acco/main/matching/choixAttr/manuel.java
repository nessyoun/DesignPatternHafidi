package com.acco.main.matching.choixAttr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class manuel implements choixAttribut {
    public List<List<HashMap<String, Object>>> choisirAttributs(List<List<HashMap<String, Object>>> data) {
        List<List<HashMap<String, Object>>> attributsChoisis = new ArrayList<>();

        for (List<HashMap<String, Object>> recordList : data) {
            List<HashMap<String, Object>> attributsSelectionnes = new ArrayList<>();

            for (HashMap<String, Object> record : recordList) {
                HashMap<String, Object> attributsRecord = new HashMap<>();

                if (record.containsKey("nom")) {
                    attributsRecord.put("nom", record.get("nom"));
                }

                if (record.containsKey("age")) {
                    attributsRecord.put("age", record.get("age"));
                }

                attributsSelectionnes.add(attributsRecord);
            }

            attributsChoisis.add(attributsSelectionnes);
        }

        return attributsChoisis;
    }
}

package com.acco.main.matching.Comparaison;

import com.acco.main.matching.Comparaison.fonctionDeComparaison;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class fonctionLogique implements fonctionDeComparaison {
    public boolean match(List<HashMap<String, Object>> record1, List<HashMap<String, Object>> record2) {
        Set<String> seenAttributes = new HashSet<>();

        for (HashMap<String, Object> attribut1 : record1) {
            for (HashMap<String, Object> attribut2 : record2) {
                if (attributesMatch(attribut1, attribut2, seenAttributes)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean attributesMatch(HashMap<String, Object> attribut1, HashMap<String, Object> attribut2, Set<String> seenAttributes) {
        for (Map.Entry<String, Object> entry : attribut1.entrySet()) {
            String key = entry.getKey();

            if (!seenAttributes.contains(key) &&
                    attribut2.containsKey(key) &&
                    entry.getValue().equals(attribut2.get(key))) {
                seenAttributes.add(key);
                return true;
            }
        }
        return false;
    }
}

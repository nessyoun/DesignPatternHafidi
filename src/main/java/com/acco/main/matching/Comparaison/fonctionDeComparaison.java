package com.acco.main.matching.Comparaison;

import java.util.HashMap;
import java.util.List;

public interface fonctionDeComparaison {
    public boolean match(List<HashMap<String, Object>> record1, List<HashMap<String, Object>> record2);
}

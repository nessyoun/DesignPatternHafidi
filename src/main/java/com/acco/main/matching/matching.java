package com.acco.main.matching;

import com.acco.main.matching.Comparaison.fonctionDeComparaison;
import com.acco.main.matching.choixAttr.choixAttribut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class matching {
    private choixAttribut algoChoixAttribut;
    private fonctionDeComparaison fonctionComparaison;

    public matching(choixAttribut ChoixAttribut, fonctionDeComparaison fonctionComparaison) {
        this.algoChoixAttribut = ChoixAttribut;
        this.fonctionComparaison = fonctionComparaison;
    }

    public List<HashMap<String, Object>> processMatching(List<List<HashMap<String, Object>>> matchingData) {
        List<List<HashMap<String, Object>>> attributsChoisis = algoChoixAttribut.choisirAttributs(matchingData);

        List<HashMap<String, Object>> distinctResults = new ArrayList<>();

        for (int i = 0; i < attributsChoisis.size(); i++) {
            for (int j = i + 1; j < attributsChoisis.size(); j++) {
                if (fonctionComparaison.match(attributsChoisis.get(i), attributsChoisis.get(j))) {
                    System.out.println("Correspondance trouvée : " + attributsChoisis.get(i) + " - " + attributsChoisis.get(j));
                }
            }
        }

        for (List<HashMap<String, Object>> result : attributsChoisis) {
            for (HashMap<String, Object> record : result) {
                if (!distinctResults.contains(record)) {
                    distinctResults.add(record);
                }
            }
        }

        return distinctResults;
    }
}

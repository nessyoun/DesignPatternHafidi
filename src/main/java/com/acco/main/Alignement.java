package com.acco.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;

abstract class Alignement {
    protected List<HashMap<String, List<String>>> data;

    public abstract List<HashMap<String, List<String>>> align();
}
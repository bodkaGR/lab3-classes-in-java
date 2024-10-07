package com.bodkasoft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;

public class Sorter {

    public static <T extends Comparable<T>> ArrayList<Npc> sortNpcs(ArrayList<Npc> npcs, Function<Npc, T> sortByField, boolean isAscending) {
        if(isAscending){
            npcs.sort(Comparator.comparing(sortByField));
        }else {
            npcs.sort(Comparator.comparing(sortByField).reversed());
        }
        return npcs;
    }

}

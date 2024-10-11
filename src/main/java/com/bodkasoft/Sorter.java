package com.bodkasoft;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

/**
 * The Sorter class provides utility methods to sort a list of NPCs based on a given field.
 *
 * <p>It contains a static generic method {@code sortNpcs}, which allows sorting an array of {@code Npc}
 * objects by a specified field, either in ascending or descending order. The sorting is performed
 * dynamically based on a user-supplied function, giving flexibility in choosing which NPC attribute
 * (such as name, age, health points, etc.) to sort by.
 */
public class Sorter {

    /**
     * Sorts an array of NPCs based on a specified key and order.
     *
     * <p>This method takes an array of NPCs, a key extractor (a method reference or lambda that provides
     * a value to sort by, e.g., {@code Npc::getName} or {@code Npc::getAge}), and a boolean flag indicating
     * whether to sort in ascending or descending order.
     *
     * @param npcs The array of NPCs to sort.
     * @param sortByField The method reference or lambda function to extract the sort key (e.g., {@code Npc::getName}).
     * @param isAscending {@code true} for ascending order, {@code false} for descending order.
     * @param <T> The type of the key to sort by, e.g., {@code String} for name or {@code Integer} for age.
     * @param <S> The type of NPC, constrained to the {@code Npc} class.
     * @return A new sorted array of NPCs.
     */
    public static <T extends Comparable<T>, S extends Npc> S[] sortNpcs(S[] npcs, Function<S, T> sortByField, boolean isAscending) {
        if (npcs == null || npcs.length == 0){
            throw new NullPointerException("Impossible to sort, npcs is null or empty");
        }

        if (sortByField == null){
            throw new NullPointerException("Impossible to sort, unknown field by which to sort");
        }

        // Create a comparator based on the field to sort by
        Comparator<S> comparator = Comparator.comparing(sortByField);

        // Reverse the comparator if not ascending
        if (!isAscending){
            comparator = comparator.reversed();
        }

        // Sort the array in place
        Arrays.sort(npcs, comparator);

        return npcs;
    }
}

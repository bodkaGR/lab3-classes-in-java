package com.bodkasoft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;

/**
 * The Sorter class provides utility methods to sort a list of NPCs based on a given field.
 *
 * <p>It contains a static generic method {@code sortNpcs}, which allows sorting an {@code ArrayList} of {@code Npc}
 * objects by a specified field, either in ascending or descending order. The sorting is performed
 * dynamically based on a user-supplied function, giving flexibility in choosing which NPC attribute
 * (such as name, age, health points, etc.) to sort by.
 */
public class Sorter {

    /**
     * Sorts a list of NPCs (or subclasses of NPC) based on a specific field, either in ascending or descending order.
     *
     * <p>This method is generic in two ways:
     *
     * <p> - {@code T}: The type of the field being used for sorting, which must implement {@code Comparable<T>}.
     * This ensures that the field can be compared and sorted.
     * <p> - {@code S}: The type of NPC objects being sorted. This can be the {@code Npc} class or any subclass of {@code Npc}.
     *
     * <p>The method uses a {@code Function<S, T>} to dynamically extract the field used for sorting. The comparator
     * is created using the {@code Comparator.comparing()} method and can be reversed based on the {@code isAscending} flag.
     *
     * <p>
     * Parameters:
     * <p> - {@code npcs}: An {@link ArrayList} of NPCs (or NPC subclasses) to be sorted.
     * <p> - {@code sortByField}: A {@code Function<S, T>} that extracts the field to be used for sorting from each NPC.
     * This can be a method reference (e.g., {@code Npc::getAge}) or a lambda expression (e.g., {@code npc -> npc.getName()}).
     * <p> - {@code isAscending}: A boolean flag indicating whether to sort in ascending order ({@code true}) or descending order ({@code false}).
     *
     * @param <T> The type of the field used for sorting, which must implement {@code Comparable<T>}.
     * @param <S> The type of the NPC or its subclass being sorted.
     * @param npcs The list of NPCs (or NPC subclasses) to be sorted.
     * @param sortByField A function to extract the field for sorting from each NPC.
     * @param isAscending A boolean indicating whether to sort in ascending ({@code true}) or descending ({@code false}) order.
     * @return The sorted list of NPCs (or subclasses of NPCs).
     * @throws NullPointerException if npcs or sortByField is null or if npcs is empty.
     */
    public static <T extends Comparable<T>, S extends Npc> ArrayList<S> sortNpcs(ArrayList<S> npcs, Function<S, T> sortByField, boolean isAscending) {
        if (npcs == null || npcs.isEmpty()){
            throw new NullPointerException("Impossible to sort, npcs is null or empty");
        }

        if (sortByField == null){
            throw new NullPointerException("Impossible to sort, unknown field by which to sort");
        }

        Comparator<S> comparator = Comparator.comparing(sortByField);
        npcs.sort(isAscending ? comparator : comparator.reversed());

        return npcs;
    }
}

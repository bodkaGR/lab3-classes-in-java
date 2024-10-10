package com.bodkasoft;

import java.util.ArrayList;

/**
 TODO
 C11 = 9
 Визначити клас НІП (неігрових персонажів, англ. NPC), який складається як мінімум з 5-и полів.
*/
public class Main {

    /**
     * A static, pre-initialized list of NPC (Non-Player Character) objects.
     *
     * <p>This list contains a set of predefined NPCs with various attributes such as
     * name, age, gender, health points (HP), and a brief description of their character.
     */
    public static ArrayList<Npc> npcList = new ArrayList<>(){{
        add(new Npc("Rulan", 200, Gender.MALE, 150, "A wise old elf with a mysterious past."));
        add(new Npc("Kaela", 25, Gender.FEMALE, 80, "A traveling bard with a silver tongue and sharp wit."));
        add(new Npc("Brynn", 45, Gender.MALE, 120, "A gruff dwarven blacksmith with a heart of gold."));
        add(new Npc("Zira", 30, Gender.FEMALE, 100, "A cold, calculating assassin who never misses her mark."));
        add(new Npc("Targun", 35, Gender.OTHER, 200, "A gentle half-orc healer with unmatched herbal knowledge."));
    }};

    /**
     * An instance of the Npc class representing a specific NPC named "Zira".
     *
     * <p>This NPC has the role of a skilled assassin with a deadly reputation, likely to
     * play a significant part in the game world or story
     * or a challenging character for the player to interact with. The instance can be
     * used for searching, comparisons, or interactions within a list of NPCs.
     */
    public static Npc npcForFound = new Npc(
            "Zira",
            30,
            Gender.FEMALE,
            100,
            "A cold, calculating assassin who never misses her mark."
    );

    public static void main(String[] args) {
        try {
            // Output of input array
            System.out.println("<---Input Array--->");
            npcList.forEach(System.out::println);
            System.out.println();

            // Sorted array by name in ascending
            ArrayList<Npc> sortedNpcListByNameAsc = Sorter.sortNpcs(npcList, Npc::getName, true);

            // Output of sorted array
            System.out.println("<---Sorted Npcs by name ascending--->");
            sortedNpcListByNameAsc.forEach(System.out::println);
            System.out.println();

            // Sorted array by age in descending
            ArrayList<Npc> sortedNpcListByAgeDesc = Sorter.sortNpcs(npcList, Npc::getAge, false);

            // Output of sorted array
            System.out.println("<---Sorted Npcs by age descending--->");
            sortedNpcListByAgeDesc.forEach(System.out::println);
            System.out.println();

            // Finding the same object
            System.out.println("<---Input Npc--->");
            System.out.println(npcForFound);

            // Checking npc for existing in npcList
            System.out.print("Result: ");
            if (isExist(npcForFound, npcList)) {
                System.out.println("\u001B[32m" + "Npc was found" + "\u001B[0m");
            }else {
                System.out.println("\u001B[31m" + "Npc not found" + "\u001B[0m");
            }
        }catch (NullPointerException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    /**
     * Checks if a specific NPC exists within a given list of NPCs.
     *
     * <p>This is a generic method where the type {@code T} must be a subclass of {@code Npc}.
     * It takes two parameters:
     *
     * <p> - {@code npcForFound}: The NPC object you are searching for in the list.
     * <p> - {@code list}: The list of NPCs (or its subclasses) where the search will be performed.
     *
     * <p>The method uses Java Streams to efficiently search the list. It utilizes the {@code anyMatch()}
     * function to check if any NPC in the list is equal to the given {@code npcForFound}. Equality is
     * based on the {@code equals()} method, which should be properly overridden in the {@code Npc} class
     * to ensure meaningful comparison (e.g., by name, age, or other unique attributes).
     *
     * @param <T> The type of NPC, constrained to the {@code Npc} class or its subclasses.
     * @param npcForFound The NPC object to search for in the list.
     * @param list The list of NPCs where the search will take place.
     * @return {@code true} if the specified NPC is found in the list, otherwise {@code false}.
     */
    public static <T extends Npc> boolean isExist(T npcForFound, ArrayList<T> list){
        if (list == null){
            throw new NullPointerException("List is null, cannot check for Npc existing in list");
        }

        return list.stream()
                .anyMatch(obj -> obj.equals(npcForFound));
    }
}
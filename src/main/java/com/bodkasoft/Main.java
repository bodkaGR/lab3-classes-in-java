package com.bodkasoft;

/*
* TODO
* C11 = 9
* Визначити клас НІП (неігрових персонажів, англ. NPC), який складається як мінімум з 5-и полів.
* */

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ArrayList<Npc> npcList = new ArrayList<>(){{
            add(new Npc("Rulan", 200, Gender.MALE, 150, "A wise old elf with a mysterious past."));
            add(new Npc("Kaela", 25, Gender.FEMALE, 80, "A traveling bard with a silver tongue and sharp wit."));
            add(new Npc("Brynn", 45, Gender.MALE, 120, "A gruff dwarven blacksmith with a heart of gold."));
            add(new Npc("Zira", 30, Gender.FEMALE, 100, "A cold, calculating assassin who never misses her mark."));
            add(new Npc("Targun", 35, Gender.OTHER, 200, "A gentle half-orc healer with unmatched herbal knowledge."));
        }};


        //
        // Output of input array
        //
        System.out.println("<---Input Array--->");
        npcList.forEach(System.out::println);
        System.out.println();

        //
        // Sorted array by name in ascending
        //
        ArrayList<Npc> sortedNpcListByNameAsc = Sorter.sortNpcs(npcList, Npc::getName, true);

        //
        // Output of sorted array
        //
        System.out.println("<---Sorted Npcs by name ascending--->");
        sortedNpcListByNameAsc.forEach(System.out::println);
        System.out.println();

        //
        // Sorted array by age in descending
        //
        ArrayList<Npc> sortedNpcListByAgeDesc = Sorter.sortNpcs(npcList, Npc::getAge, false);

        //
        // Output of sorted array
        //
        System.out.println("<---Sorted Npcs by age descending--->");
        sortedNpcListByAgeDesc.forEach(System.out::println);
        System.out.println();

        //
        // Finding the same object
        //
        System.out.println("<---Input Npc--->");
        Npc npcForFound = new Npc("Zira", 30, Gender.FEMALE, 100, "A cold, calculating assassin who never misses her mark.");
        System.out.println(npcForFound);

        Optional<Npc> foundedNpc = npcList.stream()
                .filter(npc -> npc.equals(npcForFound))
                .findFirst();

        if (foundedNpc.isPresent()) {
            System.out.println("Found Npc: " + foundedNpc.get());
        }else {
            System.out.println("Npc not found");
        }

    }
}
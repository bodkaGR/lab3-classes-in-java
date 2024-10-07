package com.bodkasoft;

/*
* TODO
* C11 = 9
* Визначити клас НІП (неігрових персонажів, англ. NPC), який складається як мінімум з 5-и полів.
* */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Npc> npcList = new ArrayList<>(){{
            add(new Npc("Rulan", 200, Gender.MALE, 150, "A wise old elf with a mysterious past."));
            add(new Npc("Kaela", 25, Gender.FEMALE, 80, "A traveling bard with a silver tongue and sharp wit."));
            add(new Npc("Brynn", 45, Gender.MALE, 120, "A gruff dwarven blacksmith with a heart of gold."));
            add(new Npc("Zira", 30, Gender.FEMALE, 100, "A cold, calculating assassin who never misses her mark."));
            add(new Npc("Targun", 35, Gender.OTHER, 200, "A gentle half-orc healer with unmatched herbal knowledge."));
        }};

        System.out.println("<---Input Array--->");
        npcList.forEach(System.out::println);
        System.out.println();


        ArrayList<Npc> sortedNpcListByNameAsc = Sorter.sortNpcs(npcList, Npc::getName, true);

        System.out.println("<---Sorted Npcs by name ascending--->");
        sortedNpcListByNameAsc.forEach(System.out::println);
        System.out.println();

        ArrayList<Npc> sortedNpcListByAgeDesc = Sorter.sortNpcs(npcList, Npc::getAge, false);

        System.out.println("<---Sorted Npcs by age descending--->");
        sortedNpcListByAgeDesc.forEach(System.out::println);
    }
}
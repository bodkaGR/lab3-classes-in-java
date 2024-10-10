package com.bodkasoft;

import java.util.Objects;

/**
 * The Npc class represents a non-player character (NPC) in a game or simulation.
 * Each NPC has attributes such as name, age, gender, health points, and a description
 * of their occupation or role in the game.
 */
public class Npc {

    /**
     * The name of the NPC
     */
    private String name;

    /**
     * The age of the NPC
     */
    private int age;

    /**
     * The gender of the NPC, represented by the Gender enum
     */
    private Gender gender;

    /**
     * The health points of the NPC, indicating their vitality
     */
    private int healthPoints;

    /**
     * A description of the NPC, typically outlining their role or backstory
     */
    private String description;

    /**
     * Default constructor for creating an NPC with no predefined attributes.
     * This constructor can be useful when an NPC is to be created without
     * immediate assignment of its attributes.
     */
    public Npc() {}

    /**
     * Constructor for creating an NPC with specified attributes.
     *
     * @param name The name of the NPC.
     * @param age The age of the NPC.
     * @param gender The gender of the NPC, represented by the {@link Gender} enum.
     * @param healthPoints The health points of the NPC.
     * @param occupation A description of the NPC's role or backstory.
     */
    public Npc(String name, int age, Gender gender, int healthPoints, String occupation) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.healthPoints = healthPoints;
        this.description = occupation;
    }

    /**
     * Gets the name of the NPC.
     *
     * @return The name of the NPC.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the NPC.
     *
     * @param name The new name for the NPC.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of the NPC.
     *
     * @return The age of the NPC.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the NPC.
     *
     * @param age The new age for the NPC.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the gender of the NPC.
     *
     * @return The gender of the NPC.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender of the NPC.
     *
     * @param gender The new gender for the NPC, represented by the {@link Gender} enum.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Gets the health points of the NPC.
     *
     * @return The health points of the NPC.
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Sets the health points of the NPC.
     *
     * @param healthPoints The new health points for the NPC.
     */
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Gets the description of the NPC.
     *
     * @return The description of the NPC.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the NPC.
     *
     * @param description The new description for the NPC.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Compares this NPC with another object for equality.
     * Two NPCs are considered equal if all their fields (name, age, gender, health points, and description)
     * are equal.
     *
     * @param obj The object to compare with this NPC.
     * @return {@code true} if the object is an instance of Npc and all fields are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this){ // Check if the same object reference
            return true;
        }

        if(!(obj instanceof Npc npc)){
            return false;
        }

        return Objects.equals(this.name, npc.name) &&
                this.age == npc.age &&
                this.gender == npc.gender &&
                this.healthPoints == npc.healthPoints &&
                Objects.equals(this.description, npc.description);
    }

    /**
     * Returns a string representation of the NPC object.
     * This representation includes the name, age, gender, health points, and description,
     * formatted for easier reading.
     *
     * @return A string representing the NPC.
     */
    @Override
    public String toString() {
        return "Npc{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", healthPoints=" + healthPoints +
                ", description='" + description + '\'' +
                '}';
    }
}

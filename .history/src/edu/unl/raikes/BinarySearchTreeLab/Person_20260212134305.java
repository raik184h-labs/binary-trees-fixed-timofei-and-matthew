package edu.unl.raikes.BinarySearchTreeLab;

/**
 * Represents a person with a NUID and name.
 */
public class Person implements Comparable<Person> {
    int key;
    String name;

    /**
	 * Creates a new person with the given NUID and name
	 * @param NUID the NUID of the person
	 * @param name the name of the person
	 */
    Person(int NUID, String name) {
        this.key = NUID;
        this.name = name;
    }

    /**
	 * Returns a string representation of this person.
	 * @return a string representation of this person.
	 */
    public String toString() {
        return "NUID: " + this.key + "  Name: " + name;
    }

    /**
     * Compares this person to another person based on their NUID.
     * @param other the other person to compare to
     * @return a negative integer, zero, or a positive integer as this person's
	 * NUID is less than, equal to, or greater than the other person's NUID
     */
    public int compareTo(Person other) {
        return Integer.compare(key, other.key);
    }
}

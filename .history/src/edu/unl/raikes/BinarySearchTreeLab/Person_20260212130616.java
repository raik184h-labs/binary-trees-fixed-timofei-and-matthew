package edu.unl.raikes.BinarySearchTreeLab;

//TODO: ADD JAVADOC COMMENT
public class Person implements Comparable<Person> {
    int key;
    String name;

    // TODO: ADD JAVADOC COMMENT
    Person(int NUID, String name) {
        this.key = NUID;
        this.name = name;
    }

    // TODO: ADD JAVADOC COMMENT
    public String toString() {
        return "NUID: " + this.key + "  Name: " + name;
    }

    /**
     * Compares this person to another person based on their NUID.
     * @param other the other person to compare to
     * @return a negative integer, zero, or a positive integer as this person's NUID is less than, equal to, or greater than the other person's NUID
     */
    public int compareTo(Person other) {
        return Integer.compare(key, other.key);
    }
}

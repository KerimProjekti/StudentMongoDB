package models;

import java.util.Map;
import java.util.UUID;

public class Student {
    private final String id;
    private String name;
    private String surname;
    private String email;
    private int year;
    private Map<String, Integer> grades;

    public Student(String name, String surname, String email, int year, Map<String, Integer> grades) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ime ne može biti prazno.");
        }
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Prezime ne može biti prazno.");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Godina mora biti između 1 i 4.");
        }
        if (grades == null) {
            throw new IllegalArgumentException("Ocjene ne smiju biti null.");
        }
        if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            throw new IllegalArgumentException("Email nije u validnom formatu.");
        }

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.year = year;
        this.grades = Map.copyOf(grades);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ime ne može biti prazno.");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Prezime ne može biti prazno.");
        }
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Godina mora biti između 1 i 4.");
        }
        this.year = year;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, Integer> grades) {
        if (grades == null) {
            throw new IllegalArgumentException("Ocjene ne smiju biti null.");
        }
        this.grades = Map.copyOf(grades);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            throw new IllegalArgumentException("Email nije u validnom formatu.");
        }
        this.email = email;
    }

    public double calculateAverageGrade() {
        if (grades == null || grades.isEmpty()) {
            return 0.0; // Return 0 if no grades are present
        }
        return grades.values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return id + " - " + name + " " + surname + ",\nEmail: " + email + "\n(Godina: " + year + ",\nOcjene: " + grades + ")";
    }
}
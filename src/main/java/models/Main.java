package models;

import controllers.MongoDBController;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(
                "Kerim",
                "Bukvić",
                "kerimbukvic4@gmail.com",
                2,
                Map.of("Projektni menadžment", 9, "Programiranje u Javi", 10)
        );

        MongoCollection<Document> collection = MongoDBController.getInstance()
                .getDatabase()
                .getCollection("studenti");

        collection.insertOne(new Document("_id", student.getId())
                .append("name", student.getName())
                .append("surname", student.getSurname())
                .append("email", student.getEmail())
                .append("year", student.getYear())
                .append("grades", student.getGrades()));

        System.out.println("Student ubačen u bazu.");

        MongoDBController.getInstance().closeConnection();
    }
}

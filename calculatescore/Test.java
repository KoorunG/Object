package calculatescore;

import java.util.Arrays;

public class Test {
    
    public static void main(String[] args) {
        // Lecture lecture = new Lecture("객체지향 프로그래밍", 70, Arrays.asList(81,95,75,50,45));
        // System.out.println(lecture.average());

        // String evaluation = lecture.evaluate();
        // System.out.println(evaluation);
        GradeLecture lecture = new GradeLecture("객체지향 프로그래밍", 70, Arrays.asList(new Grade("A",100,95),
                                                                                    new Grade("B",94,80),
                                                                                    new Grade("C",79,70),
                                                                                    new Grade("D",69,50),
                                                                                    new Grade("F",49,0)) ,Arrays.asList(81,95,75,50,45));

        System.out.println(lecture.evaluate());
        System.out.println(lecture.average("C"));   
        
        Professor professor = new Professor("KoorunG", new Lecture("객체지향 프로그래밍", 70, Arrays.asList(81,95,75,50,45)));
        Professor professor2 = new Professor("KoorunG", new GradeLecture("객체지향 프로그래밍", 70, Arrays.asList(new Grade("A",100,95),
        new Grade("B",94,80),
        new Grade("C",79,70),
        new Grade("D",69,50),
        new Grade("F",49,0)) ,Arrays.asList(81,95,75,50,45)));
        
        System.out.println(professor.compileStatistics());
        System.out.println(professor2.compileStatistics());
    }
}

package levels;

import models.Teacher;
import utils.Data;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> employees = Data.employees();

        /*
         * TO DO 1: Afficher tous les enseignants
         */
        employees.stream().forEach(System.out::println);

        /*
         * TO DO 2: Afficher les enseignants dont le nom commence par la lettre n
         */
        Predicate<Teacher> pre = teacher -> teacher.getName().startsWith("n");

        employees.stream().filter(pre).forEach(System.out::println);

        /*
         * TO DO 3: Afficher les enseignants dont le nom commence par la lettre n et le salaire > 100000
         */
        employees.stream().filter(pre).filter(teacher -> teacher.getSalary()>100000).forEach(System.out::println);

        /*
         * TO DO 4: Afficher les enseignants JAVA triés par salaire (éliminer les redondances)
         */
        employees.stream().filter(teacher -> employees.contains(teacher)).sorted((t1,t2)-> t1.compareTo(t2)).forEach(System.out::println);

        /*
         * TO DO 5: Afficher les noms des enseignants dont le salaire > 60000 avec 2 manières différentes
         */

        /* First Way */
        employees.stream().filter(teacher -> teacher.getSalary()>60000).forEach(System.out::println);
        /* Second Way */
        employees.stream().filter(teacher -> teacher.getSalary()>60000).map(teacher -> teacher.getName()).forEach(System.out::println);

        /*
         * TO DO 6:  Ajouter 200 Dt pour les enseignants dont le nom commence par m et afficher celui qui a le salaire le plus élevé
         */
        employees.stream().filter(teacher -> teacher.getName().startsWith("m")).map(teacher -> {teacher.setSalary(teacher.getSalary()+200);
        return teacher;}).max((t1,t2)-> t1.compareTo(t2));

    }
}

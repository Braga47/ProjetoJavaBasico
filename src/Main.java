import java.util.ArrayList;
import java.util.Collections;

import builders.StudentsBuilder;
import entities.Student;

public class Main {

    public static void main(String[] args) {
        var allStudents = StudentsBuilder.getAllStudents();

        // Agora vamos as atividades
        /*

        1. Recupere da lista os alunos que passaram de ano (nota minima 7.0).
            - Exiba os dados nesse formato: <código> - <nome> : Média = <nota>
        2. Recupere da lista os alunos que não passaram de ano.
            - Exiba os dados nesse formato: <código> - <nome> : Média = <media> (Faltou = <nota_faltante>)
        3. Traga os alunos que tiraram a nota máxima (nota 10).
            - Exiba os dados nesse formato: <código> - <nome>
        4. Traga o aluno que tirou a menor nota, em caso de notas iguais, traga ambos os alunos.
            - Exiba os dados nesse formato: <código> - <nome> : Nota = <nota>
        5. Faça uma lista com top 3 notas de alunos. Em caso de notas iguais coloque todos na mesma posição.
            - Ex:
                1º - Fulano : Nota = 10.0;
                   - Beltrano : Nota = 10.0;
                2º - Joãozinho : Nota = 9.0;
                3º - Mariazinha : Nota = 8.9;
            - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>
        6. Faça uma lista com as 3 menores notas de alunos. Em caso de notas iguais coloque todos na mesma posição. Exemplo igual a anterior
            - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>
        7. Monte a média de todos os alunos e exiba em tela ordenando da maior para a menor nota.
            - Exiba os dados nesse formato: <posicao> - <código> - <nome> : Média = <nota>

         */

        //Exercise 1: The students with a grade higher than 7.0
        System.out.println("Alunos Aprovados: ");
        Functions.AprovedReproved(allStudents, 'a');

        //Exercise 2: The students who failed
        System.out.println("Alunos Reprovados: ");
        Functions.AprovedReproved(allStudents, 'r');
        
        //Exercise 3: Students with the highest note possible.
        System.out.println("Alunos Nota 10: ");
        for (Student s :
                allStudents) {
            if (Functions.lowestHighest(s, 'h') == 10) {
                System.out.printf("%d - %s \n", s.getCode(), s.getName());
            }
        }

        //Exercise 4: Students with the lower score.
        System.out.println("Aluno com a pior nota: ");
        float lowerScore = 100f;
        for (Student b :
                allStudents) {
            if (lowerScore >= Functions.lowestHighest(b, 'l')) {
                lowerScore = Functions.lowestHighest(b, 'l');
            }
        }
        for (Student a :
                allStudents) {
            if (Functions.lowestHighest(a, 'l') == lowerScore) {
                System.out.printf("%d - %s: Nota = %.2f\n", a.getCode(), a.getName(), Functions.lowestHighest(a, 'l'));
            }
        }

        //Exercise 5: Top 3 students.
        System.out.println("Pódio dos alunos: ");
        float first = 0;
        float second = 0;
        float third = 0;

        for (Student b : allStudents) {
            Float temp = Functions.lowestHighest(b, 'h');
            if (temp > first) {
                first = temp;
            }
            if (temp > second && temp < first) {
                second = temp;
            }
            if (temp > third && temp < second) {
                third = temp;
            }
        }
        System.out.println("1° lugar: ");
        for (Student a :
                allStudents) {
            float temp = Functions.lowestHighest(a, 'h');
            if (temp == first) {
                System.out.printf("%d - %s: Nota = %.2f\n", a.getCode(), a.getName(), Functions.lowestHighest(a, 'h'));
            }
        }
        System.out.println("2° lugar: ");
        for (Student a :
                allStudents) {
            float temp = Functions.lowestHighest(a, 'h');
            if (temp == second) {
                System.out.printf("%d - %s: Nota = %.2f\n", a.getCode(), a.getName(), Functions.lowestHighest(a, 'h'));
            }
        }
        System.out.println("3° lugar: ");
        for (Student a :
                allStudents) {
            float temp = Functions.lowestHighest(a, 'h');
            if (temp == third) {
                System.out.printf("%d - %s: Nota = %.2f\n", a.getCode(), a.getName(), Functions.lowestHighest(a, 'h'));
            }
        }

        //Exercise 6: Three worst scores.
        System.out.println("As tres piores notas da turma: ");
        float firstWorst = 100f;
        float secondWorst = 100f;
        float thirdWorst = 100f;
        for (Student c : allStudents){
            float r = 0;
            float minC = Functions.lowestHighest(c, 'l');
            for (Student d : allStudents){
                float minD = Functions.lowestHighest(d,'l');
                if (minC < minD){
                    r = minC;
                } else {
                    r = minD;
                }
                if (r < firstWorst){
                    firstWorst = r;
                } else if (r < secondWorst && r != firstWorst){
                    secondWorst = r;
                } else if (r < thirdWorst && r != firstWorst && r != secondWorst){
                    thirdWorst = r;
                }
            }
        }
        System.out.println("1° lugar: ");
        for (Student d : allStudents) {
            if (Functions.lowestHighest(d,'l') == firstWorst){
                System.out.printf("%d - %s: Nota = %.2f\n", d.getCode(), d.getName(), Functions.lowestHighest(d, 'l'));
            }
        }
        System.out.println("2° lugar: ");
        for (Student d : allStudents){
            if (Functions.lowestHighest(d,'l') == secondWorst){
                System.out.printf("%d - %s: Nota = %.2f\n", d.getCode(), d.getName(), Functions.lowestHighest(d, 'l'));
            }
        }
        System.out.println("3° lugar: ");
        for (Student d : allStudents) {
            if (Functions.lowestHighest(d,'l') == thirdWorst){
                System.out.printf("%d - %s: Nota = %.2f\n", d.getCode(), d.getName(), Functions.lowestHighest(d, 'l'));
            }
        }

        //Exercise 7:
        System.out.println("Medias decrescentes: ");
        var medias = new ArrayList();
        for (Student c : allStudents){
            medias.add(Functions.Average(c));
        }
        Collections.sort(medias, Collections.reverseOrder());
        int pos = 1;
        for (Object o : medias) {
            float oFloat = (float) o;
            for (Student s : allStudents){
                if (Functions.Average(s) == oFloat){
                    System.out.printf("%d - %d - %s : Média = %.2f\n", pos, s.getCode(), s.getName(), oFloat);
                    pos++;
                }


            }
        }






    }
}

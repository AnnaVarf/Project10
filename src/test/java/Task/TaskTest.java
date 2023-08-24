package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void simpleTaskMatchesTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void simpleTaskNotMatchesTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void epicMachesTest() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Молоко");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void epicNotMachesTest() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Вода");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void meetingMachesTest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Выкатка");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void meetingMachesTest2() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Приложение");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void meetingNotMachesTest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Предложение");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void findQueryInTaskFalseTest() {
        Task task = new Task(32);

        boolean expected = false;
        boolean actual = task.matches("положение");

        Assertions.assertEquals(expected, actual);
    }



}
package application;

public class Main {
    public static void main(String[] args) {
        PomodoroTimer timer = new PomodoroTimer();
        PomodoroUI ui = new PomodoroUI(timer);

        ui.showMenu();
        ui.handleInput();
    }
}
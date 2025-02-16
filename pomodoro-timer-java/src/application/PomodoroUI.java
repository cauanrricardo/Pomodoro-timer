package application;

import java.util.*;

public class PomodoroUI {
    private PomodoroTimer timer;

    public PomodoroUI(PomodoroTimer timer) {
        this.timer = timer;
    }

    public void showMenu() {

        System.out.println("=== POMODORO TIMER ===");
        System.out.println("1. Iniciar Pomodoro (25 minutos)");
        System.out.println("2. Inicar Break(5 minutos)");
        System.out.println("3. Pausar:");
        System.out.println("4. Continuar");
        System.out.println("5. Avançar para o proximo estágio");
        System.out.println("6. Sair");
        System.out.println("----------------------------------------");

    }

    public void handleInput() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Escolha uma opção:");
            int option = sc.nextInt();
            System.out.println("----------------------------------------");

            switch (option) {
                case 1:
                    timer.startWork();
                    break;
                case 2:
                    timer.startBreak();
                    break;
                case 3:
                    timer.pause();
                    break;
                case 4:
                    timer.resume();
                    break;
                case 5:
                    timer.nextStage();
                    break;
                case 6:
                    timer.stopTimer();
                    running = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção invalida! Tente novamente.");
                    break;

            }
        }
    }

}
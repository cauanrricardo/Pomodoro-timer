package application;

import javax.sound.sampled.*;
import java.net.URL;

public class PomodoroTimer {

    private static final int WORK_TIME = 1500; // 25min = 1500 segundos
    private static final int BREAK_TIME = 300; // 5min = 300 segundos
    private int remainingTime;
    private boolean isRunning; // timer ta rodando
    private boolean isWorkTime; // se estamos no tempo de trabalho ou pausa
    private boolean stopTimer = false; // variavel p para o cronometro

    public void startWork() {
        remainingTime = WORK_TIME;
        isRunning = true;
        isWorkTime = true;
        stopTimer = false; // reseta a flag quando o cronômetro é iniciado
        runTimer(); // inicia o cronômetro
    }

    public void startBreak() {
        remainingTime = BREAK_TIME;
        isRunning = true;
        isWorkTime = false;
        stopTimer = false;
        runTimer();
    }

    public void pause() {
        isRunning = false;
    }
    public void resume(){
        if(!isRunning){
            isRunning = true;
            runTimer();
        }
    }

    public void nextStage() {
        if (isWorkTime) {
            startBreak();
        } else {
            startWork();
        }
    }

    public void stopTimer() {
        stopTimer = true;
    }


    public void runTimer() {
        new Thread(() -> {
            while (isRunning && remainingTime > 0 && !stopTimer) { // checa se deve parar
                try {
                    Thread.sleep(1000);
                    remainingTime--;
                    updateDisplay();
                    if (remainingTime == 0) {
                        nextStage();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Erro no cronômetro: " + e.getMessage());
                }
            }
        }).start();
    }

    private void updateDisplay() {
        int minutes = remainingTime / 60; // converte pra min
        int seconds = remainingTime % 60; // pega os seg restantes
        System.out.printf("\rTempo restante: %02d:%02d  ", minutes, seconds);
    }


    public boolean getIsRunning() {
        return isRunning;
    }

    public boolean getIsWorkTime() {
        return isWorkTime;
    }
}
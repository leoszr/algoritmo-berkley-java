package br.berkeley.model;

public class Clock {
    private int totalSegundos;
    
    public Clock(int horas, int minutos, int segundos) {
        this.totalSegundos = horas * 3600 + minutos * 60 + segundos;
    }
    
    public int getTotalSegundos() {
        return totalSegundos;
    }
    
    public void ajustar(int offsetSegundos) {
        this.totalSegundos += offsetSegundos;
    }
    
    @Override
    public String toString() {
        int horas = totalSegundos / 3600;
        int resto = totalSegundos % 3600;
        int minutos = resto / 60;
        int segundos = resto % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}

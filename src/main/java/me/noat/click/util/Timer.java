package me.noat.click.util;

public class Timer {
    long time;
    public Timer() {
        time = System.currentTimeMillis();
    }

    public boolean passedMs(int ms) {
        return System.currentTimeMillis() - time >= ms;
    }

    public void reset() {
        this.time = System.currentTimeMillis();
    }
}

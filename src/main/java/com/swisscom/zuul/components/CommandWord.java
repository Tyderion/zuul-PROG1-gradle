package com.swisscom.zuul.components;

import java.util.Arrays;

/**
 * Created by Archie on 04.10.2016.
 */
public enum CommandWord {
    LOOK("look"), GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), MAP("map");

    private String command;

    CommandWord(String command) {
        this.command = command;
    }

    public String toString() {
        return command;
    }

    public static CommandWord fromString(String cmd) {
        try {
            return CommandWord.valueOf(cmd.toUpperCase());
        } catch (IllegalArgumentException e) {
            return CommandWord.UNKNOWN;
        }
    }

    /*
 * Print all valid commands to System.out.
 */
    public static void showAll() {
        Arrays.stream(CommandWord.values())
                .filter(commandWord -> commandWord != CommandWord.UNKNOWN)
                .forEach(commandWord -> System.out.print(commandWord + " "));
        System.out.println();
    }
}

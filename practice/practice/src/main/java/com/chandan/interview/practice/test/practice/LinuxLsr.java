package com.chandan.interview.practice.test.practice;

import java.io.File;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LinuxLsr {

    public static void main(String[] args) {
        String path = "D:\\javaTechie";
        lsr(new File(path), 0);
    }

    private static void lsr(File dir, int level) {

        if (!dir.exists()) {
            System.out.println("Not exist" + dir.getAbsolutePath());
            return;
        }

        if (dir.isFile()) {
            printWithIndent(dir, level);
            return;
        }

        printWithIndent(dir, level);

        File[] files = dir.listFiles();

        if (files == null) {
            return;
        }

        for (File f : files) {
            if (f.isDirectory()) {
                lsr(f, level + 1);
            } else {
                printWithIndent(f, level + 1);
            }
        }
    }

    private static void printWithIndent(File file, int level) {
        IntStream.range(0, level).forEach(i -> System.out.print(" "));
        System.out.println(file.getName());
    }
}

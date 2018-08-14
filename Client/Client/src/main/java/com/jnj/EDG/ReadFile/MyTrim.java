package com.jnj.EDG.ReadFile;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

public class MyTrim {
    public static ArrayList<String> structureLineOfCsv(String lineOfCsv) {
        String[] stringsSplited = lineOfCsv.split(",");
        ArrayList<String> structureLine = new ArrayList<>();
        int countWithStringsSplit = 0;
        while (countWithStringsSplit < stringsSplited.length) {
            myTrim(stringsSplited[countWithStringsSplit]);
            if (!stringsSplited[countWithStringsSplit].isEmpty() && stringsSplited[countWithStringsSplit].substring(0, 1).equals("\"")) {
                String tempString = "";
                tempString += stringsSplited[countWithStringsSplit].substring(1);    //去除头部\"
                do {
                    ++countWithStringsSplit;
                    myTrim(stringsSplited[countWithStringsSplit]);
                    tempString += ",";
                    tempString += stringsSplited[countWithStringsSplit];
                } while (!stringsSplited[countWithStringsSplit].endsWith("\""));
                structureLine.add(tempString.substring(0, tempString.length() - 1));    //去除尾部\"
                ++countWithStringsSplit;
            } else {
                structureLine.add(myTrim(stringsSplited[countWithStringsSplit]));
                ++countWithStringsSplit;
            }
        }
        return structureLine;
    }

    public static String myTrim(String word) {
        while (!word.isEmpty()
                && !word.equals("")
                && (word.substring(0, 1).equals(" ")
                || word.substring(0, 1).equals("　")
                || word.substring(0, 1).equals(" ")
                || word.substring(word.length() - 1).equals(("\u00a0")))) {
            word = word.substring(1);

        }
        while (!word.isEmpty()
                && !word.equals("")
                && (word.substring(word.length() - 1).equals(" ")
                || word.substring(word.length() - 1).equals("　")
                || word.substring(word.length() - 1).equals(("\u00a0")))) {
            word = word.substring(0, word.length() - 2);
        }

        return word;
    }
}

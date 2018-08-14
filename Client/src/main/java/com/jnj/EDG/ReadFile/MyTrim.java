package com.jnj.EDG.ReadFile;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTrim {
    public static ArrayList<String>  structureLineOfCsv(String lineOfCsv){
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
        //System.out.println(structureLine);
        return structureLine;
    }
    public String replaceBlank(String str){
        Pattern pt=Pattern.compile("^\\s*|\\s*$");
        Matcher mt=pt.matcher(str);
        str=mt.replaceAll("");
        return str;
    }

    public static String myTrim(String word) {
        while(!word.isEmpty()
                && !word.equals("")
                && (word.substring(0,1).equals(" ")
                || word.substring(0,1).equals("　")
                || word.substring(0,1).equals(" ")
                || word.substring(0,1).equals(" ")
                || word.substring(0,1).equals(("\u00a0")))){
            //System.out.println("beforeword:"+word);
            word = word.substring(1);
            //System.out.println("after word:"+word);

        }
        while(!word.isEmpty()
                && !word.equals("")
                && (word.substring(word.length()-1).equals(" ")
                || word.substring(word.length()-1).equals("　")
                || word.substring(word.length()-1).equals(" ")
                || word.substring(word.length()-1).equals(" ")
                || word.substring(word.length()-1).equals(("\u00a0")))){
            word = word.substring(0,word.length()-2);
        }

        return word;
    }
    public static void main(String[] args) {
        MyTrim myTrim = new MyTrim();
        myTrim.structureLineOfCsv("\"1,    2,　　3\",4    ,5,6,7");
        char a = ' ';
        char b = ' ';

        System.out.println("  char-|||"+("\u00a0")+"|||byte-a:"+(byte)a+"|||byte-b"+(byte)b);
    }
}

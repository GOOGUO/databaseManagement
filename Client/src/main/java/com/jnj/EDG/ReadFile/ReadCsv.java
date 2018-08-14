package com.jnj.EDG.ReadFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadCsv {
    public static void main(String[] args) {
        String filePath = "C:\\somethings\\EDG\\P1-databaseManagement\\data\\mockUpDataForInterns - test.csv";
        ArrayList<ArrayList<String>> dataListList = CSV2Array(filePath);
        //dataListList.forEach((String) -> System.out.println(String));
    }
    public static ArrayList<ArrayList<String>> CSV2Array(String path) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            ArrayList<ArrayList<String>> alldata = new ArrayList<ArrayList<String>>();
            String line;
            String[] oneRowBefore;


            while ((line = in.readLine()) != null) {
                //System.out.println(line);
                ArrayList<String> oneRowAfterList = new ArrayList<>();
                oneRowBefore = line.split(",");  //默认分割符为逗号，可以不使用逗号
                int beforeCount = 0;
                while (beforeCount< oneRowBefore.length){
                    oneRowBefore[beforeCount].trim();
                    //System.out.println(oneRowBefore[beforeCount]);
                    if (!oneRowBefore[beforeCount].isEmpty() && oneRowBefore[beforeCount].substring(0,1).equals("\"")){
                        //System.out.println("前缀为\":    "+oneRowBefore[beforeCount]);
                        String tempString = "";
                        tempString += oneRowBefore[beforeCount].substring(1);    //去除头部\"

                        do {
                            ++beforeCount;
                            oneRowBefore[beforeCount].trim();
                            tempString += ",";
                            tempString += oneRowBefore[beforeCount];
                            //if(oneRowBefore[beforeCount].endsWith("\"")){
                            //                            //    //System.out.println("后缀为\":    "+oneRowBefore[beforeCount]);
                            //                            //}
                        }while (!oneRowBefore[beforeCount].endsWith("\""));
                        //System.out.println("string:   " + tempString);
                        oneRowAfterList.add(tempString.substring(0,tempString.length()-1));    //去除尾部\"
                        ++beforeCount;
                    }else {
                        oneRowAfterList.add(oneRowBefore[beforeCount]);
                        ++beforeCount;
                    }
                }
                //List<String> onerowlist = Arrays.asList(onerow);
                //System.out.println("---------"+oneRowAfterList);
                //ArrayList<String> onerowaArrayList = new ArrayList<String>(onerowlist);
                alldata.add(oneRowAfterList);
            }
            in.close();
            return alldata;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
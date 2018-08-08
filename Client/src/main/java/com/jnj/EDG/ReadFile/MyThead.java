package com.jnj.EDG.ReadFile;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

class MyThead implements Callable {
    int start;
    int end;
    File file;
    ArrayList<String> lineList = new ArrayList<>();
    public MyThead(int start, int end,File file) {
        this.start = start;
        this.end = end;
        this.file = file;
    }

    @Override
    public ArrayList<ArrayList<String>> call() {

        System.out.println(Thread.currentThread().getName()+"启动了");
        BufferedReader in = null;
        try {
            //String filePath = "C:\\somethings\\EDG\\P1-databaseManagement\\data\\mockUpDataForInterns - test.csv";
            in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            in.skip(start);
            int readLength = end-start-1;
            ArrayList<ArrayList<String>> lineList = new ArrayList<ArrayList<String>>();

            String line = "";
            line = in.readLine();
            if(line == null){
                //停止线程
            }
            if(start == 0){
                lineList.add(MyTrim.structureLineOfCsv(line));
            }

            //System.out.println(line);
            while(readLength > 0){

                line = in.readLine();
                if(line==null || line == ""){
                    break;
                }

                readLength -= line.getBytes().length;
                lineList.add(MyTrim.structureLineOfCsv(line));
            }

            System.out.println(Thread.currentThread().getName()+"结束了");
            return lineList;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

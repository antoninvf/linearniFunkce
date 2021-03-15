package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Function> arrayList = new ArrayList();

        //Reading
        try {
            BufferedReader br = new BufferedReader(new FileReader("functions.txt"));
            int test = 0;
            String next = br.readLine();
            while (next != null) {
                Function func = new Function();

                String[] dejmitycislanebouvidis = next.substring(4).split(" " + "+");

                func.timesNumber = Integer.parseInt(dejmitycislanebouvidis[0].substring(0, dejmitycislanebouvidis[0].length() - 1));
                func.plusNumber = Integer.parseInt(dejmitycislanebouvidis[2]);
                arrayList.add(func);
                next = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Writing (please i beg you, dont make a 20gb file)
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("count.txt"));

            bw.write(String.valueOf(arrayList.size())); // wtf když tam nedám valueof tak mi to dá 㰮 lmao
            System.out.println("> Written " + '"' + (arrayList.size() + "") + '"');

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int unique = 0;

        //Writing part 2 (praying for the gods of java not filling up my ssd with a 20gb file)
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("count_distinct.txt"));
            for (int i = 0; i < arrayList.size(); i++) {
                int counter = 0;
                int timesNumber = arrayList.get(i).timesNumber;
                int plusNumber = arrayList.get(i).plusNumber;

                for (Function func : arrayList) {
                    int timesNumberfunc = func.timesNumber;
                    int plusNumberfunc = func.plusNumber;

                    if (timesNumber == timesNumberfunc && plusNumber == plusNumberfunc) {
                        counter++;
                    }
                }
                if (counter < 2) {
                    unique++;
                }
            }
            bw.write(String.valueOf(unique));
            System.out.println("> Written " + '"' + unique + '"'); // for testing
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

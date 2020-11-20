package hm2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class choice {
        /*
       
       Todo
        
        */

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] stu = new Student[n];
        for (int i = 0; i < n; i++) {
            Printer.print(String.format("第%d学生信息如下:\n", i + 1));
            stu[i] = new Student();
            String tname = sc.next();
            stu[i].setName(tname);
            int tg = sc.nextInt();
            stu[i].setGrade(tg);
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                String ts = sc.next();
                int ti = sc.nextInt();
                stu[i].setCourses(j, ts, ti);
            }
            stu[i].showMessage();
        }
    }
}

class Printer {
    public static BufferedWriter stdout;

    static {
        stdout = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
    }

    public static void print(String str) throws IOException {
        stdout.write(str);
        stdout.flush();
    }
}

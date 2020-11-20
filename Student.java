package hm2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class choice {
    public static class Course {
        public String getCourseName() {
            return courseName;
        }

        public int getCourseHour() {
            return courseHour;
        }

        public void setCourseHour(int courseHour) {
            this.courseHour = courseHour;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        Course() {
        }

        Course(String cName, int cHour) {
            this.setCourseName(cName);
            this.setCourseHour(cHour);
        }

        private String courseName;
        private int courseHour;

    }

    public static class Student {
        private String name;
        private int grade;
        private Course[] courses;

        public int getHours() {
            int sum = 0;
            for (int i = 0; i < this.courses.length; i++) {
                sum += courses[i].getCourseHour();
            }
            return sum;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setGrade(int grade) {
            this.grade = grade;
            this.courses = new Course[grade];
        }

        public void setCourses(int i, String cName, int hour) {
            this.courses[i] = new Course();
            this.courses[i].setCourseName(cName);
            this.courses[i].setCourseHour(hour);
        }

        public String getName() {
            return name;
        }

        public int getGrade() {
            return grade;
        }

        public Course[] getCourses() {
            return courses;
        }

        public void showMessage() throws IOException {
            Printer.print(String.format("%s %d年级\n选修的课程包括:\n", name, grade));
            for (int i = 0; i < courses.length; i++)
                Printer.print(String.format("(%d)%s\t%d分\n", i + 1, courses[i].getCourseName(), courses[i].getCourseHour()));
            Printer.print(String.format("总学分:%d\n", getHours()));
        }

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

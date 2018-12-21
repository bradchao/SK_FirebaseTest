package tw.brad.sk_firebasetest;

import java.io.Serializable;

public class Student {
    public int ch,math, eng;
    public Student(){
        this(0,0,0);
    }
    public Student(int ch, int math, int eng){
        this.ch = ch;
        this.math = math;
        this.eng = eng;
    }

    public double calScore(){
        return ch + math + eng;
    }

    public  double calAvg(){
        return calScore()/3;
    }
}

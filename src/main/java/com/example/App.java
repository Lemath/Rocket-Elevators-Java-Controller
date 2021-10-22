package com.example;

public class App {
    
    public static void main(String[] args) {
        
        int scenarioNumber = Integer.parseInt(args[0]);
        Scenarios scenarios = new Scenarios();
        scenarios.run(scenarioNumber);

    }

    public static Boolean Contains(int[] s, int e) {
        for (int a : s) {
            if (a == e) {
                return true;
            }
        }
        return false;
    }

    public static int[] RemoveFirstElement(int[] s) {
        int[] a = new int[s.length];
        for (int j = 1; j < s.length; j++) {
            a[j-1] = s[j];
        }
        a[s.length] = 0;
        return a;
    }

    public static int[] Reverse(int[] s) {
        int reverseIndex = s.length -1;
        int[] newArr = new int[s.length];
        for (int i = 0; i <s.length; i++) {
            newArr[i] = s[reverseIndex];
            reverseIndex--;
        }
        return newArr;
    }
}

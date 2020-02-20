package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String c = reader.readLine(),c1;
        c1="the quick brown fox jumps over the lazy dog";
        if(c.equals(""))
            System.out.println(c1);
        else c1=c;
        ArrayList<String> array = pars(c1);
        ArrayList<String> arrayList= new ArrayList<>(sortWordAbc(pars(c1)));
        ArrayList<String> Lists=unical(sortWordAbc(pars(c1)));
        //задание 1
        System.out.println("Lvl 1");
        writeResult(array);
        System.out.println("");
        //
        //задание 2
        System.out.println("Lvl 2");
        writeResult(arrayList);
        System.out.println("");
        //
        //задание 3
        System.out.println("Lvl 3");
        writeResult(Lists);
        System.out.println("");
        //задание 4
        System.out.println("LVL 4");
        Map<String,Integer> map=countS(arrayList);
        for (Map.Entry<String,Integer> pair:map.entrySet()){
            System.out.println(pair.getKey()+" "+pair.getValue());
        }
        System.out.println("");
        //
        //задание 5
        System.out.println("Lvl 5");
        //
        sortMap(map);

    }
    public static void writeResult(ArrayList<String> array) {
        for (String item : array) {
            System.out.println(item);
        }
    }
    //
    //pars(1)
    //
    public static ArrayList<String> pars(String s) {
        String[] words = s.split("\\s+");
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
            arrayList.add(words[i]);
        }
        return arrayList;
    }
    //
    //sortWordAbc(2)
    //
    public static ArrayList<String> sortWordAbc(ArrayList<String> arrayList){
        Collections.sort(arrayList);
        return  arrayList;
    }
    //
    //unical(3)
    public static ArrayList<String> unical(ArrayList<String> List){
        ArrayList<String> result=new ArrayList<>();
        String word1,word2;
        for (int i=0;i<List.size();i++){
            word1=List.get(i);;
            for(int j=i+1;j<List.size();j++){
                word2=List.get(j);
                if(word1.equals(word2)){
                    List.remove(j);
                    j--;
                }
            }
            result.add(word1);
        }
        return result;
    }
    //countS(4)
    //
    public static Map<String,Integer> countS(ArrayList<String> list){
        Map<String,Integer> result=new TreeMap<>();
        String word1,word2;
        int count;
        for (int i=0;i<list.size();i++){
            word1=list.get(i);
            count=1;
            for(int j=i+1;j<list.size();j++){
                word2=list.get(j);
                if(word1.equals(word2)){
                    count++;
                    list.remove(j);
                    j--;
                }
            }
            result.put(word1, count);
        }
        return result;
    }
//
//sortMap(5)
public static void sortMap(Map<String, Integer> Maplist) {
    List<Map.Entry<String,Integer>> map=new ArrayList<Map.Entry<String, Integer>>(Maplist.entrySet());
    map.sort(new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o2.getValue().compareTo(o1.getValue());
        }
    });
    for (Map.Entry<String, Integer> e : map) {
        System.out.println("" + e.getKey() + " " + e.getValue());
    }
}
}



package com.myPhonePad.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * phonePad
 *
 */
public class App
{

    /*A function to check weather the given string is in Ascending order or not*/
    public static boolean isAscending(char[] ip) {
        for (int i = 0; i < ip.length - 1; i++) {
            if (ip[i] < ip[i + 1]) {
                continue;
            } else if (ip[i] > ip[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /*A function to sort the given string in Ascending*/
    public static String sort(String input){
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }


    /*A function to get All the combination from the hashmap declared from the string argument passed to main function*/
    public static CopyOnWriteArrayList<String> combination(char[] input, HashMap<Integer, char[]> hmap, CopyOnWriteArrayList<String> result, int j){
        if(input.length==1){
            for(char chr:hmap.get(Integer.parseInt(String.valueOf(input[0])))){
                result.add(String.valueOf(chr));
            }
            return result;
        }else if(input.length>1){
            if(j<=1){
                for(String each:result){
                    if(each.length()<input.length||each.length()>input.length){
                        result.remove(each);
                    }
                }
                return result;
            }
            for(char chr:hmap.get(Integer.parseInt(String.valueOf(input[0])))){
                result.add(String.valueOf(chr));
            }
            if(j>0){
            for(String res:result){
                for(char chr:hmap.get(Integer.parseInt(String.valueOf(input[j-1])))){
                    result.add(res.concat(String.valueOf(chr)));
                }
            }
            j--;
            combination(input,hmap,result,j);
            }
        }
        return result;
    }

    /*A function to check for all given cases and declaration of phone pad map and calling combination function*/
    public static CopyOnWriteArrayList<String> letterCombinations(String input) {
        HashMap<Integer, char[]> hmap = new HashMap<Integer, char[]>();
        hmap.put(1, new char[]{'a','b','c'});
        hmap.put(2, new char[]{'d','e','f'});
        hmap.put(3, new char[]{'g','h','i'});
        hmap.put(4, new char[]{'j','k','l'});
        hmap.put(5, new char[]{'m','n','o'});
        hmap.put(6, new char[]{'p','q','r'});
        hmap.put(7, new char[]{'s','t','u'});
        hmap.put(8, new char[]{'v','w','x'});
        hmap.put(9, new char[]{'y','z'});

        CopyOnWriteArrayList<String> result = new CopyOnWriteArrayList<String>();

        char[] ipArr = input.toCharArray();


        if(input == null || input.length() == 0) {
            result.add("error no input passed in args");
            return result;
        }else if(input.contains("0")){
            result.add("error the given input should not contain 0");
            return result;
        }if(!isAscending(ipArr)){
            result.add("please pass the input in ascending order");
            return result;
        }if(input.length()>8){
            result.add("the length of the input should be less than or equal to 8");
            return result;
        }
        result = combination(ipArr,hmap,result,ipArr.length);
        return result;
    }

    public static void main(String[] args )
    {
        if(args.length!=0){
            CopyOnWriteArrayList<String> output = letterCombinations(args[0]);
            if(output.size()==1){
                /*Printing the error message in case of any mistake*/
                System.out.println(output.get(0));
            }else {
                /*Sorting all elements of the array*/
                List<String> sorted = new ArrayList<String>();
                for (String each : output) {
                    sorted.add(sort(each));
                }
                /*Sorting the entire collection*/
                Collections.sort(sorted);

                /*Finally writing to the file for given output*/
                try {
                    PrintWriter writer = new PrintWriter(args[0]+".txt", "UTF-8");
                    for(String str:sorted)
                        writer.println(str);
                    writer.close();
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }else{
            System.out.println("No arguement is been passed to the program");
        }
    }
}

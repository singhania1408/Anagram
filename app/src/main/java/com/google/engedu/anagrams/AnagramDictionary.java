package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    HashSet<String> wordSet;
    ArrayList<String> wordList ;
    HashMap<String,ArrayList<String>> lettersToWord;

    public AnagramDictionary(InputStream wordListStream) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        wordList = new ArrayList<String>();
        wordSet=new HashSet<String>();
        lettersToWord=new HashMap<String,ArrayList<String>>();

        while((line = in.readLine()) != null) {
            String word = line.trim();
            //dictionary.add(word);

            //HashMap
            String keyString=sortLetters(word);
            ArrayList<String> list;
            if(lettersToWord.containsKey(keyString))  //if sorted String is already as the key in HashMap
            {
                list=lettersToWord.get(keyString);   //Getting old ArrayList
                list.add(word);                        //adding String to the list
            }
            else
            {
                list=new ArrayList<String>();           //Creating new ArrayList corresponding to KeyString
                list.add(word);
            }
            lettersToWord.put(keyString,list);      //updating HashMap corresponding to the KeyString
            wordSet.add(word);
        }
    }

    public boolean isGoodWord(String word, String base) {
        return true;
    }

    public ArrayList<String> getAnagrams(String targetWord)
    {
        ArrayList<String> result = new ArrayList<String>();
        String compString=sortLetters(targetWord);
        if(lettersToWord.containsKey(compString)) {
            result = lettersToWord.get(compString);
        }
        /*for(int i=0;i<wordList.size();i++)
        {
            String dicString=wordList.get(i);
            if(compString.length()==dicString.length())
            {
                if()
                {
                    result.add(dicString);
                }

            }

        }*/

        return result;
    }
    public String sortLetters(String inputString)
    {
        char[] sorted={};
        char temp;
        int length=inputString.length();
        char[] inputarray=inputString.toCharArray();
        for(int i=0;i<length;i++)
        {
            sorted[i]=inputarray[i];
            for(int j=i+1;j<length;j++)
            {
                if(inputarray[j]<sorted[i])
                {
                   temp=inputarray[j];
                   inputarray[j]=sorted[i];
                   sorted[i]=temp;
                }
            }
        }
        return sorted.toString();
    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }

    public String pickGoodStarterWord() {
        return "stop";
    }
}

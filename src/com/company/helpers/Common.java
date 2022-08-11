package com.company.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
    public static ArrayList<String> readFileAndWriteToList(String fileName) throws IOException {
        FileReader input  = new FileReader(
                fileName);
        BufferedReader bufRead = new BufferedReader(input);
        String st;
        ArrayList<String> fullList = new ArrayList<>();
        while ((st = bufRead.readLine()) != null){
            fullList.add(st.replaceAll("\u0000", ""));
        }
        return fullList;
    }

    public static ArrayList<String> getAllSkillNamesForSpecifiedLvl(ArrayList<String> list, int lvl){
        ArrayList<String> skillNames = new ArrayList<>();
        Pattern pattern = Pattern.compile("skill_name=\\[(.*?)]");
        for (String str : list){
            if (str.contains("get_lv=" + lvl)){
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()){
                    skillNames.add(matcher.group(1));
                }
            }
        }
        return skillNames;
    }

    public static ArrayList<String> removeDuplicatedValuesFromList(ArrayList<String> listToBeCleanedUp) {
        Set<String> set = new HashSet<>(listToBeCleanedUp);
        listToBeCleanedUp.clear();
        listToBeCleanedUp.addAll(set);

        return listToBeCleanedUp;
    }

    public static void writeListToOutputFile(ArrayList<String> listToFile) throws IOException {
        FileWriter writer = new FileWriter("output.txt");
        for(String str: listToFile) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}

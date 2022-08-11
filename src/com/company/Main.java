package com.company;

import java.io.*;
import java.util.ArrayList;

import static com.company.helpers.Common.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> allSkillNames = getAllSkillNamesForSpecifiedLvl(readFileAndWriteToList("skillacquire.txt"), 74);
        writeListToOutputFile(removeDuplicatedValuesFromList(allSkillNames));
    }
}

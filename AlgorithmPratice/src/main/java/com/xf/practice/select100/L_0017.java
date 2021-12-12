package com.xf.practice.select100;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L_0017 {

    public HashMap<Integer, Character[]> init() {
        HashMap<Integer, Character[]> map = new HashMap<>();
        map.put(2, new Character[] {'a', 'b', 'c'});
        map.put(3, new Character[] {'d', 'e', 'f'});
        map.put(4, new Character[] {'g', 'h', 'i'});
        map.put(5, new Character[] {'j', 'k', 'l'});
        map.put(6, new Character[] {'m', 'n', 'o'});
        map.put(7, new Character[] {'p', 'q', 'r', 's'});
        map.put(8, new Character[] {'t', 'u', 'v'});
        map.put(9, new Character[] {'w', 'x', 'y', 'z'});
        return map;
    }

    List<String> ans = new ArrayList<>();
    HashMap<Integer, Character[]> map;
    public List<String> letterCombinations(String digits) {
        int len = digits.length();

        if (len == 0) {
            return new ArrayList<>();
        }

        map = init();
        char[] chs = digits.toCharArray();
        char[] rtn = new char[len];

        dfs(chs, 0, rtn);
        return ans;
    }

    public void dfs(char[] chs, int index, char[] rtn) {
        if (index >= chs.length) {
            ans.add(String.valueOf(rtn));
            return;
        }

        for (Character character : map.get(chs[index] - 48)) {
            rtn[index] = character;
            dfs(chs, index + 1, rtn);
        }
    }

    public static void main(String[] args) {
        L_0017 ins = new L_0017();
        ins.letterCombinations("23");
    }
}

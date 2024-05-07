package com.sky.algorithmleetcode;

/*
所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常
有帮助。 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。   示例： 输入：s = "AAAAACCCCCAAAAACCC
CCCAAAAAGGGTTT" 输出：["AAAAACCCCC", "CCCCCAAAAA"]
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class L187Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s==null || s.length()<10) return result;

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<s.length()-9; i++){
            String seq = s.substring(i, i+10);
            if(map.containsKey(seq)){
                if(map.get(seq)==1) result.add(seq);
                map.put(seq, map.get(seq)+1);
            }else{
                map.put(seq, 1);
            }
        }
        return result;
    }
} 
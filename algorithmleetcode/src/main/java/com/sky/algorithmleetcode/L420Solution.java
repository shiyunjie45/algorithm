package com.sky.algorithmleetcode;

/*
一个强密码应满足以下所有条件：  	由至少6个，至多20个字符组成。 	至少包含一个小写字母，一个大写字母，和一个数字。 	同一字符不能连续出现三次 (比如 "
...aaa..." 是不允许的, 但是 "...aa...a..." 是可以的)。  编写函数 strongPasswordChecker(s)，s 代表输入
字符串，如果 s 已经符合强密码条件，则返回0；否则返回要将 s 修改为满足强密码条件的字符串所需要进行修改的最小步数。 插入、删除、替换任一字符都算作一次修改
。
*/

 class L420Solution {

    public int strongPasswordChecker(String s) {
        int n = s.length(), res = 0, missingType = 3;
        boolean needLower = true, needUpper = true, needDigit = true;
        char[] carr = s.toCharArray();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n;) {
            if (Character.isLowerCase(carr[i])) needLower = false;
            if (Character.isUpperCase(carr[i])) needUpper = false;
            if (Character.isDigit(carr[i])) needDigit = false;
            int j = i;
            while (j < n && carr[j] == carr[i]) j++;
            arr.add(j - i);
            if (j - i >= 3) {
                if (j - i % 3 == 0) res++;
                if (j - i % 3 == 1) res += missingType;
            }
            i = j; // update i after getting the length of same character substring.
        }
        if (n < 6) return Math.max(missingType, 6 - n); // case 1.
        if (n <= 20) return Math.max(missingType, res); // case 2.
        int deleteCount = n - 20, leftOver = deleteCount;
        res += Math.max(0, arr.size() - deleteCount / 3); // delete "groups" times.
        leftOver -= deleteCount % 3;
        deleteCount -= deleteCount % 3;
        // potential cases.
        for(int cnt : arr) {
            int removeSize = cnt - 2;
            if (removeSize <= 0) continue;
            if (leftOver > 0) {
                leftOver -= removeSize % 3 == 0 ? 1 : 0;
                deleteCount--;
            }
            if (leftOver <= 0) {
                res += removeSize / 3;
            }
        }
        // potential edge cases.
        if (leftOver > 0) {
            res += leftOver;
        } else if ((!needLower && needUpper && needDigit) || 
                   (needLower && !needUpper && needDigit) ||
                   (needLower && needUpper && !needDigit)) {
            res += 1;
        } else if (needLower && needUpper && needDigit) {
            res += 2;
        }
        return res;
    }
} 
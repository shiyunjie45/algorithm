package com.sky.algorithmleetcode;

/*
UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：  	对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。 
	对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个
符号的unicode码。  这是 UTF-8 编码的工作方式：   Char. number range |    UTF-8 octet sequence  
  (hexadecimal)  |       (binary)  --------------------+------------------------
---------------------  0000 0000-0000 007F | 0xxxxxxx  0000 0080-0000 07FF | 110
xxxxx 10xxxxxx  0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx  0001 0000-0010
 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx  给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。 注
意: 输入是整数数组。只有每个整数的最低 8 个有效位用来存储数据。这意味着每个整数只表示 1 字节的数据。 示例 1:  data = [197, 130, 
1], 表示 8 位的序列: 11000101 10000010 00000001. 返回 true 。 这是有效的 utf-8 编码，为一个2字节字符，跟着一
个1字节字符。  示例 2:  data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100. 返回 
false 。 前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。 下一个字节是开头为 10 的延续字节，这是正确的。 但第二个延续字节不以 10
 开头，所以是不符合规则的。
*/

 class L393Solution {
    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int c : data) {
            if (count == 0) {
                if ((c >> 5) == 0b110) count = 1;
                else if ((c >> 4) == 0b1110) count = 2;
                else if ((c >> 3) == 0b11110) count = 3;
                else if ((c >> 7) == 0b1) return false; // 首位是1，但没有进入上面三个判断语句，说明不是以10开头的延续字节，返回false
            } else {
                if ((c >> 6) != 0b10) return false; // 不是以10开头的延续字节，返回false
                count--;
            }
        }
        return count == 0; // 如果count不为0，说明有未完整的编码，返回false
    }
} 
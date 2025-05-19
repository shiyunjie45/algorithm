package com.sky.algorithmleetcode;

/*
给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元
素是 emails 表示该帐户的邮箱地址。 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相
同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。 合并帐户后，按以下格式返回帐户：
每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。 例子 1:  Input: accounts = [["
John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"
], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.
com"]] Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@
mail.com'], ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]] Explana
tion:  第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。  第二个 John 和 Mary 是不
同的人，因为他们的电子邮件地址没有被其他帐户使用。  我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'
，'johnnybravo@mail.com']，  ['John'，'john00@mail.com'，'john_newyork@mail.com'，'jo
hnsmith@mail.com']]仍然会被接受。  注意：  	accounts的长度将在[1，1000]的范围内。 	accounts[i]的长度将在[1
，10]的范围内。 	accounts[i][j]的长度将在[1，30]的范围内。
*/

 java.util.*;

public class L721Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 创建一个字典，key为邮箱地址，value为账户邮箱地址列表的索引
        // 用来根据邮箱地址查找所属的账户
        Map<String, Integer> emailToIndex = new HashMap<>();
        int n = accounts.size();    // 账户列表的长度
        int[] parents = new int[n]; // 并查集，用来判断两个账户是否在同一个集合中
        for (int i = 0; i < n; i++) {
            parents[i] = i; // 初始化并查集，每个账户的父节点都是它自己
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);  // 取出账户的邮箱地址
                if (emailToIndex.containsKey(email)) { // 如果这个邮箱地址已经有归属的账户
                    int p = emailToIndex.get(email);   // 取出这个邮箱地址的归属账户索引
                    if (p != i) {   // 如果这个邮箱地址的归属账户和当前账户不是同一个
                        int root1 = find(parents, i);   // 找到当前账户的根节点
                        int root2 = find(parents, p);   // 找到被归属账户的根节点
                        parents[root2] = root1;    // 将被归属账户的根节点挂到当前账户的根节点下面
                    }
                } else {    // 如果这个邮箱地址还没有归属的账户
                    emailToIndex.put(email, i); // 把它加到字典中
                }
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parents, i);    // 找到当前账户的根节点
            List<String> emails = accounts.get(i).subList(1, accounts.get(i).size());
            if (!indexToEmails.containsKey(root)) {
                indexToEmails.put(root, new ArrayList<>());
                indexToEmails.get(root).add(accounts.get(i).get(0));
            }
            indexToEmails.get(root).addAll(emails);    // 把自己和其它账户的邮箱地址合并起来
        }
        List<List<String>> result = new ArrayList<>(indexToEmails.values());    // 把字典中的值列表返回即可
        for (List<String> emailList: result) {
            Collections.sort(emailList.subList(1, emailList.size()));    // 给邮箱地址按字典序排序
        }
        return result;
    }

    private int find(int[] parents, int i) {
        if (parents[i] != i) { // 如果当前节点不是自己的父节点，那么递归查找直到找到自己的根节点
            parents[i] = find(parents, parents[i]);
        }
        return parents[i];  // 返回当前节点的根节点
    }
} 
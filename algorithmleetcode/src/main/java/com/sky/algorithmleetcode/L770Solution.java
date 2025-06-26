package com.sky.algorithmleetcode;

/*
给定一个表达式 expression 如 expression = "e + 8 - a + 5" 和一个求值映射，如 {"e": 1}（给定的形式为 eval
vars = ["e"] 和 evalints = [1]），返回表示简化表达式的标记列表，例如 ["-1*a","14"]  	表达式交替使用块和符号，每个块
和符号之间有一个空格。 	块要么是括号中的表达式，要么是变量，要么是非负整数。 	块是括号中的表达式，变量或非负整数。 	变量是一个由小写字母组成的字符串（不包
括数字）。请注意，变量可以是多个字母，并注意变量从不具有像 "2x" 或 "-x" 这样的前导系数或一元运算符 。  表达式按通常顺序进行求值：先是括号，然后求
乘法，再计算加法和减法。例如，expression = "1 + 2 * 3" 的答案是 ["7"]。 输出格式如下：  	对于系数非零的每个自变量项，我们按字
典排序的顺序将自变量写在一个项中。例如，我们永远不会写像 “b*a*c” 这样的项，只写 “a*b*c”。 	项的次数等于被乘的自变量的数目，并计算重复项。(例
如，"a*a*b*c" 的次数为 4。)。我们先写出答案的最大次数项，用字典顺序打破关系，此时忽略词的前导系数。 	项的前导系数直接放在左边，用星号将它与变量分
隔开(如果存在的话)。前导系数 1 仍然要打印出来。 	格式良好的一个示例答案是 ["-2*a*a*a", "3*a*a*b", "3*b*b", "4*a",
 "5*c", "-6"] 。 	系数为 0 的项（包括常数项）不包括在内。例如，“0” 的表达式输出为 []。    示例： 输入：expression = 
"e + 8 - a + 5", evalvars = ["e"], evalints = [1] 输出：["-1*a","14"] 输入：expression
 = "e - 8 + temperature - pressure", evalvars = ["e", "temperature"], evalints =
 [1, 12] 输出：["-1*pressure","5"] 输入：expression = "(e + 8) * (e - 8)", evalvars = 
[], evalints = [] 输出：["1*e*e","-64"] 输入：expression = "7 - 7", evalvars = [], eva
lints = [] 输出：[] 输入：expression = "a * b * c + b * a * c * 4", evalvars = [], eva
lints = [] 输出：["5*a*b*c"] 输入：expression = "((a - b) * (b - c) + (c - a)) * ((a -
 b) + (b - c) * (c - a))", evalvars = [], evalints = [] 输出：["-1*a*a*b*b","2*a*a*
b*c","-1*a*a*c*c","1*a*b*b*b","-1*a*b*b*c","-1*a*b*c*c","1*a*c*c*c","-1*b*b*b*c"
,"2*b*b*c*c","-1*b*c*c*c","2*a*a*b","-2*a*a*c","-2*a*b*b","2*a*c*c","1*b*b*b","-
1*b*b*c","1*b*c*c","-1*c*c*c","-1*a*a","1*a*b","1*a*c","-1*b*c"]    提示：  	expres
sion 的长度在 [1, 250] 范围内。 	evalvars, evalints 在范围 [0, 100] 内，且长度相同。
*/

 java.util.*;

public class L770Solution {
    Map<String, Integer> map = new HashMap<>();

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        for (int i = 0; i < evalvars.length; i++) {
            map.put(evalvars[i], evalints[i]);
        }

        return parse(expression).toList();
    }

    private Poly make(String expr) {
        Poly res = new Poly();

        List<String> list = new ArrayList<>();
        if (Character.isDigit(expr.charAt(0))) {
            res.add(new Term(map, "", Integer.parseInt(expr)));
            return res;
        }
        list.add("");
        for (char c : expr.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (Character.isLetter(c)) {
                for (int i = 0; i < list.size(); i++) {
                    list.set(i, list.get(i) + c);
                }
            } else {
                if (c == '+' || c == '-') {
                    list.add("" + c);
                    list.add("");
                } else {
                    List<String> tmp = new ArrayList<>();
                    tmp.add("");
                    for (Term term : make(expr.substring(expr.indexOf('(') + 1, findBracketMatch(expr))).terms) {
                        for (String s : list) {
                            tmp.set(tmp.size() - 1, tmp.get(tmp.size() - 1) + s + term.toString());
                            tmp.add(list.get(list.size() - 1));
                        }
                    }
                    list = tmp;
                    expr = expr.substring(findBracketMatch(expr) + 1);
                }
            }
        }
        for (String str : list) {
            res.add(new Term(map, str, 1));
        }

        return res;
    }

    private Poly parse(String expr) {
        List<Poly> buckets = new ArrayList<>();
        List<Character> bucketOps = new ArrayList<>();

        int i = 0;
        while (i < expr.length()) {
            if (expr.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(expr.charAt(i))) {
                int j = i;
                while (j < expr.length() && Character.isDigit(expr.charAt(j))) {
                    j++;
                }
                buckets.add(make(expr.substring(i, j)));
                i = j;
            } else if (Character.isLetter(expr.charAt(i))) {
                int j = i;
                while (j < expr.length() && Character.isLetter(expr.charAt(j))) {
                    j++;
                }
                buckets.add(make(expr.substring(i, j)));
                i = j;
            } else if (expr.charAt(i) == '(') {
                int count = 0, j = i;
                while (j < expr.length()) {
                    if (expr.charAt(j) == '(') {
                        count++;
                    }
                    if (expr.charAt(j) == ')') {
                        count--;
                    }
                    if (count == 0) {
                        break;
                    }
                    j++;
                }
                buckets.add(parse(expr.substring(i + 1, j)));
                i = j + 1;
            } else {
                bucketOps.add(expr.charAt(i));
                i++;
            }

        }
        while (bucketOps.size() > 0) {
            char op = bucketOps.remove(bucketOps.size() - 1);
            Poly b = buckets.remove(buckets.size() - 1);
            Poly a = buckets.remove(buckets.size() - 1);
            if (op == '+') {
                buckets.add(a.add(b));
            } else {
                buckets.add(a.minus(b));
            }
        }

        return buckets.get(0);
    }

    private int findBracketMatch(String expression) {
        int count = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                count++;
            }
            if (expression.charAt(i) == ')') {
                count--;
            }
            if (count == 0) {
                return i;
            }
        }
        return -1;
    }
}

class Term implements Comparable<Term> {
    int c;
    Map<String, Integer> map;

    public Term(Map<String, Integer> map, String expr, int coef) {
        this.c = coef;
        this.map = new HashMap<>();
        if (Character.isLetter(expr.charAt(0))) {
            this.map.put(expr, 1);
        } else {
            this.c *= Integer.parseInt(expr);
        }
    }

    public Term(Map<String, Integer> map, String expr) {
        this(map, expr, 1);
    }

    public Term combine(Term other) {
        if (compareTo(other) != 0) {
            return null;
        }

        return new Term(this.map, "", c + other.c);
    }

    @Override
    public int compareTo(Term other) {
        List<String> l1 = new ArrayList<>(map.keySet());
        List<String> l2 = new ArrayList<>(other.map.keySet());
        Collections.sort(l1);
        Collections.sort(l2);
        int res = Integer.compare(l1.size(), l2.size());
        if (res != 0) {
            return res;
        }
        for (int i = 0; i < l1.size(); i++) {
            res = l1.get(i).compareTo(l2.get(i));
            if (res != 0) {
                return res;
            }
        }

        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (String str : list) {
            sb.append("*");
            sb.append(str);
            if (map.get(str) != 1) {
                sb.append("^");
                sb.append(map.get(str));
            }
        }
        if (c == 0) {
            sb = new StringBuilder();
        } else if (c != 1 || sb.length() == 0) {
            sb.insert(0, c);
        }

        return sb.toString();
    }
}

class Poly {
    List<Term> terms;

    public Poly() {
        terms = new ArrayList<>();
    }

    public void add(Term a) {
        for (int i = 0; i < terms.size(); i++) {
            Term tmp = terms.get(i).combine(a);
            if (tmp != null) {
                terms.set(i, tmp);
                return;
            }
        }
        terms.add(a);
    }

    public Poly add(Poly other) {
        Poly res = new Poly();
        res.terms.addAll(terms);
        for (Term term : other.terms) {
            res.add(term);
        }
        return res;
    }

    public Poly minus(Poly other) {
        Poly res = new Poly();
        res.terms.addAll(terms);
        for (int i = 0; i < other.terms.size(); i++) {
            Term tmp = other.terms.get(i);
            res.add(new Term(tmp.map, "", -tmp.c));
        }
        return res;
    }

    public List<String> toList() {
        List<String> res = new ArrayList<>();
        List<Term> sortedTerms = new ArrayList<>(terms);
        sortedTerms.removeIf(t -> t.c == 0);
        Collections.sort(sortedTerms, Collections.reverseOrder());
        for (Term term : sortedTerms) {
            res.add(term.toString());
        }
        return res;
    }
} 
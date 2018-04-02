package com.company;

import java.math.BigDecimal;
import java.util.*;

/**
 * OnMachineDemo
 */
public class OnMachineDemo {

    /**
     * 1
     *
     * @author BoyJeffrey
     * @category 字符串操作
     * 输入一串数据，删除重复的数据。注意：读取字符串的顺序为从右往左，如果结果为0结束，则删除0；
     * 如果结果为负号‘-’就保留；
     * 例如：输入99876673 输出37689，输入 0542564 输出:4652 输入：-235432 输出：-2345
     */
    public static void string_reverse_filter() {
        System.out.println("请输入待反转-去重-过滤的字符串:");
        Scanner scanner = new Scanner(System.in);
        String data_input = scanner.nextLine();
        System.out.println("输入的字符串:" + data_input);
        StringBuffer sb = new StringBuffer(data_input).reverse();
        StringBuffer sb_result = new StringBuffer();
        char[] char_reverse = sb.toString().toCharArray();
        for(char c : char_reverse) {
            if (sb_result.indexOf(c + "") == -1)
                sb_result.append(c);
        }
        String data_result = sb_result.toString();
        if(data_result.endsWith("0"))
            data_result = data_result.substring(0, data_result.length());
        System.out.println("处理后字符串:" + data_result);

    }

    /**
     * 2
     *
     * @author
     * @category 邮箱合法性检验；
     * 邮箱地址合法性检验，合法输出字符“1”，不合法输出字符“0”
     * 合法条件：
     * 1 仅包含一个@。
     * 2 最后三位必须是“.com”.
     * 3 字符直接之间没有空格。
     * 4 有效数字是1~9，a~z、A~Z "." "@","-";
     */
    public static void emailTest() {
        System.out.println("请输入待验证的邮箱:");
        Scanner scanner = new Scanner(System.in);
        String data_input = scanner.nextLine();
        System.out.println("输入的字符串:" + data_input);
        boolean flag = data_input.matches("^[0-9a-zA-Z-]+@[0-9a-zA-Z]+\\.com$");
        if(flag)
            System.out.println("邮箱合法,flag:" + 1);
        else
            System.out.println("邮箱非法,flag:" + 0);
    }

    /**
     * 3
     *
     * @author
     * @category 分苹果
     * 有m个苹果分到n个相同的篮子里。允许有的篮子为空，一共有多少种分发？
     * 其中:0<=m<=10,0<=n<=10;
     * 如:输入7 3 结果为8
     */
    public static void shareApple() {
        System.out.println("请分别输入苹果数和篮子数目:");
        Scanner scanner = new Scanner(System.in);
        int num_apple = scanner.nextInt();
        int num_basket = scanner.nextInt();
        System.out.println("输入的苹果数和篮子数目:" + num_apple + "   " + num_basket);
        System.out.println(recursiveShareApple(num_apple, num_basket));
    }

    /**
     * 功能描述:
     *
     * 〈〉
     * 限制条件 recursiveShareApple(a,b) = recursiveShareApple(a-b,b) + recursiveShareApple(a,b-1);如果a<b ---> recursiveShareApple(a,b)=recursiveShareApple(a,a)
     * @return:
     * @since: 1.0.0
     * @Author:Jeffrey
     * @Date: 2018/4/2 14:14
     */
    private static int recursiveShareApple(int num_apple, int num_basket) {
        if(num_apple < 0 || num_basket <= 0)
            return 0;
        if(num_apple == 0 || num_basket == 1) //
            return 1;
        else if(num_apple < num_basket)
            return recursiveShareApple(num_apple, num_apple);
        else
            return recursiveShareApple(num_apple - num_basket, num_basket) + recursiveShareApple(num_apple, num_basket - 1);
    }

    /**
     * 4
     *
     * @author
     * @category 字符串反转
     * 输入一个字符。交换前后顺序后在输出。
     */
    public static void stringReverse() {
        System.out.println("请待反转字符串:");
        Scanner scanner = new Scanner(System.in);
        String data_input = scanner.nextLine();
        System.out.println("您输入的字符串为:" + data_input);
        System.out.println("反转后的字符串:" + new StringBuffer(data_input).reverse().toString());
    }

    /**
     * 5
     *
     * @author
     * @category 成绩运算
     * 输入一个同学各科的高考成绩，计算出他的成绩和平均分，共四门课程，每个成绩范围
     * 0-150，超过范围则不计算在总分内 （但科目永远是四门）*
     */
    public static void scoreCalculate() {
        String[] score_arr = null;
        // 等待输入正确的4位高考成绩
        while(true) {
            System.out.println("请输入4门科目高考成绩,以逗号隔开:");
            Scanner scanner = new Scanner(System.in);
            String data_input = scanner.nextLine();
            System.out.println("您输入的字符串为:" + data_input);
            score_arr = data_input.trim().split(",");
            if(score_arr.length != 4) {
                System.out.println("输入有误...");
            }else
                break;
        }
        double score_total = 0; // 总成绩
        double score_average = 0; // 平均成绩
        for(String s : score_arr) {
            double score = Double.valueOf(s);
            if(score >= 0 && score <= 150) {
                score_total += score;
            }
        }
        System.out.println("该同学总成绩为:" +score_total + ";平均成绩为:" + score_total/4 );

    }

    /**
     * 6
     *
     * @author
     * @category 数列求和
     * 编写程序，输入一个正整数n，求下列算式的值。要求定义和调用函数fack(k)来计算
     * k的阶乘，函数返回值类型是double。
     * 1+1/2+...+1/n!
     * 输出保留5位小数。
     * 例子：
     * 输入:5
     * 输出:2.71667
     */
    public static void sequenceSum() {
        double result = 0;
        System.out.println("请输入正整数n:");
        Scanner scanner = new Scanner(System.in);
        int data_input = scanner.nextInt();
        System.out.println("您输入的字符串为:" + data_input);
        for(int i = 1; i <= data_input; i++) {
            result += 1/factorial(i);
        }
        System.out.println("该数列值为:" + new BigDecimal(result).setScale(5,BigDecimal.ROUND_HALF_UP));

    }

    /**
     * 功能描述:
     * 递归计算阶乘
     * 〈〉
     * @param
     * @return:
     * @since: 1.0.0
     * @Author:Jeffrey
     * @Date: 2018/4/2 15:05
     */
    private static double factorial(int n) {
        if(n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    /**
     * 7
     *
     * @author
     * @category 字符串操作；
     * 程序实现目标：输入一个字符串，将其中各个字符对应的ASCll值加5后，输出结果。
     * 程序要求：该字符串只包括小写字母，若他的值加5后大于’z‘,将其转换成从a开始的字符；
     */
    public static void charReverse() {
        char[] char_arr = null;
        while(true) {
            System.out.println("请输入待转换字符串:");
            Scanner scanner = new Scanner(System.in);
            String data_input = scanner.nextLine();
            System.out.println("您输入的字符串为:" + data_input);
            char_arr = data_input.toCharArray();
            // 校验字符串必须为小写字母
            boolean flag = data_input.matches("^[a-z]+$");
            if(! flag)
                System.out.println("只能输入小写字母...");
            else
                break;
        }
        // 转换字符
        int length = char_arr.length;
        for(int i = 0; i < length; i++) {
            int c = (int)char_arr[i] + 5;
            if(c > (int)'z') {
                c = c - (int) 'z' + (int) 'a' - 1;
            }
            char_arr[i] = (char) c;
        }
        System.out.println("转换后字符串:" + new String(char_arr));
    }

    /**
     * 8
     *
     * @author
     * @category 数组操作问题
     * 求一个整形数组中的元素的平均值，并统计其中大于和小于平均值的元素个数。
     * 要求：
     * 输入：整形数组中的元素个数及各个元素。
     * 输出：整型数组中元素的平均值，大于和小于此平均值的元素个数。
     */
    public static void averageStatistics() {
        System.out.println("请输入待输入的整形数组中元素个数:");
        Scanner scanner = new Scanner(System.in);
        int data_input = scanner.nextInt();
        System.out.println("待输入元素个数为:" + data_input);
        int[] int_arr = new int[data_input];
        for(int i = 1; i <= data_input; i++) {
            System.out.println("输入第" + i + "个数组元素:");
            int_arr[i -1] = scanner.nextInt();
            System.out.println(int_arr[i - 1]);
        }
        double avg = 0; // 平均值
        int total = 0;
        for(int i : int_arr)
            total += i;
        avg = total / data_input;
        int count_less = 0; // 小于平均值个数
        int count_bigger = 0; // 大于平均值个数
        for(int i : int_arr)
            if(i > avg)
                count_bigger++;
            else if(i < avg)
                count_less++;
        System.out.println("该整形数组平均值:" + avg + ";大于平均值个数:" + count_bigger + ";小于平均值个数:" + count_less);

    }

    /**
     * 9
     *
     * @author
     * @category 回文数字判断
     * 有这样一类数字，他们顺着看和倒着看是相同的数，例如121，656，2332等，
     * 这样的数字称为：回文数字。编写一个函数，判断某数字是否是回文数字。
     * 要求实现方法：
     * public String isPalindrome(String strln);
     * 输入：strln：整数，以字符串表示；
     * 输出：true :表示是回文；
     * false:表示不是回文；
     * 注意：只需要完成函数的算法功能，中间不需要有任何io的输入输出流
     * 例子：
     * 输入：strln=121
     * 输出：true
     */
    private static void palindromeAdjust() {
        System.out.println("请输入待判断是否为回文的字符串:");
        Scanner scanner = new Scanner(System.in);
        String data_input = scanner.nextLine();
        System.out.println("输入的字符串为:" + data_input);
        if(new StringBuffer(data_input).reverse().toString().equals(data_input))
            System.out.println("该字符串符合回文规则:true");
        else
            System.out.println("该字符串不符合回文规则:false");
    }

    /**
     * 10
     *
     * @author
     * @category 字符串操作
     * 随即打印50个随即（4-10长度）的字符串，要求字符串包含范围是所有的英文字母无论大小写包，
     * 含所有的数字，按照编码顺序排序，每次打印4个，要求首字母对齐；
     */
    public static void printRandomCharacters() {
        Set<String> set = new TreeSet<>();
        for(int i = 1; i <= 50; i++) {
            set.add(getRandomString());
        }
        int count = 1;
        for(String s : set) {
            if(count % 4 == 0)
                System.out.println(s);
            else
                System.out.print(s.substring(0,10) + "\t");
            count++;
        }
    }

    private static String getRandomString() {
        Random random = new Random();
        int len = random.nextInt(7) + 4;
        char[] char_arr = new char[len];
        for(int i = 0; i < len; i++) {
            int choose_type = random.nextInt(3);
            if(choose_type == 0) // 小写字母
                char_arr[i] = (char)((int)'a' + random.nextInt(26));
            else if(choose_type == 1) //大写字母
                char_arr[i] = (char)((int)'A' + random.nextInt(26));
            else
                char_arr[i] = (char)(random.nextInt(10) + '0');
        }
        return new String(char_arr) + "      ";
    }

    /**
     * 11
     *
     * @author
     * @category 字符串操作；
     * 题目：已知：：yi  er san  si  wu liu qi ba  jiu 分别对应123456789，
     * 对一段只含有这种字符的字符串进行转换，例如：
     * 输入：yiersansan
     * 输出:1233
     * 要求实现方法：
     * public String trunNumber(String data){
     * //TODO
     * return  "";
     * }
     */
    public static void trunNumber() {
        StringBuffer sb_result = new StringBuffer();
        Map<String, Integer> map = new HashMap<>();
        map.put("yi", 1);
        map.put("er", 2);
        map.put("san", 3);
        map.put("si", 5);
        map.put("liu", 6);
        map.put("qi", 7);
        map.put("ba", 8);
        map.put("jiu", 9);
        System.out.println("请输入相关字符串,以逗号隔开:");
        Scanner scanner = new Scanner(System.in);
        String data_input = scanner.nextLine();
        System.out.println("您输入的字符串为:" + data_input);
        String[] str_arr = data_input.split(",");
        for(String s : str_arr)
            sb_result.append(map.get(s) == null ? "" : map.get(s));
        System.out.println("对应的字符转换value为:" + sb_result.toString());
    }

    /**
     * 12
     *
     * @author
     * @category 字符串操作
     * 手动输入一个字符串，仅限于小写字母，统计并输出在每个字符在字符串中出现的次数，并输出。提示（）
     * 可以使用Map）
     * 实例：aaabbbccc
     * 输出：a3
     * b3
     * c3
     */
    public static void characterStatistics() {
        String data_input = "";
        while(true) {
            System.out.println("请输入待统计小写字母的字符串");
            Scanner scanner = new Scanner(System.in);
            data_input = scanner.nextLine();
            System.out.println("您输入的字符串为:" + data_input);
            boolean flag = data_input.matches("^[a-z]+$");
            if(! flag)
                System.out.println("只能输入小写字母...");
            else
                break;
        }
        // 统计字母数
        Map<Character, Integer> char_statistic = new HashMap<>();
        char[] char_arr = data_input.toCharArray();
        for(char c : char_arr) {
            if(char_statistic.containsKey(c))
                char_statistic.put(c, char_statistic.get(c) + 1);
            else
                char_statistic.put(c, 1);
        }
        for(Map.Entry<Character, Integer> entry : char_statistic.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

    /**
     * 13
     *
     * @author
     * @category 字符串操作
     * 输入：a aa,cat tiger.123dd 输出：tiger
     * 功能描述：键盘输入一句话输出一句话中最长的单词，如果最长的出现多次，返回第一个。
     * 这句话只包含数字字母和标点。
     */
    public static void findLongestWord() {
        System.out.println("请输入待查找首个最长字符长度的字符串");
        Scanner scanner = new Scanner(System.in);
        String data_input = scanner.nextLine();
        System.out.println("您输入的字符串为:" + data_input);
        String[] string_arr = data_input.split("[\\.\\, ]");
        int len_max = 0;
        String result = ""; // 目标字符串
        for(String s : string_arr) {
            if(s.length() > len_max) {
                len_max = s.length();
                result = s;
            }
        }
        System.out.println("该字符串中最长的字符串为:" + result + ";长度为:" + len_max);
    }


    /**
     * 14
     *
     * @author
     * @category 字符串操作
     * 将字符串中的字母全部替换成该字母的下一个字母，要是最后一位是z或者Z则替换为a或者A。
     * 输入：aBxyZ
     * 输出：bCyzA
     */
    public static void replaceNextLetter() {
        System.out.println("请输入待转换的字符串");
        Scanner scanner = new Scanner(System.in);
        String data_input = scanner.nextLine();
        System.out.println("您输入的字符串为:" + data_input);
        char[] char_arr = data_input.toCharArray();
        int len = char_arr.length;
        for(int i = 0; i< len; i++) {
            //TODO 尚需补充是否为字母判断
            if(char_arr[i] == 'z')
                char_arr[i] = 'a';
            else if(char_arr[i] == 'Z')
                char_arr[i] = 'A';
            else
                char_arr[i] = (char)(char_arr[i] + 1);
        }
        System.out.println("字符串中字母替换后:" + new String(char_arr));
    }

    /**
     * 15
     * @author
     * @category 字符串操作
     * 删除字符串中字符出现次数最少的字符，最少的要全部删除然后返回该字符串；
     * 输入：asdasdas
     * 返回：asasas
     */
    public static void deleteLeastCharacters() {
        System.out.println("请输入待删除qizho9ng最少字符数目的字符串");
        Scanner scanner = new Scanner(System.in);
        String data_input = scanner.nextLine();
        System.out.println("您输入的字符串为:" + data_input);
        // 先统计各字符个数
        List<Character> character_list = new ArrayList<>();
        char[] char_arr = data_input.toCharArray();
        Map<Character, Integer> char_statistics_map = new HashMap<>();
        for(char c : char_arr) {
            if(char_statistics_map.containsKey(c))
                char_statistics_map.put(c, char_statistics_map.get(c) + 1);
            else
                char_statistics_map.put(c, 1);
        }
        // 从map中找出最少数目的字符,如果存在相同的,都放入最少字符数目的字符列表中
        int len = data_input.length();
        for(Map.Entry<Character, Integer> entry : char_statistics_map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if(value < len) {
                // 新的最少数目字符出现,清空下统计list
                character_list.clear();
                // 放入list
                character_list.add(key);
                len = value; // 最少数目统计改变
            } else if(value == len) {
                character_list.add(key);
            }
        }
        // 删除最少数目的字符
        for(Character c : character_list)
            data_input = data_input.replace(c + "", "");
        System.out.println("删除最少数目字符后:" + data_input);
    }

    public static void main(String[] args) {
//        OnMachineDemo.string_reverse_filter();
//        OnMachineDemo.emailTest();
//        OnMachineDemo.shareApple();
//        OnMachineDemo.stringReverse();
//        OnMachineDemo.scoreCalculate();
//        OnMachineDemo.sequenceSum();
//        OnMachineDemo.charReverse();
//        OnMachineDemo.averageStatistics();
//        OnMachineDemo.palindromeAdjust();
//        OnMachineDemo.printRandomCharacters();
//        OnMachineDemo.trunNumber();
//        OnMachineDemo.characterStatistics();
//        OnMachineDemo.findLongestWord();
//        OnMachineDemo.replaceNextLetter();
        OnMachineDemo.deleteLeastCharacters();

    }
}

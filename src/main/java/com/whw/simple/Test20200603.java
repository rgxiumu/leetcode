package com.whw.simple;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * TODO
 *
 * @author wuhongwei
 * @version 1.0
 * @date 2020/6/3
 */
public class Test20200603 {

    public static void main(String[] args) {
//        System.out.println(isPalindrome(11211));
//        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
//        System.out.println(isValid("([)]"));

//        strStr("hello","ll");
//         pivotIndex(new int[]{1,7,3,6,5,6});

//        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
//        firstMissingPositive(new int[]{0});
//        minDeletionSize(new String[]{"ca","bb","ac"});
//        int i = totalFruit(new int[]{1,0,1,4,1,4,1,2,3});
//        wiggleSort(new int[]{3,5,2,1,6,4});
//        matrixReshape(new int[][]{{1,2},{3,4}}, 1, 4);
        findLongestWord("wordgoodgoodgoodbestword" ,Arrays.asList(new String[]{"word","good","best","good"}));
    }


    /**
     * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
     * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
     *
     * @param s
     * @param d
     * @return
     */
    public static String findLongestWord(String s, List<String> d) {

        if(d.size()==0){
            return "";
        }

        String result = "";
        int length = 0;
        for (String s1 : d) {
           int i = 0;
           int j = 0;
           while(i<s1.length() && j<s.length()) {
               if (s1.charAt(i) == s.charAt(j)) {
                   i++;
                   j++;
               } else {
                   j++;
               }
           }
           if(i>=s1.length()){
               if(length < s1.length()) {
                   length = s1.length();
                   result = s1;
               }else if(length == s1.length()){
                   for (int k = 0; k < length; k++) {
                       if(result.charAt(k) > s1.charAt(k)){
                           result = s1;
                           break;
                       }else if(result.charAt(k) < s1.charAt(k)){
                           break;
                       }
                   }
               }
           }
        }
        return result;
    }
    /**
     * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
     *
     * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
     *
     * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和
     *
     * @param employees
     * @param id
     * @return
     */
    public static int getImportance(List<Employee> employees, int id) {

        int sum = 0;
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).id == id){
                if(employees.get(i).subordinates != null && employees.get(i).subordinates.size() > 0) {
                    for (int i1 = 0; i1 < employees.get(i).subordinates.size(); i1++) {
                        sum += getImportance(employees, employees.get(i).subordinates.get(i1));
                    }
                }
                sum += employees.get(i).importance;
                return sum;
            }
        }

        return sum;

    }

    /**
     * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     *
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
     *
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
     *
     * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {

        int row = nums.length;
        if(row == 0){
            return nums;
        }
        int columns = nums[0].length;

        if(row * columns != r * c){
            return nums;
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int index = columns * i + j;
                int rowIndex = index / c;
                int columnIndex = index % c;
                result[rowIndex][columnIndex] = nums[i][j];
            }
        }
        return result;
    }

    /**
     * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。
     * 例如，在数组{5, 8, 6, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
     *
     * @param nums
     */
    public static void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if(i % 2 == 0){
                if(nums[i] > nums[i - 1]){
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }else {
                if(nums[i] < nums[i - 1]){
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }
        }
    }

    /**
     * 返回与给定的前序和后序遍历匹配的任何二叉树。
     *
     *  pre 和 post 遍历中的值是不同的正整数。
     *
     *  我们知道，在前序遍历的时候，根节点是第一个输出，而在后序遍历中，根节点是最后一个输出；
     *
     * 那么我们可以利用前序遍历来构建Tree，然后通过后续遍历来检验当前树是否构建完毕。
     *
     * 首先我们创建一个节点作为 root，root = TreeNode(pre[preIndex])当 root.val == post[posIndex]时, 意味着我们已经构建完毕了当前子树，如果当前子树没有构建完毕，那么我们就递归的构建左右子树。
     *
     * @param pre
     * @param post
     * @return
     */
    int preIndex = 0;
    int postIndex = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if(root.val != post[postIndex]){
            root.left = constructFromPrePost(pre, post);
        }
        if(root.val != post[postIndex]){
            root.right = constructFromPrePost(pre, post);
        }
        postIndex++;
        return root;
    }

    /**
     * 给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。
     * @param nums
     * @return
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {


        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            count += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); j++) {
                Integer key = i + j;
                if(!map.containsKey(key)){
//                    map.put(key, new LinkedList<>());
                }
                map.get(key).add(nums.get(i).get(j));
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (Integer integer : map.keySet()) {
            List<Integer> linkedList = map.get(integer);
            for (int i = linkedList.size() - 1; i >= 0 ; i--) {
                result[index] = linkedList.get(i);
                index++;
            }
        }

        return result;
    }

    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ch =  strs[i].toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!map.containsKey(key)){
//                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
    /**
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {

        int diff = 0;
        if(first.length() == second.length()){
            for (int i = 0; i < first.length(); i++) {
                if(first.charAt(i) != second.charAt(i)){
                    diff++;
                }
            }
        }else if(Math.abs(first.length() - second.length()) == 1){
            int n = Math.min(first.length(), second.length());
            for (int i = 0; i < n; i++) {
                if(first.charAt(i) != second.charAt(i)){
                   if(first.substring(i).equalsIgnoreCase(second.substring(i+1))){
                       return true;
                   }else if(first.substring(i+1).equalsIgnoreCase(second.substring(i))){
                       return true;
                   }else {
                       return false;
                   }
                }
            }
        }else {
            return false;
        }
        if(diff < 2){
            return true;
        }

        return false;
    }

    /**
     * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
     * 你可以从你选择的任何树开始，然后重复执行以下步骤：
     *
     * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
     * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
     * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
     *
     * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
     * 用这个程序你能收集的水果总量是多少？
     *
     * @param tree
     * @return
     */
    public static int totalFruit(int[] tree) {

        int one = tree[0];
        int two = -1;
        int begin = 0;
        int end = 0;
        for (int i = 1; i < tree.length; i++) {
            if(one != tree[i]){
                two = tree[i];
                end = i;
                break;
            }
        }
        if(two < 0){
            return tree.length;
        }
        int result = 0;
        while(end<tree.length){

            if(tree[end] != one && tree[end] != two){
                result = Math.max(result, end - begin);
                one = tree[end-1];
                two = tree[end];
                begin = end - 1;
                while (begin >0 && one == tree[begin-1]){
                    begin--;
                }
            }
            end++;
        }

        return Math.max(result, end - begin);
    }


    /**
     * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
     *
     * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
     *
     * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
     *
     * @param distance
     * @param start
     * @param destination
     * @return
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int length = distance.length;
        int all = 0;
        int needLength = 0;
        for (int i = 0; i < length; i++) {
            all += distance[i];
        }

        if(start <= destination) {
            for (int i = start; i < destination; i++) {
                needLength += distance[i];
            }
        }else {
            for (int i = destination; i <start ; i++) {
                needLength += distance[i];
            }
        }

        return Math.min(needLength, all - needLength);

    }
    /**
     * 请你编写一个程序来计算两个日期之间隔了多少天。
     *
     * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
     * @param date1
     * @param date2
     * @return
     */
    public int daysBetweenDates(String date1, String date2) {

        return (int)LocalDate.parse(date1).until(LocalDate.parse(date2), ChronoUnit.DAYS);
    }
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     *
     * @param root
     * @param p
     * @param q
     * @return
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root != null){
            if(root.val < p.val && root.val < q.val){
                return lowestCommonAncestor(root.right, p, q);
            }
            if(root.val > p.val && root.val > q.val){
                return lowestCommonAncestor(root.left, p ,q);
            }
        }
        return root;

    }
    /**
     * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
     *
     * 选取一个删除索引序列，对于 A 中的每个字符串，删除对应每个索引处的字符。
     *
     * 比如，有 A = ["abcdef", "uvwxyz"]，删除索引序列 {0, 2, 3}，删除后 A 为["bef", "vyz"]。
     *
     * 假设，我们选择了一组删除索引 D，那么在执行删除操作之后，最终得到的数组的元素是按 字典序（A[0] <= A[1] <= A[2] ... <= A[A.length - 1]）排列的，然后请你返回 D.length 的最小可能值。
     *
     * @param A
     * @return
     */
    public static int minDeletionSize(String[] A) {

        int count = 0;
        int length = A[0].length();
        String[] curr = new String[A.length];
        boolean flag;
        for (int i = 0; i <length; i++) {
            flag = true;
            for (int i1 = 0; i1 < A.length - 1; i1++) {
                if(A[i1].charAt(i) > A[i1+1].charAt(i)){

                    if(curr[i1] != null && curr[i1].compareTo(curr[i1+1]) < 0){
                        continue;
                    }

                    System.out.println(i);
                    count++;
                    flag = false;
                    break;
                }
            }
            if(flag){
                for (int i1 = 0; i1 < A.length; i1++) {
                    curr[i1] = curr[i1]==null ? ""+A[i1].charAt(i) : curr[i1]+A[i1].charAt(i);
                }

            }

        }

        return count;
    }

    /**
     * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
     *
     * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
     *
     * @param t1
     * @param t2
     * @return
     */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {

        if(t1 == null ){
            return t2 == null;
        }

        return isSame(t1, t2)|| checkSubTree(t1.left, t2)|| checkSubTree(t1.right, t2);
    }

    public boolean isSame(TreeNode t1, TreeNode t2) {

        if(t1 == null && t2 == null){
            return true;
        }

        if(t1 != null && t2 != null) {
            if (t1.val == t2.val) {
                return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
            }
        }
        return false;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        // TODO: 2020/6/9
        return 0;
    }

    /**
     * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
     *
     * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
     *
     * 请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
     *
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int length = startTime.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(startTime[i]<= queryTime && endTime[i] >= queryTime){
                count++;
            }
        }
        return count;
    }

    /**
     * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
     *
     * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.length() > magazine.length()){
            return false;
        }

       int[] caps = new int[26];
        for (char c : ransomNote.toCharArray()){
            int index = magazine.indexOf(c, caps[c - 97]);
            if(index == -1){
                return false;
            }
            caps[c - 97] = index + 1;
        }
        return true;
    }

    /**
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff ^= nums[i];
        }

        diff = Integer.highestOneBit(diff);
        int[] result = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            if((diff & nums[i]) == 0){
                result[0] ^= nums[i];
            }else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x){

        List<Integer> num = new ArrayList<>();
        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }
        int startNum = x;
        while (x >= 10){
            int z = x % 10;
            x = x / 10;
            num.add(z);
        }
        num.add(x);
        int result=0;
        for (Integer integer : num) {
            result = result*10+integer;
        }
        if(result == startNum){
            return true;
        }
        return false;
    }


    /**
     * 给定一个罗马数字，将其转换成整数
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int nextNum = getValue(s.charAt(i));
            if(preNum < nextNum){
                sum -= preNum;
            }else {
                sum += preNum;
            }
            preNum = nextNum;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch){
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0){
            return "";
        }
        if(strs[0].length() == 0){
            return "";
        }
        String prefix = "";
        char pp = strs[0].charAt(0);


        boolean flag = true;
        for (int i = 0; i < strs[0].length(); i++) {
            for (String str : strs) {
                if(str.length() > i && str.charAt(i) == pp){

                }else {
                    flag = false;
                }
            }
            if(flag) {
                prefix = prefix.concat(String.valueOf(pp));
                if(i + 1 >= strs[0].length()){
                    break;
                }
                pp = strs[0].charAt(i+1);
            }else {
                break;
            }
        }
        return prefix;
    }


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if(s.length()%2 != 0){
            return false;
        }
        char[] ch = s.toCharArray();
        Deque<String> deque = new LinkedList<>();
        HashSet<String> endSet = new HashSet<>();
        endSet.add(")");
        endSet.add("}");
        endSet.add("]");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(")","(");
        hashMap.put("}","{");
        hashMap.put("]","[");
        for (int i = 0; i < ch.length; i++) {
            String str = String.valueOf(ch[i]);
            if(endSet.contains(str)){
                String targetStr = hashMap.get(str);
                String lastStr = deque.pollLast();
                if(!targetStr.equalsIgnoreCase(lastStr)){
                    return false;
                }
            }else {
                deque.addLast(str);
            }
        }
        if(deque.size() == 0){
            return true;
        }
        return false;
    }


    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode end = result;
        while (l1 != null || l2 != null) {
            if(l1 == null){
                result.next = l2;
                break;
            }else if(l2 == null){
                result.next =  l1;
                break;
            }else if(l1.val > l2.val) {
                result.next =  new ListNode(l2.val);
                l2 = l2.next;
            } else {
                result.next =  new ListNode(l1.val);
                l1 = l1.next;
            }
            result = result.next;
        }

        return end.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val > l2.val){
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }else {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
    }

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){ return 0;}
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[k] != nums[i]){
                k++;
                nums[k] = nums[i];
            }
        }
        return k+1;
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @param val
     * @return
     */

    public int removeElement(int[] nums, int val) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;

    }


    /**
     * 实现 strStr() 函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.equalsIgnoreCase("")){
            return 0;
        }
        int length = needle.length();
        int end = haystack.length();
        for (int i = 0; i <= end-length; i++) {
            String temp = haystack.substring(i, i+length);
            if(temp.equalsIgnoreCase(needle)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
     *
     * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     *
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        int tempSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if(tempSum == sum - tempSum - nums[i]){
                return i;
            }
            tempSum += nums[i];
        }
        return  -1;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
     *
     * 找到所有出现两次的元素。
     *
     * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                result.add(Math.abs(index+1));
            }
            nums[index] = -nums[index];
        }
        return result;
    }


    /**
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     *
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     *
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] - i != 1){
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void swap(int[] nums, int index1, int index2){
        if(index1 == index2){
            return;
        }

        nums[index1] = nums[index1] + nums[index2];

        nums[index2] = nums[index1] - nums[index2];

        nums[index1] = nums[index1] - nums[index2];
    }


    /**
     * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {

        if(nums.length == 1){
            return nums[0] == 1 ? 2 : 1;
        }

        boolean flag = true;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                flag = false;
            }
            if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }

        if(flag){
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }

        return nums.length + 1;
    }


    /**
     * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
     *
     * 请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
     *
     * 注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {

        int[] arr = new int[101];
        for (int i = 0; i < heights.length; i++) {
            arr[heights[i]]++;
        }
        int count = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            while(arr[i] > 0){
                if(i != heights[j]){
                    count++;
                }
                j++;
                arr[i]--;
            }
        }
        return count;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
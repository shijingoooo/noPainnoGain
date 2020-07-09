package com.shijing.nopainnogain.algorithm.array;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 * <p>
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *
 * @description:
 * @author: shijing
 * @create: 2020-07-08 22:06
 **/
public class CountCharacters {
    public static void main(String[] args) {
        CountCharacters c = new CountCharacters();
        String[] words1 = new String[]{"cat", "bt", "hat", "tree"};
        String chars1 = "atach";
        System.out.println(c.count(words1, chars1));

        words1 = new String[]{"hello", "world", "leetcode"};
        chars1 = "welldonehoneyr";
        System.out.println(c.count(words1, chars1));

    }

    public int count(String[] words, String chars) {
        int length = 0;
        int[] charArr = new int[26];
        // chars中字母计数
        for (char c : chars.toCharArray()) {
            charArr[c - 'a'] += 1;
        }

        a:
        for (String word : words) {
            int[] temp = new int[26];
            for (char c : word.toCharArray()) {
                temp[c - 'a'] += 1;
            }

            for (int i = 0; i < 26; i++) {
                if (temp[i] > charArr[i]) {
                    continue a;
                }
            }

            length += word.length();
        }
        return length;
    }
}

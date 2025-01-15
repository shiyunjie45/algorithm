package com.sky.algorithmleetcode;

/*
TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它
将返回一个简化的URL http://tinyurl.com/4e9iAk. 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法
。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
*/

 java.util.HashMap;

public class L535Solution {
    private static final String PREFIX = "http://tinyurl.com/";
    private HashMap<String, String> urlToTinyMap = new HashMap<>();
    private HashMap<String, String> tinyToUrlMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlToTinyMap.containsKey(longUrl)) {
            return urlToTinyMap.get(longUrl);
        }
        String key = PREFIX + urlToTinyMap.size();
        urlToTinyMap.put(longUrl, key);
        tinyToUrlMap.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyToUrlMap.getOrDefault(shortUrl, null);
    }
} 
package com.sky.algorithmleetcode;

/*
你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本
都是错的。 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。 你可以通过调用 bool isBadVersi
on(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。 示例
: 给定 n = 5，并且 version = 4 是第一个错误的版本。 调用 isBadVersion(3) -> false 调用 isBadVersion
(5) -> true 调用 isBadVersion(4) -> true 所以，4 是第一个错误的版本。
*/

 class L278Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 调用 isBadVersion() 接口的具体实现，此处为父类中抽象方法，需要子类实现
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
} 
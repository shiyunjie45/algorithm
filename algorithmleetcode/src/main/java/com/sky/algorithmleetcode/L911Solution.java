package com.sky.algorithmleetcode;

/*
在选举中，第 i 张票是在时间为 times[i] 时投给 persons[i] 的。 现在，我们想要实现下面的查询函数： TopVotedCandidate.
q(int t) 将返回在 t 时刻主导选举的候选人的编号。 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。 示
例： 输入：["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,1
5,20,25,30]],[3],[12],[25],[15],[24],[8]] 输出：[null,0,1,1,0,0,1] 解释： 时间为 3，票数分布情况
是 [0]，编号为 0 的候选人领先。 时间为 12，票数分布情况是 [0,1,1]，编号为 1 的候选人领先。 时间为 25，票数分布情况是 [0,1,1,0
,0,1]，编号为 1 的候选人领先（因为最近的投票结果是平局）。 在时间 15、24 和 8 处继续执行 3 个查询。    提示：  	1 	0 	time
s 是严格递增的数组，所有元素都在 [0, 10^9] 范围中。 	每个测试用例最多调用 10000 次 TopVotedCandidate.q。 	TopVo
tedCandidate.q(int t) 被调用时总是满足 t >= times[0]。
*/

 java.util.*;

class TopVotedCandidate {
    private int[] times;
    private int[] winnerAtTime;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int[] votesByPerson = new int[persons.length];
        int maxVotes = 0;
        winnerAtTime = new int[persons.length];
        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];
            votesByPerson[person] = votesByPerson[person] + 1;
            if (votesByPerson[person] >= maxVotes) {
                maxVotes = votesByPerson[person];
                winnerAtTime[i] = person;
            } else {
                winnerAtTime[i] = winnerAtTime[i - 1];
            }
        }
    }

    public int q(int t) {
        int index = Arrays.binarySearch(times, t);
        if (index < 0) {
            index = -(index + 1) - 1;
        }
        return winnerAtTime[index];
    }
} 
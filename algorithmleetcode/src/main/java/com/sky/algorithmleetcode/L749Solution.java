package com.sky.algorithmleetcode;

/*
病毒扩散得很快，现在你的任务是尽可能地通过安装防火墙来隔离病毒。 假设世界由二维矩阵组成，0 表示该区域未感染病毒，而 1 表示该区域已感染病毒。可以在任意 2
 个四方向相邻单元之间的共享边界上安装一个防火墙（并且只有一个防火墙）。 每天晚上，病毒会从被感染区域向相邻未感染区域扩散，除非被防火墙隔离。现由于资源有限，每
天你只能安装一系列防火墙来隔离其中一个被病毒感染的区域（一个区域或连续的一片区域），且该感染区域对未感染区域的威胁最大且保证唯一。 你需要努力使得最后有部分区域
不被病毒感染，如果可以成功，那么返回需要使用的防火墙个数; 如果无法实现，则返回在世界被病毒全部感染时已安装的防火墙个数。   示例 1： 输入: grid =
 [[0,1,0,0,0,0,0,1], [0,1,0,0,0,0,0,1], [0,0,0,0,0,0,0,1], [0,0,0,0,0,0,0,0]] 输出
: 10 说明: 一共有两块被病毒感染的区域: 从左往右第一块需要 5 个防火墙，同时若该区域不隔离，晚上将感染 5 个未感染区域（即被威胁的未感染区域个数为 
5）; 第二块需要 4 个防火墙，同理被威胁的未感染区域个数是 4。因此，第一天先隔离左边的感染区域，经过一晚后，病毒传播后世界如下: [[0,1,0,0,0,
0,1,1], [0,1,0,0,0,0,1,1], [0,0,0,0,0,0,1,1], [0,0,0,0,0,0,0,1]] 第二题，只剩下一块未隔离的被感
染的连续区域，此时需要安装 5 个防火墙，且安装完毕后病毒隔离任务完成。  示例 2： 输入: grid = [[1,1,1], [1,0,1], [1,1,1
]] 输出: 4 说明: 此时只需要安装 4 面防火墙，就有一小区域可以幸存，不被病毒感染。 注意不需要在世界边界建立防火墙。   示例 3: 输入: grid
 = [[1,1,1,0,0,0,0,0,0], [1,0,1,0,1,1,1,1,1], [1,1,1,0,0,0,0,0,0]] 输出: 13 说明: 在隔
离右边感染区域后，隔离左边病毒区域只需要 2 个防火墙了。    说明:  	grid 的行数和列数范围是 [1, 50]。 	 grid[i][j] 只包含 
0 或 1 。 	题目保证每次选取感染区域进行隔离时，一定存在唯一一个对未感染区域的威胁最大的区域。
*/

 class L749Solution {
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int containVirus(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        while (true) {
            boolean[][] visited = new boolean[m][n];
            PriorityQueue<Area> areas = new PriorityQueue<>();
            List<Wall> walls = new ArrayList<>();

            // 找出所有感染区域
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        Area area = new Area(i, j, visited);
                        areas.offer(area);
                        walls.addAll(area.walls);
                    }
                }
            }

            // 所有感染区域都被隔离
            if (areas.isEmpty()) break;

            // 隔离威力最大的感染区域
            Area areaToIsolate = areas.poll();
            ans += areaToIsolate.isolate();

            // 病毒扩散
            for (Area area: areas) area.spread();
        }
        return ans;
    }

    class Area implements Comparable<Area>{
        int row; // 区域所在行
        int col; // 区域所在列
        int threats; // 该区域对未感染区域的威胁值
        List<Wall> walls; // 隔离感染区域的隔离墙
        boolean[][] visited; // 记录该区域已经访问的位置

        public Area(int row, int col, boolean[][] visited) {
            this.row = row;
            this.col = col;
            this.visited = visited;
            this.threats = 0;
            this.walls = new ArrayList<>();
            dfs(row, col);
        }

        // 深度优先遍历找到该感染区域
        public void dfs(int row, int col) {
            if (visited[row][col])
                return;

            visited[row][col] = true;
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < visited.length &&
                        newCol >= 0 && newCol < visited[0].length) {
                    if (visited[newRow][newCol]) continue;
                    if (grid[newRow][newCol] == 1) dfs(newRow, newCol);
                    else {
                        walls.add(new Wall(newRow, newCol, this));
                        this.threats++;
                    }
                }
            }
        }

        // 隔离该感染区域, 返回隔离的墙数
        public int isolate() {
            for (Wall wall : walls) {
                grid[wall.row][wall.col] = 2; // 隔离, 标记为2
            }
            return walls.size();
        }

        // 病毒扩散
        public void spread() {
            List<Area> neighbors = new ArrayList<>();
            for (Wall wall : walls) {
                int r = wall.row;
                int c = wall.col;
                for (int[] direction : directions) {
                    int newRow = r + direction[0];
                    int newCol = c + direction[1];
                    if (newRow >= 0 && newRow < visited.length &&
                            newCol >= 0 && newCol < visited[0].length &&
                            !visited[newRow][newCol]) {
                        if (grid[newRow][newCol] == 1) {
                            neighbors.add(new Area(newRow, newCol, visited));
                            visited[newRow][newCol] = true;
                        } else if (grid[newRow][newCol] == 0) {
                            grid[newRow][newCol] = 1; // 感染
                        }
                    }
                }
            }

            // 更新感染区域的威胁值
            for (Area neighbor : neighbors) {
                for (Wall wall : neighbor.walls) {
                    if (this.walls.contains(wall)) {
                        this.threats--;
                        break;
                    }
                }
            }
        }

        @Override
        public int compareTo(Area o) {
            return o.threats - this.threats;
        }
    }

    class Wall {
        int row;
        int col;
        Area area; // 该隔离墙隔离的区域

        public Wall(int row, int col, Area area) {
            this.row = row;
            this.col = col;
            this.area = area;
        }
    }
} 
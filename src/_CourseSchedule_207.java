import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        if (prerequisites.length == 0) return true;
        int[] inDegrees = new int[numCourses];
        for (int[] cp : prerequisites)
        {
            inDegrees[cp[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegrees.length; i++)
        {
            if (inDegrees[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty())
        {
            int curr = queue.poll();
            numCourses--;
            for (int[] cp : prerequisites)
            {
                if (cp[1] != curr) continue;
                if (--inDegrees[cp[0]] == 0) queue.offer(cp[0]);
            }
        }

        return numCourses == 0;
    }

//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[][] adjacency = new int[numCourses][numCourses];
//        int[] flags = new int[numCourses];
//        for(int[] cp : prerequisites)
//            adjacency[cp[1]][cp[0]] = 1;
//        for(int i = 0; i < numCourses; i++){
//            if(!dfs(adjacency, flags, i)) return false;
//        }
//        return true;
//    }
//    private boolean dfs(int[][] adjacency, int[] flags, int i) {
//        if(flags[i] == 1) return false;
//        if(flags[i] == -1) return true;
//        flags[i] = 1;
//        for(int j = 0; j < adjacency.length; j++) {
//            if(adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) return false;
//        }
//        flags[i] = -1;
//        return true;
//    }
}

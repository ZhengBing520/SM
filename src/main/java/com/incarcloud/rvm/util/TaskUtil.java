package com.incarcloud.rvm.util;

import com.incarcloud.concurrent.LimitedTask;
import com.incarcloud.concurrent.PerfMetric;
import com.incarcloud.concurrent.TaskTracking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TaskUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(TaskUtil.class);

    /**
     * 输出性能简报
     * @param task 输出该任务的性能简报
     * @param msMax 长时间任务临界值,毫秒.执行时间超过此临界值的任务被视为长时间任务.如果是0或负值,不输出长时间任务
     * @param title 标题
     * @return 性能简报。运行频率(Hz)每秒执行多少个任务|正在执行中的任务数|正在等待中的任务数|已经执行完成的任务数<br>
     *                  执行完成的任务运行时间统计：平均耗时(秒)|最小耗时(毫秒)|最大耗时(毫秒)<br>
     *                  执行完成的任务等待时间比诸：平均耗时(秒)|最小耗时(毫秒)|最大耗时(毫秒)
     */
    public static String printMetric(LimitedTask task, long msMax, String title){
        try {
            StringBuilder sbBuf = new StringBuilder();
            PerfMetric<Long> metric = task.queryPerfMetric();

            int running = task.getRunning();
            int waiting = task.getWaiting();
            long finished = metric.getFinishedTask();
            if(running > 0 || waiting > 0 || finished > 0){
                sbBuf.append(String.format("-----%s-----\n" +
                                "Perf: %6.2f Hz | Running: %d | Waiting: %d | Finished: %d\n" +
                                "Running avg:%6.3fs | min:%4dms | max:%4dms\n" +
                                "Waiting avg:%6.3fs | min:%4dms | max:%4dms\n" +
                                "-----%s-----",
                        title,
                        task.queryPerf(),
                        running,
                        waiting,
                        finished,

                        metric.getPerfRunning().getAvg() / 1000.0f,
                        (Long)(metric.getPerfRunning().getMin() == null ? -1L:metric.getPerfRunning().getMin()),
                        (Long)(metric.getPerfRunning().getMax() == null ? -1L:metric.getPerfRunning().getMax()),

                        metric.getPerfWaiting().getAvg() / 1000.0f,
                        (Long)(metric.getPerfWaiting().getMin() == null ? -1L:metric.getPerfWaiting().getMin()),
                        (Long)(metric.getPerfWaiting().getMax() == null ? -1L:metric.getPerfWaiting().getMax()),
                        title.replaceAll(".", "+")
                ));

                if(msMax > 0){
                    List<TaskTracking> tracks = task.scanForLongTimeTask(msMax);
                    long tmNow = System.currentTimeMillis();
                    if(tracks != null){
                        sbBuf.append("\nlong time task(s):");
                        tracks.forEach((track)->{
                            float fT = (tmNow - track.getExecTM()) / 1000.0f;
                            sbBuf.append(String.format("\n%8.3fs %s", fT, track.getTask()));
                        });
                    }
                }

                return sbBuf.toString();
            }
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("TaskUtil printMetric error!", e);
        }

        return null;
    }
}

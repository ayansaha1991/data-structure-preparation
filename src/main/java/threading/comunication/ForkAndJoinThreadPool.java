package threading.comunication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkAndJoinThreadPool {
    public static void main(String[] args) {




    }
}

class CustomRecursiveAction extends RecursiveAction {

    private String workload;
    private static final int TH = 2;

    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length() > 2) {
            List<CustomRecursiveAction> subTasks = createSubTask(workload);
            ForkJoinTask.invokeAll(createSubTask(workload));
        } else {
            process(workload);
        }
    }

    private void process(String workload) {
        System.out.println(workload.toUpperCase());
    }



    private List<CustomRecursiveAction> createSubTask(String workload) {

        int length = workload.length();
        String firstTask = workload.substring(0, length / 2);
        String secondTask = workload.substring(length / 2, length);
        ArrayList<RecursiveAction> recursiveActions = new ArrayList<>();
        return List.of(new CustomRecursiveAction(firstTask), new CustomRecursiveAction(secondTask));
    }
}

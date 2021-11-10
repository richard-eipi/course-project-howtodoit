package helpers;

import entities.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class puts a map of tasks into a sorted list based on due date.
 */
public class ChronologicalSort {
    public static List<Task> tasks_in_ch_order(HashMap<String, Task> map) {
        List<Task> list_to_return = new ArrayList<>();
        for (String name : map.keySet()) {
           add_task_to_list(list_to_return, map.get(name));
        }
        return list_to_return;
    }

    private static void add_task_to_list(List<Task> list, Task newtask) {
        for (Task task : list) {
            if (LocalDate.parse(newtask.getDueDate()).isBefore(LocalDate.parse(task.getDueDate()))) {
                list.add(list.indexOf(task), newtask);
                return;
            }
        }
        list.add(newtask);
    }
}


package com.babak.scrumify.task.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.babak.scrumify.task.model.Task;
import com.babak.scrumify.task.model.TaskStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Babak Vahidi
 */
@Controller
public class ScrumifyController {

    private static final AtomicLong taskIdGenerator = new AtomicLong(0);
    private static final ConcurrentSkipListMap<Long, Task> taskRepository = new ConcurrentSkipListMap<Long, Task>();

    @RequestMapping(value = "/task", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Task> list() {
        return new ArrayList<Task>(taskRepository.values());
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Task getById(@PathVariable long id) {
        return taskRepository.get(id);
    }

    @RequestMapping(value = "/task", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@RequestBody Task task) {
    	if(task.getId() != null) {
            taskRepository.put(task.getId(), task);
            return;
    	}
        long id = taskIdGenerator.incrementAndGet();
        task.setId(id);
        task.setStatus(TaskStatus.TODO);
        taskRepository.put(id, task);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        taskRepository.remove(id);
    }

}

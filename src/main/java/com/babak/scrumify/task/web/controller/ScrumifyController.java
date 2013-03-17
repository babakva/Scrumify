package com.babak.scrumify.task.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.babak.scrumify.task.model.Task;

/**
 * @author Babak Vahidi
 */
@Controller
public class ScrumifyController {

    private static final AtomicLong taskIdGenerator = new AtomicLong(0);
    private static final Map<Long, Task> taskRepository = new HashMap<Long, Task>();

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
    	Assert.notNull(task);
    	Assert.hasText(task.getTitle());
        long id = taskIdGenerator.incrementAndGet();
        task.setId(id);
        taskRepository.put(id, task);
    }
    

    @RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable long id, @RequestBody Task task) {
    	Assert.notNull(id);
    	taskRepository.put(id, task);
    }
    
        

    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        taskRepository.remove(id);
    }

}

package org.marta.workers;

import org.marta.dbservice.daoimplementation.Statistics;
import org.marta.dbservice.entities.Worker;
import org.marta.dbservice.service.WorkersService;
import org.marta.price.SalaryStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;


@Controller
public class WorkersController
{
    @Autowired
    private WorkersService workersService;

    @Autowired
    private Statistics statistics;

    @RequestMapping(value = "/workers")
    public String rules(Model model)
    {
        model.addAttribute("worker", new Worker());
        model.addAttribute("workers", workersService.getWorkers());
        model.addAttribute("salaryStatisticsList", statistics.getSalaryStatistics());
        model.addAttribute("salaryStatistics", new SalaryStatistics());
        return "workers/workers";
    }

    @RequestMapping(value = "/add-worker", method = RequestMethod.GET)
    public String addWorker(Model model)
    {
        return "workers/addworker";
    }

    @RequestMapping(value = "/add-worker", method = RequestMethod.POST)
    public String addWorkerPost(@ModelAttribute Worker worker)
    {
        workersService.addWorker(worker);
        return "redirect:/workers";
    }

    @RequestMapping(value = "/edit-worker/{id}", method = RequestMethod.GET)
    public String editWorker(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("worker", workersService.selectWorker(id));
        return "workers/editworker";
    }

    @RequestMapping(value = "/edit-worker/{id}", method = RequestMethod.POST)
    public String editWorkerPost(@ModelAttribute Worker worker, @PathVariable("id") int id)
    {
        worker.setId((long)id);
        workersService.updateWorker(worker);
        return "redirect:/workers";
    }

    @RequestMapping(value = "/delete-worker/{id}", method = RequestMethod.GET)
    public String deleteWorker(@PathVariable("id") long id) throws SQLException
    {
        workersService.deleteWorker(id);
        return "redirect:/workers";
    }

}

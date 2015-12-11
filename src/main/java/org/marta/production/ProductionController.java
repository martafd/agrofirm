package org.marta.production;

import org.marta.dbservice.daoimplementation.Statistics;
import org.marta.dbservice.entities.Field;
import org.marta.dbservice.entities.Plant;
import org.marta.dbservice.service.FieldService;
import org.marta.dbservice.service.PlantService;
import org.marta.price.CultureStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by marta on 04.11.15.
 */
@Controller
public class ProductionController
{
    @Autowired
    private FieldService fieldService;
    @Autowired
    private PlantService plantService;
    @Autowired
    private Statistics statistics;

    @RequestMapping(value = "/production")
    public String production(Model model)
    {
        model.addAttribute("plant", new CultureOutput());
        model.addAttribute("plants", plantService.outputPlantsData());
        model.addAttribute("cultureStatistics", new CultureStatistics());
        model.addAttribute("cultureStatisticsList", statistics.getCultureStatistics());
        return "production/production";
    }

    @RequestMapping(value = "/add-culture", method = RequestMethod.GET)
    public String addCulture(Model model)
    {
        model.addAttribute("field", new Field());
        model.addAttribute("fields", fieldService.listFields());
        return "production/addculture";
    }

    @RequestMapping(value = "/add-culture", method = RequestMethod.POST)
    public String addCulturePost(@ModelAttribute Plant plant, @ModelAttribute("field") int fieldId)
    {
        fieldService.addPlant(plant, fieldId);
        return "redirect:/production";
    }


}

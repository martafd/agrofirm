package org.marta.price;

import org.marta.dbservice.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by marta on 31.10.15.
 */
@Controller
@ComponentScan("org.marta.price")
public class PriceController
{
    @Autowired
    private StatisticsService statisticsService;
    @RequestMapping(value = "/price", method = RequestMethod.GET)
    public String price(Model model)
    {
        model.addAttribute("statisticsUnit", new SpendStatistic());
        model.addAttribute("statisticsList", statisticsService.getSpendStatistic());
        return "price/price";
    }
}

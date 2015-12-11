package org.marta.dbservice.service;

import org.marta.dbservice.daointerface.IStatistics;
import org.marta.price.SpendStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marta on 08.12.15.
 */
@Service
@Configuration
@ComponentScan("org.dav1nci.dbservice")
public class StatisticsService implements IStatisticsService
{
    @Autowired
    private IStatistics statistics;

    @Override
    public List<SpendStatistic> getSpendStatistic() {
        return statistics.getSpendStatistic();
    }
}

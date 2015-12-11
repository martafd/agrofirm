package org.marta.dbservice.daointerface;

import org.marta.dbservice.entities.TechOperation;
import org.marta.price.CultureStatistics;
import org.marta.price.SalaryStatistics;
import org.marta.price.SpendStatistic;

import java.util.List;

/**
 * Created by marta on 08.12.15.
 */
public interface IStatistics
{
    List<SpendStatistic> getSpendStatistic();
    List<SalaryStatistics> getSalaryStatistics();
    List<CultureStatistics> getCultureStatistics();
}

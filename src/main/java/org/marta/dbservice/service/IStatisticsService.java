package org.marta.dbservice.service;

import org.marta.price.SpendStatistic;

import java.util.List;

/**
 * Created by marta on 08.12.15.
 */
public interface IStatisticsService
{
    List<SpendStatistic> getSpendStatistic();
}

package org.marta.dbservice.service;

import org.marta.dbservice.entities.Plant;
import org.marta.production.CultureOutput;

import java.util.List;

/**
 * Created by marta on 08.12.15.
 */
public interface IPlantService
{
    void addPlant(Plant plant);
    List<CultureOutput> outputPlantsData();
    void updatePlant(Plant plant);
    void deletePlant(int id);
}

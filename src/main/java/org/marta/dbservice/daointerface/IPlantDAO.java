package org.marta.dbservice.daointerface;

import org.marta.dbservice.entities.Plant;
import org.marta.production.CultureOutput;

import java.util.List;

/**
 * Created by marta on 08.12.15.
 */
public interface IPlantDAO
{
    List<CultureOutput> outputPlantData();
    void updatePlant(Plant plant);
    void deletePlant(int id);
}


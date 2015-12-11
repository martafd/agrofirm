package org.marta.dbservice.service;

import org.marta.dbservice.daointerface.IPlantDAO;
import org.marta.dbservice.entities.Plant;
import org.marta.production.CultureOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by marta on 08.12.15.
 */
@Service
@Configuration
@ComponentScan("org.dav1nci.dbservice")
public class PlantService implements IPlantService
{
    @Autowired
    private IPlantDAO plantDAO;

    @Transactional
    @Override
    public void addPlant(Plant plant) {

    }

    @Transactional
    @Override
    public List<CultureOutput> outputPlantsData() {
        return plantDAO.outputPlantData();
    }

    @Transactional
    @Override
    public void updatePlant(Plant plant) {

    }

    @Transactional
    @Override
    public void deletePlant(int id) {

    }
}

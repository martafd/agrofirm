package org.marta.dbservice.service;

import org.marta.dbservice.daointerface.IFieldDAO;
import org.marta.dbservice.entities.Field;
import org.marta.dbservice.entities.Plant;
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
public class FieldService implements IFieldService
{
    @Autowired
    private IFieldDAO fieldDAO;

    @Transactional
    @Override
    public Field getField(int id) {
        return fieldDAO.getField(id);
    }

    @Transactional
    @Override
    public List<Field> listFields() {
        return fieldDAO.listFields();
    }

    @Transactional
    @Override
    public void addPlant(Plant plant, int fieldId) {
        fieldDAO.addPlant(plant, fieldId);
    }



}

package org.marta.dbservice.service;

import org.marta.dbservice.entities.Field;
import org.marta.dbservice.entities.Plant;

import java.util.List;

/**
 * Created by marta on 08.12.15.
 */
public interface IFieldService
{
    Field getField(int id);
    List<Field> listFields();
    void addPlant(Plant plant, int fieldId);
}

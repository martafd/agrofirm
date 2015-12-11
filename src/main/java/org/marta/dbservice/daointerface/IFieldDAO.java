package org.marta.dbservice.daointerface;

import org.marta.dbservice.entities.Field;
import org.marta.dbservice.entities.Plant;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by marta on 07.12.15.
 */
public interface IFieldDAO
{
    Field getField(int id);
    List<Field> listFields();
    void addPlant(Plant plant, int fieldId);
    void updateField(int fieldId, int plantId);
}

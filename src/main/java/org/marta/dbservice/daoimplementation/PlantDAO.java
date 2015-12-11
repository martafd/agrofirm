package org.marta.dbservice.daoimplementation;

import org.marta.dbservice.daointerface.IPlantDAO;
import org.marta.dbservice.entities.Field;
import org.marta.dbservice.entities.Plant;
import org.marta.production.CultureOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marta on 08.12.15.
 */
@Repository
@EnableTransactionManagement
public class PlantDAO implements IPlantDAO
{
    @Autowired
    private DataSource dataSource;

    @Override
    public List<CultureOutput> outputPlantData() {
        final String SQL_SELECT = "SELECT plants.culture_name, plants.sort_name, fields.id, fields.area FROM plants INNER JOIN fields ON fields.culture_id = plants.id";
        List<CultureOutput> cultureOutputList = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT)
        )
        {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                CultureOutput cultureOutput = new CultureOutput();
                cultureOutput.setCulture(resultSet.getString(1));
                cultureOutput.setSort(resultSet.getString(2));
                cultureOutput.setFieldNumber(resultSet.getInt(3));
                cultureOutput.setFieldArea(resultSet.getDouble(4));
                cultureOutputList.add(cultureOutput);
            }
        }catch (SQLException e){System.out.println(e);}
        return cultureOutputList;
    }

    @Override
    public void updatePlant(Plant plant) {

    }

    @Override
    public void deletePlant(int id) {
    }
}

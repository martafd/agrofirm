package org.marta.dbservice.daoimplementation;

import org.marta.dbservice.daointerface.IFieldDAO;
import org.marta.dbservice.entities.Field;
import org.marta.dbservice.entities.Plant;
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
public class FieldDAO implements IFieldDAO
{
    @Autowired
    private DataSource dataSource;

    @Override
    public Field getField(int id) {
        return null;
    }

    @Override
    public List<Field> listFields() {
        final String SQL_SELECT = "SELECT * FROM fields WHERE is_occupied = 0";
        List<Field> fields = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT)
        )
        {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Field field = new Field();
                field.setId(resultSet.getInt(1));
                field.setArea(resultSet.getDouble(2));
                field.setIsOccupied(resultSet.getInt(3) != 0);
                field.setPlant(null);
                fields.add(field);
            }
        }catch (SQLException e){System.out.println(e);}
        return fields;
    }

    @Override
    public void addPlant(Plant plant, int fieldId) {
        final String SQL_INSERT = "INSERT INTO plants (id, culture_name, sort_name) VALUES (nextval('hibernate_sequence'), ?, ?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id"})
        ) {
            statement.setString(1, plant.getCultureName());
            statement.setString(2, plant.getSortName());
            if (statement.executeUpdate() > 0)
            {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (null != generatedKeys && generatedKeys.next())
                {
                    long id = generatedKeys.getLong(1);
                    updateField(fieldId, (int)id);
                }
            }
        }
        catch (SQLException e){
            System.out.println(e);}
    }

    @Override
    public void updateField(int fieldId, int plantId) {
        final String SQL_UPDATE = "UPDATE fields SET culture_id = ?, is_occupied = 1 WHERE id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)
        ) {
            statement.setInt(1, plantId);
            statement.setInt(2, fieldId);

            if (statement.executeUpdate() < 0)
                System.out.println("ERROR WITH UPDATE STATEMENT.");
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}

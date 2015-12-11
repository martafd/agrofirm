package org.marta.dbservice.daoimplementation;

import org.marta.dbservice.daointerface.IWorkerDAO;
import org.marta.dbservice.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marta on 07.12.15.
 */
@Repository
@EnableTransactionManagement
public class WorkerDAO implements IWorkerDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public void addWorker(Worker worker) {
        final String SQL_INSERT = "INSERT INTO workers (id, name_surname, qualification, work_hours, money_per_hour) VALUES (nextval('hibernate_sequence'), ?, ?, ?, ?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id"})
        ) {
            statement.setString(1, worker.getNameSurname());
            statement.setString(2, worker.getQualification());
            statement.setInt(3, worker.getWorkHours());
            statement.setDouble(4, worker.getMoneyPerHour());

            if (statement.executeUpdate() > 0) {

                // getGeneratedKeys() returns result set of keys that were auto
                // generated
                // in our case student_id column
                ResultSet generatedKeys = statement.getGeneratedKeys();

                // if resultset has data, get the primary key value
                // of last inserted record
                if (null != generatedKeys && generatedKeys.next()) {

                    long id = generatedKeys.getLong(1);
                    System.out.println(id);
                }

            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public Worker selectWorker(int id) {
        final String SQL_SELECT = "select * from workers WHERE id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT)
        )
        {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Worker worker = new Worker();
                worker.setId(resultSet.getLong(1));
                worker.setNameSurname(resultSet.getString(2));
                worker.setQualification(resultSet.getString(3));
                worker.setWorkHours(resultSet.getInt(4));
                worker.setMoneyPerHour(resultSet.getDouble(5));
                return worker;
            }
        }catch (SQLException e){System.out.println(e);}
        return null;
    }

    @Override
    public void updateWorker(Worker worker) {
        final String SQL_UPDATE = "UPDATE workers SET name_surname = ?, qualification = ?, work_hours = ?, money_per_hour = ? WHERE id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)
        ) {
            statement.setString(1, worker.getNameSurname());
            statement.setString(2, worker.getQualification());
            statement.setInt(3, worker.getWorkHours());
            statement.setDouble(4, worker.getMoneyPerHour());
            statement.setInt(5, (int)worker.getId());

            if (statement.executeUpdate() < 0) {

                System.out.println("ERROR WITH UPDATE STATEMENT.");

            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteWorkerById(long id) throws SQLException
    {
        final String SQL_DELETE = "DELETE FROM workers WHERE id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_DELETE)
        ) {
            statement.setInt(1, (int)id);
            int out = statement.executeUpdate();

            if (statement.executeUpdate() < 0) {

                throw new SQLException("Error with deleting object with id = " + id);

            }
        }
        /*catch (SQLException e){
            System.out.println(e);
        }*/
    }

    @Override
    public List<Worker> listWorkers() {
        final String SQL_SELECT = "select * from workers";
        List<Worker> workers = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT)
        )
        {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Worker worker = new Worker();
                worker.setId(resultSet.getLong(1));
                worker.setNameSurname(resultSet.getString(2));
                worker.setQualification(resultSet.getString(3));
                worker.setWorkHours(resultSet.getInt(4));
                worker.setMoneyPerHour(resultSet.getDouble(5));
                workers.add(worker);
            }
        }catch (SQLException e){System.out.println(e);}
        return workers;
    }

}

package org.marta.dbservice.daoimplementation;

import org.marta.dbservice.daointerface.IStatistics;
import org.marta.price.CultureStatistics;
import org.marta.price.SalaryStatistics;
import org.marta.price.SpendStatistic;
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
public class Statistics implements IStatistics
{
    @Autowired
    private DataSource dataSource;

    @Override
    public List<SpendStatistic> getSpendStatistic() {
        final String SQL_SELECT = "SELECT tech_operations.month, SUM(tech_operations.fuel_consumption*fields.area) " +
                "FROM tech_operations " + "INNER JOIN tech_card ON tech_operations.id = tech_card.tech_operation_id " +
                "INNER JOIN plants ON tech_card.plant_id= plants.id " + "INNER JOIN fields ON plants.id = fields.culture_id " +
                "GROUP BY tech_operations.month ";
        List<SpendStatistic> spendStatisticOutputList = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT)
        )
        {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                SpendStatistic spendStatistic = new SpendStatistic();
                spendStatistic.setMonth(resultSet.getString(1));
                spendStatistic.setSpendMoney(resultSet.getDouble(2));
                spendStatisticOutputList.add(spendStatistic);
            }
        }catch (SQLException e){System.out.println(e);}
        return spendStatisticOutputList;
    }

    @Override
    public List<SalaryStatistics> getSalaryStatistics() {
        final String SQL_SELECT = "SELECT workers.qualification, SUM(workers.money_per_hour * workers.work_hours) FROM workers GROUP BY workers.qualification";
        List<SalaryStatistics> salaryStatisticsArrayList = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT)
        )
        {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                SalaryStatistics salaryStatistics = new SalaryStatistics();
                salaryStatistics.setQualification(resultSet.getString(1));
                salaryStatistics.setAvgMoneyPerHour(resultSet.getDouble(2));
                salaryStatisticsArrayList.add(salaryStatistics);
            }
        }catch (SQLException e){System.out.println(e);}
        return salaryStatisticsArrayList;
    }

    @Override
    public List<CultureStatistics> getCultureStatistics() {
        final String SQL_SELECT = "SELECT plants.culture_name, tech_operations.operation_name " +
                "FROM plants " +
                "LEFT JOIN tech_card ON plants.id = tech_card.plant_id " +
                "INNER JOIN tech_operations ON tech_operations.id = tech_card.tech_operation_id";
        List<CultureStatistics> cultureStatisticsList = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT)
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CultureStatistics cultureStatistics = new CultureStatistics();
                cultureStatistics.setCulture(resultSet.getString(1));
                cultureStatistics.setTechOperation(resultSet.getString(2));
                cultureStatisticsList.add(cultureStatistics);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cultureStatisticsList;
    }
}

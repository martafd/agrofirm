package org.marta.dbservice.service;

import org.marta.dbservice.daointerface.IWorkerDAO;
import org.marta.dbservice.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by marta on 07.12.15.
 */
@Service
@Configuration
@ComponentScan("org.dav1nci.dbservice")
public class WorkersService implements IWorkerService
{
    @Autowired
    private IWorkerDAO workersDAO;

    @Transactional
    public void addWorker(Worker worker)
    {
        workersDAO.addWorker(worker);
    }

    @Transactional
    public List<Worker> getWorkers()
    {
        return workersDAO.listWorkers();
    }

    @Transactional
    public void deleteWorker(long id) throws SQLException
    {
        workersDAO.deleteWorkerById(id);
    }

    @Transactional
    public void updateWorker(Worker worker)
    {
        workersDAO.updateWorker(worker);
    }

    @Transactional
    public Worker selectWorker(int id)
    {
        return workersDAO.selectWorker(id);
    }

}

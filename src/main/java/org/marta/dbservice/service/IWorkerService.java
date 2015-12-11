package org.marta.dbservice.service;

import org.marta.dbservice.entities.Worker;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by marta on 08.12.15.
 */
public interface IWorkerService
{
    void addWorker(Worker worker);
    List<Worker> getWorkers();
    void deleteWorker(long id) throws SQLException;
    void updateWorker(Worker worker);
    Worker selectWorker(int id);
}

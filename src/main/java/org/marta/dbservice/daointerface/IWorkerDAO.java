package org.marta.dbservice.daointerface;

import org.marta.dbservice.entities.Worker;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by marta on 07.12.15.
 */
public interface IWorkerDAO
{
    void addWorker(Worker worker);
    Worker selectWorker(int id);
    void updateWorker(Worker worker);
    void deleteWorkerById(long id) throws SQLException;
    List<Worker> listWorkers();
}

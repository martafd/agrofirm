package org.marta.dbservice.entities;

/**
 * Created by marta on 06.12.15.
 */
public class Plant
{
    private int id;
    private String cultureName;
    private String sortName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCultureName() {
        return cultureName;
    }

    public void setCultureName(String cultureName) {
        this.cultureName = cultureName;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
}

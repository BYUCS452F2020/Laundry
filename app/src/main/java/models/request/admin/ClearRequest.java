package models.request.admin;

import models.TableType;

public class ClearRequest {

    private TableType table;

    public ClearRequest(TableType table) {
        this.table = table;
    }

    public TableType getTable() {
        return table;
    }
}

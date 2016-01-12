package com.kantilever.t1c3android.domain.abs;

import java.io.Serializable;

/**
 * Created by Tom on 5-1-2016.
 */
public abstract class PersistenceEntity implements Serializable {

    private static final long serialVersionUID = 8286324917041072212L;

    private String id;

    private int version;

    public String getId() {
        return this.id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}

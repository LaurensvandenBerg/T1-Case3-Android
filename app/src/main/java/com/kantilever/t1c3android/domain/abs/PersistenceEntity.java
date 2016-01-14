package com.kantilever.t1c3android.domain.abs;

import java.io.Serializable;

/**
 * The type Persistence entity.
 */
public abstract class PersistenceEntity implements Serializable {

    private static final long serialVersionUID = 8286324917041072212L;

    private String id;

    private int version;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Gets version.
     *
     * @return the version
     */
    public int getVersion() {
        return this.version;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets version.
     *
     * @param version the version
     */
    public void setVersion(int version) {
        this.version = version;
    }
}

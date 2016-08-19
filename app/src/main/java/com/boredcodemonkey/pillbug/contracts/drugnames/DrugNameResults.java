package com.boredcodemonkey.pillbug.contracts.drugnames;

/**
 *
 * Created by jbueno on 8/19/2016.
 */

public class DrugNameResults
{
    private Data[] data;

    private Metadata metadata;

    public Data[] getData ()
    {
        return data;
    }

    public void setData (Data[] data)
    {
        this.data = data;
    }

    public Metadata getMetadata ()
    {
        return metadata;
    }

    public void setMetadata (Metadata metadata)
    {
        this.metadata = metadata;
    }


}

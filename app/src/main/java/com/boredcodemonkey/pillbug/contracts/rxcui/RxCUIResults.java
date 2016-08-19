package com.boredcodemonkey.pillbug.contracts.rxcui;

/**
 *
 * Created by jbueno on 8/19/2016.
 */

public class RxCUIResults
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

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", metadata = "+metadata+"]";
    }
}

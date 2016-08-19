package com.boredcodemonkey.pillbug.contracts.rxcui;

/**
 *
 * Created by jbueno on 8/19/2016.
 */

public class Data
{
    private String rxcui;

    private String rxtty;

    private String rxstring;

    public String getRxcui ()
    {
        return rxcui;
    }

    public void setRxcui (String rxcui)
    {
        this.rxcui = rxcui;
    }

    public String getRxtty ()
    {
        return rxtty;
    }

    public void setRxtty (String rxtty)
    {
        this.rxtty = rxtty;
    }

    public String getRxstring ()
    {
        return rxstring;
    }

    public void setRxstring (String rxstring)
    {
        this.rxstring = rxstring;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [rxcui = "+rxcui+", rxtty = "+rxtty+", rxstring = "+rxstring+"]";
    }
}

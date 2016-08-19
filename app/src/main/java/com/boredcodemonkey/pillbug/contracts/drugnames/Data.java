package com.boredcodemonkey.pillbug.contracts.drugnames;

/**
 *
 * Created by jbueno on 8/19/2016.
 */

public class Data
{
    private String name_type;

    private String drug_name;

    public String getName_type ()
    {
        return name_type;
    }

    public void setName_type (String name_type)
    {
        this.name_type = name_type;
    }

    public String getDrug_name ()
    {
        return drug_name;
    }

    public void setDrug_name (String drug_name)
    {
        this.drug_name = drug_name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name_type = "+name_type+", drug_name = "+drug_name+"]";
    }
}

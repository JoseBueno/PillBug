package com.boredcodemonkey.pillbug.contracts.rxcui;

/**
 *
 * Created by jbueno on 8/19/2016.
 */

public class Metadata
{
    private String next_page_url;

    private String previous_page_url;

    private String elements_per_page;

    private String previous_page;

    private String total_elements;

    private String current_url;

    private String total_pages;

    private String next_page;

    private String current_page;

    public String getNext_page_url ()
    {
        return next_page_url;
    }

    public void setNext_page_url (String next_page_url)
    {
        this.next_page_url = next_page_url;
    }

    public String getPrevious_page_url ()
    {
        return previous_page_url;
    }

    public void setPrevious_page_url (String previous_page_url)
    {
        this.previous_page_url = previous_page_url;
    }

    public String getElements_per_page ()
    {
        return elements_per_page;
    }

    public void setElements_per_page (String elements_per_page)
    {
        this.elements_per_page = elements_per_page;
    }

    public String getPrevious_page ()
    {
        return previous_page;
    }

    public void setPrevious_page (String previous_page)
    {
        this.previous_page = previous_page;
    }

    public String getTotal_elements ()
    {
        return total_elements;
    }

    public void setTotal_elements (String total_elements)
    {
        this.total_elements = total_elements;
    }

    public String getCurrent_url ()
    {
        return current_url;
    }

    public void setCurrent_url (String current_url)
    {
        this.current_url = current_url;
    }

    public String getTotal_pages ()
    {
        return total_pages;
    }

    public void setTotal_pages (String total_pages)
    {
        this.total_pages = total_pages;
    }

    public String getNext_page ()
    {
        return next_page;
    }

    public void setNext_page (String next_page)
    {
        this.next_page = next_page;
    }

    public String getCurrent_page ()
    {
        return current_page;
    }

    public void setCurrent_page (String current_page)
    {
        this.current_page = current_page;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [next_page_url = "+next_page_url+", previous_page_url = "+previous_page_url+", elements_per_page = "+elements_per_page+", previous_page = "+previous_page+", total_elements = "+total_elements+", current_url = "+current_url+", total_pages = "+total_pages+", next_page = "+next_page+", current_page = "+current_page+"]";
    }
}

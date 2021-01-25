package com.example.dashboard_java;
import java.io.Serializable;

public class Model implements Serializable {
    private String  country, cases, deaths, recovered, active, todayCases, todayDeath, incRec;

    public  Model(String country, String cases, String deaths, String recovered,
                  String active, String todayCases, String todayDeath, String incRec)
    {

        this.country = country;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
        this.active = active;
        this.todayCases = todayCases;
        this.todayDeath = todayDeath;
        this.incRec = incRec;
    }

    public String getTodayCases()
    {
        return this.todayCases;
    }

    public void setTodayCases(String todayCases)
    {
        this.todayCases = todayCases;
    }

    public String getTodayDeath()
    {
        return todayDeath;
    }

    public void setTodayDeath(String todayDeath)
    {
        this.todayDeath = todayDeath;
    }

    public String getIncRec()
    {
        return incRec;
    }

    public void setIncRec(String incRec)
    {
        this.incRec = incRec;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCases()
    {
        return cases;
    }

    public void setCases(String cases)
    {
        this.cases = cases;
    }

    public String getDeaths()
    {
        return deaths;
    }

    public void setDeaths(String deaths)
    {
        this.deaths = deaths;
    }

    public String getRecovered()
    {
        return recovered;
    }

    public void setRecovered(String recovered)
    {
        this.recovered = recovered;
    }

    public String getActive()
    {
        return active;
    }

    public void setActive(String active)
    {
        this.active = active;
    }

}

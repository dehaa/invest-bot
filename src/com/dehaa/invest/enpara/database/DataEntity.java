package com.dehaa.invest.enpara.database;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by sefa on 15.01.2016.
 */
@Entity
@Table(name = "enpara_data", schema = "dehaa_invest", catalog = "")
public class DataEntity {
    private int dataId;
    private double altinGramAlis;
    private double altinGramSatis;
    private double ceyrekAlis;
    private double ceyrekSatis;
    private double dolarAlis;
    private double dolarSatis;
    private double euroAlis;
    private double euroSatis;

    @Id
    @Column(name = "dataId")
    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    @Basic
    @Column(name = "altinGramAlis")
    public double getAltinGramAlis() {
        return altinGramAlis;
    }

    public void setAltinGramAlis(double altinGramAlis) {
        this.altinGramAlis = altinGramAlis;
    }

    @Basic
    @Column(name = "altinGramSatis")
    public double getAltinGramSatis() {
        return altinGramSatis;
    }

    public void setAltinGramSatis(double altinGramSatis) {
        this.altinGramSatis = altinGramSatis;
    }

    @Basic
    @Column(name = "ceyrekAlis")
    public double getCeyrekAlis() {
        return ceyrekAlis;
    }

    public void setCeyrekAlis(double ceyrekAlis) {
        this.ceyrekAlis = ceyrekAlis;
    }

    @Basic
    @Column(name = "ceyrekSatis")
    public double getCeyrekSatis() {
        return ceyrekSatis;
    }

    public void setCeyrekSatis(double ceyrekSatis) {
        this.ceyrekSatis = ceyrekSatis;
    }

    @Basic
    @Column(name = "dolarAlis")
    public double getDolarAlis() {
        return dolarAlis;
    }

    public void setDolarAlis(double dolarAlis) {
        this.dolarAlis = dolarAlis;
    }

    @Basic
    @Column(name = "dolarSatis")
    public double getDolarSatis() {
        return dolarSatis;
    }

    public void setDolarSatis(double dolarSatis) {
        this.dolarSatis = dolarSatis;
    }

    @Basic
    @Column(name = "euroAlis")
    public double getEuroAlis() {
        return euroAlis;
    }

    public void setEuroAlis(double euroAlis) {
        this.euroAlis = euroAlis;
    }

    @Basic
    @Column(name = "euroSatis")
    public double getEuroSatis() {
        return euroSatis;
    }

    public void setEuroSatis(double euroSatis) {
        this.euroSatis = euroSatis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataEntity that = (DataEntity) o;

        if (dataId != that.dataId) return false;
        if (Double.compare(that.altinGramAlis, altinGramAlis) != 0) return false;
        if (Double.compare(that.altinGramSatis, altinGramSatis) != 0) return false;
        if (Double.compare(that.ceyrekAlis, ceyrekAlis) != 0) return false;
        if (Double.compare(that.ceyrekSatis, ceyrekSatis) != 0) return false;
        if (Double.compare(that.dolarAlis, dolarAlis) != 0) return false;
        if (Double.compare(that.dolarSatis, dolarSatis) != 0) return false;
        if (Double.compare(that.euroAlis, euroAlis) != 0) return false;
        if (Double.compare(that.euroSatis, euroSatis) != 0) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dataId;
        temp = Double.doubleToLongBits(altinGramAlis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(altinGramSatis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ceyrekAlis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ceyrekSatis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dolarAlis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dolarSatis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(euroAlis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(euroSatis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

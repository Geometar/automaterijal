//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.09.04 at 11:53:31 AM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataSupplierFacetCount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataSupplierFacetCount"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dataSupplierId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="mfrId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="mfrName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSupplierFacetCount", propOrder = {
    "dataSupplierId",
    "mfrId",
    "mfrName",
    "count"
})
public class DataSupplierFacetCount {

    protected int dataSupplierId;
    protected int mfrId;
    @XmlElement(required = true)
    protected String mfrName;
    protected long count;

    /**
     * Gets the value of the dataSupplierId property.
     * 
     */
    public int getDataSupplierId() {
        return dataSupplierId;
    }

    /**
     * Sets the value of the dataSupplierId property.
     * 
     */
    public void setDataSupplierId(int value) {
        this.dataSupplierId = value;
    }

    /**
     * Gets the value of the mfrId property.
     * 
     */
    public int getMfrId() {
        return mfrId;
    }

    /**
     * Sets the value of the mfrId property.
     * 
     */
    public void setMfrId(int value) {
        this.mfrId = value;
    }

    /**
     * Gets the value of the mfrName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMfrName() {
        return mfrName;
    }

    /**
     * Sets the value of the mfrName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMfrName(String value) {
        this.mfrName = value;
    }

    /**
     * Gets the value of the count property.
     * 
     */
    public long getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     */
    public void setCount(long value) {
        this.count = value;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.31 at 11:12:31 AM CET 
//


package com.automaterijal.application.tecdoc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for brandsRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="brandsRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}brandsRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dataSupplierId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="mfrId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="mfrName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="addressDetails" type="{http://server.cat.tecdoc.net}brandAddressRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="dataSupplierStatus" type="{http://server.cat.tecdoc.net}dataSupplierStatusRecord" minOccurs="0"/&gt;
 *         &lt;element name="dataSupplierLogo" type="{http://server.cat.tecdoc.net}dataSupplierLogoRecord" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "brandsRecord", propOrder = {
    "dataSupplierId",
    "mfrId",
    "mfrName",
    "addressDetails",
    "dataSupplierStatus",
    "dataSupplierLogo"
})
public class BrandsRecord
    extends BrandsRecordSrc
{

    protected int dataSupplierId;
    protected int mfrId;
    @XmlElement(required = true)
    protected String mfrName;
    protected List<BrandAddressRecord> addressDetails;
    protected DataSupplierStatusRecord dataSupplierStatus;
    protected DataSupplierLogoRecord dataSupplierLogo;

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
     * Gets the value of the addressDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BrandAddressRecord }
     * 
     * 
     */
    public List<BrandAddressRecord> getAddressDetails() {
        if (addressDetails == null) {
            addressDetails = new ArrayList<BrandAddressRecord>();
        }
        return this.addressDetails;
    }

    /**
     * Gets the value of the dataSupplierStatus property.
     * 
     * @return
     *     possible object is
     *     {@link DataSupplierStatusRecord }
     *     
     */
    public DataSupplierStatusRecord getDataSupplierStatus() {
        return dataSupplierStatus;
    }

    /**
     * Sets the value of the dataSupplierStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSupplierStatusRecord }
     *     
     */
    public void setDataSupplierStatus(DataSupplierStatusRecord value) {
        this.dataSupplierStatus = value;
    }

    /**
     * Gets the value of the dataSupplierLogo property.
     * 
     * @return
     *     possible object is
     *     {@link DataSupplierLogoRecord }
     *     
     */
    public DataSupplierLogoRecord getDataSupplierLogo() {
        return dataSupplierLogo;
    }

    /**
     * Sets the value of the dataSupplierLogo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSupplierLogoRecord }
     *     
     */
    public void setDataSupplierLogo(DataSupplierLogoRecord value) {
        this.dataSupplierLogo = value;
    }

}

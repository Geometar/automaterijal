//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.25 at 12:34:57 AM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for axleIdByTypeManCriteria3Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="axleIdByTypeManCriteria3Response"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}axleIdByTypeManCriteria3ResponseSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="data" type="{http://server.cat.tecdoc.net}axleIdByTypeManCriteria3RecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="statusText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "axleIdByTypeManCriteria3Response", propOrder = {
    "data",
    "status",
    "statusText"
})
public class AxleIdByTypeManCriteria3Response
    extends AxleIdByTypeManCriteria3ResponseSrc
{

    protected AxleIdByTypeManCriteria3RecordSeq data;
    protected int status;
    protected String statusText;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link AxleIdByTypeManCriteria3RecordSeq }
     *     
     */
    public AxleIdByTypeManCriteria3RecordSeq getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link AxleIdByTypeManCriteria3RecordSeq }
     *     
     */
    public void setData(AxleIdByTypeManCriteria3RecordSeq value) {
        this.data = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(int value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusText() {
        return statusText;
    }

    /**
     * Sets the value of the statusText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusText(String value) {
        this.statusText = value;
    }

}

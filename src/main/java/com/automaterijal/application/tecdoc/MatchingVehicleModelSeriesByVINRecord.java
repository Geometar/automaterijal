//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.29 at 02:20:27 PM CET 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for matchingVehicleModelSeriesByVINRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="matchingVehicleModelSeriesByVINRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}matchingVehicleModelSeriesByVINRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="manuId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="modelId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="modelName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "matchingVehicleModelSeriesByVINRecord", propOrder = {
    "manuId",
    "modelId",
    "modelName"
})
public class MatchingVehicleModelSeriesByVINRecord
    extends MatchingVehicleModelSeriesByVINRecordSrc
{

    protected int manuId;
    protected int modelId;
    @XmlElement(required = true)
    protected String modelName;

    /**
     * Gets the value of the manuId property.
     * 
     */
    public int getManuId() {
        return manuId;
    }

    /**
     * Sets the value of the manuId property.
     * 
     */
    public void setManuId(int value) {
        this.manuId = value;
    }

    /**
     * Gets the value of the modelId property.
     * 
     */
    public int getModelId() {
        return modelId;
    }

    /**
     * Sets the value of the modelId property.
     * 
     */
    public void setModelId(int value) {
        this.modelId = value;
    }

    /**
     * Gets the value of the modelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Sets the value of the modelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelName(String value) {
        this.modelName = value;
    }

}

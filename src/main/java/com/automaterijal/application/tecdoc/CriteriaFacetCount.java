//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.05 at 10:10:27 PM CEST 
//


package com.automaterijal.application.tecdoc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CriteriaFacetCount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CriteriaFacetCount"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="criteria" type="{http://server.cat.tecdoc.net}CriteriaInfo"/&gt;
 *         &lt;element name="criteriaValueCounts" type="{http://server.cat.tecdoc.net}CriteriaValueCounts" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CriteriaFacetCount", propOrder = {
    "criteria",
    "criteriaValueCounts"
})
public class CriteriaFacetCount {

    @XmlElement(required = true)
    protected CriteriaInfo criteria;
    protected List<CriteriaValueCounts> criteriaValueCounts;

    /**
     * Gets the value of the criteria property.
     * 
     * @return
     *     possible object is
     *     {@link CriteriaInfo }
     *     
     */
    public CriteriaInfo getCriteria() {
        return criteria;
    }

    /**
     * Sets the value of the criteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriteriaInfo }
     *     
     */
    public void setCriteria(CriteriaInfo value) {
        this.criteria = value;
    }

    /**
     * Gets the value of the criteriaValueCounts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the criteriaValueCounts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCriteriaValueCounts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriteriaValueCounts }
     * 
     * 
     */
    public List<CriteriaValueCounts> getCriteriaValueCounts() {
        if (criteriaValueCounts == null) {
            criteriaValueCounts = new ArrayList<CriteriaValueCounts>();
        }
        return this.criteriaValueCounts;
    }

}
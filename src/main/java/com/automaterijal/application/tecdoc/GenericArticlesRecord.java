//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.29 at 02:20:27 PM CET 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for genericArticlesRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="genericArticlesRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}genericArticlesRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="assemblyGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="designation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="genericArticleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="masterDesignation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="searchTreeNodeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="usageDesignation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "genericArticlesRecord", propOrder = {
    "assemblyGroup",
    "designation",
    "genericArticleId",
    "masterDesignation",
    "searchTreeNodeId",
    "usageDesignation"
})
public class GenericArticlesRecord
    extends GenericArticlesRecordSrc
{

    protected String assemblyGroup;
    protected String designation;
    protected Long genericArticleId;
    protected String masterDesignation;
    protected Long searchTreeNodeId;
    protected String usageDesignation;

    /**
     * Gets the value of the assemblyGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssemblyGroup() {
        return assemblyGroup;
    }

    /**
     * Sets the value of the assemblyGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssemblyGroup(String value) {
        this.assemblyGroup = value;
    }

    /**
     * Gets the value of the designation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets the value of the designation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesignation(String value) {
        this.designation = value;
    }

    /**
     * Gets the value of the genericArticleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGenericArticleId() {
        return genericArticleId;
    }

    /**
     * Sets the value of the genericArticleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGenericArticleId(Long value) {
        this.genericArticleId = value;
    }

    /**
     * Gets the value of the masterDesignation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterDesignation() {
        return masterDesignation;
    }

    /**
     * Sets the value of the masterDesignation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterDesignation(String value) {
        this.masterDesignation = value;
    }

    /**
     * Gets the value of the searchTreeNodeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSearchTreeNodeId() {
        return searchTreeNodeId;
    }

    /**
     * Sets the value of the searchTreeNodeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSearchTreeNodeId(Long value) {
        this.searchTreeNodeId = value;
    }

    /**
     * Gets the value of the usageDesignation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsageDesignation() {
        return usageDesignation;
    }

    /**
     * Sets the value of the usageDesignation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsageDesignation(String value) {
        this.usageDesignation = value;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.06.25 at 12:34:57 AM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GenericArticleFacetCount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GenericArticleFacetCount"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="genericArticleId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="genericArticleDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "GenericArticleFacetCount", propOrder = {
    "genericArticleId",
    "genericArticleDescription",
    "count"
})
public class GenericArticleFacetCount {

    protected int genericArticleId;
    @XmlElement(required = true)
    protected String genericArticleDescription;
    protected long count;

    /**
     * Gets the value of the genericArticleId property.
     * 
     */
    public int getGenericArticleId() {
        return genericArticleId;
    }

    /**
     * Sets the value of the genericArticleId property.
     * 
     */
    public void setGenericArticleId(int value) {
        this.genericArticleId = value;
    }

    /**
     * Gets the value of the genericArticleDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenericArticleDescription() {
        return genericArticleDescription;
    }

    /**
     * Sets the value of the genericArticleDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenericArticleDescription(String value) {
        this.genericArticleDescription = value;
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

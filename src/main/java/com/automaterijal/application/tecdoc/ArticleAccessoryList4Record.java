//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.05 at 10:10:27 PM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for articleAccessoryList4Record complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articleAccessoryList4Record"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}articleAccessoryList4RecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accessoryAttributs" type="{http://server.cat.tecdoc.net}articleAccessoryImmediateAttributsRecordSeq" minOccurs="0"/&gt;
 *         &lt;element name="accessoryDetails" type="{http://server.cat.tecdoc.net}articleAccessoryList3Record" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articleAccessoryList4Record", propOrder = {
    "accessoryAttributs",
    "accessoryDetails"
})
public class ArticleAccessoryList4Record
    extends ArticleAccessoryList4RecordSrc
{

    protected ArticleAccessoryImmediateAttributsRecordSeq accessoryAttributs;
    protected ArticleAccessoryList3Record accessoryDetails;

    /**
     * Gets the value of the accessoryAttributs property.
     * 
     * @return
     *     possible object is
     *     {@link ArticleAccessoryImmediateAttributsRecordSeq }
     *     
     */
    public ArticleAccessoryImmediateAttributsRecordSeq getAccessoryAttributs() {
        return accessoryAttributs;
    }

    /**
     * Sets the value of the accessoryAttributs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticleAccessoryImmediateAttributsRecordSeq }
     *     
     */
    public void setAccessoryAttributs(ArticleAccessoryImmediateAttributsRecordSeq value) {
        this.accessoryAttributs = value;
    }

    /**
     * Gets the value of the accessoryDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ArticleAccessoryList3Record }
     *     
     */
    public ArticleAccessoryList3Record getAccessoryDetails() {
        return accessoryDetails;
    }

    /**
     * Sets the value of the accessoryDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticleAccessoryList3Record }
     *     
     */
    public void setAccessoryDetails(ArticleAccessoryList3Record value) {
        this.accessoryDetails = value;
    }

}
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
 * <p>Java class for replacedByNumbersRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="replacedByNumbersRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}replacedByNumbersRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="replaceArticleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="replaceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "replacedByNumbersRecord", propOrder = {
    "replaceArticleId",
    "replaceNumber"
})
public class ReplacedByNumbersRecord
    extends ReplacedByNumbersRecordSrc
{

    protected Long replaceArticleId;
    protected String replaceNumber;

    /**
     * Gets the value of the replaceArticleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReplaceArticleId() {
        return replaceArticleId;
    }

    /**
     * Sets the value of the replaceArticleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReplaceArticleId(Long value) {
        this.replaceArticleId = value;
    }

    /**
     * Gets the value of the replaceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplaceNumber() {
        return replaceNumber;
    }

    /**
     * Sets the value of the replaceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplaceNumber(String value) {
        this.replaceNumber = value;
    }

}
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
 * <p>Java class for thumbnailByArticleIdRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="thumbnailByArticleIdRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}thumbnailByArticleIdRecordSrc"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="thumbDocId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="thumbFileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="thumbTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "thumbnailByArticleIdRecord", propOrder = {
    "thumbDocId",
    "thumbFileName",
    "thumbTypeId"
})
public class ThumbnailByArticleIdRecord
    extends ThumbnailByArticleIdRecordSrc
{

    protected String thumbDocId;
    protected String thumbFileName;
    protected Long thumbTypeId;

    /**
     * Gets the value of the thumbDocId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThumbDocId() {
        return thumbDocId;
    }

    /**
     * Sets the value of the thumbDocId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThumbDocId(String value) {
        this.thumbDocId = value;
    }

    /**
     * Gets the value of the thumbFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThumbFileName() {
        return thumbFileName;
    }

    /**
     * Sets the value of the thumbFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThumbFileName(String value) {
        this.thumbFileName = value;
    }

    /**
     * Gets the value of the thumbTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getThumbTypeId() {
        return thumbTypeId;
    }

    /**
     * Sets the value of the thumbTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setThumbTypeId(Long value) {
        this.thumbTypeId = value;
    }

}
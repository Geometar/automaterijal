//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.29 at 02:20:27 PM CET 
//


package com.automaterijal.application.tecdoc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for articleLinkedAllLinkingTargetsByIds3RecordSeq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articleLinkedAllLinkingTargetsByIds3RecordSeq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="array" type="{http://server.cat.tecdoc.net}articleLinkedAllLinkingTargetsByIds3Record" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articleLinkedAllLinkingTargetsByIds3RecordSeq", propOrder = {
    "array"
})
public class ArticleLinkedAllLinkingTargetsByIds3RecordSeq {

    @XmlElement(nillable = true)
    protected List<ArticleLinkedAllLinkingTargetsByIds3Record> array;

    /**
     * Gets the value of the array property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the array property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArticleLinkedAllLinkingTargetsByIds3Record }
     * 
     * 
     */
    public List<ArticleLinkedAllLinkingTargetsByIds3Record> getArray() {
        if (array == null) {
            array = new ArrayList<ArticleLinkedAllLinkingTargetsByIds3Record>();
        }
        return this.array;
    }

}

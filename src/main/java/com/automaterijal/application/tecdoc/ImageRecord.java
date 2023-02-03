//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.05 at 10:10:27 PM CEST 
//


package com.automaterijal.application.tecdoc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ImageRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImageRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://server.cat.tecdoc.net}AssetRecord"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="imageURL50" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="imageURL100" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="imageURL200" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="imageURL400" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="imageURL800" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="imageURL1600" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="imageURL3200" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="frame" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="totalFrames" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageRecord", propOrder = {
    "imageURL50",
    "imageURL100",
    "imageURL200",
    "imageURL400",
    "imageURL800",
    "imageURL1600",
    "imageURL3200",
    "frame",
    "totalFrames"
})
public class ImageRecord
    extends AssetRecord
{

    @XmlElement(required = true)
    protected String imageURL50;
    @XmlElement(required = true)
    protected String imageURL100;
    @XmlElement(required = true)
    protected String imageURL200;
    @XmlElement(required = true)
    protected String imageURL400;
    @XmlElement(required = true)
    protected String imageURL800;
    @XmlElement(required = true)
    protected String imageURL1600;
    @XmlElement(required = true)
    protected String imageURL3200;
    protected Integer frame;
    protected Integer totalFrames;

    /**
     * Gets the value of the imageURL50 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageURL50() {
        return imageURL50;
    }

    /**
     * Sets the value of the imageURL50 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageURL50(String value) {
        this.imageURL50 = value;
    }

    /**
     * Gets the value of the imageURL100 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageURL100() {
        return imageURL100;
    }

    /**
     * Sets the value of the imageURL100 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageURL100(String value) {
        this.imageURL100 = value;
    }

    /**
     * Gets the value of the imageURL200 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageURL200() {
        return imageURL200;
    }

    /**
     * Sets the value of the imageURL200 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageURL200(String value) {
        this.imageURL200 = value;
    }

    /**
     * Gets the value of the imageURL400 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageURL400() {
        return imageURL400;
    }

    /**
     * Sets the value of the imageURL400 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageURL400(String value) {
        this.imageURL400 = value;
    }

    /**
     * Gets the value of the imageURL800 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageURL800() {
        return imageURL800;
    }

    /**
     * Sets the value of the imageURL800 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageURL800(String value) {
        this.imageURL800 = value;
    }

    /**
     * Gets the value of the imageURL1600 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageURL1600() {
        return imageURL1600;
    }

    /**
     * Sets the value of the imageURL1600 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageURL1600(String value) {
        this.imageURL1600 = value;
    }

    /**
     * Gets the value of the imageURL3200 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageURL3200() {
        return imageURL3200;
    }

    /**
     * Sets the value of the imageURL3200 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageURL3200(String value) {
        this.imageURL3200 = value;
    }

    /**
     * Gets the value of the frame property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFrame() {
        return frame;
    }

    /**
     * Sets the value of the frame property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFrame(Integer value) {
        this.frame = value;
    }

    /**
     * Gets the value of the totalFrames property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalFrames() {
        return totalFrames;
    }

    /**
     * Sets the value of the totalFrames property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalFrames(Integer value) {
        this.totalFrames = value;
    }

}
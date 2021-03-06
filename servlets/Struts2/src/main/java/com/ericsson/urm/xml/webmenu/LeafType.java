//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.11 at 10:54:10 AM CEST 
//


package com.ericsson.urm.xml.webmenu;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for leaf-type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="leaf-type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authorization" type="{http://www.ericsson.com/URM_MENU}authorization-type" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://www.ericsson.com/URM_MENU}idnum use="required""/>
 *       &lt;attribute ref="{http://www.ericsson.com/URM_MENU}label"/>
 *       &lt;attribute ref="{http://www.ericsson.com/URM_MENU}key-label"/>
 *       &lt;attribute ref="{http://www.ericsson.com/URM_MENU}link"/>
 *       &lt;attribute ref="{http://www.ericsson.com/URM_MENU}link-target"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "leaf-type", propOrder = {
    "authorization"
})
public class LeafType {

    protected AuthorizationType authorization;
    @XmlAttribute(namespace = "http://www.ericsson.com/URM_MENU", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long idnum;
    @XmlAttribute(namespace = "http://www.ericsson.com/URM_MENU")
    protected String label;
    @XmlAttribute(name = "key-label", namespace = "http://www.ericsson.com/URM_MENU")
    protected String keyLabel;
    @XmlAttribute(namespace = "http://www.ericsson.com/URM_MENU")
    protected String link;
    @XmlAttribute(name = "link-target", namespace = "http://www.ericsson.com/URM_MENU")
    protected String linkTarget;

    /**
     * Gets the value of the authorization property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizationType }
     *     
     */
    public AuthorizationType getAuthorization() {
        return authorization;
    }

    /**
     * Sets the value of the authorization property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizationType }
     *     
     */
    public void setAuthorization(AuthorizationType value) {
        this.authorization = value;
    }

    /**
     * Gets the value of the idnum property.
     * 
     */
    public long getIdnum() {
        return idnum;
    }

    /**
     * Sets the value of the idnum property.
     * 
     */
    public void setIdnum(long value) {
        this.idnum = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the keyLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyLabel() {
        return keyLabel;
    }

    /**
     * Sets the value of the keyLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyLabel(String value) {
        this.keyLabel = value;
    }

    /**
     * Gets the value of the link property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLink(String value) {
        this.link = value;
    }

    /**
     * Gets the value of the linkTarget property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkTarget() {
        return linkTarget;
    }

    /**
     * Sets the value of the linkTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkTarget(String value) {
        this.linkTarget = value;
    }

}

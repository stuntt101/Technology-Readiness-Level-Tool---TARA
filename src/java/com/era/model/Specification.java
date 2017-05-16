/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author LQwabe
 */
@Entity
@Table(name = "specification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specification.findAll", query = "SELECT s FROM Specification s"),
    @NamedQuery(name = "Specification.findBySpecificationId", query = "SELECT s FROM Specification s WHERE s.specificationId = :specificationId"),
    @NamedQuery(name = "Specification.findByDatasheetFiletype", query = "SELECT s FROM Specification s WHERE s.datasheetFiletype = :datasheetFiletype"),
    @NamedQuery(name = "Specification.findByPictureFiletype", query = "SELECT s FROM Specification s WHERE s.pictureFiletype = :pictureFiletype")})
public class Specification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "specification_id")
    private Integer specificationId;
    @Lob
    @Column(name = "picture")
    private byte[] picture;
    @Lob
    @Column(name = "datasheet")
    private byte[] datasheet;
    @Size(max = 100)
    @Column(name = "datasheet_filetype")
    private String datasheetFiletype;
    @Size(max = 100)
    @Column(name = "picture_filetype")
    private String pictureFiletype;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "specification_details")
    private String specificationDetails;
    @OneToMany(mappedBy = "specification")
    private List<Equipment> equipmentList;

    public Specification() {
    }

    public Specification(Integer specificationId) {
        this.specificationId = specificationId;
    }

    public Integer getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public byte[] getDatasheet() {
        return datasheet;
    }

    public void setDatasheet(byte[] datasheet) {
        this.datasheet = datasheet;
    }

    public String getDatasheetFiletype() {
        return datasheetFiletype;
    }

    public void setDatasheetFiletype(String datasheetFiletype) {
        this.datasheetFiletype = datasheetFiletype;
    }

    public String getPictureFiletype() {
        return pictureFiletype;
    }

    public void setPictureFiletype(String pictureFiletype) {
        this.pictureFiletype = pictureFiletype;
    }

    public String getSpecificationDetails() {
        return specificationDetails;
    }

    public void setSpecificationDetails(String specificationDetails) {
        this.specificationDetails = specificationDetails;
    }

    @XmlTransient
    @JsonIgnore
    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specificationId != null ? specificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specification)) {
            return false;
        }
        Specification other = (Specification) object;
        if ((this.specificationId == null && other.specificationId != null) || (this.specificationId != null && !this.specificationId.equals(other.specificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.era.model.Specification[ specificationId=" + specificationId + " ]";
    }
    
}

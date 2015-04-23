/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.rhythmtech.cineplex.enitities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mdoucette
 */
@Entity
@Table(name = "MOVIES")
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "select m from Movie m"),
    @NamedQuery(name = "Movies.findById", query = "select m from Movie m where m.id = :id"),
    @NamedQuery(name = "Movies.findByName", query = "")
})
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private Integer id;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    
    @NotNull
    @Size(min = 1, max = 200)
    private String actors;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private Collection<ShowTiming> showTimings;
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public Collection<ShowTiming> getShowTimings() {
        return showTimings;
    }

    public void setShowTimings(Collection<ShowTiming> showTimings) {
        this.showTimings = showTimings;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movie[ id=" + id + " ]";
    }
    
}

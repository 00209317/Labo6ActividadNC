package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name= "estudiante")
public class Estudiante {
	
	@Id
	@Column(name = "id_estudiante")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoEstudiante;
	
	@Column(name = "nombre")
	@Size(message = "El campo nombre no debe tener más de 30 caracteres", max=30)
	@NotEmpty(message = "El campo nombre no puede ser vacío")
	private String nombre;
	
	@Column(name = "apellido")
	@Size(message = "El campo apellido no debe tener más de 30 caracteres", max=30)
	@NotEmpty(message = "El campo apellido no puede ser vacío")
	private String apellido;
	
	@Column(name = "edad")
	@NotNull(message = "El campo edad no puede ser vacío")
	@Min(value = 18, message = "No puede ser menor a 18 años")
	private Integer edad;
	
	@Column(name = "estado")
	private Boolean estado;
	
	@OneToMany(mappedBy = "estudiante", fetch = FetchType.EAGER)
	private List<Computadora> computadoras;
	
	
	public Integer getCodigoEstudiante() {
		return codigoEstudiante;
	}
	public void setCodigoEstudiante(Integer codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public List<Computadora> getComputadoras() {
		return computadoras;
	}
	public void setComputadoras(List<Computadora> computadoras) {
		this.computadoras = computadoras;
	}
	public Estudiante() {
		
	}	
	
	public String getEstadoDelegate() {
		if(this.estado == null) return "";
		else {
			return estado == true ?"Activo":"Inactivo";
		}
	}
	/*public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}*/
		
}

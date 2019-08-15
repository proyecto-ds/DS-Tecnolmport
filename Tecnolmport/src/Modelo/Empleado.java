/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author bryan
 */
public class Empleado extends RecursiveTreeObject<Empleado>{
    protected String id;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String direccion;
    protected String email;
    protected String local;
    protected boolean activo;

    public Empleado() {
    }
    
    
    public Empleado(String identificacion, String nombre, String apellido, String telefono, String direccion, String email, String local, boolean activo) {
        this.id = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.local = local;
        this.activo = activo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public ObservableList <Empleado> llenarTableEmpleado(TableView tableEmpleado){
        ObservableList <Empleado> lista = FXCollections.observableArrayList ();
        lista.add(new Empleado("0926522703","bryan","tutiven","0988097982","Daule","brcetuti@espol.edu.ec","Matriz",true));
        lista.add(new Empleado("0926522708","cesar","acosta","0988097982","Daule","brcetuti@espol.edu.ec","Bodega",true));
        tableEmpleado.getItems().addAll(lista);
        return lista;
    }
}

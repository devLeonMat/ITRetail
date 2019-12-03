package com.rleon.clientes.model;

import java.util.Date;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@ApiModel("Model Client")
@Document(collection = "Clientes")
@Data
public class Client {


    @Id
    @ApiModelProperty(value = "Id de Cliente", required = true)
    private String id;

    @ApiModelProperty(value = "Nombre de Cliente", required = true)
    @NotNull(message="No puede ser Nulo")
    private String nombres;

    @ApiModelProperty(value = "Apellido Paterno", required = true)
    @NotNull(message="No puede ser Nulo")
    private String apellidoPaterno;

    @ApiModelProperty(value = "Apellido Materno", required = true)
    @NotNull(message="No puede ser Nulo")
    private String apellidoMaterno;

    @ApiModelProperty(value = "Nombre de Usuario", required = true)
    @NotNull(message="No puede ser Nulo")
    private int edad;

    @ApiModelProperty(value = "Fecha de Nacimiento", required = true)
    @NotNull(message="No puede ser Nulo")
    private Date fechaDeNacimiento;

    @ApiModelProperty(value = "Fecha de Posible Fallecimiento", required = true)
    private Date fechaPosFallecimiento;


    public Client() {
    }

    public Client(String id, String nombres, String apellidoPaterno, String apellidoMaterno, int edad,
                  Date fechaDeNacimiento , Date fechaPosFallecimiento) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaPosFallecimiento = fechaPosFallecimiento;
    }
}

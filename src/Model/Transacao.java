/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author abelo
 */
@Data
public abstract class Transacao {
   
    public String Descricao;
    public Double Valor;
    public String Data;

    public abstract void Movimentar(Double value);
    public abstract String getDescricao();
    public abstract Double getValor();
    public abstract String getData();
}

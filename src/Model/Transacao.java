/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author abelo
 */
public abstract class Transacao {
    public String Descricao;
    public Double Valor;
    public String Data;

    public abstract void Movimentar(Double value);
}

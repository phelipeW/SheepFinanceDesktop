/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author abelo
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
    private int Id;
    private String Nome;   
    private Double Saldo;
    
    public void Credito(Double valor) {
        Saldo += valor;
    }

    public void Debto(Double valor) {
        Saldo -= valor;
    }
}

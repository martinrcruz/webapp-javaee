/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beansMR;

import javax.ejb.Local;

/**
 *
 * @author martin
 */
@Local
public interface CalculadorMRLocal {

    int dineroPromoSalud(String promocion);

    int dineroDescuentoTipoConductor(String tipoConductor, int valorFinalVenta);

    int dineroTotalSinDescuento(String tipoCombustible, int cantidadCombustible);
    
    int valorFinal(int valorTotal, int dsctoTipo, int dsctoPromo);
    
}

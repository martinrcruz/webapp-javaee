/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beansMR;

import javax.ejb.Stateless;

/**
 *
 * @author martin
 */
@Stateless
public class CalculadorMR implements CalculadorMRLocal {

    //OBTENER DINERO POR PROMOCION (SE SUMA)
    @Override
    public int dineroPromoSalud(String promocion) {
        int dineroPromoSalud = 0;
        if (promocion.equals("no")) {
            dineroPromoSalud = 0;
        } else if (promocion.equals("20ml")) {
            dineroPromoSalud = 1000;
        } else if (promocion.equals("210ml")) {
            dineroPromoSalud = 3000;
        }
        return dineroPromoSalud;
    }

    //DINERO POR DESCUENTO SEGUN TIPO DE CONDUCTOR (SE RESTA)
    @Override
    public int dineroDescuentoTipoConductor(String tipoConductor, int valorFinal) {
        int dineroDescuentoTipoConductor = 0;
        if (tipoConductor.equals("normal")) {
            dineroDescuentoTipoConductor = 0;
        } else if (tipoConductor.equals("vip")) {
            dineroDescuentoTipoConductor = (int) (valorFinal * (float) 10 / 100);
        }
        return dineroDescuentoTipoConductor;
    }

    //DINERO TOTAL SIN DESCUENTOS
    @Override
    public int dineroTotalSinDescuento(String tipoCombustible, int cantidadCombustible) {
        int valorLitroCombustible=0;
        switch (tipoCombustible) {
            case "93":
                valorLitroCombustible = 600;
                break;
            case "95":
                valorLitroCombustible = 700;
                break;
            case "97":
                valorLitroCombustible = 800;
                break;
            case "Petroleo":
                valorLitroCombustible = 300;
                break;
            case "Parafina":
                valorLitroCombustible = 100;
                break;

        }
        int valorTotal;
        valorTotal = (valorLitroCombustible * cantidadCombustible);
        return valorTotal;  
    }

    //GENERAR VALOR FINAL
    @Override
    public int valorFinal(int valorTotal, int dsctoTipo, int dsctoPromo) {
        int valorFinal;
        valorFinal = valorTotal - dsctoTipo + dsctoPromo;
        return valorFinal;
    }


}

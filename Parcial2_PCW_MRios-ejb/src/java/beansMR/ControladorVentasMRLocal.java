/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beansMR;

import javax.ejb.Local;
import clasesMR.RegistroVentasMR;
import java.util.*;

/**
 *
 * @author martin
 */
@Local
public interface ControladorVentasMRLocal {

    void agregarVentaMR(String nombreVendedor, String sexoConductor, String tipoConductor, String tipoVehiculo, String tipoCombustible, int cantidadCombustible, String promocionSalud, int dineroPromoSalud, int dineroDescuentoTipoConductor, int valorFinalVenta);

    List<RegistroVentasMR> retornaTodasLasVentasMR();

    public int generaCorrelativoMR();

    RegistroVentasMR ultimoRegistroVentaMR();

    List<RegistroVentasMR> retornaRegistroPorSexoMR(String sexo);

    List<RegistroVentasMR> retornaFiltroCombustibleVehiculo(String tipoVehiculo, String tipoCombustible);

    List<RegistroVentasMR> retornaFiltroVendedor(String nombreVendedor);

    int retornaDineroVendedor(String nombreVendedor);

    int retornaCantLitrosFiltradoComb(String tipoCombustible);
    
    List<RegistroVentasMR> retornaFiltroCombustible(String tipoCombustible);

    int retornaCantMujeres93();
    
    List<RegistroVentasMR> retornaListaMujeres93();

    void removeVentaMR(RegistroVentasMR venta);

    RegistroVentasMR returnVentaObjMR(RegistroVentasMR venta);

    //void updateVentaMR(int codigoVenta);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beansMR;

import javax.ejb.Stateful;
import clasesMR.RegistroVentasMR;
import java.util.*;

/**
 *
 * @author martin
 */
@Stateful
public class ControladorVentasMR implements ControladorVentasMRLocal {

    //ATRIBUTOS
    List<RegistroVentasMR> almacen = new ArrayList<>();
    List<RegistroVentasMR> almacenSexo = new ArrayList<>();
    List<RegistroVentasMR> almacenFiltroCV = new ArrayList<>();
    List<RegistroVentasMR> almacenFiltroVendedor = new ArrayList<>();
    List<Integer> almacenDineroVendedor = new ArrayList<>();
    List<RegistroVentasMR> almacenFiltroCombustible = new ArrayList<>();
    List<RegistroVentasMR> almacenMujeres93 = new ArrayList<>();

    //METODO PARA GENERAR Y RETORNAR NUMERO CORRELATIVO
    @Override
    public int generaCorrelativoMR() {
        int Id = 1;
        for (int i = 0; i < almacen.size(); i++) {
            RegistroVentasMR get = almacen.get(i);
            if (get.getId_Venta() > 0) {
                Id = (get.getId_Venta() + 1);
            }
        }
        return Id;
    }

    //CREAR VENTA (OBJETO DE CLASE RegistroVentasMR
    @Override
    public void agregarVentaMR(String nombreVendedor, String sexoConductor, String tipoConductor, String tipoVehiculo, String tipoCombustible, int cantidadCombustible, String promocionSalud, int dineroPromoSalud, int dineroDescuentoTipoConductor, int valorFinalVenta) {
        int correlativoId = this.generaCorrelativoMR();
        RegistroVentasMR venta = new RegistroVentasMR(correlativoId, nombreVendedor, sexoConductor, tipoConductor, tipoVehiculo, tipoCombustible, cantidadCombustible, promocionSalud, dineroPromoSalud, dineroDescuentoTipoConductor, valorFinalVenta);
        this.almacen.add(venta);
    }

    //RETORNAR LA LISTA COMPLETA DE VENTAS
    @Override
    public List<RegistroVentasMR> retornaTodasLasVentasMR() {
        return this.almacen;
    }

    //RETORNA ULTIMO REGISTRO
    @Override
    public RegistroVentasMR ultimoRegistroVentaMR() {
        for (int i = almacen.size() - 1; i < almacen.size(); i++) {
            RegistroVentasMR auxiliar = almacen.get(i);
            return auxiliar;
        }
        return null;
    }

    //RETORNA REGISTROS SEGUN SEXO
    @Override
    public List<RegistroVentasMR> retornaRegistroPorSexoMR(String sexo) {
        for (int i = 0; i < almacen.size(); i++) {
            RegistroVentasMR get = almacen.get(i);
            if (get.getSexoConductor().equals(sexo)) {
                this.almacenSexo.add(get);
            }
        }
        return almacenSexo;
    }

    //RETORNA REGISTROS filtrado por tipo combustible y tipo vehiculo
    @Override
    public List<RegistroVentasMR> retornaFiltroCombustibleVehiculo(String tipoVehiculo, String tipoCombustible) {
        for (int i = 0; i < almacen.size(); i++) {
            RegistroVentasMR get = almacen.get(i);
            if (get.getTipoVehiculo().equals(tipoVehiculo) && get.getTipoCombustible().equals(tipoCombustible)) {
                this.almacenFiltroCV.add(get);
            }
        }
        return almacenFiltroCV;
    }

    //RETORNA LISTA DE VENDEDOR FILTRADO
    @Override
    public List<RegistroVentasMR> retornaFiltroVendedor(String nombreVendedor) {
        int dineroVendedor = 0;
        for (int i = 0; i < almacen.size(); i++) {
            RegistroVentasMR get = almacen.get(i);
            if (get.getNombreVendedor().equals(nombreVendedor)) {
                this.almacenDineroVendedor.add(get.getValorFinalVenta());
                this.almacenFiltroVendedor.add(get);
            }

        }
        return almacenFiltroVendedor;
    }

    //RETORNA DINERO TOTAL DE VENDEDOR FILTRADO
    @Override
    public int retornaDineroVendedor(String nombreVendedor) {
        int dineroVendedor = 0;
        for (int i = 0; i < almacen.size(); i++) {
            RegistroVentasMR get = almacen.get(i);
            if (get.getNombreVendedor().equals(nombreVendedor)) {
                dineroVendedor = dineroVendedor + get.getValorFinalVenta();

            }   
        }
        return dineroVendedor;
    }

    //RETORNA CANTIDAD TOTAL DE LITROS VENDIDOS, FILTRADA POR TIPO DE COMBUSTIBLE
    @Override
    public int retornaCantLitrosFiltradoComb(String tipoCombustible) {
        int combSumador = 0;
        for (int i = 0; i < almacen.size(); i++) {
            RegistroVentasMR get = almacen.get(i);
            if (get.getTipoCombustible().equals(tipoCombustible)) {
                int combustible = get.getCantidadCombustible();
                combSumador = combustible + combSumador;

            }

        }
        return combSumador;
    }
    
    //RETORNA REGISTROS FILTRADO POR TIPO COMBUSTIBLE
    @Override
    public List<RegistroVentasMR> retornaFiltroCombustible(String tipoCombustible){
        for (int i = 0; i < almacen.size(); i++) {
            RegistroVentasMR get = almacen.get(i);
            if (get.getTipoCombustible().equals(tipoCombustible)) {
                this.almacenFiltroCombustible.add(get);
            }
        }
        return almacenFiltroCombustible;
    }
    

    //RETORNA CANTIDAD DE MUJERES QUE COMPRARON 93
    @Override
    public int retornaCantMujeres93() {
        int cantMujeres93 = 0;
        for (int i = 0; i < almacen.size(); i++) {
            RegistroVentasMR get = almacen.get(i);
            if (get.getSexoConductor().equals("F") && get.getTipoCombustible().equals("93")) {
                cantMujeres93++;
            }

        }
        return cantMujeres93;
    }
    
    @Override
    public List<RegistroVentasMR> retornaListaMujeres93(){
        for (int i = 0; i < almacen.size(); i++) {
            RegistroVentasMR get = almacen.get(i);
            if (get.getSexoConductor().equals("F") && get.getTipoCombustible().equals("93")) {
                this.almacenMujeres93.add(get);
            }
        }
        return almacenMujeres93;
    }

    /*int Id= tempList.getId_Venta();
            String nombreVendedor= tempList.getNombreVendedor();
            String sexoConductor= tempList.getSexoConductor();
            String tiopConductor= tempList.getTipoConductor();
            String tipoVehiculo= tempList.getTipoVehiculo();
            String tipoCombustible= tempList.getTipoCombustible();
            int cantidadCombustible= tempList.getCantidadCombustible();
            String promocionSalud= tempList.getPromocionSalud();
            int dineroPromoSalud= tempList.getDineroPromoSalud();
            int dineroDescuentoTipoConductor= tempList.getDineroDescuentoTipoConductor();
            int valorFinalVenta= tempList.getValorFinalVenta();*/
//RETORNA REGISTRO DE VENTAS FILTRADO POR SEXO
    /*List<RegistroVentasMR> almacenSexo = new ArrayList<>();

    public List<RegistroVentasMR> retornaRegistroPorSexo(String sexo) {
        for (int i = 0; i < almacen.size(); i++) {
            RegistroVentasMR obj = almacen.get(i);
            if (obj.getSexoConductor().equals("femenino")) {
                int j = 0;
                while (j < almacen.size()) {
                    this.almacenSexo.add(obj);
                }
                return almacenSexo;

            } else if (obj.getSexoConductor().equals("masculino")) {
                int j = 0;
                while (j < almacen.size()) {
                    this.almacenSexo.add(obj);
                }
                return almacenSexo;
            }

        }
        return null;
    }
     */
    //MODIFICAR VENTA
    /* @Override
    public void updateVentaMR(int codigoVenta) {
        for (int i = 0; i < almacen.size(); i++) {
            VentaMR obj = almacen.get(i);
            if (obj.getId_Venta() == codigoVenta) {
                
            }
        }
    }*/
    //ELIMINAR VENTA
    @Override
    public void removeVentaMR(RegistroVentasMR venta) {
        this.almacen.remove(venta);
    }

    //LEER VENTA POR NOMBRE DE OBJETO
    @Override
    public RegistroVentasMR returnVentaObjMR(RegistroVentasMR venta) {
        for (int i = 0; i < almacen.size(); i++) {
            RegistroVentasMR obj = almacen.get(i);
            if (obj.equals(venta)) {
                return obj;
            }

        }
        return null;
    }

}

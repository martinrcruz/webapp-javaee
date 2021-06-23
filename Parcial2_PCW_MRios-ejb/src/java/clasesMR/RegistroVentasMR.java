/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesMR;

/**
 *
 * @author martin
 */
public class RegistroVentasMR {

    //ATRIBUTOS
    int id_Venta, cantidadCombustible, dineroPromoSalud, dineroDescuentoTipoConductor, valorFinalVenta;
    String nombreVendedor, sexoConductor, tipoConductor, tipoVehiculo, tipoCombustible, promocionSalud;

    //METODO CONSTRUCTOR
    public RegistroVentasMR() {
    }
// RegistroVentasMR registro = new RegistroVentasMR(id, nombreVendedor, sexoConductor, tipoConductor, tipoVehiculo, tipoCombustible, cantCombustible, promocion, dineroPromoSalud, dineroDescuentoTipoConductor, totalFinal);

    public RegistroVentasMR(int id_Venta, String nombreVendedor, String sexoConductor, String tipoConductor, String tipoVehiculo, String tipoCombustible, int cantidadCombustible, String promocionSalud, int dineroPromoSalud, int dineroDescuentoTipoConductor, int valorFinalVenta) {
        this.id_Venta = id_Venta;
        this.cantidadCombustible = cantidadCombustible;
        this.dineroPromoSalud = dineroPromoSalud;
        this.dineroDescuentoTipoConductor = dineroDescuentoTipoConductor;
        this.nombreVendedor = nombreVendedor;
        this.sexoConductor = sexoConductor;
        this.tipoConductor = tipoConductor;
        this.tipoVehiculo = tipoVehiculo;
        this.tipoCombustible = tipoCombustible;
        this.promocionSalud = promocionSalud;
        this.valorFinalVenta = valorFinalVenta;
    }

    //METODOS ACCESORES
    public int getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(int id_Venta) {
        this.id_Venta = id_Venta;
    }

    public int getCantidadCombustible() {
        return cantidadCombustible;
    }

    public void setCantidadCombustible(int cantidadCombustible) {
        this.cantidadCombustible = cantidadCombustible;
    }

    public int getDineroPromoSalud() {
        return dineroPromoSalud;
    }

    public void setDineroPromoSalud(int dineroPromoSalud) {
        this.dineroPromoSalud = dineroPromoSalud;
    }

    public int getDineroDescuentoTipoConductor() {
        return dineroDescuentoTipoConductor;
    }

    public void setDineroDescuentoTipoConductor(int dineroDescuentoTipoConductor) {
        this.dineroDescuentoTipoConductor = dineroDescuentoTipoConductor;
    }

    public int getValorFinalVenta() {
        return valorFinalVenta;
    }

    public void setValorFinalVenta(int valorFinalVenta) {
        this.valorFinalVenta = valorFinalVenta;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getSexoConductor() {
        return sexoConductor;
    }

    public void setSexoConductor(String sexoConductor) {
        this.sexoConductor = sexoConductor;
    }

    public String getTipoConductor() {
        return tipoConductor;
    }

    public void setTipoConductor(String tipoConductor) {
        this.tipoConductor = tipoConductor;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getPromocionSalud() {
        return promocionSalud;
    }

    public void setPromocionSalud(String promocionSalud) {
        this.promocionSalud = promocionSalud;
    }

    @Override
    public String toString() {
        return "RegistroVentasMR{" + "id_Venta=" + id_Venta + ", cantidadCombustible=" + cantidadCombustible + ", dineroPromoSalud=" + dineroPromoSalud + ", dineroDescuentoTipoConductor=" + dineroDescuentoTipoConductor + ", valorFinalVenta=" + valorFinalVenta + ", nombreVendedor=" + nombreVendedor + ", sexoConductor=" + sexoConductor + ", tipoConductor=" + tipoConductor + ", tipoVehiculo=" + tipoVehiculo + ", tipoCombustible=" + tipoCombustible + ", promocionSalud=" + promocionSalud + '}';
    }

}

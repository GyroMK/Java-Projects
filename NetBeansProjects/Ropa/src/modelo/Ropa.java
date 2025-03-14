package modelo;

/**
 *
 * @author gonzalo.detomas
 */
public class Ropa {
    private int idArticulo;
    private String tipoPrenda;
    private String tipoMaterial;
    private String descripcion;
    private String talla;
    private float precio;
    
    public Ropa(){
        this.idArticulo=-9;
        this.tipoPrenda="ERROR";
        this.tipoMaterial="ERROR";
        this.descripcion="ERROR";
        this.talla="ERROR";
        this.precio=-9.9f;
    }
    public Ropa(String tipoPrenda, String tipoMaterial, String descripcion, String talla, float precio){
        this.tipoPrenda=tipoPrenda;
        this.tipoMaterial=tipoMaterial;
        this.descripcion=descripcion;
        this.talla=talla;
        this.precio=precio;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getTipoPrenda() {
        return tipoPrenda;
    }

    public void setTipoPrenda(String tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}

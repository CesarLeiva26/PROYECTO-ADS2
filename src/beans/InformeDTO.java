package beans;

public class InformeDTO {

	private int codigoInforme;
	private int codigoSolicitante;
	private String nombreSolicitante;
	private int codigoUbicacion;
	private String nombreUbicacion;
	private String fechaSolicitud;
	private String numeroIncidente;
	private int codigoIncidente;
	private String descripcion;
	private String impacto;
	private String estado;
	private String recomendaciones;

	public InformeDTO(int codigoInforme, String nombreSolicitante, String nombreUbicacion, String fechaSolicitud, String numeroIncidente,
			String descripcion, String impacto, String estado , String recomendaciones) {
		super();
		this.codigoInforme = codigoInforme;
		this.nombreSolicitante = nombreSolicitante;
		this.nombreUbicacion = nombreUbicacion;
		this.fechaSolicitud = fechaSolicitud;
		this.numeroIncidente = numeroIncidente;
		this.descripcion = descripcion;
		this.impacto = impacto;
		this.estado = estado;
		this.recomendaciones = recomendaciones;
	}

	public int getCodigoSolicitante() {
		return codigoSolicitante;
	}

	public void setCodigoSolicitante(int codigoSolicitante) {
		this.codigoSolicitante = codigoSolicitante;
	}

	public String getNombreSolicitante() {
		return nombreSolicitante;
	}

	public void setNombreSolicitante(String nombreSolicitante) {
		this.nombreSolicitante = nombreSolicitante;
	}

	public int getCodigoInforme() {
		return codigoInforme;
	}

	public void setCodigoInforme(int codigoInforme) {
		this.codigoInforme = codigoInforme;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getNumeroIncidente() {
		return numeroIncidente;
	}

	public void setNumeroIncidente(String numeroIncidente) {
		this.numeroIncidente = numeroIncidente;
	}

	public int getCodigoIncidente() {
		return codigoIncidente;
	}

	public void setCodigoIncidente(int codigoIncidente) {
		this.codigoIncidente = codigoIncidente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImpacto() {
		return impacto;
	}

	public void setImpacto(String impacto) {
		this.impacto = impacto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCodigoUbicacion() {
		return codigoUbicacion;
	}

	public void setCodigoUbicacion(int codigoUbicacion) {
		this.codigoUbicacion = codigoUbicacion;
	}

	public String getNombreUbicacion() {
		return nombreUbicacion;
	}

	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}

	public String getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}
}
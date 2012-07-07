//GenClass Generator - v1.01 - Wed Jul 21 22:08:35 BRT 2004 
package BR;
import  frameWork.SimpleBean;

public class Estado extends SimpleBean { 

  private java.lang.Integer cdestado; 
  //Criando uma referência a classe estado, ao inves de usar a coluna idpais
  //private java.lang.Integer idpais;
  private pais pais;
  private java.lang.String nmestado;

/**
 * @return Returns the pais.
 */
public pais getPais() {
	return pais;
}
/**
 * @param pais The pais to set.
 */
public void setPais(pais pais) {
	this.pais = pais;
}
  public void setCdEstado(java.lang.Integer cdestado) { 
     this.cdestado = cdestado; 
  } 


  public java.lang.Integer getCdEstado () { 
     return this.cdestado; 
  } 

// Removendo o set e get deste atributo
//  public void setIdPais(java.lang.Integer idpais) { 
//     this.idpais = idpais; 
//  } 


//  public java.lang.Integer getIdPais () { 
//     return this.idpais; 
//  } 


  public void setNmEstado(java.lang.String nmestado) { 
     this.nmestado = nmestado; 
  } 


  public java.lang.String getNmEstado () { 
     return this.nmestado; 
  } 
   


} 
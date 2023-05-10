/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;

/**
 *
 * @author Job
 */
public class Hospital  implements Serializable{
    
    private int idHospital;
    private String hospitalDom;

    /**
     * @return the idHospital
     */
    public int getIdHospital() {
        return idHospital;
    }

    /**
     * @param idHospital the idHospital to set
     */
    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    /**
     * @return the hospitalDom
     */
    public String getHospitalDom() {
        return hospitalDom;
    }

    /**
     * @param hospitalDom the hospitalDom to set
     */
    public void setHospitalDom(String hospitalDom) {
        this.hospitalDom = hospitalDom;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.backend.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Logger;
import ni.edu.uni.programacion.controllers.PnlVehicleController;
/**
 *
 * @author jahp0
 */
public class VehiculoObservable extends Observable{
    private static final Logger logger = Logger.getLogger(VehiculoObservable.class.getName());
    //private List<PnlVehicleController> Sujeto= new ArrayList();
            
private int valor =0;
    public VehiculoObservable() {
    }
    
    
    public VehiculoObservable( int nValor,int nInferior,int nSuperior ){
        this.valor=nValor;
    }
    
    public void setValor(int nValor){
        this.valor = nValor;
        setChanged();
        notifyObservers();
        logger.info("Se llamo el evento setChanged y Notify Observers");
    }
    
    public int getValor(){
        return(valor);
    }
}

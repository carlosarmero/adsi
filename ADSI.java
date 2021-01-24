/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsi;

import Controlador.Ctrlp;
import Modelo.Consultasp;
import Modelo.Producto;
import Vista.Acceso;
import Vista.Inicio;

/**
 *
 * @author carlos herrerra
 */
public class ADSI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto mod = new Producto();
        Consultasp modc = new Consultasp();
        Inicio frm = new Inicio();
        Acceso acc = new Acceso(frm, true);
        
        Ctrlp cont = new Ctrlp(mod, modc, frm, acc);
        frm.setVisible(true);
        cont.iniciar();
        
        //frm.setVisible(false);
        
        
    }
    
}

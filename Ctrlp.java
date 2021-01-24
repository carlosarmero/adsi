/*
The controller calls where we receive the requests from view and process the by sending to model
 */
package Controlador;

import Modelo.Consultasp;
import Modelo.Producto;
import Vista.Acceso;
import Vista.Consultas;
import Vista.Consultaspedido;
import Vista.Consultasproveedor;
import Vista.Ingresar;
import Vista.Ingresarpedido;
import Vista.Ingresarproveedor;
import Vista.Ingresarusuario;
import Vista.Inicio;
import Vista.Ventas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *Esta clase es el controlador que recibe todos los eventos de la vista
 * y envia la informacion al modelo
 * @author carlos herrerra
 */
public class Ctrlp implements ActionListener {
    
    private Producto mod;    
    private Consultasp modC;
    private Inicio frm;
    private Ingresar i = new Ingresar();
    private Consultas  c = new Consultas();
    private Ventas ve = new Ventas();
    private Consultasproveedor cpro = new Consultasproveedor();
    private Ingresarproveedor ipro = new Ingresarproveedor();
    private Consultaspedido cped = new Consultaspedido();
    private Ingresarpedido iped = new Ingresarpedido();
    private Ingresarusuario nusu = new Ingresarusuario();
    private Acceso acc = new Acceso(frm, true);
    //constructor
    public Ctrlp (Producto mod, Consultasp modC, Inicio frm, Acceso acc){
      this.mod = mod;
      this.modC = modC;
      this.frm = frm;
      this.acc = acc;
      this.frm.ingresa.addActionListener(this);
      this.frm.actu.addActionListener(this);
      this.frm.venta.addActionListener(this);
      this.frm.consulpro.addActionListener(this);
      this.frm.nuevopro.addActionListener(this);
      this.frm.consulped.addActionListener(this);
      this.frm.nuevoped.addActionListener(this);
      this.frm.nuevousua.addActionListener(this);
      this.acc.bot.addActionListener(this);
    }
    //inicia la ventana del programa
    public void iniciar ()
    {
    frm.setTitle("Inicio");
    frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frm.setLocationRelativeTo(null);
    frm.setResizable(false);
    ///verifica usuario
    acc.setDefaultCloseOperation(Acceso.DO_NOTHING_ON_CLOSE);
    acc.setLocationRelativeTo(null);
    acc.setVisible(true);
      }
    @Override
    //botones para opciones del programa
     public void actionPerformed (ActionEvent e){
        //botones inventario
         if(e.getSource()== frm.ingresa){
          frm.desk.removeAll();
          frm.desk.add(i);
          i.show();
          i.setLocation(100, 1);
          i.ingresar.addActionListener(this);
          }
           if(e.getSource()== i.ingresar){
             ingresarprod ();
             i.ingresar.removeActionListener(this);
           } 
         if(e.getSource()== frm.actu){
          frm.desk.removeAll();
          frm.desk.add(c);
          c.show();
          c.setLocation(100, 1);
          c.busca.addActionListener(this);
          c.actualiza.addActionListener(this);
          c.actualizar.addActionListener(this);
           }
             if(e.getSource()== c.busca){
             llenar(c.tablac);
             }
             if(e.getSource()== c.actualiza){ 
             seleccionar();
             }
             if(e.getSource()== c.actualizar){
             actualizar();
             }
             //botones venta
         if(e.getSource()== frm.venta){
          frm.desk.removeAll();
          frm.desk.add(ve);
          ve.show();
          ve.setLocation(100, 1);
          ve.buscasku.addActionListener(this);
          ve.calcu.addActionListener(this);
          ve.alcarro.addActionListener(this);
          ve.procesar.addActionListener(this);
          ve.impri.addActionListener(this);
          ve.nuevav.addActionListener(this);
          }
             if(e.getSource()== ve.buscasku){
               if(ve.bussku.getText().isEmpty()){
                   JOptionPane.showMessageDialog(ve.bussku, "Inserte SKU");
               }else{
                 mod.setSku(Integer.parseInt(ve.bussku.getText()));
                if(modC.buscasku(mod)){
                ve.nombresku.setText(String.valueOf(mod.getNombre()));
                ve.preciosku.setText(String.valueOf(mod.getPrecio())); 
                
              }else {JOptionPane.showMessageDialog(ve.bussku, "No existe SKU");}
                }              
            }
             if (e.getSource()== ve.calcu){
                 if(ve.numerop.getText().isEmpty()||ve.preciosku.getText().isEmpty() ){
                   JOptionPane.showMessageDialog(ve.bussku, "Inserte cantidad y/o precio");
                   }else{
                   int qty = Integer.parseInt(ve.numerop.getText());
                   int price = Integer.parseInt(ve.preciosku.getText());
                   int tot = qty * price;
                   ve.tot.setText(String.valueOf(tot));}
             }
             if (e.getSource()== ve.alcarro){
             carro(ve.tablav);
             }
             if (e.getSource()== ve.procesar){
               ve.procesar.setEnabled(false);
               ve.procesar.removeActionListener(this);
               ve.procesar.setEnabled(false);
               balance();
             }
             if (e.getSource()== ve.impri){
             try {
                 ve.factur.print();
             } catch (PrinterException ex) {
                 Logger.getLogger(Ctrlp.class.getName()).log(Level.SEVERE, null, ex);
              }
             }
             if (e.getSource()== ve.nuevav){
             ve.bussku.setText("");
             ve.nombresku.setText("");
             ve.preciosku.setText("");
             ve.numerop.setText("");
             ve.tot.setText("");
             ve.totven.setText("");
             ve.balance.setText("");
             ve.pago.setText("");
             ve.factur.setText("");
             ve.procesar.setEnabled(true);
             ve.procesar.addActionListener(this);
             limpitabla(ve.tablav);
             }                          
           //botones proveedores
         if(e.getSource()== frm.nuevopro){
          frm.desk.removeAll();
          frm.desk.add(ipro);
          ipro.show();
          ipro.setLocation(100, 1);
          ipro.ingresar.addActionListener(this);
          }  
             if(e.getSource()== ipro.ingresar){
             ingresarprov ();
           }        
         if(e.getSource()== frm.consulpro){
          frm.desk.removeAll();
          frm.desk.add(cpro);
          cpro.show();
          cpro.setLocation(100, 1);
          cpro.busca.addActionListener(this);
          cpro.actualiza.addActionListener(this);
          cpro.actualizar.addActionListener(this);
          }  
              if(e.getSource()== cpro.busca){
             llenarpro(cpro.tablac);
             } 
             if(e.getSource()== cpro.actualiza){ 
             seleccionarpro();
             }
             if(e.getSource()== cpro.actualizar){
             actualizarpro();
             }
             
             //botoenspedidos
         if(e.getSource()== frm.nuevoped){
          frm.desk.removeAll();
          frm.desk.add(iped);
          iped.show();
          iped.setLocation(100, 1);
          iped.ingresar.addActionListener(this);
          }  
            if(e.getSource()== iped.ingresar){
             ingresarped ();
           } 
          if(e.getSource()== frm.consulped){
          frm.desk.removeAll();
          frm.desk.add(cped);
          cped.show();
          cped.setLocation(100, 1);
          cped.busca.addActionListener(this);
          cped.actualiza.addActionListener(this);
          cped.actualizar.addActionListener(this);
          }      
            if(e.getSource()== cped.busca){
             llenarped(cped.tablac);
             } 
             if(e.getSource()== cped.actualiza){ 
             seleccionarped();
             }
             if(e.getSource()== cped.actualizar){
             actualizarped();
             }          
             //botones acceso
         if(e.getSource()== acc.bot){
              mod.setUsu(acc.usu.getText());
              mod.setPass(String.valueOf(acc.cont.getPassword()));
                if(modC.buscausu(mod)){
                acc.dispose();     
              }else {JOptionPane.showMessageDialog(ve.bussku, "Usuario o contraseña erroneos");}
            }
         if(e.getSource()== frm.nuevousua){
          frm.desk.removeAll();
          frm.desk.add(nusu);
          nusu.show();
          nusu.setLocation(100, 1);
          nusu.ingresar.addActionListener(this);
          }  
             if(e.getSource()== nusu.ingresar){
             ingresarusu ();   
            }
}
 //metodos del inventario    
public void ingresarprod (){
            String msgerror = "";
             if(i.nombre.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte nombre de producto\n ";}else{
             mod.setNombre(i.nombre.getText());
             }
             if(i.precio.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte precio de producto\n ";} else{
             mod.setPrecio(Integer.parseInt(i.precio.getText()));
             }
             if(i.cantidad.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte cantidad de producto\n ";}else{
             mod.setCantidad(Integer.parseInt(i.cantidad.getText()));
             }if(i.fecha.getDate()==null){
              msgerror = msgerror+"Inserte fecha de vencimiento del producto.";
             } else{ 
             SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
             String fechat = form.format(i.fecha.getDate());
             System.out.println(fechat);
             mod.setFecha(fechat);
            }
             if(msgerror.isEmpty()==true){
             if (modC.registrar(mod)){
               JOptionPane.showMessageDialog(null, "Registrado");
             }else{
               JOptionPane.showMessageDialog(null, "No registrado");
             }
             } else{
             JOptionPane.showMessageDialog(null, msgerror);
              }
}
    
public void llenar(JTable tabla){

    DefaultTableModel modelot = new DefaultTableModel();
    tabla.setModel(modelot);
    
    
    modelot.addColumn("SKU");
    modelot.addColumn("Nombre");
    modelot.addColumn("Precio");
    modelot.addColumn("Cantidad");
    modelot.addColumn("Fecha venc.");
    
    Object [] columna = new Object[5];
    int numreg = modC.busca().size();

    for (int j = 0; j < numreg; j++) {
        columna[0] = modC.busca().get(j).getSku();
        columna[1] = modC.busca().get(j).getNombre();
        columna[2] = modC.busca().get(j).getPrecio();
        columna[3] = modC.busca().get(j).getCantidad();
        columna[4] = modC.busca().get(j).getFecha();
        modelot.addRow(columna);
    }


}

public void seleccionar (){
    int registro =  c.tablac.getSelectedRow();
    if(registro >= 0){
    
    c.nom.setText( c.tablac.getValueAt(registro, 1).toString() );
    c.pre.setText( c.tablac.getValueAt(registro, 2).toString() );
    c.cant.setText( c.tablac.getValueAt(registro, 3).toString() );
    String fech; 
    fech = String.valueOf((c.tablac.getValueAt(registro, 4).toString()));
     SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
             Date fechtx; 
        try {
            fechtx  = form.parse(fech);
            c.fec.setDate(fechtx);
        } catch (ParseException ex) {
            Logger.getLogger(Ctrlp.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{JOptionPane.showMessageDialog(c, "Seleccione un producto para actuailzar");
    }
}

public void actualizar (){
            int registro =  c.tablac.getSelectedRow(); 
            if(registro >= 0){
            mod.setSku((int) c.tablac.getValueAt(c.tablac.getSelectedRow(),0));
            String msgerror = "";
             if(c.nom.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte nombre de producto\n ";}else{
             mod.setNombre(c.nom.getText());
             }
             if(c.pre.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte precio de producto\n ";} else{
             mod.setPrecio(Integer.parseInt(c.pre.getText()));
             }
             if(c.cant.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte cantidad de producto\n ";}else{
             mod.setCantidad(Integer.parseInt(c.cant.getText()));
             }
             if(c.fec.getDate()==null){
              msgerror = msgerror+"Inserte fecha de vencimiento del producto.";
             } else{ 
             SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
             String fechat = form.format(c.fec.getDate());
             System.out.println(fechat);
             mod.setFecha(fechat);
            }       
             if(msgerror.isEmpty()==true){
             if (modC.editar(mod)){
               JOptionPane.showMessageDialog(null, "Actualizado");
             }else{
               JOptionPane.showMessageDialog(null, "No actualizado");
              }
             } else{
             JOptionPane.showMessageDialog(null, msgerror);
              }
           }else{JOptionPane.showMessageDialog(c, "Seleccione un producto para actuailzar");}


}
//metodos de venta
public void carro(JTable tabla){
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel)tabla.getModel();
        if(ve.bussku.getText().isEmpty()||ve.nombresku.getText().isEmpty()||ve.preciosku.getText().isEmpty()|| ve.numerop.getText().isEmpty()|| ve.tot.getText().isEmpty() ){
                   JOptionPane.showMessageDialog(ve.bussku, "Inserte Detalles de venta");
               }
        else{
        model.addRow(new Object[]
        {
            
        ve.bussku.getText(),
        ve.nombresku.getText(),
        ve.preciosku.getText(),
        ve.numerop.getText(),
        ve.tot.getText(),
        
    });
        int sum = 0;
        for(int i = 0; i<tabla.getRowCount(); i++){
        sum = sum + Integer.parseInt(tabla.getValueAt(i, 4).toString());
                   
    }ve.totven.setText(Integer.toString(sum));
     ve.nombresku.setText("");
     ve.preciosku.setText("");
     ve.numerop.setText("");
     ve.tot.setText("");
     ve.bussku.setText("");
        }
}

public void balance(){
    if(ve.totven.getText().isEmpty() || ve.pago.getText().isEmpty()){
        JOptionPane.showMessageDialog(ve.bussku, "Inserte Detalles de transaccion");
    }else  {int total = Integer.parseInt(ve.totven.getText());
      int pay = Integer.parseInt(ve.pago.getText());
        
        int bal = pay - total;
        ve.balance.setText(String.valueOf(bal));
     factura(); 
     actuinve(ve.tablav);    
    }
      
}

public void factura(){
    
    String total = ve.totven.getText();
    String pay = ve.pago.getText();
    String bal = ve.balance.getText();
   
     DefaultTableModel model = new DefaultTableModel();
     model = (DefaultTableModel) ve.tablav.getModel();
        
     ve.factur.setText(ve.factur.getText()+"**************************\n");
     ve.factur.setText(ve.factur.getText()+"*Supermercado Grancolombiano\n");
     ve.factur.setText(ve.factur.getText()+"**************************\n");
     
     //xtbill.setText(txtbill.getText()+"Producto"+"\t"+"Precio"+"\t"+"Cantidad"+"\n");
     ve.factur.setText(ve.factur.getText()+"Producto"+"\t"+"Precio"+"\n");
     for (int i=0; i< model.getRowCount(); i++){
    String codigopro = (String)model.getValueAt(i, 1);
    String preciopro = (String)model.getValueAt(i, 2);
    String cantidadpro = (String)model.getValueAt(i, 3);
    String costo = (String)model.getValueAt(i, 4);
     ve.factur.setText(ve.factur.getText()+codigopro+"  "+preciopro+" X "+cantidadpro+" -- "+costo+"\n");
    
    }
    ve.factur.setText(ve.factur.getText()+"**************************\n");
    ve.factur.setText(ve.factur.getText()+"**************************\n");   
    ve.factur.setText(ve.factur.getText()+"Subtotal: "+ total +"\n");
    ve.factur.setText(ve.factur.getText()+"Pago: "+ pay +"\n");
    ve.factur.setText(ve.factur.getText()+"Vueltas: "+ bal +"\n");
    
    
    }

public void actuinve (JTable tabla){
      DefaultTableModel model = new DefaultTableModel();
      model = (DefaultTableModel)tabla.getModel();

        for (int i = 0; i< model.getRowCount(); i++) {
            mod.setSku(Integer.parseInt((String) model.getValueAt(i, 0)));
            mod.setCantidad(Integer.parseInt((String) model.getValueAt(i, 3)));
            modC.actuainve(mod);
        
        }
  
    }
public void limpitabla(JTable tabla){
  DefaultTableModel modelot = new DefaultTableModel();
    tabla.setModel(modelot);
    
    
    modelot.addColumn("SKU");
    modelot.addColumn("Nombre");
    modelot.addColumn("Precio");
    modelot.addColumn("Cantidad");
    modelot.addColumn("Costo");
        

}

/////metodos de poveedor
public void ingresarprov (){
            String msgerror = "";
             if(ipro.nombre.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte nombre de proveedor\n ";}else{
             mod.setNombrepro(ipro.nombre.getText());
             }
             if(ipro.productos.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte productos ofrecidos\n ";} else{
             mod.setProductos(ipro.productos.getText());
             }
             if(ipro.telefono.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte telefono\n ";}else{
             mod.setTelefono(ipro.telefono.getText());
             }
             if(ipro.nit.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte NIT del proveedor.";
             }else{
             mod.setNIT(ipro.nit.getText());
             }
             if(msgerror.isEmpty()==true){
             if (modC.registrarpro(mod)){
               JOptionPane.showMessageDialog(null, "Registrado");
             }else{
               JOptionPane.showMessageDialog(null, "No registrado");
             }
             } else{
             JOptionPane.showMessageDialog(null, msgerror);
              }
}

public void llenarpro(JTable tabla){

    DefaultTableModel modelot = new DefaultTableModel();
    tabla.setModel(modelot);
    
    modelot.addColumn("ID");
    modelot.addColumn("Nombre");
    modelot.addColumn("Productos");
    modelot.addColumn("Telefono");
    modelot.addColumn("NIT");
    
    Object [] columna = new Object[5];
    int numreg = modC.buscapro().size();

    for (int j = 0; j < numreg; j++) {
        columna[0] = modC.buscapro().get(j).getID();
        columna[1] = modC.buscapro().get(j).getNombrepro();
        columna[2] = modC.buscapro().get(j).getProductos();
        columna[3] = modC.buscapro().get(j).getTelefono();
        columna[4] = modC.buscapro().get(j).getNIT();
        modelot.addRow(columna);
    }
    
}
public void seleccionarpro (){
    int registro =  cpro.tablac.getSelectedRow();
    if(registro >= 0){
    
    cpro.nom.setText( cpro.tablac.getValueAt(registro, 1).toString() );
    cpro.pro.setText( cpro.tablac.getValueAt(registro, 2).toString() );
    cpro.tel.setText( cpro.tablac.getValueAt(registro, 3).toString() );
    cpro.nit.setText( cpro.tablac.getValueAt(registro, 4).toString() );
      }else{JOptionPane.showMessageDialog(c, "Seleccione un proveedor para actuailzar");}
}
  


public void actualizarpro (){
            int registro =  cpro.tablac.getSelectedRow(); 
            if(registro >= 0){
    
            mod.setID((int) cpro.tablac.getValueAt(cpro.tablac.getSelectedRow(),0));
           String msgerror = "";
             if(cpro.nom.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte nombre de proveedor\n ";}else{
             mod.setNombrepro(cpro.nom.getText());
             }
             if(cpro.pro.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte productos ofrecidos\n ";} else{
             mod.setProductos(cpro.pro.getText());
             }
             if(cpro.tel.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte telefono de proveedor\n ";}else{
             mod.setTelefono(cpro.tel.getText());
             }
             if(cpro.nit.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte NIt del proveedor.";
             }else{
             mod.setNIT(cpro.nit.getText());
             }
             if(msgerror.isEmpty()==true){
             if (modC.editarpro(mod)){
               JOptionPane.showMessageDialog(null, "Actualizado");
             }else{
               JOptionPane.showMessageDialog(null, "No actualizado");
              }
             } else{
             JOptionPane.showMessageDialog(null, msgerror);
              }
              }else{JOptionPane.showMessageDialog(c, "Seleccione un proveedor para actualizar");}

}
//pedidos
public void ingresarped (){
            String msgerror = "";
             if(iped.nombre.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte nombre de pedido\n ";}else{
             mod.setNombreped(iped.nombre.getText());
             }
             if(iped.precio.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte precio de pedido\n ";} else{
             mod.setPrecioped(Integer.parseInt(iped.precio.getText()));
             }
             if(iped.cantidad.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte cantidad de pedido\n ";}else{
             mod.setCantidadped(Integer.parseInt(iped.cantidad.getText()));
             }
             
             if(iped.fecha.getDate()==null){
              msgerror = msgerror+"Inserte fecha de entrega del pedido\n";
             } else{ 
             SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
             String fechat = form.format(iped.fecha.getDate());
             System.out.println(fechat);
             mod.setFechaen(fechat);
             }          
             if(iped.idpro.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte id del proveedor\n ";} else{
             mod.setIDpro(Integer.parseInt(iped.idpro.getText()));
             }
             if(msgerror.isEmpty()==true){
             if (modC.registrarped(mod)){
               JOptionPane.showMessageDialog(null, "Registrado");
             }else{
               JOptionPane.showMessageDialog(null, "No registrado");
             }
             }else{
             JOptionPane.showMessageDialog(null, msgerror);
              } 
}
    
public void llenarped(JTable tabla){

    DefaultTableModel modelot = new DefaultTableModel();
    tabla.setModel(modelot);
    
    
    modelot.addColumn("ID pedido");
    modelot.addColumn("Nombre");
    modelot.addColumn("Precio");
    modelot.addColumn("Cantidad");
    modelot.addColumn("Fecha entrega.");
    modelot.addColumn("ID proveedor");
    
    Object [] columna = new Object[6];
    int numreg = modC.buscaped().size();

    for (int j = 0; j < numreg; j++) {
        columna[0] = modC.buscaped().get(j).getIdpe();
        columna[1] = modC.buscaped().get(j).getNombreped();
        columna[2] = modC.buscaped().get(j).getPrecioped();
        columna[3] = modC.buscaped().get(j).getCantidadped();
        columna[4] = modC.buscaped().get(j).getFechaen();
        columna[5] = modC.buscaped().get(j).getIDpro();
        modelot.addRow(columna);
    }


}

public void seleccionarped (){
    int registro =  cped.tablac.getSelectedRow();
        if(registro >= 0){
    cped.nom.setText( cped.tablac.getValueAt(registro, 1).toString() );
    cped.pre.setText( cped.tablac.getValueAt(registro, 2).toString() );
    cped.cant.setText( cped.tablac.getValueAt(registro, 3).toString() );
    String fech; 
    fech = String.valueOf((cped.tablac.getValueAt(registro, 4).toString()));
     SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
             Date fechtx; 
        try {
            fechtx  = form.parse(fech);
            cped.fec.setDate(fechtx);
        } catch (ParseException ex) {
            Logger.getLogger(Ctrlp.class.getName()).log(Level.SEVERE, null, ex);
        }
         cped.idprov.setText( cped.tablac.getValueAt(registro, 5).toString() );
        } else{JOptionPane.showMessageDialog(c, "Seleccione un pedido para actuailzar");}
        }

public void actualizarped (){
            int registro =  cped.tablac.getSelectedRow(); 
            if(registro >= 0){
            
            mod.setIdpe((int) cped.tablac.getValueAt(cped.tablac.getSelectedRow(),0));
           String msgerror = "";
            if(cped.nom.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte nombre de pedido\n ";}else{
             mod.setNombreped(cped.nom.getText());
             }
             if(cped.pre.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte precio de pedido\n ";} else{
             mod.setPrecioped(Integer.parseInt(cped.pre.getText()));
             }
             if(cped.cant.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte cantidad de pedido\n ";}else{
             mod.setCantidadped(Integer.parseInt(cped.cant.getText()));
             }          
             if(cped.fec.getDate()==null){
              msgerror = msgerror+"Inserte fecha de entrega del pedido";
             } else{ 
             SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
             String fechat = form.format(cped.fec.getDate());
             System.out.println(fechat);
             mod.setFechaen(fechat);
             }
             if(cped.idprov.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte id del proveedor\n ";} else{
             mod.setIDpro(Integer.parseInt(cped.idprov.getText()));
             }
             if(msgerror.isEmpty()==true){
             if (modC.editarped(mod)){
               JOptionPane.showMessageDialog(null, "Actualizado");
             }else{
               JOptionPane.showMessageDialog(null, "No Actualizado");
             }
             }else{
             JOptionPane.showMessageDialog(null, msgerror);
              } 
            }else{JOptionPane.showMessageDialog(c, "Seleccione un pedido para actuailzar");}
  
}

    private void ingresarusu() {
        String msgerror = "";
             if(nusu.nombre.getText() .isEmpty()==true){
             msgerror = msgerror+"Inserte nombre de usuario\n ";}else{
             mod.setUsu(nusu.nombre.getText());
             }
             if(String.valueOf(nusu.contra.getPassword()) .isEmpty()==true){
             msgerror = msgerror+"Inserte contraseña\n ";} else{
             mod.setPass(String.valueOf(nusu.contra.getPassword()));
             }
                 
             if(msgerror.isEmpty()==true){
             if (modC.nuevousu(mod)){
               JOptionPane.showMessageDialog(null, "Registrado");
             }else{
               JOptionPane.showMessageDialog(null, "No registrado");
             }
             }else{
             JOptionPane.showMessageDialog(null, msgerror);
              } 
  }


}
    
    
    
  

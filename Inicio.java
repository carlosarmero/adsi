/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author carlos herrerra
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Insertar
     */
    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        desk = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        inventario = new javax.swing.JMenu();
        actu = new javax.swing.JMenuItem();
        ingresa = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        venta = new javax.swing.JMenuItem();
        pedidos = new javax.swing.JMenu();
        consulped = new javax.swing.JMenuItem();
        nuevoped = new javax.swing.JMenuItem();
        proveedores = new javax.swing.JMenu();
        consulpro = new javax.swing.JMenuItem();
        nuevopro = new javax.swing.JMenuItem();
        nuevousu = new javax.swing.JMenu();
        nuevousua = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout deskLayout = new javax.swing.GroupLayout(desk);
        desk.setLayout(deskLayout);
        deskLayout.setHorizontalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
        );
        deskLayout.setVerticalGroup(
            deskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(11, 187, 226));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(244, 50));

        inventario.setText("Inventario");
        inventario.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N

        actu.setText("Consultar y/o actualizar");
        inventario.add(actu);

        ingresa.setText("Ingresar producto");
        inventario.add(ingresa);

        jMenuBar1.add(inventario);

        jMenu2.setText("Ventas");
        jMenu2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N

        venta.setText("Nueva venta");
        jMenu2.add(venta);

        jMenuBar1.add(jMenu2);

        pedidos.setText("Pedidos");
        pedidos.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N

        consulped.setText("Consultar y/o actualizar");
        pedidos.add(consulped);

        nuevoped.setText("Nuevo pedido");
        pedidos.add(nuevoped);

        jMenuBar1.add(pedidos);

        proveedores.setText("Proveedores");
        proveedores.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N

        consulpro.setText("Consultar y/o actualizar");
        proveedores.add(consulpro);

        nuevopro.setText("Nuevo proveedor");
        proveedores.add(nuevopro);

        jMenuBar1.add(proveedores);

        nuevousu.setText("Usuario");
        nuevousu.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N

        nuevousua.setText("Nuevo usuario");
        nuevousu.add(nuevousua);

        jMenuBar1.add(nuevousu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desk)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem actu;
    public javax.swing.JMenuItem consulped;
    public javax.swing.JMenuItem consulpro;
    public javax.swing.JDesktopPane desk;
    public javax.swing.JMenuItem ingresa;
    private javax.swing.JMenu inventario;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JMenuItem nuevoped;
    public javax.swing.JMenuItem nuevopro;
    private javax.swing.JMenu nuevousu;
    public javax.swing.JMenuItem nuevousua;
    private javax.swing.JMenu pedidos;
    private javax.swing.JMenu proveedores;
    public javax.swing.JMenuItem venta;
    // End of variables declaration//GEN-END:variables
}

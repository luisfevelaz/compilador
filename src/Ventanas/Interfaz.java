/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.time.Clock.system;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author didih
 */
public class Interfaz extends javax.swing.JFrame {
    JFileChooser seleccionado = new JFileChooser();
    int ii=0;

    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
    String nombreArchivo;
    int editarBandera = 0;

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        colors();
        this.txtAreaCompilarD.setEnabled(false);
        
    }
    
    //Metodo para encontrar ultimas cadenas
    private int findLastNonWordChar(String text, int index) {
        while (--index >= 0) {
            //  \\W = [A-Za-Z0-9]
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }
    //Metodo para encontrar ultimas cadenas
    private int findFirstNonWordChar(String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }
    
    //metodo para colorear palabras reservadas
    private void colors(){
        final StyleContext cont = StyleContext.getDefaultStyleContext();
        
        //colores
        final AttributeSet attred = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground  , new Color(254,0,0));
        final AttributeSet attgreen = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground  , new Color(0,143,57));
        final AttributeSet attblue = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground  , new Color(0,102,254));
        final AttributeSet attblack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground  , new Color(10,10,10));
        final AttributeSet attpurple = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground  , new Color(87,35,100));
        
        
        //Estilo
        DefaultStyledDocument doc = new DefaultStyledDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offset);
                if (before < 0) {
                    before = 0;
                }
                int after = findFirstNonWordChar(text, offset + str.length());
                int wordL = before;
                int wordR = before;

                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                        if (text.substring(wordL, wordR).matches("(\\W)*(if|else|for|while|program|fi|do|until|read|write)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attblue, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(int|float|bool|not|and|or|char)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attgreen, false);
                        /*} else if (text.substring(wordL, wordR).matches("(\\W)*(RET|ETD|SLD)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attred, false);*/
                        } else {
                            setCharacterAttributes(wordL, wordR - wordL, attblack, false);
                        }
                        wordL = wordR;

                    }
                    wordR++;
                }
            }
            @Override
            public void remove(int offs, int len) throws BadLocationException {
                
                ii= ii+1;
                System.out.print(ii+"\n");
                System.out.print("entra if de remove \n");
                super.remove(offs, len);
                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offs);
                if (before < 0) {
                    before = 0;
                    System.out.print("segundo if de remove\n");
                }
                System.out.print("final if de remove\n\n");
            }
        };
        
        JTextPane txt = new JTextPane(doc);
                String temp = txtAreaCompilarD.getText();
                txtAreaCompilarD.setStyledDocument(txt.getStyledDocument());
                txtAreaCompilarD.setText(temp);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        multipanelDerecho = new javax.swing.JTabbedPane();
        scrollLexico = new javax.swing.JScrollPane();
        txtAreaLexico = new javax.swing.JTextArea();
        scrollSintactico = new javax.swing.JScrollPane();
        txtAreaSintactico = new javax.swing.JTextArea();
        scrollSemantico = new javax.swing.JScrollPane();
        txtAreaSemantico = new javax.swing.JTextArea();
        scrollCodigoIntermedio = new javax.swing.JScrollPane();
        txtAreaCodigoIntermedio = new javax.swing.JTextArea();
        instruccionCompilar = new javax.swing.JLabel();
        multipanelBajo = new javax.swing.JTabbedPane();
        scrollErrores = new javax.swing.JScrollPane();
        txtAreaErrores = new javax.swing.JTextArea();
        scrollResultados = new javax.swing.JScrollPane();
        txtAreaResultados = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaCompilarD = new javax.swing.JTextPane();
        menu = new javax.swing.JMenuBar();
        menuArchivos = new javax.swing.JMenu();
        subMenuAbrir = new javax.swing.JMenuItem();
        subMenuCerrar = new javax.swing.JMenuItem();
        subMenuGuardar = new javax.swing.JMenuItem();
        subMenuGuardarComo = new javax.swing.JMenuItem();
        subMenuSalir = new javax.swing.JMenuItem();
        itemCompilar = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();
        menuFormato = new javax.swing.JMenu();
        menuCompilar = new javax.swing.JMenu();
        menuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        fondo.setBackground(new java.awt.Color(204, 255, 153));
        fondo.setForeground(new java.awt.Color(153, 255, 0));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAreaLexico.setColumns(20);
        txtAreaLexico.setRows(5);
        txtAreaLexico.setText("a");
        scrollLexico.setViewportView(txtAreaLexico);

        multipanelDerecho.addTab("Lexico", scrollLexico);

        txtAreaSintactico.setColumns(20);
        txtAreaSintactico.setRows(5);
        txtAreaSintactico.setText("b");
        scrollSintactico.setViewportView(txtAreaSintactico);

        multipanelDerecho.addTab("Sintactico", scrollSintactico);

        txtAreaSemantico.setColumns(20);
        txtAreaSemantico.setRows(5);
        txtAreaSemantico.setText("c");
        scrollSemantico.setViewportView(txtAreaSemantico);

        multipanelDerecho.addTab("Sintactico", scrollSemantico);

        txtAreaCodigoIntermedio.setColumns(20);
        txtAreaCodigoIntermedio.setRows(5);
        txtAreaCodigoIntermedio.setText("d");
        scrollCodigoIntermedio.setViewportView(txtAreaCodigoIntermedio);

        multipanelDerecho.addTab("Codigo Intermedio", scrollCodigoIntermedio);

        fondo.add(multipanelDerecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 280, 340));

        instruccionCompilar.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        instruccionCompilar.setText("Codigo a compilar");
        fondo.add(instruccionCompilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtAreaErrores.setColumns(20);
        txtAreaErrores.setRows(5);
        txtAreaErrores.setText("s");
        scrollErrores.setViewportView(txtAreaErrores);

        multipanelBajo.addTab("Erorres", scrollErrores);

        txtAreaResultados.setColumns(20);
        txtAreaResultados.setRows(5);
        txtAreaResultados.setText("a");
        scrollResultados.setViewportView(txtAreaResultados);

        multipanelBajo.addTab("Resultados", scrollResultados);

        fondo.add(multipanelBajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 830, 120));

        txtAreaCompilarD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAreaCompilarDKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtAreaCompilarD);

        fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 510, 340));

        menuArchivos.setText("Archivos");

        subMenuAbrir.setText("Abrir");
        subMenuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuAbrirActionPerformed(evt);
            }
        });
        menuArchivos.add(subMenuAbrir);

        subMenuCerrar.setText("Cerrar");
        subMenuCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCerrarActionPerformed(evt);
            }
        });
        menuArchivos.add(subMenuCerrar);

        subMenuGuardar.setText("Guardar");
        subMenuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuGuardarActionPerformed(evt);
            }
        });
        menuArchivos.add(subMenuGuardar);

        subMenuGuardarComo.setText("Guardar como");
        menuArchivos.add(subMenuGuardarComo);

        subMenuSalir.setText("Salir");
        menuArchivos.add(subMenuSalir);

        itemCompilar.setText("Compilar");
        itemCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCompilarActionPerformed(evt);
            }
        });
        menuArchivos.add(itemCompilar);

        menu.add(menuArchivos);

        menuEditar.setText("Editar");
        menuEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEditarMouseClicked(evt);
            }
        });
        menu.add(menuEditar);

        menuFormato.setText("Formato");
        menu.add(menuFormato);

        menuCompilar.setText("Compilar");
        menuCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCompilarActionPerformed(evt);
            }
        });
        menu.add(menuCompilar);

        menuAyuda.setText("Ayuda");
        menuAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAyudaActionPerformed(evt);
            }
        });
        menu.add(menuAyuda);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subMenuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAbrirActionPerformed
        // TODO add your handling code here: 
        System.out.println("Abrir");
        if(seleccionado.showDialog(this, "Abrir archivo") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionado.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                this.nombreArchivo = archivo.getName();
                String contenido = this.abrirArchivo(archivo);
                this.txtAreaCompilarD.setText(contenido);
            }
        }

    }//GEN-LAST:event_subMenuAbrirActionPerformed

    private void subMenuCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCerrarActionPerformed
        // TODO add your handling code here:
        System.out.println("Cerrar");
        
    }//GEN-LAST:event_subMenuCerrarActionPerformed

    private void subMenuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuGuardarActionPerformed
        // TODO add your handling code here:
        System.out.println("Guardar");
        System.out.println(this.txtAreaCompilarD.getText());
        if(seleccionado.showDialog(null,"Guardar archivo") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionado.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String contenido = this.txtAreaCompilarD.getText();
                String respuesta = this.guardarTexto(archivo, contenido);
                if(respuesta != null){
                    JOptionPane.showMessageDialog(null,respuesta);
                }else{
                    JOptionPane.showMessageDialog(null,"No se pudo guardar el texto");
                }
            }
        }
    }//GEN-LAST:event_subMenuGuardarActionPerformed

    private void menuEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEditarMouseClicked
        // TODO add your handling code here:
        if(editarBandera == 0){
            this.menuEditar.setForeground(Color.blue);
            editarBandera = 1;
            this.txtAreaCompilarD.setEnabled(true);
        }
        else{
            this.menuEditar.setForeground(Color.black);
            editarBandera = 0;
            this.txtAreaCompilarD.setEnabled(false);
        }
    }//GEN-LAST:event_menuEditarMouseClicked

    private void txtAreaCompilarDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaCompilarDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaCompilarDKeyReleased

    private void menuCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCompilarActionPerformed
        // TODO add your handling code here:
        System.out.println("Compilaaaaaaaaaaaaaaaaaaaa");
        //this.sintactico();
    }//GEN-LAST:event_menuCompilarActionPerformed

    private void menuAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAyudaActionPerformed
        // TODO add your handling code here:
        System.out.println("Compilaaaaaaaaaaaaaaaaaaaa");
    }//GEN-LAST:event_menuAyudaActionPerformed

    private void itemCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCompilarActionPerformed
        // TODO add your handling code here:
        System.out.println("Compilaaaaaaaaaaaaaaaaaaaa");
        try {
            this.sintactico();
        } catch (IOException ex) {
            
        }
    }//GEN-LAST:event_itemCompilarActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    public String abrirArchivo(File archivo){
        String contenido =""; // variable que va a leer el archivo
        try{
            entrada = new FileInputStream(archivo);
            int ascii;
            while((ascii = entrada.read()) != -1){
                char caracter = (char)ascii;
                contenido += caracter;
            }

        }catch(Exception e){
        }
        return contenido;
    }

    public String guardarTexto(File archivo, String contenido){
        String respuesta = null; // respuesta null si el archivo no se guardó
        try{
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            respuesta = "Se guardó con éxito";
        }catch(Exception e){}
        return respuesta;
    }
    
    public void sintactico() throws IOException{
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c","cd \"C:\\Users\\Admin\\Documents\\compiladores\\Proyecto\" && sintactico", this.nombreArchivo
        );
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        String txtSintactico = null;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            txtSintactico+= line+"\n";
            System.out.println(line);
        }
        this.txtAreaSintactico.setText(txtSintactico);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel instruccionCompilar;
    private javax.swing.JMenuItem itemCompilar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuArchivos;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuCompilar;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JMenu menuFormato;
    private javax.swing.JTabbedPane multipanelBajo;
    private javax.swing.JTabbedPane multipanelDerecho;
    private javax.swing.JScrollPane scrollCodigoIntermedio;
    private javax.swing.JScrollPane scrollErrores;
    private javax.swing.JScrollPane scrollLexico;
    private javax.swing.JScrollPane scrollResultados;
    private javax.swing.JScrollPane scrollSemantico;
    private javax.swing.JScrollPane scrollSintactico;
    private javax.swing.JMenuItem subMenuAbrir;
    private javax.swing.JMenuItem subMenuCerrar;
    private javax.swing.JMenuItem subMenuGuardar;
    private javax.swing.JMenuItem subMenuGuardarComo;
    private javax.swing.JMenuItem subMenuSalir;
    private javax.swing.JTextArea txtAreaCodigoIntermedio;
    private javax.swing.JTextPane txtAreaCompilarD;
    private javax.swing.JTextArea txtAreaErrores;
    private javax.swing.JTextArea txtAreaLexico;
    private javax.swing.JTextArea txtAreaResultados;
    private javax.swing.JTextArea txtAreaSemantico;
    private javax.swing.JTextArea txtAreaSintactico;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JTextArea textoCodigoCompilar;
}

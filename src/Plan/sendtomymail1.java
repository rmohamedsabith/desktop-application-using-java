/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plan;

//import com.sun.jdi.connect.Transport;
import java.awt.event.KeyEvent;
//import java.net.PasswordAuthentication;
import java.util.Date;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.PasswordAuthentication;
//import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;



/**
 *
 * @author User
 */
public class sendtomymail1 extends javax.swing.JFrame {

   
    public sendtomymail1() {
        initComponents();
        txtemail.grabFocus();
    }

   public String sendmail(String email,String password,String toemai,String subject,String text)
   {
       String msg;
       final String username=email;
       final String pass="bwbkolgffmqwnsej";
        final String ssl_factory="javax.net.ssl.SSLSocketFactory";
       
        Properties prop=new Properties();
       prop.setProperty("mail.smtp.socketFactory.class",ssl_factory);
        prop.setProperty("mail.smtp.socketFactory.fallback","false");
       prop.put("mail.smtp.auth","true");
        prop.setProperty("mail.smtp.socketFactory.port","465");
         prop.put("mail.debug","true");
         prop.put("mail.store.protocol","pop3");
          prop.put("mail.transport.protocol","smtp");
         prop.setProperty("mail.smtp.host","smtp.gmail.com");
       prop.setProperty("mail.smtp.port","465");
       
//       Properties prop=new Properties();
//       prop.put("mail.smtp.auth","true");
//       prop.put("mail.smtp.starttls.enable","true");
//       prop.put("mail.smtp.host","smtp.gmail.com");
//       prop.put("mail.smtp.port","587");
//       prop.setProperty("mail.smtp.ssl.trust","smtp.gmail.com");
       
      Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, pass);
    }
});
       
       try {
           Message message=new MimeMessage(session);
           message.setFrom(new InternetAddress(email)); //your email
           message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email,false));// u will send to
           message.setSubject(subject);
           message.setText(text);
           
           message.setSentDate(new Date());
           Transport.send(message);
           
           msg="true";
           return msg;
       } catch (Exception e) {
           return e.toString();
       }
      
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtareafile2 = new javax.swing.JTextArea();
        txtemail = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        lblpassword = new javax.swing.JLabel();
        lblemail1 = new javax.swing.JLabel();
        btnsave = new java.awt.Button();
        btnclear = new java.awt.Button();

        txtareafile2.setColumns(20);
        txtareafile2.setRows(5);
        jScrollPane1.setViewportView(txtareafile2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 204));
        setResizable(false);

        txtemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtemail.setForeground(new java.awt.Color(102, 0, 102));
        txtemail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtemailKeyPressed(evt);
            }
        });

        txtpassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(102, 0, 102));
        txtpassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });

        lblpassword.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        lblpassword.setForeground(new java.awt.Color(102, 0, 102));
        lblpassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblpassword.setText("PASSWORD");

        lblemail1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lblemail1.setForeground(new java.awt.Color(102, 0, 102));
        lblemail1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblemail1.setText("Email");

        btnsave.setBackground(new java.awt.Color(102, 0, 102));
        btnsave.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setLabel("SAVE\n");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnclear.setBackground(new java.awt.Color(102, 0, 102));
        btnclear.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        btnclear.setForeground(new java.awt.Color(255, 255, 255));
        btnclear.setLabel("CLEAR\n");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblemail1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblpassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtemail, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(txtpassword))
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addComponent(lblemail1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        txtemail.setText("");
        txtpassword.setText("");
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String email=txtemail.getText();
        String password=String.valueOf(txtpassword.getPassword());
        String text=txtareafile2.getText();
        //System.out.println(txtareafile2.getText());
       
        
        String data =new sendtomymail1().sendmail(email,password,email,"MY TRIP DAY PLAN",text);
        
        if(data.equals("true"))
        {
            JOptionPane.showMessageDialog(this,"Email Sent Successfully");
        }else{
            JOptionPane.showMessageDialog(this,"Email did not send !!!" );
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void txtemailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            txtpassword.grabFocus();
        }
    }//GEN-LAST:event_txtemailKeyPressed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtpasswordKeyPressed

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
            java.util.logging.Logger.getLogger(sendtomymail1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sendtomymail1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sendtomymail1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sendtomymail1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new sendtomymail1().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnclear;
    private java.awt.Button btnsave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblemail1;
    private javax.swing.JLabel lblpassword;
    public static javax.swing.JTextArea txtareafile2;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airline.management.system;

import java.awt.event.KeyEvent;

/**
 *
 * @author moham
 */
public class MainMenuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form MainMenuAdmin
     */
    public MainMenuAdmin() {
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
        Cus_Reg = new javax.swing.JButton();
        Tic_Cancel = new javax.swing.JButton();
        Staff_Reg = new javax.swing.JButton();
        Tic_Book = new javax.swing.JButton();
        back = new javax.swing.JButton();
        feedback = new javax.swing.JButton();
        flight = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 50));

        Cus_Reg.setBackground(new java.awt.Color(255, 255, 153));
        Cus_Reg.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        Cus_Reg.setForeground(new java.awt.Color(0, 0, 0));
        Cus_Reg.setText("CUSTOMER REGISTRATION");
        Cus_Reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cus_RegActionPerformed(evt);
            }
        });
        Cus_Reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Cus_RegKeyPressed(evt);
            }
        });

        Tic_Cancel.setBackground(new java.awt.Color(255, 255, 153));
        Tic_Cancel.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        Tic_Cancel.setForeground(new java.awt.Color(0, 0, 0));
        Tic_Cancel.setText("TICKET CANCELLATION");
        Tic_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tic_CancelActionPerformed(evt);
            }
        });
        Tic_Cancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tic_CancelKeyPressed(evt);
            }
        });

        Staff_Reg.setBackground(new java.awt.Color(255, 255, 153));
        Staff_Reg.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        Staff_Reg.setForeground(new java.awt.Color(0, 0, 0));
        Staff_Reg.setText("STAFF REGISTRATION");
        Staff_Reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Staff_RegActionPerformed(evt);
            }
        });
        Staff_Reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Staff_RegKeyPressed(evt);
            }
        });

        Tic_Book.setBackground(new java.awt.Color(255, 255, 153));
        Tic_Book.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        Tic_Book.setForeground(new java.awt.Color(0, 0, 0));
        Tic_Book.setText("TICKET BOOKING");
        Tic_Book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tic_BookActionPerformed(evt);
            }
        });
        Tic_Book.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tic_BookKeyPressed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 102, 102));
        back.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        back.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backKeyPressed(evt);
            }
        });

        feedback.setBackground(new java.awt.Color(255, 255, 153));
        feedback.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        feedback.setForeground(new java.awt.Color(0, 0, 0));
        feedback.setText("FEEDBACK");
        feedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedbackActionPerformed(evt);
            }
        });
        feedback.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                feedbackKeyPressed(evt);
            }
        });

        flight.setBackground(new java.awt.Color(255, 255, 153));
        flight.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        flight.setForeground(new java.awt.Color(0, 0, 0));
        flight.setText("FLIGHT");
        flight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightActionPerformed(evt);
            }
        });
        flight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                flightKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMIN MENU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Staff_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(Cus_Reg))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tic_Book, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(flight, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tic_Cancel))))
                .addGap(30, 31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Cus_Reg, Staff_Reg, Tic_Book, Tic_Cancel, back, feedback, flight});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Staff_Reg)
                    .addComponent(Cus_Reg))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tic_Cancel)
                    .addComponent(Tic_Book))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flight)
                    .addComponent(feedback))
                .addGap(25, 25, 25)
                .addComponent(back)
                .addGap(38, 38, 38))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Staff_Reg, Tic_Book, Tic_Cancel, back, feedback, flight});

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 560, 300));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin Menu.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        //For back Button
        this.hide();
        CommonLogin frm = new CommonLogin ();
        frm.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void Tic_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tic_CancelActionPerformed
        TicketCancellation C = new TicketCancellation("MainMenuAdmin");
        this.hide();
        C.setVisible(true);
    }//GEN-LAST:event_Tic_CancelActionPerformed

    private void Cus_RegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cus_RegActionPerformed
        Customer C = new Customer("MainMenuAdmin");
        this.hide();
        C.setVisible(true);
    }//GEN-LAST:event_Cus_RegActionPerformed

    private void Staff_RegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Staff_RegActionPerformed
        StaffRegistration C = new StaffRegistration("MainMenuAdmin");
        this.hide();
        C.setVisible(true);
    }//GEN-LAST:event_Staff_RegActionPerformed

    private void Tic_BookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tic_BookActionPerformed
        TicketBooking C = new TicketBooking("MainMenuAdmin");
        this.hide();
        C.setVisible(true);
    }//GEN-LAST:event_Tic_BookActionPerformed

    private void feedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedbackActionPerformed
        Feedback C = new Feedback("MainMenuAdmin");
        this.hide();
        C.setVisible(true);
    }//GEN-LAST:event_feedbackActionPerformed

    private void flightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightActionPerformed
        Flight C = new Flight("MainMenuAdmin");
        this.hide();
        C.setVisible(true);
    }//GEN-LAST:event_flightActionPerformed

    //FOR KEYBOARD KEYS....
    private void Tic_CancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tic_CancelKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TicketCancellation C = new TicketCancellation("MainMenuAdmin");
            this.hide();
            C.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            Cus_Reg.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            Tic_Book.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            feedback.requestFocus();
        }
    }//GEN-LAST:event_Tic_CancelKeyPressed

    private void Tic_BookKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tic_BookKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TicketBooking C = new TicketBooking("MainMenuAdmin");
            this.hide();
            C.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            Tic_Cancel.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            Staff_Reg.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            flight.requestFocus();
        }
    }//GEN-LAST:event_Tic_BookKeyPressed

    private void backKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.hide();
            CommonLogin frm = new CommonLogin ();
            frm.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            flight.requestFocus();
        }
    }//GEN-LAST:event_backKeyPressed

    private void Cus_RegKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cus_RegKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Customer C = new Customer("MainMenuAdmin");
            this.hide();
            C.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            Tic_Cancel.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            Staff_Reg.requestFocus();
        }
    }//GEN-LAST:event_Cus_RegKeyPressed

    private void Staff_RegKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Staff_RegKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            StaffRegistration C = new StaffRegistration("MainMenuAdmin");
            this.hide();
            C.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            Cus_Reg.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            Tic_Book.requestFocus();
        }
    }//GEN-LAST:event_Staff_RegKeyPressed

    private void feedbackKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feedbackKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Feedback C = new Feedback("MainMenuAdmin");
            this.hide();
            C.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            Tic_Cancel.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            back.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            flight.requestFocus();
        }
    }//GEN-LAST:event_feedbackKeyPressed

    private void flightKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_flightKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Flight C = new Flight("MainMenuAdmin");
            this.hide();
            C.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            Tic_Book.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            back.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            feedback.requestFocus();
        }
    }//GEN-LAST:event_flightKeyPressed

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
            java.util.logging.Logger.getLogger(MainMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new MainMenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cus_Reg;
    private javax.swing.JButton Staff_Reg;
    private javax.swing.JButton Tic_Book;
    private javax.swing.JButton Tic_Cancel;
    private javax.swing.JButton back;
    private javax.swing.JButton feedback;
    private javax.swing.JButton flight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

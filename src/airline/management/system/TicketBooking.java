/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airline.management.system;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author moham
 */
public class TicketBooking extends javax.swing.JFrame {

    private String sourcePage;
    String jdbcUrl = "jdbc:mysql://localhost:3306/airline_management_system";
    String user = "root";
    String dbpassword = "";
    
    /**
     * Creates new form TicketBooking
     */
    
    Connection con;
    ResultSet rs;
    ResultSet rs1;
    PreparedStatement pst= null;
    PreparedStatement pst1=null;
    PreparedStatement pst2=null;

    
    public TicketBooking(String sourcePage) {
        initComponents();
        this.sourcePage = sourcePage;
        table_update();
        LoadCusID();
        Loadflightno();
        autoID();
        
        //For making all text fields empty...
        cusidbox.setSelectedIndex(-1);
        flightnobox.setSelectedIndex(-1);
        seattypebox.setSelectedIndex(-1);     
        cusname.setText("");
        psprt.setText("");
        nationality.setText("");
        source.setText("");
        Ddate.setText("");
        Dtime.setText("");
        destination.setText("");
        Adate.setText("");
        Atime.setText("");
        ticPrice.setText("");
        discount.setText("");
        DPrice.setText("");
        available.setText("");
        jDateChooser1.setDate(null);
        
        // Add an item listener to the seattypebox
        seattypebox.addItemListener(new java.awt.event.ItemListener() 
        {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) 
            {
                seattypeboxItemStateChanged(evt);
            }

            private void seattypeboxItemStateChanged(ItemEvent evt) 
            {
                if (seattypebox.getSelectedIndex() != -1) 
                {  
                    int selectedIndex = seattypebox.getSelectedIndex();
                
                    try {
                        String ticPrices = rs1.getString("Ticket_Price");
                        String[] ticPriceArray = ticPrices.split(",");
                        
                        if (selectedIndex >= 0 && selectedIndex < ticPriceArray.length) 
                        {
                            // Set the corresponding ticket price based on the selected seat type
                            ticPrice.setText(ticPriceArray[selectedIndex].trim());
                        } else 
                        {
                            // Handle the case where the selected index is out of range
                            ticPrice.setText(""); // Clear the ticPrice field
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
            }
        });
        
        // Add an ActionListener to the discount field
        discount.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                discountActionPerformed(evt);
            }

            private void discountActionPerformed(ActionEvent evt) 
            {
                try {
                    // Get the discount value entered by the user
                    double enteredDiscount = Double.parseDouble(discount.getText());

                    // Retrieve the ticket price from the "Ticket Price" field
                    double ticketPrice = Double.parseDouble(ticPrice.getText());

                    // Calculate the discount price
                    double discountPrice = ticketPrice - (ticketPrice * (enteredDiscount / 100));

                    // Update the "Discount Price" field with the calculated value
                    DPrice.setText(String.format("%.2f", discountPrice));
                } catch (NumberFormatException ex) {
                    // Handle the case where the user enters an invalid discount value
                    DPrice.setText(""); // Clear the "Discount Price" field
                }
            }
        });
    }

    public void table_update()
    {   
        try {
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl, user, dbpassword);
            
            pst = con.prepareStatement("select * from ticket_booking");
            rs = pst.executeQuery();
            ResultSetMetaData rd = rs.getMetaData();
            c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for (int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("Tic_ID"));
                    v2.add(rs.getString("Booking_Date"));
                    v2.add(rs.getString("Cus_ID"));
                    v2.add(rs.getString("Customer_Name"));
                    v2.add(rs.getString("Nationality"));
                    v2.add(rs.getString("Passport_No"));
                    v2.add(rs.getString("Flight_No"));
                    v2.add(rs.getString("Source"));
                    v2.add(rs.getString("Departure_Date"));
                    v2.add(rs.getString("Departure_Time"));
                    v2.add(rs.getString("Destination"));
                    v2.add(rs.getString("Arrival_Date"));
                    v2.add(rs.getString("Arrival_Time"));
                    v2.add(rs.getString("Seat_Type"));
                    v2.add(rs.getString("Ticket_Price"));
                    v2.add(rs.getString("Discount"));
                    v2.add(rs.getString("Discount_Price")); 
                }
                df.addRow(v2);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        back = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        book = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cusname = new javax.swing.JTextField();
        psprt = new javax.swing.JTextField();
        nationality = new javax.swing.JTextField();
        ticID = new javax.swing.JTextField();
        source = new javax.swing.JTextField();
        Ddate = new javax.swing.JTextField();
        Dtime = new javax.swing.JTextField();
        discount = new javax.swing.JTextField();
        available = new javax.swing.JTextField();
        destination = new javax.swing.JTextField();
        Adate = new javax.swing.JTextField();
        Atime = new javax.swing.JTextField();
        ticPrice = new javax.swing.JTextField();
        DPrice = new javax.swing.JTextField();
        seattypebox = new javax.swing.JComboBox<>();
        flightnobox = new javax.swing.JComboBox<>();
        cusidbox = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setText("Ticket Booking");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(474, 474, 474))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        book.setText("Book");
        book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ticket ID", "Booking Date", "Customer ID", "Customer Name", "Nationality", "Passport No", "Flight No", "Source", "Departure Date", "Departure Time", "Destination", "Arrival Date", "Arrival time", "Seat_Type", "Ticket Price", "Discount", "Discount Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Customer ID");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Passport No");

        jLabel5.setText("Nationality");

        jLabel6.setText("Ticket ID");

        jLabel7.setText("Flight No");

        jLabel8.setText("Source");

        jLabel9.setText("Departure Date");

        jLabel10.setText("Departure Time");

        jLabel11.setText("Seat Type");

        jLabel12.setText("Discount");

        jLabel13.setText("Available Seats");

        jLabel14.setText("Destination");

        jLabel15.setText("Arrival Date");

        jLabel16.setText("Arrival Time");

        jLabel17.setText("Ticket Price");

        jLabel18.setText("Discount Price");

        cusname.setEditable(false);
        cusname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cusnameActionPerformed(evt);
            }
        });

        psprt.setEditable(false);

        nationality.setEditable(false);

        ticID.setEditable(false);

        source.setEditable(false);

        Ddate.setEditable(false);

        Dtime.setEditable(false);

        available.setEditable(false);

        destination.setEditable(false);

        Adate.setEditable(false);

        Atime.setEditable(false);

        ticPrice.setEditable(false);

        flightnobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightnoboxActionPerformed(evt);
            }
        });

        cusidbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cusidboxActionPerformed(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("Press Enter after entered the value");

        jLabel20.setText("Booking Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cusname, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(psprt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cusidbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ticID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(source)
                            .addComponent(Ddate)
                            .addComponent(Dtime)
                            .addComponent(discount)
                            .addComponent(seattypebox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(flightnobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(418, 418, 418)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(book)
                                .addGap(106, 106, 106)
                                .addComponent(back)))))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Atime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Adate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(available, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel16, jLabel17, jLabel18, jLabel2, jLabel20, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Adate, Atime, DPrice, Ddate, Dtime, available, cusidbox, cusname, destination, discount, flightnobox, jDateChooser1, nationality, psprt, seattypebox, source, ticID, ticPrice});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel13)
                                .addComponent(available, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(flightnobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ticID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14)
                            .addComponent(source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(cusidbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15)
                            .addComponent(Ddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Adate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cusname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Dtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Atime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel4)
                            .addComponent(psprt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel17)
                            .addComponent(ticPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seattypebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel18)
                            .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(book)
                    .addComponent(back))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel16, jLabel17, jLabel18, jLabel2, jLabel20, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Adate, Atime, DPrice, Ddate, Dtime, available, cusidbox, cusname, destination, discount, flightnobox, jDateChooser1, nationality, psprt, seattypebox, source, ticID, ticPrice});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
     public void autoID()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl, user, dbpassword);
            
            Statement s = con.createStatement();
            
            rs = s.executeQuery("select Max(Tic_ID) from Ticket_Booking");
            rs.next();
            rs.getString("Max(Tic_ID)");
           
            if (rs.getString("Max(Tic_ID)")== null)
            {
                ticID.setText("T0001");
            }
            else
            {
                long id = Long.parseLong(rs.getString("Max(Tic_ID)").substring(2,rs.getString("Max(Tic_ID)").length()));
                id++;
                ticID.setText("T0" + String.format("%03d",id));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void LoadCusID()
    {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl, user, dbpassword);
            pst = con.prepareStatement("select * from customer");
            rs = pst.executeQuery();
            cusidbox.removeAllItems();
            
            while (rs.next())
                {
                    cusidbox.addItem(rs.getString(1));
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void Loadflightno()
    {   
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl, user, dbpassword);
            pst = con.prepareStatement("select * from flight");
            rs = pst.executeQuery();
            flightnobox.removeAllItems();
            
            while (rs.next())
                {
                    flightnobox.addItem(rs.getString(3));
                }        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // For back Button
        this.dispose(); // Close the current page
    
        if (sourcePage.equals("MainMenuAdmin")) {
            MainMenuAdmin adminPage = new MainMenuAdmin();
            adminPage.setVisible(true);
        } else if (sourcePage.equals("MainMenuStaff")) {
            MainMenuStaff staffPage = new MainMenuStaff();
            staffPage.setVisible(true);
        }
    }//GEN-LAST:event_backActionPerformed

    private void cusnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cusnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cusnameActionPerformed

    private void cusidboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cusidboxActionPerformed
        //when a cus id clicked then particular customer's details will be display in next text fields.. 
        if (cusidbox.getSelectedIndex() != -1) {  
        
            try {
                String Cid = cusidbox.getSelectedItem().toString();
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(jdbcUrl,user,dbpassword);
            
                pst1 = con.prepareStatement("select * from customer where Cus_ID = ?");
                pst1.setString(1, Cid);
                rs1 = pst1.executeQuery();
              
                if (rs1.next()) 
                {
                    // Retrieve customer details from the database
                    String customerName = rs1.getString("Customer_Name");
                    String passportNo = rs1.getString("Passport_No");
                    String country = rs1.getString("Nationality");

                    // Populate the text fields with retrieved information
                    cusname.setText(customerName);
                    psprt.setText(passportNo);
                    this.nationality.setText(country);
                } 
                else
                {
                    JOptionPane.showMessageDialog(this, "Customer Not Found");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cusidboxActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Ticket Booking Button
        String tid = ticID.getText();
        String Bdate = jDateChooser1.getDate() != null ? new SimpleDateFormat ("yyyy/MM/dd").format(jDateChooser1.getDate()) : null;
        String cid = cusidbox.getSelectedItem().toString();
        String cname = cusname.getText();
        String passport = psprt.getText();
        String country = nationality.getText();
        String Fno = flightnobox.getSelectedItem().toString();
        String src = source.getText();
        String DprtrD = Ddate.getText();
        String DprtrT = Dtime.getText();
        String dstnt = destination.getText();
        String arvlD = Adate.getText();
        String arvlT = Atime.getText();
        String Stype = seattypebox.getSelectedItem().toString();
        String Tprice = ticPrice.getText();
        String dis = discount.getText();
        String DisP = DPrice.getText();

        // Decrease the available seats by one
        int currentAvailableSeats = Integer.parseInt(available.getText());
        currentAvailableSeats--;

        // Update the "Available Seats" field
        available.setText(String.valueOf(currentAvailableSeats));
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl,user,dbpassword);
            
            if (dis.equals("")||DisP.equals("")||Bdate == null)
            {
                JOptionPane.showMessageDialog(this, "Some Fields are empty");   
            }
            else
            {
                pst = con.prepareStatement("insert into ticket_booking(Tic_ID,Booking_Date,Cus_ID,Customer_Name,Nationality,Passport_No,Flight_No,Source,Departure_Date,Departure_Time,Destination,Arrival_Date,Arrival_Time,Seat_Type,Ticket_Price,Discount,Discount_Price) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, tid);
                pst.setString(2, Bdate);
                pst.setString(3, cid);            
                pst.setString(4, cname);
                pst.setString(5, country);
                pst.setString(6, passport);
                pst.setString(7, Fno);
                pst.setString(8, src);
                pst.setString(9, DprtrD);            
                pst.setString(10, DprtrT);
                pst.setString(11, dstnt);
                pst.setString(12, arvlD);
                pst.setString(13, arvlT);
                pst.setString(14, Stype);
                pst.setString(15, Tprice);
                pst.setString(16, dis);
                pst.setString(17, DisP);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this,"Ticket Boooked.");
            
                //For making all text fields empty...
                cusidbox.setSelectedIndex(-1);
                flightnobox.setSelectedItem(-1);
                seattypebox.setSelectedItem(-1);     
                cusname.setText("");
                psprt.setText("");
                nationality.setText("");
                source.setText("");
                Ddate.setText("");
                Dtime.setText("");
                destination.setText("");
                Adate.setText("");
                Atime.setText("");
                ticPrice.setText("");
                discount.setText("");
                DPrice.setText("");
                available.setText("");
                jDateChooser1.setDate(null);
                autoID();
                table_update();
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    
    
    private void flightnoboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightnoboxActionPerformed
        //when a flight_no clicked then that flight details will appear in next text fields
        if (flightnobox.getSelectedIndex() != -1) 
        {  
            String flightNumber = flightnobox.getSelectedItem().toString();
        
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(jdbcUrl,user,dbpassword);
                pst2 = con.prepareStatement("select * from flight where Flight_No = ?");
                pst2.setString(1, flightNumber);
                rs1 = pst2.executeQuery();
              
                if (rs1.next()) 
                {
                    // Retrieve flight details from the database
                    String srce = rs1.getString("Source");
                    String seatTypes = rs1.getString("Seat_Type");
                    String dprtrDate = rs1.getString("Departure_Date");
                    String dprtrTime = rs1.getString("Departure_Time");
                    String dstntn = rs1.getString("Destination");
                    String arvlDate = rs1.getString("Arrival_Date");
                    String arvlTime = rs1.getString("Arrival_Time");
                    String ticprice = rs1.getString("Ticket_Price");
                    // Retrieve the initial number of available seats
                    int initialAvailableSeats = rs1.getInt("No_of_Seats");
 
                    // Populate the text fields with retrieved information
                    source.setText(srce);
                    Ddate.setText(dprtrDate);
                    Dtime.setText(dprtrTime);
                    destination.setText(dstntn);
                    Adate.setText(arvlDate);
                    Atime.setText(arvlTime);
                    available.setText(String.valueOf(initialAvailableSeats));
                
                    // Fetch and populate seat types in the combo box
                    String[] seatTypeArray = seatTypes.split(","); // Assuming seat types are separated by commas
                    seattypebox.removeAllItems(); // Clear existing items

                    for (String seatType : seatTypeArray) 
                    {
                        seattypebox.addItem(seatType.trim()); // Add each seat type to the combo box
                    }

                    // Fetch and populate ticket prices in the ticPrice field based on the selected seat type
                    String[] ticPriceArray = ticprice.split(","); // Assuming ticket prices correspond to seat types
                    int selectedIndex = seattypebox.getSelectedIndex();

                    if (selectedIndex >= 0 && selectedIndex < ticPriceArray.length) 
                    {
                        // Set the corresponding ticket price based on the selected seat type
                        ticPrice.setText(ticPriceArray[selectedIndex].trim());
                    } else {
                        // Handle the case where the selected index is out of range
                        ticPrice.setText(""); // Clear the ticPrice field
                    }
                }    
                else
                {
                    JOptionPane.showMessageDialog(this, "Flight Not Found");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(TicketBooking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_flightnoboxActionPerformed

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
            java.util.logging.Logger.getLogger(TicketBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketBooking("MainMenuAdmin").setVisible(true);
                new TicketBooking("MainMenuStaff").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Adate;
    private javax.swing.JTextField Atime;
    private javax.swing.JTextField DPrice;
    private javax.swing.JTextField Ddate;
    private javax.swing.JTextField Dtime;
    private javax.swing.JTextField available;
    private javax.swing.JButton back;
    private javax.swing.JButton book;
    private javax.swing.JComboBox<String> cusidbox;
    private javax.swing.JTextField cusname;
    private javax.swing.JTextField destination;
    private javax.swing.JTextField discount;
    private javax.swing.JComboBox<String> flightnobox;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nationality;
    private javax.swing.JTextField psprt;
    private javax.swing.JComboBox<String> seattypebox;
    private javax.swing.JTextField source;
    private javax.swing.JTextField ticID;
    private javax.swing.JTextField ticPrice;
    // End of variables declaration//GEN-END:variables
}

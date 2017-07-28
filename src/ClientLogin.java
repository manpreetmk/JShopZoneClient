
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class ClientLogin extends javax.swing.JFrame
{

    EmployeeHome eh;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    ImageIcon iconProduct;
    ArrayList<ArrayListData> al;
    BillFrame billFrame;

    public ClientLogin()
    {
        initComponents();
        setTitle("Employee Login - jShopZone");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = this.getWidth();
        int frameHeight = this.getHeight();

        int x = (int) ((screenWidth / 2) - (frameWidth / 2));
        int y = (int) ((screenHeight / 2) - (frameHeight / 2));
        setLocation(x, y);
//        Client client = new Client();
//        Thread thread = new Thread(client);
//        thread.start();
        new Thread(new Client()).start();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        tfPhoneNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        showPasswordCb = new javax.swing.JCheckBox();
        lbForgotPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Enter Phone Number");

        tfPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfPhoneNumber.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tfPhoneNumberActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Enter Password");

        tfPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfPassword.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tfPasswordActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLogin.setText("Proceed Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLoginActionPerformed(evt);
            }
        });

        showPasswordCb.setToolTipText("Show Password");
        showPasswordCb.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                showPasswordCbActionPerformed(evt);
            }
        });

        lbForgotPassword.setForeground(new java.awt.Color(0, 0, 255));
        lbForgotPassword.setText("Forgot Password?");
        lbForgotPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbForgotPassword.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lbForgotPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                lbForgotPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                lbForgotPasswordMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(showPasswordCb))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbForgotPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPasswordCb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbForgotPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLoginActionPerformed
    {//GEN-HEADEREND:event_btnLoginActionPerformed
        try
        {
            String phoneNumber = tfPhoneNumber.getText().trim();
            String password = new String(tfPassword.getPassword());

            dos.writeBytes("emp_login\r\n");        //request
            dos.writeBytes(phoneNumber + "\r\n");
            dos.writeBytes(password + "\r\n");
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lbForgotPasswordMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lbForgotPasswordMouseClicked
    {//GEN-HEADEREND:event_lbForgotPasswordMouseClicked
        try
        {
            String email = JOptionPane.showInputDialog(this, "Enter Your Email");
            dos.writeBytes("forgot_password\r\n");
            dos.writeBytes(email + "\r\n");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lbForgotPasswordMouseClicked

    private void lbForgotPasswordMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lbForgotPasswordMouseEntered
    {//GEN-HEADEREND:event_lbForgotPasswordMouseEntered
        lbForgotPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lbForgotPasswordMouseEntered

    private void lbForgotPasswordMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lbForgotPasswordMouseExited
    {//GEN-HEADEREND:event_lbForgotPasswordMouseExited
        lbForgotPassword.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lbForgotPasswordMouseExited

    private void showPasswordCbActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_showPasswordCbActionPerformed
    {//GEN-HEADEREND:event_showPasswordCbActionPerformed

        if (showPasswordCb.isSelected())
        {
            tfPassword.setEchoChar((char) 0);
        } else
        {
            tfPassword.setEchoChar((char) '\u25cf');
        }
    }//GEN-LAST:event_showPasswordCbActionPerformed

    private void tfPhoneNumberActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tfPhoneNumberActionPerformed
    {//GEN-HEADEREND:event_tfPhoneNumberActionPerformed
        btnLoginActionPerformed(evt);
    }//GEN-LAST:event_tfPhoneNumberActionPerformed

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tfPasswordActionPerformed
    {//GEN-HEADEREND:event_tfPasswordActionPerformed

        btnLoginActionPerformed(evt);
    }//GEN-LAST:event_tfPasswordActionPerformed

    public static void main(String args[])
    {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ClientLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ClientLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ClientLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ClientLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ClientLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbForgotPassword;
    private javax.swing.JCheckBox showPasswordCb;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfPhoneNumber;
    // End of variables declaration//GEN-END:variables

    private class Client implements Runnable
    {

        String response;

        public Client()
        {
            try
            {
                socket = new Socket("127.0.0.1", 9000);
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(ClientLogin.this, "Server Not Found");
                System.exit(0);
            }
        }

        public void run()
        {

            try
            {
                while (true)
                {
                    response = dis.readLine();
                    if (response.equals("emp_login_true"))
                    {
                        eh = new EmployeeHome();
                        ClientLogin.this.dispose();
                    } else if (response.equals("emp_login_false"))
                    {
                        JOptionPane.showMessageDialog(ClientLogin.this, "Login Failed", "Error - jShopZone", JOptionPane.ERROR_MESSAGE);
                    } else if (response.equals("email_not_exist"))
                    {
                        JOptionPane.showMessageDialog(ClientLogin.this, "Email Does Not Exist", "Forgot Password - jShopZone", JOptionPane.ERROR_MESSAGE);
                    } else if (response.equals("email_not_sent"))
                    {
                        JOptionPane.showMessageDialog(ClientLogin.this, "Error occured From Server.\nTry Again Later", "Forgot Password - jShopZone", JOptionPane.ERROR_MESSAGE);
                    } else if (response.equals("email_sent"))
                    {
                        JOptionPane.showMessageDialog(ClientLogin.this, "Password has been sent to your Email.", "Forgot Password - jShopZone", JOptionPane.INFORMATION_MESSAGE);
                    } else if (response.equals("product_id_true"))
                    {
                        String name = dis.readLine();
                        Double price = Double.parseDouble(dis.readLine());
                        String subCategoryName = dis.readLine();
                        String categoryName = dis.readLine();
                        eh.nameLb.setText(name);
                        eh.categoryLb.setText(categoryName);
                        eh.subCategoryLb.setText(subCategoryName);
                        eh.priceLb.setText(price + "");
                        eh.quantityTf.setText("1");
                        eh.addBt.setEnabled(true);
                        eh.addBt.requestFocus();
                    } else if (response.equals("product_id_false"))
                    {
                        JOptionPane.showMessageDialog(ClientLogin.this, "Product Not Found", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (response.equals("read_image"))
                    {
                        int arrayLength = dis.readInt();
                        System.out.println("ArrayLength - " + arrayLength);
                        byte[] buffer = new byte[arrayLength];
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        int count = 0;
                        while (true)
                        {
                            int read = dis.read(buffer, 0, buffer.length);
                            baos.write(buffer, 0, read);
                            count += read;
                            if (count == arrayLength)
                            {
                                break;
                            }
                        }
                        byte[] rawImage = baos.toByteArray();
                        iconProduct = new ImageIcon(buffer);

                        Image im = iconProduct.getImage();
                        BufferedImage orig = ClientLogin.toBufferedImage(im);
                        BufferedImage resize = ClientLogin.resize(orig, 128, 128);
                        eh.jLabel6.setIcon(new ImageIcon(resize));

                        eh.jLabel6.setMaximumSize(new Dimension(128, 128));
                        eh.jLabel6.setMinimumSize(new Dimension(128, 128));

                    } else if (response.equals("phone_number_true"))
                    {
                        String name = dis.readLine();
                        String email = dis.readLine();
                        String points = dis.readInt() + "";

                        eh.customerNameLb.setText(name);
                        eh.emailLb.setText(email);
                        eh.pointsLb.setText(points);
                    } else if (response.equals("phone_number_false"))
                    {
                        CustomerAddPanel panel = new CustomerAddPanel();
                        String buttons[] =
                        {
                            "Add", "Cancel"
                        };
                        int n = JOptionPane.showOptionDialog(ClientLogin.this, panel, "Add Customer", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);

                        if (n == JOptionPane.YES_OPTION)
                        {
                            dos.writeBytes("add_customer\r\n");
                            String name = panel.nameTf.getText().trim();
                            String phoneNumber = eh.phoneTf.getText().trim();
                            String email = panel.emailIdTf.getText().trim();

                            if (!(email.contains("@") && email.contains(".") && email.indexOf('@') < email.lastIndexOf('.')))
                            {
                                JOptionPane.showMessageDialog(ClientLogin.this, "Invalid Email-ID");
                                return;
                            }
                            if (name.isEmpty() || phoneNumber.isEmpty() || email.isEmpty())
                            {
                                JOptionPane.showMessageDialog(ClientLogin.this, "Insufficient Information", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                            dos.writeBytes(name + "\r\n");
                            dos.writeBytes(phoneNumber + "\r\n");
                            dos.writeBytes(email + "\r\n");
                        }
                    } else if (response.equals("bill_generate_true"))
                    {
                        JOptionPane.showMessageDialog(eh, "Bill Saved");
                        billFrame = new BillFrame(eh.customerNameLb.getText(), eh.phoneTf.getText(), eh.grandTotalLb.getText());
                        eh.phoneTf.setText(null);
                        eh.customerNameLb.setText(null);
                        eh.emailLb.setText(null);
                        eh.pointsLb.setText(null);
                        eh.itemsLb.setText(null);
                        eh.amountLb.setText(null);
                        eh.vatLb.setText(null);
                        eh.grandTotalLb.setText(null);
                        al.clear();
                        eh.backgroundPanel.removeAll();
                    }
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public class EmployeeHome extends javax.swing.JFrame
    {

        public EmployeeHome()
        {
            initComponents();
            setVisible(true);
            setResizable(false);
            setTitle("jShopZone");
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;
            int frameWidth = this.getWidth();
            int frameHeight = this.getHeight();

            int x = (int) ((screenWidth / 2) - (frameWidth / 2));
            int y = (int) ((screenHeight / 2) - (frameHeight / 2));
            setLocation(x, y);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            al = new ArrayList<>();
            addBt.setEnabled(false);
            checkOutBt.setEnabled(false);

            jScrollPane1.setMaximumSize(new Dimension(380, 333));
            jScrollPane1.setMinimumSize(new Dimension(380, 333));

            jPanel1.setMaximumSize(new Dimension(308, 316));
            jPanel1.setMinimumSize(new Dimension(308, 316));

            jLabel6.setMaximumSize(new Dimension(128, 128));
            jLabel6.setMinimumSize(new Dimension(128, 128));

            jLabel6.setBorder(new LineBorder(Color.BLACK, 2));
        }

        void refreshPanels()
        {
            Image im = iconProduct.getImage();
            BufferedImage orig = ClientLogin.toBufferedImage(im);
            BufferedImage resize = ClientLogin.resize(orig, 152, 180);
            backgroundPanel.removeAll();
            DynamicPanel dynamicPanel[] = new DynamicPanel[al.size()];
            for (int i = 0; i < al.size(); i++)
            {
                int j = i;
                ArrayListData arrayListData = al.get(i);
                System.out.println("jfkfdjknjkjk");
                dynamicPanel[i] = new DynamicPanel(arrayListData.quantity, arrayListData.name, arrayListData.category, arrayListData.subCategory, arrayListData.price, arrayListData.iconProduct);
                dynamicPanel[i].removeBt.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                        System.out.println(al.get(j).quantity + "  --------------");
                        if (al.get(j).quantity > 1)
                        {
                            al.get(j).quantity--;
                            refreshPanels();
                        } else
                        {
                            al.remove(j);
                        }
                    }
                });
                backgroundPanel.add(dynamicPanel[i]);
                backgroundPanel.invalidate();
                this.setSize(this.getSize().width + 1, this.getSize().height);
                this.setSize(this.getSize().width - 1, this.getSize().height);
            }
        }

        void updateAmount()
        {
            int totalItems = al.size();
            int totalAmount = 0;
            double VAT = 14.7;
            double grandAmount = 0;
            for (int i = 0; i < al.size(); i++)
            {
                int itemQuantity = al.get(i).quantity;
                totalAmount += al.get(i).price * itemQuantity;
            }
            grandAmount = totalAmount + (double) ((totalAmount / 100) * VAT);
            itemsLb.setText(totalItems + "");
            amountLb.setText(totalAmount + "");
            vatLb.setText(VAT + "%");
            grandTotalLb.setText(grandAmount + "");
        }

        private void addBtActionPerformed(java.awt.event.ActionEvent evt)
        {
            Image im = iconProduct.getImage();
            BufferedImage orig = ClientLogin.toBufferedImage(im);
            BufferedImage resize = ClientLogin.resize(orig, 152, 180);

            if (productIdTf.getText().isEmpty() || nameLb.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Insuffucient Information");
                return;
            }
            backgroundPanel.removeAll();
            boolean alUpdate = true;
            for (int i = 0; i < al.size(); i++)
            {
                if (al.get(i).productId.equals(productIdTf.getText()))
                {
                    al.get(i).quantity += Integer.parseInt(quantityTf.getText());
                    alUpdate = false;
                }
            }
            if (alUpdate)
            {
                al.add(new ArrayListData(productIdTf.getText(), nameLb.getText(), Double.parseDouble(priceLb.getText()), categoryLb.getText(), subCategoryLb.getText(), resize, Integer.parseInt(quantityTf.getText())));
            }
            for (int i = 0; i < al.size(); i++)
            {
                int j = i;
                ArrayListData arrayListData = al.get(i);
                DynamicPanel dynamicPanel = new DynamicPanel(arrayListData.quantity, arrayListData.name, arrayListData.category, arrayListData.subCategory, arrayListData.price, arrayListData.iconProduct);
                dynamicPanel.removeBt.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                        al.remove(j);
                        refreshPanels();
                    }
                });
                backgroundPanel.add(dynamicPanel);
                backgroundPanel.invalidate();
            }
            productIdTf.setText(null);
            nameLb.setText(null);
            priceLb.setText(null);
            categoryLb.setText(null);
            subCategoryLb.setText(null);
            jLabel6.setIcon(null);
            addBt.setEnabled(false);
            quantityTf.setText(null);
            productIdTf.requestFocus();
            checkOutBt.setEnabled(true);
            updateAmount();
        }

        private void checkOutBtActionPerformed(java.awt.event.ActionEvent evt)
        {
            try
            {
                String phoneNumber = phoneTf.getText().trim();
                Double totalAmount = Double.parseDouble(eh.grandTotalLb.getText());
                if (phoneNumber.isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "No Phone Number");
                    return;
                }
                int currentPoints = Integer.parseInt(pointsLb.getText());
                int newPoints = 0;
                if (totalAmount > 1000)
                {
                    if (currentPoints >= 0)
                    {
                        System.out.println("current pts" + currentPoints);
                        int n = JOptionPane.showConfirmDialog(this, "Do you want to use all points?", "Title", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (n == JOptionPane.YES_OPTION)
                        {
                            double tempPrice = totalAmount;
                            tempPrice -= currentPoints;
                            if (tempPrice < 0)
                            {
                                JOptionPane.showMessageDialog(this, "Cannot use points on this amount");
                            } else
                            {
                                currentPoints = 0;
                                grandTotalLb.setText(totalAmount + "");
                                totalAmount = tempPrice;
                            }
                        }
                        newPoints = (int) (totalAmount / 1000) + currentPoints;
                        System.out.println("total =" + totalAmount);
                        System.out.println("new pts =" + newPoints);
                    }
                }
                dos.writeBytes("bill_generate\r\n");
                dos.writeBytes(phoneTf.getText() + "\r\n");
                dos.writeDouble(totalAmount);
                dos.writeInt(newPoints);
                dos.writeInt(al.size());
                for (int i = 0; i < al.size(); i++)
                {
                    dos.writeBytes(al.get(i).productId + "\r\n");
                    dos.writeInt(al.get(i).quantity);
                }
//                phoneTf.setText(null);
//                customerNameLb.setText(null);
//                emailLb.setText(null);
//                pointsLb.setText(null);
//                itemsLb.setText(null);
//                amountLb.setText(null);
//                vatLb.setText(null);
//                grandTotalLb.setText(null);
//                al.clear();
//                refreshPanels();
            } catch (IOException ex)
            {
                Logger.getLogger(ClientLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void phoneTfActionPerformed(java.awt.event.ActionEvent evt)
        {
            try
            {
                if (phoneTf.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "Enter a Phone Number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                dos.writeBytes("phone_number\r\n");
                dos.writeBytes(phoneTf.getText() + "\r\n");
            } catch (IOException ex)
            {
                Logger.getLogger(ClientLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents()
        {

            jFrame1 = new javax.swing.JFrame();
            jLabel7 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            jPanel1 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            productIdTf = new javax.swing.JTextField();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            addBt = new javax.swing.JButton();
            nameLb = new javax.swing.JLabel();
            categoryLb = new javax.swing.JLabel();
            subCategoryLb = new javax.swing.JLabel();
            priceLb = new javax.swing.JLabel();
            jLabel17 = new javax.swing.JLabel();
            quantityTf = new javax.swing.JTextField();
            jScrollPane1 = new javax.swing.JScrollPane();
            backgroundPanel = new javax.swing.JPanel();
            customerPanel = new javax.swing.JPanel();
            jLabel9 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            jLabel11 = new javax.swing.JLabel();
            jLabel12 = new javax.swing.JLabel();
            phoneTf = new javax.swing.JTextField();
            customerNameLb = new javax.swing.JLabel();
            emailLb = new javax.swing.JLabel();
            pointsLb = new javax.swing.JLabel();
            totalPanel = new javax.swing.JPanel();
            jLabel13 = new javax.swing.JLabel();
            jLabel14 = new javax.swing.JLabel();
            jLabel15 = new javax.swing.JLabel();
            jLabel16 = new javax.swing.JLabel();
            itemsLb = new javax.swing.JLabel();
            amountLb = new javax.swing.JLabel();
            vatLb = new javax.swing.JLabel();
            grandTotalLb = new javax.swing.JLabel();
            checkOutBt = new javax.swing.JButton();

            javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
            jFrame1.getContentPane().setLayout(jFrame1Layout);
            jFrame1Layout.setHorizontalGroup(
                    jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 400, Short.MAX_VALUE)
            );
            jFrame1Layout.setVerticalGroup(
                    jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 300, Short.MAX_VALUE)
            );

            jLabel7.setText("jLabel7");

            jLabel8.setText("jLabel8");

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Product Panel"));

            jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jLabel1.setText("Product ID");

            productIdTf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            productIdTf.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    productIdTfActionPerformed(evt);
                }
            });

            jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jLabel2.setText("Name");

            jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jLabel3.setText("Category");

            jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jLabel4.setText("Sub Category");

            jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jLabel5.setText("Price");

            jLabel6.setBackground(new java.awt.Color(102, 255, 0));

            addBt.setText("Add To Cart");
            addBt.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    addBtActionPerformed(evt);
                }
            });

            nameLb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            categoryLb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            subCategoryLb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            priceLb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            jLabel17.setText("Quantity");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                                            .addContainerGap()
                                                                            .addComponent(jLabel4))
                                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                            .addGap(10, 10, 10)
                                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                            .addGap(0, 20, Short.MAX_VALUE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(addBt, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                                    .addComponent(productIdTf)
                                                    .addComponent(nameLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(categoryLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(subCategoryLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(priceLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(quantityTf, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))))
                            .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(productIdTf, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(nameLb, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                            .addGap(5, 5, 5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(categoryLb, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                            .addGap(9, 9, 9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(subCategoryLb, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceLb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantityTf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addBt, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cart"));

            backgroundPanel.setLayout(new javax.swing.BoxLayout(backgroundPanel, javax.swing.BoxLayout.Y_AXIS));
            jScrollPane1.setViewportView(backgroundPanel);

            customerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer Information"));

            jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jLabel9.setText("Phone Number");

            jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jLabel10.setText("Name");

            jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jLabel11.setText("Email ID");

            jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jLabel12.setText("Points");

            phoneTf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            phoneTf.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    phoneTfActionPerformed(evt);
                }
            });

            customerNameLb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            emailLb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            pointsLb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            javax.swing.GroupLayout customerPanelLayout = new javax.swing.GroupLayout(customerPanel);
            customerPanel.setLayout(customerPanelLayout);
            customerPanelLayout.setHorizontalGroup(
                    customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(phoneTf, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(customerNameLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(emailLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pointsLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
            );
            customerPanelLayout.setVerticalGroup(
                    customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneTf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(customerNameLb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(11, 11, 11)
                            .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(emailLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pointsLb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            totalPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));

            jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jLabel13.setText("Items");

            jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jLabel14.setText("Amount");

            jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jLabel15.setText("VAT");

            jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            jLabel16.setText("Grand Total");

            itemsLb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            amountLb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            vatLb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            grandTotalLb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

            checkOutBt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            checkOutBt.setText("Proceed To Bill");
            checkOutBt.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    checkOutBtActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout totalPanelLayout = new javax.swing.GroupLayout(totalPanel);
            totalPanel.setLayout(totalPanelLayout);
            totalPanelLayout.setHorizontalGroup(
                    totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkOutBt, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                    .addGroup(totalPanelLayout.createSequentialGroup()
                                            .addGroup(totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(43, 43, 43)
                                            .addGroup(totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(itemsLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(amountLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(vatLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(grandTotalLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addContainerGap())
            );
            totalPanelLayout.setVerticalGroup(
                    totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(itemsLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(amountLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(vatLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(totalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(grandTotalLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(checkOutBt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(customerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(totalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(customerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
            );

            pack();
        }// </editor-fold>                                       

        private void productIdTfActionPerformed(java.awt.event.ActionEvent evt)
        {
            try
            {
                String productID = productIdTf.getText().trim();
                if (productID.isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "Product ID missing", "Error - jShopZone", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                dos.writeBytes("product_id\r\n");
                dos.writeBytes(productID + "\r\n");
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

        // Variables declaration - do not modify                     
        private javax.swing.JButton addBt;
        private javax.swing.JLabel amountLb;
        private javax.swing.JLabel jLabel17;
        private javax.swing.JPanel backgroundPanel;
        private javax.swing.JLabel categoryLb;
        private javax.swing.JButton checkOutBt;
        private javax.swing.JLabel customerNameLb;
        private javax.swing.JPanel customerPanel;
        private javax.swing.JLabel emailLb;
        private javax.swing.JLabel grandTotalLb;
        private javax.swing.JLabel itemsLb;
        private javax.swing.JFrame jFrame1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel13;
        private javax.swing.JLabel jLabel14;
        private javax.swing.JLabel jLabel15;
        private javax.swing.JLabel jLabel16;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JLabel nameLb;
        private javax.swing.JTextField phoneTf;
        private javax.swing.JTextField quantityTf;
        private javax.swing.JLabel pointsLb;
        private javax.swing.JLabel priceLb;
        private javax.swing.JTextField productIdTf;
        private javax.swing.JLabel subCategoryLb;
        private javax.swing.JPanel totalPanel;
        private javax.swing.JLabel vatLb;
        // End of variables declaration     

    }

    class ArrayListData
    {

        String productId;
        int quantity;
        double price;
        String name, category, subCategory;
        BufferedImage iconProduct;

        public ArrayListData(String productId, String name, double price, String category, String subCategory, BufferedImage iconProduct, int quantity)
        {
            this.productId = productId;
            this.price = price;
            this.name = name;
            this.category = category;
            this.subCategory = subCategory;
            this.iconProduct = iconProduct;
            this.quantity = quantity;
        }
    }

    public static BufferedImage resize(BufferedImage image, int width, int height)
    {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    public class BillFrame extends javax.swing.JFrame
    {

        public BillFrame(String name, String phoneNumber, String total)
        {
            initComponents();
            setVisible(true);
            setResizable(false);
            setTitle("Bill");
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;
            int frameWidth = this.getWidth();
            int frameHeight = this.getHeight();

            int x = (int) ((screenWidth / 2) - (frameWidth / 2));
            int y = (int) ((screenHeight / 2) - (frameHeight / 2));
            setLocation(x, y);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            System.out.println(al.size());
            for (int i = 0; i < al.size(); i++)
            {
                DynamicBill dynamicBill = new DynamicBill(al.get(i).name, al.get(i).quantity, al.get(i).price);

                jPanel1.add(dynamicBill);
                jPanel1.invalidate();
            }
            dateLb.setText(new SimpleDateFormat("dd MMM yyy HH:mm:ss a").format(new Date(System.currentTimeMillis())));
            customerNameLb.setText(name);
            phoneNumberLb.setText(phoneNumber);
            totalLb.setText(total);
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents()
        {

            jLabel1 = new javax.swing.JLabel();
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
            jScrollPane1 = new javax.swing.JScrollPane();
            jPanel1 = new javax.swing.JPanel();
            customerNameLb = new javax.swing.JLabel();
            phoneNumberLb = new javax.swing.JLabel();
            jLabel12 = new javax.swing.JLabel();
            totalLb = new javax.swing.JLabel();
            dateLb = new javax.swing.JLabel();
            jLabel13 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Bill");

            jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
            jLabel1.setText("jShopZone");

            jLabel2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
            jLabel2.setText("Pvt Ltd.");

            jLabel3.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
            jLabel3.setText("Created By: Jaideep Singh,");

            jLabel4.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
            jLabel4.setText("Bawneet Kaur, Aayush Gupta");

            jLabel5.setText("CASH MEMO");

            jLabel6.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
            jLabel6.setText("*****************************************************");

            jLabel7.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
            jLabel7.setText("Quantity");

            jLabel8.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
            jLabel8.setText("Name");

            jLabel9.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
            jLabel9.setText("Price");

            jLabel10.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
            jLabel10.setText("Amount (Rs)");

            jLabel11.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
            jLabel11.setText("*****************************************************");

            jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
            jScrollPane1.setViewportView(jPanel1);

            customerNameLb.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
            customerNameLb.setText("jLabel12");

            phoneNumberLb.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
            phoneNumberLb.setText("jLabel12");

            jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel12.setText("Payable Amount");

            totalLb.setText("jLabel13");

            dateLb.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
            dateLb.setText("jLabel13");

            jLabel13.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
            jLabel13.setText("*****************************************************");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel9)
                            .addGap(46, 46, 46)
                            .addComponent(jLabel10)
                            .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                            .addGap(138, 138, 138)
                            .addComponent(jLabel2)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                            .addGap(103, 103, 103)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(27, 27, 27)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(customerNameLb)
                                    .addComponent(phoneNumberLb)
                                    .addComponent(dateLb))
                            .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalLb, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addGap(4, 4, 4)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel7)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(totalLb))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dateLb)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(customerNameLb)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(phoneNumberLb)
                            .addContainerGap(12, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>                          

        // Variables declaration - do not modify                     
        private javax.swing.JLabel customerNameLb;
        private javax.swing.JLabel dateLb;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel13;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JLabel phoneNumberLb;
        private javax.swing.JLabel totalLb;
        // End of variables declaration                   
    }
}

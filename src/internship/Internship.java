/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internship;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mrx
 */
public class Internship extends JFrame {

    // <editor-fold defaultstate="collapsed" desc="All variables">
    static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    
    static Internship internship;
    static Login login;
    static StudentReg studentReg;
    static CompanyReg companyReg;
    static Company company;
    
    static Container pane;
    static CardLayout cl;
    static Container stu_pane;
    static CardLayout stu_cl;
    
    static Connection conn;
    static Statement st, st2;
    static PreparedStatement ps;
    static ResultSet rs, rs2;
    
    static String currentRoll = "";
    static String query = "";
    static int currentComp = 0;
    
    static DefaultTableModel tm_all;
    // </editor-fold>
    
    /**
     * Creates new form Internship2
     */
    public Internship() {
        super("Internship");
        initComponents();
    }
    
    private static void showi(String info){
        JOptionPane.showMessageDialog(null, info, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void showe(String error){
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    static void setsize(int width, int height) {
        internship.setPreferredSize(new Dimension(width, height));
        internship.setSize(width, height);
    }
    
    static void showLogin() {
        setsize(400, 270);
        cl.show(pane, "LOGIN");
    }
    
    static void showStudentReg() {
        setsize(599, 320);
        try {
            rs = st.executeQuery("SELECT dept_name FROM department");
            while(rs.next())
                studentReg.deptCb.addItem(rs.getString("dept_name"));
        } catch (Exception ex) {
            System.err.println("err showStudentReg 01:"+ex);
        }
        
        cl.show(pane, "STUDENTREG");
    }
    
    static void showCompanyReg() {
        
    }
    
    static void showStudent() {
        
    }
    
    static void showCompany() {
        try {
            rs = st.executeQuery("SELECT * FROM company WHERE company_id = " + currentComp);
            if(rs.next()) {
                company.comp_id.setText(rs.getString("company_id"));
                company.comp_name.setText(rs.getString("company_name"));
                company.comp_addr.setText(rs.getString("address"));
                company.comp_site.setText(rs.getString("website"));
                company.comp_cat.setText("category");
                company.comp_sector.setText("sector");
            }
            
            rs = st.executeQuery("SELECT internship_id, profile FROM internship WHERE company_id = " + currentComp);
            tm_all = (DefaultTableModel) company.all_table.getModel();
            while(rs.next()) {
                JButton tmp = new JButton("Applicants_" + rs.getInt("internship_id"));
                tmp.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        Applicants aa = new Applicants(((JButton)(e.getSource())).getText().substring(11));
                    }
                });
                tm_all.addRow(new Object[] {rs.getInt("internship_id"), rs.getString("profile"), });
            }
        } catch (Exception ex) {
            Logger.getLogger(Internship.class.getName()).log(Level.SEVERE, null, ex);
        }
        setsize(482, 445);
        cl.show(pane, "COMPANY");
    }
    
    static void setListeners() {
        login.loginB.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(login.usernameTf.getText().equals("") || new String(login.passwordPf.getPassword()).equals(""))
                    showe("None of the fields can be empty!!");
                else if(login.choiceCb.getSelectedIndex() == 0) {
                    try {
                        rs = st.executeQuery("SELECT password FROM student where roll_no = '"+login.usernameTf.getText()+"'");
                        if(rs.next()){
                            if(rs.getString("password").equals(new String(login.passwordPf.getPassword())))
                                showStudent();
                        }
                    } catch (Exception ex) {
                        showe("Such Username doesn't exist!");
                    }
                }
                else if(login.choiceCb.getSelectedIndex() == 1) {
                    try {
                        rs = st.executeQuery("SELECT password FROM company where company_id = '"+login.usernameTf.getText()+"'");
                        if(rs.next()){
                            if(rs.getString("password").equals(new String(login.passwordPf.getPassword())))
                                showCompany();
                        }
                    } catch (Exception ex) {
                        showe("Please check your ID once again!");
                    }
                }
                // TODO : reset all fields
            }
        });
        
        login.regCompanyB.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                showCompanyReg();
            }
        });
        
        login.regStudentB.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                showStudentReg();
            }
        });
        
        studentReg.uploadB.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // TODO : get file name and address
            }
        });
        
        studentReg.reg_nextB.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(studentReg.rollTf.getText().equals("") ||
                   studentReg.nameTf.getText().equals("") ||
                   studentReg.emailTf.getText().equals("") ||
                   studentReg.phoneTf.getText().equals(""))
                    showe("None of the fields can be empty or Invalid!!");
                
                else {
                    try {
                        ps = conn.prepareStatement("INSERT INTO student VALUES(?, ?, ?, ?, ?, ?, ?)");
                        ps.setString(1, studentReg.rollTf.getText());
                        ps.setString(2, new String(studentReg.passwordPf.getPassword()));
                        ps.setString(3, (String) studentReg.degreeCb.getSelectedItem());
                        ps.setString(4, studentReg.cgpaTf.getText());
                        ps.setString(5, (String) studentReg.sexCb.getSelectedItem());
                        ps.setString(6, studentReg.emailTf.getText());
                        ps.setString(7, studentReg.phoneTf.getText());
                        ps.executeUpdate();
                        currentRoll = studentReg.rollTf.getText();
                        
                        // TODO : upload resume
                        
                        // TODO : clear all fields
                        
                        stu_cl.show(stu_pane, "STU_ACADQP");
                    } catch(Exception ex) {
                        showe("Roll No already exists!!");
                    }
                }
            }
        });
        
        studentReg.acadq_anotherB.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(studentReg.acadq_standardTf.getText().equals("") ||
                    studentReg.acadq_nameTf.getText().equals("") ||
                    studentReg.acadq_instiTf.getText().equals("") ||
                    studentReg.acadq_branchTf.getText().equals("") ||
                    studentReg.acadq_cgpaTf.getText().equals("") ||
                    studentReg.acadq_yearTf.getText().equals(""))
                    showe("None of the fields can be empty or Invalid!!");
                else {
                    try {
                        ps = conn.prepareStatement("INSERT INTO academic_qualification VALUES(?, ?, ?, ?, ?, ?, ?)");
                        ps.setString(1, currentRoll);
                        ps.setString(2, studentReg.acadq_standardTf.getText());
                        ps.setString(3, studentReg.acadq_nameTf.getText());
                        ps.setString(4, studentReg.acadq_instiTf.getText());
                        ps.setString(5, studentReg.acadq_branchTf.getText());
                        ps.setString(6, studentReg.acadq_cgpaTf.getText());
                        ps.setString(7, studentReg.acadq_yearTf.getText());
                        ps.executeUpdate();
                        
                        // TODO : clear all fields
                    } catch(Exception ex) {
                        showe("Academic Qualification\nNone of the fields can be empty or Invalid!!");
                    }
                }
            }
        });
        
        studentReg.acadq_nextB.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(studentReg.acadq_standardTf.getText().equals("") ||
                    studentReg.acadq_nameTf.getText().equals("") ||
                    studentReg.acadq_instiTf.getText().equals("") ||
                    studentReg.acadq_branchTf.getText().equals("") ||
                    studentReg.acadq_cgpaTf.getText().equals("") ||
                    studentReg.acadq_yearTf.getText().equals(""))
                    showe("None of the fields can be empty or Invalid!!");
                else {
                    try {
                        ps = conn.prepareStatement("INSERT INTO academic_qualification VALUES(?, ?, ?, ?, ?, ?, ?)");
                        ps.setString(1, currentRoll);
                        ps.setString(2, studentReg.acadq_standardTf.getText());
                        ps.setString(3, studentReg.acadq_nameTf.getText());
                        ps.setString(4, studentReg.acadq_instiTf.getText());
                        ps.setString(5, studentReg.acadq_branchTf.getText());
                        ps.setString(6, studentReg.acadq_cgpaTf.getText());
                        ps.setString(7, studentReg.acadq_yearTf.getText());
                        ps.executeUpdate();
                        
                        // TODO : clear all fields
                        
                        stu_cl.show(stu_pane, "STU_ACADAP");
                    } catch(Exception ex) {
                        showe("Academic Qualification\nNone of the fields can be empty or Invalid!!");
                    }
                }
            }
        });
        
        studentReg.acada_anotherB.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(studentReg.acada_orgTf.getText().equals("") ||
                    studentReg.acada_nameTf.getText().equals("") ||
                    studentReg.acada_detailsTa.getText().equals(""))
                    showe("None of the fields can be empty or Invalid!!");
                else {
                    try {
                        ps = conn.prepareStatement("INSERT INTO academic_achievements VALUES(?, ?, ?, ?)");
                        ps.setString(1, currentRoll);
                        ps.setString(2, studentReg.acada_nameTf.getText());
                        ps.setString(3, studentReg.acada_orgTf.getText());
                        ps.setString(4, studentReg.acada_detailsTa.getText());
                        ps.executeUpdate();
                        
                        // TODO : clear all fields
                    } catch(Exception ex) {
                        showe("Academic Achievements\nNone of the fields can be empty or Invalid!!");
                    }
                }
            }
        });
        
        studentReg.acada_nextB.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(studentReg.acada_orgTf.getText().equals("") ||
                    studentReg.acada_nameTf.getText().equals("") ||
                    studentReg.acada_detailsTa.getText().equals(""))
                    showe("None of the fields can be empty or Invalid!!");
                else {
                    try {
                        ps = conn.prepareStatement("INSERT INTO academic_achievements VALUES(?, ?, ?, ?)");
                        ps.setString(1, currentRoll);
                        ps.setString(2, studentReg.acada_nameTf.getText());
                        ps.setString(3, studentReg.acada_orgTf.getText());
                        ps.setString(4, studentReg.acada_detailsTa.getText());
                        ps.executeUpdate();
                        
                        // TODO : clear all fields
                        
                        stu_cl.show(stu_pane, "STU_QEP");
                    } catch(Exception ex) {
                        showe("Academic Achievements\nNone of the fields can be empty or Invalid!!");
                    }
                }
            }
        });
        
        studentReg.qe_nextB.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(studentReg.qe_nameTf.getText().equals("") ||
                    studentReg.qe_yearTf.getText().equals("") ||
                    studentReg.qe_rankTf.getText().equals(""))
                    showe("None of the fields can be empty or Invalid!!");
                else {
                    try {
                        ps = conn.prepareStatement("INSERT INTO qualifying_exam VALUES(?, ?, ?, ?)");
                        ps.setString(1, currentRoll);
                        ps.setString(2, studentReg.qe_nameTf.getText());
                        ps.setString(3, studentReg.qe_rankTf.getText());
                        ps.setString(4, studentReg.qe_yearTf.getText());
                        ps.executeUpdate();
                        
                        // TODO : clear all fields
                        
                        stu_cl.show(stu_pane, "STU_PORP");
                    } catch(Exception ex) {
                        showe("Qualifying Examination\nNone of the fields can be empty or Invalid!!");
                    }
                }
            }
        });
        
        studentReg.por_anotherTf.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(studentReg.por_orgTf.getText().equals("") ||
                    studentReg.por_roleTf.getText().equals("") ||
                    studentReg.por_actTa.getText().equals(""))
                    showe("None of the fields can be empty or Invalid!!");
                else {
                    try {
                        ps = conn.prepareStatement("INSERT INTO pos_of_res VALUES(?, ?, ?, ?, ?, ?, ?)");
                        ps.setString(1, currentRoll);
                        ps.setString(2, studentReg.por_orgTf.getText());
                        ps.setString(3, studentReg.por_roleTf.getText());
                        ps.setString(4, studentReg.por_actTa.getText());
                        ps.executeUpdate();
                        
                        // TODO : clear all fields
                    } catch(Exception ex) {
                        showe("Position of Responsibility\nNone of the fields can be empty or Invalid!!");
                    }
                }
            }
        });
        
        studentReg.por_finishB.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(studentReg.por_orgTf.getText().equals("") ||
                    studentReg.por_roleTf.getText().equals("") ||
                    studentReg.por_actTa.getText().equals(""))
                    showe("None of the fields can be empty or Invalid!!");
                else {
                    try {
                        ps = conn.prepareStatement("INSERT INTO academic_qualification VALUES(?, ?, ?, ?, ?, ?, ?)");
                        ps.setString(1, currentRoll);
                        ps.setString(2, studentReg.por_orgTf.getText());
                        ps.setString(3, studentReg.por_roleTf.getText());
                        ps.setString(4, studentReg.por_actTa.getText());
                        ps.executeUpdate();
                        
                        // TODO : clear all fields
                        
                        cl.show(pane, "LOGIN");
                    } catch(Exception ex) {
                        showe("Academic Qualification\nNone of the fields can be empty or Invalid!!");
                    }
                }
            }
        });
        
        companyReg.regB.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(companyReg.nameTf.getText().equals("") ||
                    new String(companyReg.passPf.getPassword()).equals("") ||
                    companyReg.addressTa.getText().equals("") ||
                    companyReg.siteTf.getText().equals("") ||
                    companyReg.catTf.getText().equals("") ||
                    companyReg.sectorTf.getText().equals(""))
                    showe("None of the fields can be empty or Invalid!!");
                else {
                    try {
                        ps = conn.prepareStatement("INSERT INTO academic_qualification VALUES(NULL, ?, ?, ?, ?, ?)");
                        ps.setString(1, companyReg.nameTf.getText());
                        ps.setString(2, companyReg.addressTa.getText());
                        ps.setString(3, companyReg.siteTf.getText());
                        ps.setString(4, companyReg.catTf.getText());
                        ps.setString(5, companyReg.sectorTf.getText());
                        ps.executeUpdate();
                        
                        rs = st.executeQuery("SELECT company_id FROM company WHERE company_name = '" + companyReg.nameTf.getText() + "'");
                        if(rs.next()) {
                            currentComp = rs.getInt("company_id");
                        }
                        
                        ps = conn.prepareStatement("INSERT INTO company_progress VALUES (?, ?)");
                        ps.setInt(1, currentComp);
                        ps.setString(2, new String(companyReg.passPf.getPassword()));
                        ps.executeUpdate();
                        showi("Your Company ID : " + currentComp);
                        
                        // TODO : clear all fields
                        
                        cl.show(pane, "LOGIN");
                    } catch(Exception ex) {
                        showe("None of the fields can be empty or Invalid!!");
                    }
                }
            }
        });
        
        company.comp_logout.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // TODO : reset tables, labels, fields
                
                cl.show(pane, "LOGIN");
            }
        });
        
        company.new_degrees.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Degrees degrees = new Degrees();
                query = degrees.getDegrees();
            }
        });
        
        company.new_submit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(company.new_profile.getText().equals("") ||
                    company.new_stipend.getText().equals("") ||
                    company.new_cgpa.getText().equals("") ||
                    company.new_process.getText().equals("") ||
                    company.new_endDate.getText().equals("") ||
                    company.new_interview.getText().equals(""))
                    showe("None of the fields can be empty or Invalid!!");
                else {
                    try {
                        ps = conn.prepareStatement("INSERT INTO internship VALUES(NULL, ?, ?, ?, ?, ?, ?, ?)");
                        ps.setInt(1, currentComp);
                        ps.setString(2, company.new_profile.getText());
                        ps.setString(3, company.new_stipend.getText());
                        ps.setString(4, company.new_cgpa.getText());
                        ps.setString(5, company.new_process.getText());
                        ps.setString(6, company.new_endDate.getText());
                        ps.setString(7, studentReg.acadq_yearTf.getText());
                        ps.setString(8, company.new_interview.getText());
                        ps.executeUpdate();
                        
                        rs = st.executeQuery("SELECT internship_id FROM internship WHERE company_id = "
                                + currentComp + " AND profile = '" + company.new_profile.getText() + "'");
                        String intern_id = "";
                        if(rs.next())
                            intern_id = rs.getString("internship_id");
                        query = query.replace("?", intern_id);
                        ps = conn.prepareStatement(query.substring(0, query.length()-2));
                        ps.executeUpdate();
                        query = "";
                        
                        // TODO : clear all fields
                    } catch(Exception ex) {
                        showe("Interview\nNone of the fields can be empty or Invalid!!");
                    }
                }
            }
        });
        
        company.notice_subCb.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(company.notice_headTf.getText().equals("") ||
                    company.notice_textTa.getText().equals(""))
                    showe("None of the fields can be empty or Invalid!!");
                else {
                    try {
                        ps = conn.prepareStatement("INSERT INTO notice VALUES(NULL, ?, ?, ?, ?, ?, ?, ?)");
                        ps.setInt(1, currentComp);
                        ps.setString(2, company.new_profile.getText());
                        ps.setString(3, company.new_stipend.getText());
                        ps.setString(4, company.new_cgpa.getText());
                        ps.setString(5, company.new_process.getText());
                        ps.setString(6, company.new_endDate.getText());
                        ps.setString(7, studentReg.acadq_yearTf.getText());
                        ps.setString(8, company.new_interview.getText());
                        ps.executeUpdate();
                        
                        rs = st.executeQuery("SELECT internship_id FROM internship WHERE company_id = "
                                + currentComp + " AND profile = '" + company.new_profile.getText() + "'");
                        String intern_id = "";
                        if(rs.next())
                            intern_id = rs.getString("internship_id");
                        query = query.replace("?", intern_id);
                        ps = conn.prepareStatement(query.substring(0, query.length()-2));
                        ps.executeUpdate();
                        query = "";
                        
                        // TODO : clear all fields
                    } catch(Exception ex) {
                        showe("Interview\nNone of the fields can be empty or Invalid!!");
                    }
                }
                // TODO : reset all fields
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
        } catch(Exception ex) {
            System.err.println("err main 01:"+ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    internship = new Internship();
                    login = new Login();
                    studentReg = new StudentReg();
                    companyReg = new CompanyReg();
                    company = new Company();
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://10.5.18.66:3306/12CS30001", "12CS30001", "dual12");
                    st = conn.createStatement();
                    
                    internship.setResizable(false);
                    internship.pack();
                    internship.setVisible(true);
                    
                    pane = internship.getContentPane();
                    pane.setLayout(new CardLayout());
                    cl = (CardLayout)pane.getLayout();
                    
                    stu_pane = studentReg.getRootPane();
                    stu_cl = (CardLayout) studentReg.getLayout();
                    
                    pane.add(login, "LOGIN");
                    pane.add(studentReg, "STUDENTREG");
                    pane.add(companyReg, "COMPANYREG");
                    pane.add(company, "COMPANY");
                    setListeners();
                    showLogin();
                } catch (Exception ex) {
                    Logger.getLogger(Internship.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internship;

/**
 *
 * @author mrx
 */
public class Company extends javax.swing.JPanel {

    /**
     * Creates new form Company
     */
    public Company() {
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

        nameTf = new javax.swing.JLabel();
        tabPane = new javax.swing.JTabbedPane();
        tab_company = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        comp_id = new javax.swing.JLabel();
        comp_name = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        comp_logout = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        comp_addr = new javax.swing.JTextArea();
        comp_sector = new javax.swing.JLabel();
        comp_cat = new javax.swing.JLabel();
        comp_site = new javax.swing.JLabel();
        tab_new = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        new_profile = new javax.swing.JTextField();
        new_stipend = new javax.swing.JTextField();
        new_cgpa = new javax.swing.JTextField();
        new_process = new javax.swing.JTextField();
        new_endDate = new javax.swing.JTextField();
        new_interview = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        new_degrees = new javax.swing.JButton();
        new_submit = new javax.swing.JButton();
        tab_all = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tab_notice = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        notice_subCb = new javax.swing.JComboBox();
        notice_headTf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        notice_textTa = new javax.swing.JTextArea();
        notice_postB = new javax.swing.JButton();

        nameTf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameTf.setText("Company");

        jLabel11.setText("ID:");

        comp_id.setText("jLabel12");

        comp_name.setText("Name:");

        jLabel14.setText("Address:");

        jLabel15.setText("Website:");

        jLabel16.setText("Category:");

        jLabel17.setText("Sector:");

        jLabel18.setText("jLabel18");

        comp_logout.setText("Logout");

        comp_addr.setEditable(false);
        comp_addr.setColumns(20);
        comp_addr.setRows(5);
        jScrollPane3.setViewportView(comp_addr);

        comp_sector.setText("jLabel19");

        comp_cat.setText("jLabel20");

        comp_site.setText("jLabel21");

        javax.swing.GroupLayout tab_companyLayout = new javax.swing.GroupLayout(tab_company);
        tab_company.setLayout(tab_companyLayout);
        tab_companyLayout.setHorizontalGroup(
            tab_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_companyLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(tab_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(comp_name)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addGap(91, 91, 91)
                .addGroup(tab_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_companyLayout.createSequentialGroup()
                        .addGroup(tab_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(comp_id))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tab_companyLayout.createSequentialGroup()
                        .addGroup(tab_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addGroup(tab_companyLayout.createSequentialGroup()
                                .addGroup(tab_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comp_sector)
                                    .addComponent(comp_cat)
                                    .addComponent(comp_site))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_companyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comp_logout)
                .addContainerGap())
        );
        tab_companyLayout.setVerticalGroup(
            tab_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_companyLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(tab_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comp_id))
                .addGap(18, 18, 18)
                .addGroup(tab_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comp_name)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(tab_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(tab_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(comp_site))
                .addGap(18, 18, 18)
                .addGroup(tab_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(comp_cat))
                .addGap(18, 18, 18)
                .addGroup(tab_companyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(comp_sector))
                .addGap(18, 18, 18)
                .addComponent(comp_logout)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        tabPane.addTab("Company", tab_company);

        jLabel1.setText("Profile");

        jLabel5.setText("Stipend per month");

        jLabel6.setText("CGPA cut-off");

        jLabel7.setText("Selection Process");

        jLabel8.setText("Upload End");

        jLabel9.setText("Interview Date");

        jLabel10.setText("Allowed Degrees");

        new_degrees.setText("Select");

        new_submit.setText("Submit");

        javax.swing.GroupLayout tab_newLayout = new javax.swing.GroupLayout(tab_new);
        tab_new.setLayout(tab_newLayout);
        tab_newLayout.setHorizontalGroup(
            tab_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_newLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(tab_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(51, 51, 51)
                .addGroup(tab_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(new_degrees)
                    .addGroup(tab_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(new_submit)
                        .addGroup(tab_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(new_profile)
                            .addComponent(new_stipend)
                            .addComponent(new_cgpa)
                            .addComponent(new_process)
                            .addComponent(new_endDate)
                            .addComponent(new_interview, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        tab_newLayout.setVerticalGroup(
            tab_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_newLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(new_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tab_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(new_stipend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tab_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(new_cgpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tab_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(new_process, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tab_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(new_endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tab_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(new_interview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tab_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(new_degrees))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(new_submit)
                .addGap(36, 36, 36))
        );

        tabPane.addTab("New Internship", tab_new);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Profile", "Applicants"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout tab_allLayout = new javax.swing.GroupLayout(tab_all);
        tab_all.setLayout(tab_allLayout);
        tab_allLayout.setHorizontalGroup(
            tab_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_allLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        tab_allLayout.setVerticalGroup(
            tab_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_allLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabPane.addTab("Internships", tab_all);

        jLabel2.setText("Subject");

        jLabel3.setText("Headline");

        jLabel4.setText("Notice Text:");

        notice_subCb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Additional Requirement", "CV Submission", "Date Extension", "General", "Workshop/Seminar", "Reschedule", "Result", "Schedule", "Shortlist", "Urgent" }));

        notice_textTa.setColumns(20);
        notice_textTa.setRows(5);
        jScrollPane1.setViewportView(notice_textTa);

        notice_postB.setText("Post");

        javax.swing.GroupLayout tab_noticeLayout = new javax.swing.GroupLayout(tab_notice);
        tab_notice.setLayout(tab_noticeLayout);
        tab_noticeLayout.setHorizontalGroup(
            tab_noticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_noticeLayout.createSequentialGroup()
                .addGroup(tab_noticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_noticeLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(tab_noticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(tab_noticeLayout.createSequentialGroup()
                                .addGroup(tab_noticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(61, 61, 61)
                                .addGroup(tab_noticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(notice_headTf)
                                    .addGroup(tab_noticeLayout.createSequentialGroup()
                                        .addComponent(notice_subCb, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 103, Short.MAX_VALUE))))
                            .addGroup(tab_noticeLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_noticeLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(notice_postB)))
                .addContainerGap())
        );
        tab_noticeLayout.setVerticalGroup(
            tab_noticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_noticeLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(tab_noticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(notice_subCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tab_noticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(notice_headTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(notice_postB)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tabPane.addTab("New Notice", tab_notice);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameTf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(nameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea comp_addr;
    private javax.swing.JLabel comp_cat;
    private javax.swing.JLabel comp_id;
    private javax.swing.JButton comp_logout;
    private javax.swing.JLabel comp_name;
    private javax.swing.JLabel comp_sector;
    private javax.swing.JLabel comp_site;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nameTf;
    private javax.swing.JTextField new_cgpa;
    private javax.swing.JButton new_degrees;
    private javax.swing.JTextField new_endDate;
    private javax.swing.JTextField new_interview;
    private javax.swing.JTextField new_process;
    private javax.swing.JTextField new_profile;
    private javax.swing.JTextField new_stipend;
    private javax.swing.JButton new_submit;
    private javax.swing.JTextField notice_headTf;
    private javax.swing.JButton notice_postB;
    private javax.swing.JComboBox notice_subCb;
    private javax.swing.JTextArea notice_textTa;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JPanel tab_all;
    private javax.swing.JPanel tab_company;
    private javax.swing.JPanel tab_new;
    private javax.swing.JPanel tab_notice;
    // End of variables declaration//GEN-END:variables
}


import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.CardLayout;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @~~~waves~~~
 */
public class StudentManagementSyst extends javax.swing.JFrame {
 private LoginClass access;
 private RegisterClass access1; 
 private PaymentClass access2;
 private EditClass access3;
 private CourseRegClass access4;
 String path="";
    /**
     * Creates new form StudentManagementSyst
     */
    
 public StudentManagementSyst() {
      access = new LoginClass();  
      access1 = new RegisterClass();
      access2 = new PaymentClass();
      access3 = new EditClass();
      access4 = new CourseRegClass();
        initComponents();
        FacultyCombo();
        DepartmentCombo();
        view();
        CourseCombo();
    }
    
    //populating the combo box from the database
    private void FacultyCombo(){
     Connection connection= null;
     Statement statement= null;
     ResultSet resultSet= null;
    //create a URL
    final String DATABASE_URL = "jdbc:mysql://localhost:3306/users";
    
    try{
     String sql ="select * from faculty";
    //establish connection to database
    connection = DriverManager.getConnection(DATABASE_URL,"root","");
    
     //create statement for querying database
     statement = connection.prepareStatement(sql);
     
     //query database
     resultSet = statement.executeQuery(sql);
     
     //filling the combo box up
     while(resultSet.next()) {
      String faculty= resultSet.getString("faculty");
      jcbCg.addItem(faculty);
      jcbCg2.addItem(faculty);
      jcbFac1.addItem(faculty);
     } 
    }
     catch(Exception e){
     JOptionPane.showMessageDialog(null, "ERROR");
     }
         
    }
    
   private void DepartmentCombo(){
    Connection connection= null;
     Statement statement= null;
     ResultSet resultSet= null;
    //create a URL
    final String DATABASE_URL = "jdbc:mysql://localhost:3306/users";
    
    try{
     String sql ="select * from department";
    //establish connection to database
    connection = DriverManager.getConnection(DATABASE_URL,"root","");
    
     //create statement for querying database
     statement = connection.prepareStatement(sql);
     
     //query database
     resultSet = statement.executeQuery(sql);
     
     //filling the combo box up
     while(resultSet.next()) {
      String department= resultSet.getString("department");
      jcbDp.addItem(department);
      jcbDp2.addItem(department);
      jcbDeprt1.addItem(department);
     } 
    }
     catch(Exception e){
     JOptionPane.showMessageDialog(null, "ERROR");
     }
   }
   
   private void CourseCombo(){
     Connection connection= null;
     Statement statement= null;
     ResultSet resultSet= null;
    
    //create a URL
    final String DATABASE_URL = "jdbc:mysql://localhost:3306/users";
    
    try{
     String sql ="select * from courses";
    //establish connection to database
    connection = DriverManager.getConnection(DATABASE_URL,"root","");
    
     //create statement for querying database
     statement = connection.prepareStatement(sql);
     
     //query database
     resultSet = statement.executeQuery(sql);
     
     //filling the combo box up
     while(resultSet.next()) {
      String course= resultSet.getString("course");
      jcbCourse1.addItem(course);
      jcbCourse2.addItem(course);
      jcbCourse3.addItem(course);
      jcbCourse4.addItem(course);
      jcbCourse5.addItem(course);
     } 
    }
     catch(Exception e){
     JOptionPane.showMessageDialog(null, "ERROR");
     }
   
   }
 
    //to save profile pic
    public void save(){
     try {
         FileInputStream fis=null;
         File img=null;
         
         img=new File(path);
         fis=new FileInputStream(img);
         
         if(new ImageClass().add(img, fis)){
         
          jlabBrowse.setIcon(null);
         }
         else{
           JOptionPane.showMessageDialog(null, "NOT SUCCESSFULLY SAVED");
         }
        
        } catch (FileNotFoundException ex) {
         Logger.getLogger(StudentManagementSyst.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    //to retrieve the image
    private void retrieve() throws SQLException{
     try {
         int id= new ImageClass().retrieve();
         
         if(id != -1){
             JOptionPane.showMessageDialog(null, "SUCCESSFULLY RETRIEVED");
             jlabPic.setIcon(new ImageIcon("C:\\Users\\HP\\Pictures\\"+id+".JPG"));
         }
         else{
          JOptionPane.showMessageDialog(null, "NOT SUCCESSFULLY RETRIEVED");
         }
     } catch (IOException ex) {
         Logger.getLogger(StudentManagementSyst.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    }
    
    //view student info
    private void view(){
     DefaultTableModel dm1 = new viewClass().viewData();
       
       jtabInfo2.setModel(dm1);
    }
    
    //update image
     public void update(){
     try {
         FileInputStream fis=null;
         File img=null;
         int matric_no =Integer.parseInt(jtfMatricNo.getText());;
         
         img=new File(path);
         fis=new FileInputStream(img);
         
         if(new EditImageClass().UpdateImage(img, fis, matric_no)){
         
         jlabUpload.setIcon(null);
         }
         else{
           JOptionPane.showMessageDialog(null, "NOT SUCCESSFULLY SAVED");
         }
        
        } catch (FileNotFoundException ex) {
         Logger.getLogger(StudentManagementSyst.class.getName()).log(Level.SEVERE, null, ex);
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

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jpInitial = new javax.swing.JPanel();
        jpLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jbutLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JTextField();
        jbutExit = new javax.swing.JButton();
        jplStudent = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        payment = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        result = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        course = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        jbutLogOut = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpNewStud = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jtfFname = new javax.swing.JTextField();
        jtfSname = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jcbCg = new javax.swing.JComboBox<>();
        jcbDp = new javax.swing.JComboBox<>();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jcbSmter = new javax.swing.JComboBox<>();
        jcblevel = new javax.swing.JComboBox<>();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jtfNum = new javax.swing.JTextField();
        jtfGNum = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jbutNWclear = new javax.swing.JButton();
        jbutNewStudent1 = new javax.swing.JButton();
        jlabPic = new javax.swing.JLabel();
        jlabBrowse = new javax.swing.JLabel();
        jpEditInfo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jtfFname2 = new javax.swing.JTextField();
        jtfGnum = new javax.swing.JTextField();
        jtfSname2 = new javax.swing.JTextField();
        jtfPnum = new javax.swing.JTextField();
        jcbDp2 = new javax.swing.JComboBox<>();
        jcbSmter2 = new javax.swing.JComboBox<>();
        jcbCg2 = new javax.swing.JComboBox<>();
        jcbLevel2 = new javax.swing.JComboBox<>();
        jtfEmail2 = new javax.swing.JTextField();
        jlabUpload = new javax.swing.JLabel();
        jlabPic2 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jbutUpdate = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtabInfo = new javax.swing.JTable();
        jLabel50 = new javax.swing.JLabel();
        jtfMatricNo = new javax.swing.JTextField();
        jbutRetrieve = new javax.swing.JButton();
        jpView = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtabInfo2 = new javax.swing.JTable();
        jpSearch = new javax.swing.JPanel();
        jbutSearch = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        jtfSMat = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtabInfo1 = new javax.swing.JTable();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jtfSF = new javax.swing.JTextField();
        jpPayment = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jpHistory = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jtfPayF = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtabPay = new javax.swing.JTable();
        jbutPayHistory = new javax.swing.JButton();
        jbutPaySearch = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jtfPayS = new javax.swing.JTextField();
        jpVer = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtfAmount = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jcbPayment = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jtfDesc = new javax.swing.JTextField();
        jbutSubmit = new javax.swing.JButton();
        jbutPaymentClear = new javax.swing.JButton();
        jbutPayVerback = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jtfMatNo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jtfSName = new javax.swing.JTextField();
        jplCourseReg = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jpRegistration1 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jbutRegBack1 = new javax.swing.JButton();
        jcbSemester1 = new javax.swing.JComboBox<>();
        jtfMat = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jcbFac1 = new javax.swing.JComboBox<>();
        jcbDeprt1 = new javax.swing.JComboBox<>();
        jLabel77 = new javax.swing.JLabel();
        jcbCourse1 = new javax.swing.JComboBox<>();
        jLabel78 = new javax.swing.JLabel();
        jcbCourse3 = new javax.swing.JComboBox<>();
        jLabel79 = new javax.swing.JLabel();
        jcbCourse2 = new javax.swing.JComboBox<>();
        jLabel80 = new javax.swing.JLabel();
        jcbCourse4 = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        jcbCourse5 = new javax.swing.JComboBox<>();
        jbutCourseReg1 = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        jtfMFN = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jtfMSN = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jcbLevel1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jtfM = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jtfF = new javax.swing.JTextField();
        jbutSearch1 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtabInfo3 = new javax.swing.JTable();
        jbutRegBack2 = new javax.swing.JButton();
        jpResultChecker = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtfRM = new javax.swing.JTextField();
        jbutRClear = new javax.swing.JButton();
        jbutRSave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtfRC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfRS = new javax.swing.JTextField();
        jtfRG = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ResultChecker = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtabResult = new javax.swing.JTable();
        jbutResultBack1 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jtfResult = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jbutResultChecker = new javax.swing.JButton();
        jbutResultBack3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        option = new javax.swing.JMenu();
        aboutUs = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel40.setText("jLabel40");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpInitial.setLayout(new java.awt.CardLayout());

        jpLogin.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("SECURE LOGIN");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("USERNAME:");

        jbutLogin.setBackground(new java.awt.Color(51, 51, 51));
        jbutLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutLogin.setText("LOGIN");
        jbutLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbutLoginMouseClicked(evt);
            }
        });
        jbutLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutLoginActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("PASSWORD:");

        jbutExit.setBackground(new java.awt.Color(51, 51, 51));
        jbutExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutExit.setText("EXIT");
        jbutExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpLoginLayout = new javax.swing.GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpLoginLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpLoginLayout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jbutLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(jbutExit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 499, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbutLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbutExit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(421, Short.MAX_VALUE))
        );

        jpInitial.add(jpLogin, "cardHome");

        jToolBar1.setRollover(true);

        payment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        payment.setText("PAYMENT");
        payment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        payment.setFocusable(false);
        payment.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        payment.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });
        jToolBar1.add(payment);
        jToolBar1.add(filler1);

        result.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        result.setText("RESULT-CHECKER");
        result.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        result.setFocusable(false);
        result.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        result.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultActionPerformed(evt);
            }
        });
        jToolBar1.add(result);
        jToolBar1.add(filler2);

        course.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        course.setText("COURSE REG.");
        course.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        course.setFocusable(false);
        course.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        course.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseActionPerformed(evt);
            }
        });
        jToolBar1.add(course);
        jToolBar1.add(filler3);

        jbutLogOut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbutLogOut.setText("LOG-OUT");
        jbutLogOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jbutLogOut.setFocusable(false);
        jbutLogOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbutLogOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbutLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutLogOutActionPerformed(evt);
            }
        });
        jToolBar1.add(jbutLogOut);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel58.setText("FIRST NAME:");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel59.setText("SECOND NAME:");

        jtfFname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jtfSname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel60.setText("COLLEGE:");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel61.setText("DEPARTMENT:");

        jcbCg.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jcbDp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel62.setText("SEMESTER:");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel63.setText("LEVEL:");

        jcbSmter.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbSmter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st SEMESTER", "2nd SEMESTER" }));

        jcblevel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcblevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100 LEVEL", "200LEVEL", "300 LEVEL", "400 LEVEL", "500 LEVEL" }));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel64.setText("PHONE NO.:");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel65.setText("GUARDIAN NO.:");

        jtfNum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jtfGNum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel66.setText("EMAIL:");

        jtfEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jbutNWclear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutNWclear.setText("CLEAR");

        jbutNewStudent1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutNewStudent1.setText("SAVE");
        jbutNewStudent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutNewStudent1ActionPerformed(evt);
            }
        });

        jlabPic.setBackground(new java.awt.Color(255, 255, 255));
        jlabPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jlabBrowse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlabBrowse.setText("BROWSE");
        jlabBrowse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabBrowseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpNewStudLayout = new javax.swing.GroupLayout(jpNewStud);
        jpNewStud.setLayout(jpNewStudLayout);
        jpNewStudLayout.setHorizontalGroup(
            jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNewStudLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNewStudLayout.createSequentialGroup()
                        .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64)
                            .addComponent(jtfNum, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62)
                            .addComponent(jcbSmter, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102)
                        .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63)
                            .addComponent(jcblevel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65)
                            .addComponent(jtfGNum, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpNewStudLayout.createSequentialGroup()
                        .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpNewStudLayout.createSequentialGroup()
                                .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfFname, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel58)
                                    .addGroup(jpNewStudLayout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addGap(351, 351, 351)
                                        .addComponent(jLabel61))
                                    .addGroup(jpNewStudLayout.createSequentialGroup()
                                        .addGap(353, 353, 353)
                                        .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel59)
                                            .addComponent(jtfSname, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpNewStudLayout.createSequentialGroup()
                                .addComponent(jcbCg, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                .addComponent(jcbDp, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)))
                        .addComponent(jlabPic, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlabBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNewStudLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbutNewStudent1)
                .addGap(166, 166, 166)
                .addComponent(jbutNWclear)
                .addGap(315, 315, 315))
        );
        jpNewStudLayout.setVerticalGroup(
            jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNewStudLayout.createSequentialGroup()
                .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNewStudLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpNewStudLayout.createSequentialGroup()
                                .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel58)
                                    .addComponent(jLabel59))
                                .addGap(12, 12, 12)
                                .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfSname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel61))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcbCg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbDp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jlabPic, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpNewStudLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jlabBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcblevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSmter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfGNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jpNewStudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbutNewStudent1)
                    .addComponent(jbutNWclear))
                .addGap(304, 304, 304))
        );

        jTabbedPane1.addTab("NEW STUDENT", jpNewStud);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("FIRST NAME:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setText("SECOND NAME:");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel48.setText("COLLEGE:");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel49.setText("GUARDIAN NO.:");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel51.setText("LEVEL:");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel52.setText("SEMESTER:");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel53.setText("PHONE NO.:");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel54.setText("EMAIL:");

        jtfFname2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jtfGnum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jtfSname2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jtfPnum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jcbDp2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jcbSmter2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbSmter2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st SEMESTER", "2nd SEMESTER" }));

        jcbCg2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jcbLevel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbLevel2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100 LEVEL", "200LEVEL", "300 LEVEL", "400 LEVEL", "500 LEVEL" }));

        jtfEmail2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jlabUpload.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlabUpload.setText("UPLOAD NEW PICTURE");
        jlabUpload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabUploadMouseClicked(evt);
            }
        });

        jlabPic2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel57.setText("DEPARTMENT:");

        jbutUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutUpdate.setText("UPDATE");
        jbutUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutUpdateActionPerformed(evt);
            }
        });

        jtabInfo.setBorder(new javax.swing.border.MatteBorder(null));
        jtabInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtabInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATRIC NO.", "FIRST NAME", "LAST NAME", "COLLEGE", "DEPARTMENT", "LEVEL", "SEMESTER", "PHONE NO.", "GUARDIAN PHONE NO.", "EMAIL"
            }
        ));
        jtabInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabInfoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtabInfo);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setText("MATRIC NO.:");

        jtfMatricNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jbutRetrieve.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutRetrieve.setText("RETRIEVE INFO");
        jbutRetrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutRetrieveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpEditInfoLayout = new javax.swing.GroupLayout(jpEditInfo);
        jpEditInfo.setLayout(jpEditInfoLayout);
        jpEditInfoLayout.setHorizontalGroup(
            jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEditInfoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEditInfoLayout.createSequentialGroup()
                        .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEditInfoLayout.createSequentialGroup()
                                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel57)
                                    .addComponent(jcbDp2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51)
                                    .addComponent(jcbLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(113, 113, 113))
                            .addGroup(jpEditInfoLayout.createSequentialGroup()
                                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfMatricNo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21)
                                    .addComponent(jtfSname2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jlabPic2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpEditInfoLayout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbutRetrieve)
                        .addGap(83, 83, 83))
                    .addGroup(jpEditInfoLayout.createSequentialGroup()
                        .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpEditInfoLayout.createSequentialGroup()
                                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbSmter2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel52))
                                .addGap(52, 52, 52)
                                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel49)
                                    .addComponent(jtfGnum, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53)
                                    .addComponent(jtfPnum, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel50)
                            .addGroup(jpEditInfoLayout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfFname2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel48)
                                    .addComponent(jcbCg2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpEditInfoLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(260, 260, 260)
                                        .addComponent(jlabUpload)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jpEditInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbutUpdate)
                .addGap(0, 113, Short.MAX_VALUE))
        );

        jpEditInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtfGnum, jtfPnum});

        jpEditInfoLayout.setVerticalGroup(
            jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEditInfoLayout.createSequentialGroup()
                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEditInfoLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel4))
                    .addGroup(jpEditInfoLayout.createSequentialGroup()
                        .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEditInfoLayout.createSequentialGroup()
                                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpEditInfoLayout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jtfFname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel48)
                                        .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpEditInfoLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(jcbCg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11)
                                                .addComponent(jLabel51)
                                                .addGap(4, 4, 4)
                                                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jcbDp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jcbLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jpEditInfoLayout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addComponent(jLabel57))))
                                    .addGroup(jpEditInfoLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel50)
                                            .addComponent(jLabel19))
                                        .addGap(12, 12, 12)
                                        .addComponent(jtfMatricNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel21)
                                        .addGap(12, 12, 12)
                                        .addComponent(jtfSname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpEditInfoLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jlabUpload)
                                        .addGap(18, 18, 18)
                                        .addComponent(jlabPic2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtfPnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpEditInfoLayout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel49)
                                    .addComponent(jLabel52))
                                .addGap(18, 18, 18)
                                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfGnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbSmter2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbutRetrieve, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jpEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbutUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jpEditInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtfGnum, jtfPnum});

        jTabbedPane1.addTab("EDIT INFO", jpEditInfo);

        jtabInfo2.setBorder(new javax.swing.border.MatteBorder(null));
        jtabInfo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtabInfo2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATRIC NO.", "FIRST NAME", "LAST NAME", "COLLEGE", "DEPARTMENT", "SEMESTER", "LEVEL", "PHONE NO.", "GUARDIAN PHONE NO.", "EMAIL", "REG. TIME"
            }
        ));
        jScrollPane8.setViewportView(jtabInfo2);

        javax.swing.GroupLayout jpViewLayout = new javax.swing.GroupLayout(jpView);
        jpView.setLayout(jpViewLayout);
        jpViewLayout.setHorizontalGroup(
            jpViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpViewLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jpViewLayout.setVerticalGroup(
            jpViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpViewLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("VIEW", jpView);

        jpSearch.setBackground(new java.awt.Color(204, 204, 204));

        jbutSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutSearch.setText("SEARCH");
        jbutSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutSearchActionPerformed(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel69.setText("SEARCH  STUDENT INFORMATION");

        jtabInfo1.setBorder(new javax.swing.border.MatteBorder(null));
        jtabInfo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtabInfo1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATRIC NO.", "FIRST NAME", "LAST NAME", "COLLEGE", "DEPARTMENT", "SEMESTER", "LEVEL", "PHONE NO.", "GUARDIAN PHONE NO.", "EMAIL", "REG. TIME"
            }
        ));
        jScrollPane7.setViewportView(jtabInfo1);

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel70.setText("MATRIC NO.:");

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel71.setText("FIRST NAME:");

        javax.swing.GroupLayout jpSearchLayout = new javax.swing.GroupLayout(jpSearch);
        jpSearch.setLayout(jpSearchLayout);
        jpSearchLayout.setHorizontalGroup(
            jpSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSearchLayout.createSequentialGroup()
                .addGroup(jpSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSearchLayout.createSequentialGroup()
                        .addGroup(jpSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpSearchLayout.createSequentialGroup()
                                .addGroup(jpSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpSearchLayout.createSequentialGroup()
                                        .addComponent(jLabel70)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfSMat, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpSearchLayout.createSequentialGroup()
                                        .addComponent(jbutSearch)
                                        .addGap(250, 250, 250)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfSF, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel69))
                        .addGap(0, 277, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jpSearchLayout.setVerticalGroup(
            jpSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSearchLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSMat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfSF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addComponent(jbutSearch)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SEARCH", jpSearch);

        javax.swing.GroupLayout jplStudentLayout = new javax.swing.GroupLayout(jplStudent);
        jplStudent.setLayout(jplStudentLayout);
        jplStudentLayout.setHorizontalGroup(
            jplStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jplStudentLayout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jplStudentLayout.setVerticalGroup(
            jplStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplStudentLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jpInitial.add(jplStudent, "cardStudent");

        jpHistory.setBackground(new java.awt.Color(204, 204, 204));
        jpHistory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 4));
        jpHistory.setForeground(new java.awt.Color(102, 102, 102));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("FIRST NAME");

        jtfPayF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfPayF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));

        jtabPay.setBackground(new java.awt.Color(102, 102, 102));
        jtabPay.setBorder(new javax.swing.border.MatteBorder(null));
        jtabPay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtabPay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FIRST NAME", "SECOND NAME", "MATRIC NO", "AMOUNT", "PAYMENT TYPE", "DESCRIPTION", "DATE OF PAYMENT"
            }
        ));
        jScrollPane3.setViewportView(jtabPay);

        jbutPayHistory.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutPayHistory.setText("BACK");
        jbutPayHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutPayHistoryActionPerformed(evt);
            }
        });

        jbutPaySearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutPaySearch.setText("SEARCH");
        jbutPaySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutPaySearchActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("SECOND NAME");

        jtfPayS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfPayS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));

        javax.swing.GroupLayout jpHistoryLayout = new javax.swing.GroupLayout(jpHistory);
        jpHistory.setLayout(jpHistoryLayout);
        jpHistoryLayout.setHorizontalGroup(
            jpHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHistoryLayout.createSequentialGroup()
                .addGroup(jpHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpHistoryLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPayF, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpHistoryLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPayS, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jbutPaySearch))
                    .addGroup(jpHistoryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpHistoryLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbutPayHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jpHistoryLayout.setVerticalGroup(
            jpHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHistoryLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jpHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jtfPayF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jpHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jtfPayS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbutPaySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbutPayHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("PAYMENT HISTORY", jpHistory);

        jpVer.setBackground(new java.awt.Color(204, 204, 204));
        jpVer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 4));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("FIRST NAME:");
        jLabel13.setToolTipText("");

        jtfName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtfName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("AMOUNT:");
        jLabel14.setToolTipText("");

        jtfAmount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtfAmount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("PAYMENT TYPE:");
        jLabel15.setToolTipText("");

        jcbPayment.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH", "BANK TRANSFER" }));
        jcbPayment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("DESCRIPTION:");
        jLabel16.setToolTipText("");

        jtfDesc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtfDesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));

        jbutSubmit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutSubmit.setText("SUBMIT");
        jbutSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutSubmitActionPerformed(evt);
            }
        });

        jbutPaymentClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutPaymentClear.setText("CLEAR");
        jbutPaymentClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutPaymentClearActionPerformed(evt);
            }
        });

        jbutPayVerback.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutPayVerback.setText("BACK ");
        jbutPayVerback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutPayVerbackActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setText("MATRIC NUMBER:");
        jLabel33.setToolTipText("");

        jtfMatNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtfMatNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("SECOND NAME:");
        jLabel17.setToolTipText("");

        jtfSName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtfSName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));

        javax.swing.GroupLayout jpVerLayout = new javax.swing.GroupLayout(jpVer);
        jpVer.setLayout(jpVerLayout);
        jpVerLayout.setHorizontalGroup(
            jpVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVerLayout.createSequentialGroup()
                .addGroup(jpVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpVerLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jbutSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(jbutPaymentClear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(jbutPayVerback, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpVerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel13)
                            .addComponent(jLabel17))
                        .addGap(17, 17, 17)
                        .addGroup(jpVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMatNo, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSName, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        jpVerLayout.setVerticalGroup(
            jpVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpVerLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(jpVerLayout.createSequentialGroup()
                        .addGroup(jpVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfSName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfMatNo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jtfDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)))
                .addGroup(jpVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbutPayVerback, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbutPaymentClear, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbutSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(289, Short.MAX_VALUE))
        );

        jpVerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbutPayVerback, jbutPaymentClear, jbutSubmit});

        jTabbedPane2.addTab("PAYMENT VERIFICATION", jpVer);

        javax.swing.GroupLayout jpPaymentLayout = new javax.swing.GroupLayout(jpPayment);
        jpPayment.setLayout(jpPaymentLayout);
        jpPaymentLayout.setHorizontalGroup(
            jpPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jpPaymentLayout.setVerticalGroup(
            jpPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jpInitial.add(jpPayment, "cardPayment");

        jpRegistration1.setBackground(new java.awt.Color(204, 204, 204));
        jpRegistration1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "COURSE REGISTRATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel73.setText("MATRIC NUMBER:");

        jbutRegBack1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutRegBack1.setText("BACK");
        jbutRegBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutRegBack1ActionPerformed(evt);
            }
        });

        jcbSemester1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbSemester1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1ST SEMESTER", "2ND SEMESTER" }));

        jtfMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfMatKeyReleased(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel74.setText("COLLEGE:");

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel75.setText("DEPARTMENT:");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel76.setText("SEMESTER:");

        jcbFac1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcbFac1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jcbFac1MouseReleased(evt);
            }
        });

        jcbDeprt1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcbDeprt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbDeprt1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jcbDeprt1MouseReleased(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel77.setText("COURSE 1:");

        jcbCourse1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel78.setText("COURSE 3:");

        jcbCourse3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel79.setText("COURSE 2:");

        jcbCourse2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel80.setText("COURSE 4:");

        jcbCourse4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel81.setText("COURSE 5:");

        jcbCourse5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jbutCourseReg1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutCourseReg1.setText("REGISTER");
        jbutCourseReg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutCourseReg1ActionPerformed(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel82.setText("FIRST NAME:");

        jtfMFN.setFocusable(false);

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel83.setText("SECOND NAME:");

        jtfMSN.setFocusable(false);
        jtfMSN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMSNActionPerformed(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel84.setText("LEVEL:");

        jcbLevel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbLevel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100L", "200L", "300L", "400L", "500L" }));

        javax.swing.GroupLayout jpRegistration1Layout = new javax.swing.GroupLayout(jpRegistration1);
        jpRegistration1.setLayout(jpRegistration1Layout);
        jpRegistration1Layout.setHorizontalGroup(
            jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistration1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpRegistration1Layout.createSequentialGroup()
                        .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpRegistration1Layout.createSequentialGroup()
                                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbCourse1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpRegistration1Layout.createSequentialGroup()
                                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jcbCourse3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpRegistration1Layout.createSequentialGroup()
                                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jcbCourse2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpRegistration1Layout.createSequentialGroup()
                                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jcbCourse4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(139, 139, 139))
                    .addGroup(jpRegistration1Layout.createSequentialGroup()
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jcbCourse5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(590, Short.MAX_VALUE))
                    .addGroup(jpRegistration1Layout.createSequentialGroup()
                        .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbSemester1, 0, 203, Short.MAX_VALUE)
                            .addComponent(jcbFac1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfMat)
                            .addComponent(jtfMFN))
                        .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpRegistration1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbDeprt1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(139, 139, 139))
                            .addGroup(jpRegistration1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfMSN, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(jpRegistration1Layout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addComponent(jbutCourseReg1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jbutRegBack1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpRegistration1Layout.setVerticalGroup(
            jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistration1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jtfMat))
                .addGap(32, 32, 32)
                .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addComponent(jtfMFN))
                    .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfMSN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSemester1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFac1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDeprt1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRegistration1Layout.createSequentialGroup()
                        .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbCourse1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbCourse3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpRegistration1Layout.createSequentialGroup()
                        .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbCourse2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbCourse4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbCourse5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jpRegistration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbutCourseReg1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbutRegBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("REGISTER", jpRegistration1);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel85.setText("SEARCH  COURSE REGISTERED ");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel86.setText("MATRIC NO.:");

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel87.setText("FIRST NAME:");

        jbutSearch1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutSearch1.setText("SEARCH");
        jbutSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutSearch1ActionPerformed(evt);
            }
        });

        jtabInfo3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jtabInfo3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtabInfo3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATRIC NO.", "FIRST NAME", "LAST NAME", "COLLEGE", "DEPARTMENT", "SEMESTER", "LEVEL", "COURSE1", "COURSE2", "COURSE3", "COURSE4", "COURSE5"
            }
        ));
        jScrollPane9.setViewportView(jtabInfo3);

        jbutRegBack2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutRegBack2.setText("BACK");
        jbutRegBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutRegBack2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel86)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfM, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbutSearch1)
                                .addGap(250, 250, 250)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel87)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfF, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel85)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbutRegBack2)
                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jbutSearch1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbutRegBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(311, 311, 311))
        );

        jTabbedPane3.addTab("SEARCH", jPanel1);

        javax.swing.GroupLayout jplCourseRegLayout = new javax.swing.GroupLayout(jplCourseReg);
        jplCourseReg.setLayout(jplCourseRegLayout);
        jplCourseRegLayout.setHorizontalGroup(
            jplCourseRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplCourseRegLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3))
        );
        jplCourseRegLayout.setVerticalGroup(
            jplCourseRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplCourseRegLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jpInitial.add(jplCourseReg, "cardCReg");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("MATRIC NO.:");

        jtfRM.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jbutRClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutRClear.setText("CLEAR");
        jbutRClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutRClearActionPerformed(evt);
            }
        });

        jbutRSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutRSave.setText("SAVE");
        jbutRSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutRSaveActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("COURSE:");

        jtfRC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("SCORE:");

        jtfRS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jtfRG.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("GRADE:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(87, 87, 87)
                        .addComponent(jtfRM, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jbutRSave)
                        .addGap(113, 113, 113)
                        .addComponent(jbutRClear))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(87, 87, 87)
                        .addComponent(jtfRC, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(87, 87, 87)
                        .addComponent(jtfRS, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(87, 87, 87)
                        .addComponent(jtfRG, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(499, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbutRSave)
                    .addComponent(jbutRClear))
                .addGap(94, 94, 94))
        );

        jTabbedPane4.addTab("Record Result", jPanel4);

        ResultChecker.setBackground(new java.awt.Color(204, 204, 204));
        ResultChecker.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RESULT CHECKER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(102, 102, 102))); // NOI18N
        ResultChecker.setPreferredSize(new java.awt.Dimension(600, 501));

        jtabResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COURSE", "SCORE", "GRADE"
            }
        ));
        jScrollPane5.setViewportView(jtabResult);

        jbutResultBack1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutResultBack1.setText("BACK");
        jbutResultBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutResultBack1ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setText("Matric number:");

        jtfResult.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("HELP");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel39.setText("ANY COMPLAINS? GET OUR CONTACTS-:");

        jbutResultChecker.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutResultChecker.setText("SHOW RESULT");
        jbutResultChecker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutResultCheckerActionPerformed(evt);
            }
        });

        jbutResultBack3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbutResultBack3.setText("BACK");
        jbutResultBack3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutResultBack3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ResultCheckerLayout = new javax.swing.GroupLayout(ResultChecker);
        ResultChecker.setLayout(ResultCheckerLayout);
        ResultCheckerLayout.setHorizontalGroup(
            ResultCheckerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultCheckerLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addComponent(jtfResult, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResultCheckerLayout.createSequentialGroup()
                .addContainerGap(422, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
            .addGroup(ResultCheckerLayout.createSequentialGroup()
                .addGroup(ResultCheckerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ResultCheckerLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jbutResultBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ResultCheckerLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jbutResultChecker)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ResultCheckerLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbutResultBack3)
                .addGap(69, 69, 69))
        );
        ResultCheckerLayout.setVerticalGroup(
            ResultCheckerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultCheckerLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(ResultCheckerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfResult, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(26, 26, 26)
                .addComponent(jbutResultChecker, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ResultCheckerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ResultCheckerLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResultCheckerLayout.createSequentialGroup()
                        .addComponent(jbutResultBack3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231)))
                .addComponent(jbutResultBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ResultCheckerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Check Result", ResultChecker);

        javax.swing.GroupLayout jpResultCheckerLayout = new javax.swing.GroupLayout(jpResultChecker);
        jpResultChecker.setLayout(jpResultCheckerLayout);
        jpResultCheckerLayout.setHorizontalGroup(
            jpResultCheckerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpResultCheckerLayout.createSequentialGroup()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        jpResultCheckerLayout.setVerticalGroup(
            jpResultCheckerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpResultCheckerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );

        jpInitial.add(jpResultChecker, "cardResult");

        option.setText("OPTIONS");
        option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionActionPerformed(evt);
            }
        });

        aboutUs.setText("ABOUT US");
        aboutUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutUsActionPerformed(evt);
            }
        });
        option.add(aboutUs);

        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        option.add(exit);

        jMenuBar1.add(option);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpInitial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpInitial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbutExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbutExitActionPerformed

    private void jbutLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbutLoginMouseClicked
        //accept user data
        int result = 0;
        String username = jtfUsername.getText();
        String pass = jtfPassword.getText();
        //perform login test
        if(username.equals("")|| pass.equals("")){
            JOptionPane.showMessageDialog(rootPane, "EMPTY FILEDS DETECTED");
        }
        else{
            try{
            result = access.Login(username,pass);
            }catch(SQLException ex){  }

            if(result == 1){
                //empty fields
                jtfUsername.setText("");
                jtfPassword.setText("");

                //display successful login information
                JOptionPane.showMessageDialog(rootPane, "LOGIN SUCCESSFUL: "+ username);
                CardLayout card;
                card= ((CardLayout)jpInitial.getLayout());
                card.show(jpInitial, "cardStudent");
                
            }
            else{
            JOptionPane.showMessageDialog(rootPane, "INCORRECT USER/PASSWORD");
            }
            
        }
    }//GEN-LAST:event_jbutLoginMouseClicked

    private void jbutLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutLoginActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbutLoginActionPerformed

    private void jbutPayVerbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutPayVerbackActionPerformed
        CardLayout card;
        card= ((CardLayout)jpInitial.getLayout());
        card.show(jpInitial, "cardStudent");
    }//GEN-LAST:event_jbutPayVerbackActionPerformed

    private void jbutPayHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutPayHistoryActionPerformed
        CardLayout card;
        card= ((CardLayout)jpInitial.getLayout());
        card.show(jpInitial, "cardStudent");
    }//GEN-LAST:event_jbutPayHistoryActionPerformed

    private void jbutRegBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutRegBack1ActionPerformed
        CardLayout card;
        card= ((CardLayout)jpInitial.getLayout());
        card.show(jpInitial, "cardStudent");
    }//GEN-LAST:event_jbutRegBack1ActionPerformed

    private void jtfMSNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMSNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMSNActionPerformed

    private void jbutNewStudent1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutNewStudent1ActionPerformed
         
        //accept user data
        String fname = jtfFname.getText();
        String sname = jtfSname.getText();
        String college = jcbCg.getSelectedItem().toString();
        String department = jcbDp.getSelectedItem().toString();
        String semester = jcbSmter.getSelectedItem().toString();
        String level = jcblevel.getSelectedItem().toString();
        String phone_no =  jtfNum.getText();
        String guardian_no =  jtfGNum.getText();
        String email = jtfEmail.getText();
    
        
        //perform register test
        if(fname.equals("")||sname.equals("")||guardian_no.equals("")||phone_no.equals("")||email.equals("")){
            JOptionPane.showMessageDialog(rootPane, "EMPTY FILED(S) DETECTED");
        }
        else{
            try{
             access1.add(fname,sname,college,department,semester,level,phone_no,guardian_no,email);
             
             //save picture
             this.save();
           
             this.retrieve();
             
            }catch (SQLException ex){  } catch (IOException ex) {
                Logger.getLogger(StudentManagementSyst.class.getName()).log(Level.SEVERE, null, ex);
            }
             jtfFname.setText("");
             jtfSname.setText("");
             jtfNum.setText("");
             jtfGNum.setText("");
             jtfEmail.setText("");
             
             //to refresh the view table
             view();
             JOptionPane.showMessageDialog(rootPane, "SUCCESSFUL");
        }
      
    }//GEN-LAST:event_jbutNewStudent1ActionPerformed

    private void jbutSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutSubmitActionPerformed
        String first_name = jtfName.getText();
        String second_name = jtfSName.getText();
        int matric_no = Integer.parseInt(jtfMatNo.getText());
        String amount = jtfAmount.getText();
        String payment_type = jcbPayment.getSelectedItem().toString();
        String description = jtfDesc.getText();
             
        //perform payment test
        if(first_name.equals("")||second_name.equals("")|| matric_no==0||amount.equals("")||description.equals("")){
            JOptionPane.showMessageDialog(rootPane, "EMPTY FILED(S) DETECTED");
        }
        else{
            try {
                access2.pay(first_name,second_name,matric_no, amount,payment_type,description);
                JOptionPane.showMessageDialog(rootPane, "SUCCESSFUL");
            } catch (SQLException ex) {
                Logger.getLogger(StudentManagementSyst.class.getName()).log(Level.SEVERE, null, ex);
            }
            jtfName.setText("");
            jtfSName.setText("");
            jtfMatNo.setText("");
            jtfAmount.setText("");
            jtfDesc.setText("");
        }
        
    }//GEN-LAST:event_jbutSubmitActionPerformed

    private void jlabBrowseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabBrowseMouseClicked
         //show the file chooser to a picture
         FileDialog fd= new FileDialog(this);
         fd.show();
         path=fd.getDirectory()+fd.getFile();
     
         //set the image to the jlabel
         jlabPic.setIcon(new ImageIcon(path));
    }//GEN-LAST:event_jlabBrowseMouseClicked

    private void jbutRetrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutRetrieveActionPerformed
       if(Integer.parseInt(jtfMatricNo.getText()) == 0){
           JOptionPane.showMessageDialog(null, "EMPTY FILED(S) DETECTED ");
           jtabInfo.setModel(null);
       }
       else{ 
       //set data from the data base to the table
       DefaultTableModel dm = new EditClass().getData(Integer.parseInt(jtfMatricNo.getText()));
       
       jtabInfo.setModel(dm);
       }
    }//GEN-LAST:event_jbutRetrieveActionPerformed

    private void jtabInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabInfoMouseClicked
               //get data from the populated table
             
               String first_name= jtabInfo.getValueAt(jtabInfo.getSelectedRow(),1).toString();
               String second_name= jtabInfo.getValueAt(jtabInfo.getSelectedRow(),2).toString();
               String college= jtabInfo.getValueAt(jtabInfo.getSelectedRow(),3).toString();
               String department= jtabInfo.getValueAt(jtabInfo.getSelectedRow(),4).toString();
               String level= jtabInfo.getValueAt(jtabInfo.getSelectedRow(),5).toString();
               String semester= jtabInfo.getValueAt(jtabInfo.getSelectedRow(),6).toString();
               String phone_no= jtabInfo.getValueAt(jtabInfo.getSelectedRow(),7).toString();
               String guardian_no=jtabInfo.getValueAt(jtabInfo.getSelectedRow(),8).toString();
               String email= jtabInfo.getValueAt(jtabInfo.getSelectedRow(),9).toString();
               int id=Integer.parseInt(jtfMatricNo.getText());
     
               //set each data to the form for updating
               
               jtfFname2.setText(first_name);
               jtfSname2.setText(second_name);
               jcbCg2.setSelectedItem(college);
               jcbDp2.setSelectedItem(department);
               jcbLevel2.setSelectedItem(level);
               jcbSmter2.setSelectedItem(semester);
               jtfPnum.setText(phone_no);
               jtfGnum.setText(guardian_no);
               jtfEmail2.setText(email);
               jlabPic2.setIcon(new ImageIcon("C:\\Users\\HP\\Pictures\\"+id+".JPG"));
               
               
    }//GEN-LAST:event_jtabInfoMouseClicked

    private void jlabUploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabUploadMouseClicked
        //show the file chooser to a picture
         FileDialog fd= new FileDialog(this);
         fd.show();
         path=fd.getDirectory()+fd.getFile();
     
         //set the image to the jlabel
         jlabPic2.setIcon(new ImageIcon(path));
    }//GEN-LAST:event_jlabUploadMouseClicked

    private void jbutUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutUpdateActionPerformed
       int matric_no =Integer.parseInt(jtfMatricNo.getText());
       String first_name=jtfFname2.getText();
       String second_name=jtfSname2.getText();
       String college=jcbCg2.getSelectedItem().toString();
       String department=jcbDp2.getSelectedItem().toString();
       String semester=jcbSmter2.getSelectedItem().toString();
       String level=jcbLevel2.getSelectedItem().toString();
       String phone_no=jtfPnum.getText();
       String guardian_no=jtfGnum.getText();
       String email=jtfEmail2.getText();
   
        if(first_name.equals("")||second_name.equals("")||phone_no.equals("")||guardian_no.equals(""))
        {   
            JOptionPane.showMessageDialog(rootPane, "EMPTY FIELD(S) DETECTED");
        }else{
            access3.update(matric_no,first_name,second_name,college,department,semester,level,phone_no,guardian_no,email);
            //new EditClass().del(matric_no);
            this.update();
            //new EditImageClass().UpdateImage(img, fis, matric_no);
            JOptionPane.showMessageDialog(rootPane, "SUCCESSFULLY UPDATED");
        }
    }//GEN-LAST:event_jbutUpdateActionPerformed

    private void jbutSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutSearchActionPerformed
       int mat=Integer.parseInt(jtfSMat.getText());
       String fname=jtfSF.getText();
       
       if(mat==0 || fname.equals("")){
           JOptionPane.showMessageDialog(null, "EMPTY FILED(S) DETECTED ");
           jtabInfo1.setModel(null); 
       }else{
        DefaultTableModel dm2 = new viewClass().searchData(mat,fname);
       
       jtabInfo1.setModel(dm2);
       }
    }//GEN-LAST:event_jbutSearchActionPerformed

    private void jbutPaySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutPaySearchActionPerformed
       if(jtfPayF.getText().equals("") || jtfPayS.getText().equals("")){
          JOptionPane.showMessageDialog(null, "EMPTY FILED(S) DETECTED ");
           jtabPay.setModel(null);
       }
       else{ 
        DefaultTableModel pay = new PaymentClass().searchPayData(jtfPayF.getText(),jtfPayS.getText());
       
       jtabPay.setModel(pay);
       }
    }//GEN-LAST:event_jbutPaySearchActionPerformed

    private void optionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionActionPerformed
      CardLayout card;
      card= ((CardLayout)jpInitial.getLayout());
      card.show(jpInitial, "cardCReg");
    }//GEN-LAST:event_optionActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
     System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void jbutCourseReg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutCourseReg1ActionPerformed
        int matric_no=Integer.parseInt(jtfMat.getText());
        String first_name= jtfMFN.getText();
        String second_name= jtfMSN.getText();
        String semester=jcbSemester1.getSelectedItem().toString();
        String level=jcbLevel1.getSelectedItem().toString();
        String college=jcbFac1.getSelectedItem().toString();
        String department=jcbDeprt1.getSelectedItem().toString();
        String course1=jcbCourse1.getSelectedItem().toString();
        String course2=jcbCourse2.getSelectedItem().toString();
        String course3=jcbCourse3.getSelectedItem().toString();
        String course4=jcbCourse4.getSelectedItem().toString();
        String course5=jcbCourse5.getSelectedItem().toString();
        
        if(first_name.equals("")||second_name.equals("")){
         JOptionPane.showMessageDialog(rootPane, "EMPTY FIELD(S) DETECTED");
        }
        else{
         access4.Reg(matric_no, first_name, second_name, semester, level, college, department, course1,  course2,  course3,  course4,  course5);
         JOptionPane.showMessageDialog(rootPane, "SUCCESSFUL");
        }
        
        
    }//GEN-LAST:event_jbutCourseReg1ActionPerformed

    private void jbutSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutSearch1ActionPerformed
      if(Integer.parseInt(jtfM.getText())==0 || jtfF.getText().equals("")){
           jtabInfo3.setModel(null);
           JOptionPane.showMessageDialog(null, "EMPTY FILED(S) DETECTED ");
        }
      else{  
        DefaultTableModel reg = new CourseRegClass().searchCourse(Integer.parseInt(jtfM.getText()),jtfF.getText());
       
        jtabInfo3.setModel(reg);
      }
    }//GEN-LAST:event_jbutSearch1ActionPerformed

    private void aboutUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutUsActionPerformed
       CardLayout card;
      card= ((CardLayout)jpInitial.getLayout());
      card.show(jpInitial, "cardResult");
    }//GEN-LAST:event_aboutUsActionPerformed

    private void jbutResultBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutResultBack1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbutResultBack1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jbutResultCheckerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutResultCheckerActionPerformed
        if(jtfResult.getText().equals("")){
            JOptionPane.showMessageDialog(null, "EMPTY FILED(S) DETECTED ");
            jtabResult.setModel(null);
        }
        else{
        DefaultTableModel result = new CourseRegClass().ResultChck(Integer.parseInt(jtfResult.getText()));
       
       jtabResult.setModel(result);
        }
    }//GEN-LAST:event_jbutResultCheckerActionPerformed

    private void jbutRSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutRSaveActionPerformed
        int matric_no = Integer.parseInt(jtfRM.getText());
        String course= jtfRC.getText();
        int score=  Integer.parseInt(jtfRS.getText());
        String grade= jtfRG.getText();
        
        if(matric_no==0 ||course.equals("")||score==0||grade.equals("")){
        JOptionPane.showMessageDialog(null, "EMPTY FILED(S) DETECTED ");
    
    }else{
            access4.RecordResult(matric_no, course, score, grade);
            JOptionPane.showMessageDialog(null, "SUCCESSFUL");
            
            jtfRM.setText("");
            jtfRC.setText("");
            jtfRS.setText("");
            jtfRG.setText("");
        
        }
    }//GEN-LAST:event_jbutRSaveActionPerformed

    private void jbutPaymentClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutPaymentClearActionPerformed
       jtfName.setText("");
       jtfSName.setText("");
       jtfMatNo.setText("");
       jtfAmount.setText("");
       jtfDesc.setText("");
    }//GEN-LAST:event_jbutPaymentClearActionPerformed

    private void jbutRegBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutRegBack2ActionPerformed
        CardLayout card;
        card= ((CardLayout)jpInitial.getLayout());
        card.show(jpInitial, "cardStudent");
    }//GEN-LAST:event_jbutRegBack2ActionPerformed

    private void jbutResultBack3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutResultBack3ActionPerformed
        CardLayout card;
        card= ((CardLayout)jpInitial.getLayout());
        card.show(jpInitial, "cardStudent");
    }//GEN-LAST:event_jbutResultBack3ActionPerformed

    private void jbutRClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutRClearActionPerformed
      jtfRM.setText("");
      jtfRC.setText("");
      jtfRS.setText("");
      jtfRG.setText("");
    }//GEN-LAST:event_jbutRClearActionPerformed

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        CardLayout card;
        card= ((CardLayout)jpInitial.getLayout());
        card.show(jpInitial, "cardPayment");
    }//GEN-LAST:event_paymentActionPerformed

    private void resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultActionPerformed
       CardLayout card;
        card= ((CardLayout)jpInitial.getLayout());
        card.show(jpInitial, "cardResult");
    }//GEN-LAST:event_resultActionPerformed

    private void courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseActionPerformed
        CardLayout card;
        card= ((CardLayout)jpInitial.getLayout());
        card.show(jpInitial, "cardCReg");
    }//GEN-LAST:event_courseActionPerformed

    private void jtfMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMatKeyReleased
    
     int matid= Integer.parseInt(jtfMat.getText());

     Connection connection= null;
     Statement statement= null;
     ResultSet resultSet= null;
    //create a URL
    final String DATABASE_URL = "jdbc:mysql://localhost:3306/users";
    
    try{
      String sql ="select first_name , second_name from new_student where matric_no='"+matid+"'";
    //establish connection to database
    connection = DriverManager.getConnection(DATABASE_URL,"root","");
    
     //create statement for querying database
     statement = connection.prepareStatement(sql);
     
     //query database
     resultSet = statement.executeQuery(sql);
     
     //filling the textfield up
     while(resultSet.next()) {
      String fname= resultSet.getString("first_name");
      String sname= resultSet.getString("second_name");
      
      jtfMFN.setText(fname);
      jtfMSN.setText(sname);
         
     } 
    }
     catch(Exception e){
     JOptionPane.showMessageDialog(null, "ERROR");
     }
        
    }//GEN-LAST:event_jtfMatKeyReleased

    private void jbutLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutLogOutActionPerformed
        CardLayout card;
        card= ((CardLayout)jpInitial.getLayout());
        card.show(jpInitial, "cardHome");
    }//GEN-LAST:event_jbutLogOutActionPerformed

    private void jcbFac1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbFac1MouseReleased
         String col = jcbFac1.getSelectedItem().toString();
         //System.out.println(col);

     Connection connection= null;
     Statement statement= null;
     ResultSet resultSet= null;
    //create a URL
    final String DATABASE_URL = "jdbc:mysql://localhost:3306/users";
    
    try{
       //System.out.println(col); 
      String sql ="select department from department where faculty='"+col+"'";
      
      //establish connection to database
      connection = DriverManager.getConnection(DATABASE_URL,"root","");
    
     //create statement for querying database
     statement = connection.prepareStatement(sql);
     
     //query database
     resultSet = statement.executeQuery(sql);

     //filling the combobox up
     while(resultSet.next()) {
     String dep= resultSet.getString("department");
      
     jcbDeprt1.addItem(dep);
     } 
    }
     catch(Exception e){
     JOptionPane.showMessageDialog(null, "ERROR");
     }
    }//GEN-LAST:event_jcbFac1MouseReleased

    private void jcbDeprt1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDeprt1MouseReleased

    }//GEN-LAST:event_jcbDeprt1MouseReleased

    private void jcbDeprt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDeprt1MouseClicked
//         String col = jcbFac1.getSelectedItem().toString();
//         //System.out.println(col);
//
//     Connection connection= null;
//     Statement statement= null;
//     ResultSet resultSet= null;
//    //create a URL
//    final String DATABASE_URL = "jdbc:mysql://localhost:3306/users";
//    
//    try{
//       System.out.println(col); 
//      String sql ="select * from department where faculty='"+col+"'";
//      
//      //establish connection to database
//      connection = DriverManager.getConnection(DATABASE_URL,"root","");
//    
//     //create statement for querying database
//     statement = connection.prepareStatement(sql);
//     
//     //query database
//     resultSet = statement.executeQuery(sql);
//     
//     //filling the combobox up
//     while(resultSet.next()) {
//     String dep= resultSet.getString("department");
//      
//     jcbDeprt1.addItem(dep);
//     } 
//    }
//     catch(Exception e){
//     JOptionPane.showMessageDialog(null, "ERROR");
//     }
    }//GEN-LAST:event_jcbDeprt1MouseClicked

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
            java.util.logging.Logger.getLogger(StudentManagementSyst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentManagementSyst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentManagementSyst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentManagementSyst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentManagementSyst().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ResultChecker;
    private javax.swing.JMenuItem aboutUs;
    private javax.swing.JButton course;
    private javax.swing.JMenuItem exit;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbutCourseReg1;
    private javax.swing.JButton jbutExit;
    private javax.swing.JButton jbutLogOut;
    private javax.swing.JButton jbutLogin;
    private javax.swing.JButton jbutNWclear;
    private javax.swing.JButton jbutNewStudent1;
    private javax.swing.JButton jbutPayHistory;
    private javax.swing.JButton jbutPaySearch;
    private javax.swing.JButton jbutPayVerback;
    private javax.swing.JButton jbutPaymentClear;
    private javax.swing.JButton jbutRClear;
    private javax.swing.JButton jbutRSave;
    private javax.swing.JButton jbutRegBack1;
    private javax.swing.JButton jbutRegBack2;
    private javax.swing.JButton jbutResultBack1;
    private javax.swing.JButton jbutResultBack3;
    private javax.swing.JButton jbutResultChecker;
    private javax.swing.JButton jbutRetrieve;
    private javax.swing.JButton jbutSearch;
    private javax.swing.JButton jbutSearch1;
    private javax.swing.JButton jbutSubmit;
    private javax.swing.JButton jbutUpdate;
    private javax.swing.JComboBox<String> jcbCg;
    private javax.swing.JComboBox<String> jcbCg2;
    private javax.swing.JComboBox<String> jcbCourse1;
    private javax.swing.JComboBox<String> jcbCourse2;
    private javax.swing.JComboBox<String> jcbCourse3;
    private javax.swing.JComboBox<String> jcbCourse4;
    private javax.swing.JComboBox<String> jcbCourse5;
    private javax.swing.JComboBox<String> jcbDeprt1;
    private javax.swing.JComboBox<String> jcbDp;
    private javax.swing.JComboBox<String> jcbDp2;
    private javax.swing.JComboBox<String> jcbFac1;
    private javax.swing.JComboBox<String> jcbLevel1;
    private javax.swing.JComboBox<String> jcbLevel2;
    private javax.swing.JComboBox<String> jcbPayment;
    private javax.swing.JComboBox<String> jcbSemester1;
    private javax.swing.JComboBox<String> jcbSmter;
    private javax.swing.JComboBox<String> jcbSmter2;
    private javax.swing.JComboBox<String> jcblevel;
    private javax.swing.JLabel jlabBrowse;
    private javax.swing.JLabel jlabPic;
    private javax.swing.JLabel jlabPic2;
    private javax.swing.JLabel jlabUpload;
    private javax.swing.JPanel jpEditInfo;
    private javax.swing.JPanel jpHistory;
    private javax.swing.JPanel jpInitial;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JPanel jpNewStud;
    private javax.swing.JPanel jpPayment;
    private javax.swing.JPanel jpRegistration1;
    private javax.swing.JPanel jpResultChecker;
    private javax.swing.JPanel jpSearch;
    private javax.swing.JPanel jpVer;
    private javax.swing.JPanel jpView;
    private javax.swing.JPanel jplCourseReg;
    private javax.swing.JPanel jplStudent;
    private javax.swing.JTable jtabInfo;
    private javax.swing.JTable jtabInfo1;
    private javax.swing.JTable jtabInfo2;
    private javax.swing.JTable jtabInfo3;
    private javax.swing.JTable jtabPay;
    private javax.swing.JTable jtabResult;
    private javax.swing.JTextField jtfAmount;
    private javax.swing.JTextField jtfDesc;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfEmail2;
    private javax.swing.JTextField jtfF;
    private javax.swing.JTextField jtfFname;
    private javax.swing.JTextField jtfFname2;
    private javax.swing.JTextField jtfGNum;
    private javax.swing.JTextField jtfGnum;
    private javax.swing.JTextField jtfM;
    private javax.swing.JTextField jtfMFN;
    private javax.swing.JTextField jtfMSN;
    private javax.swing.JTextField jtfMat;
    private javax.swing.JTextField jtfMatNo;
    private javax.swing.JTextField jtfMatricNo;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfNum;
    private javax.swing.JTextField jtfPassword;
    private javax.swing.JTextField jtfPayF;
    private javax.swing.JTextField jtfPayS;
    private javax.swing.JTextField jtfPnum;
    private javax.swing.JTextField jtfRC;
    private javax.swing.JTextField jtfRG;
    private javax.swing.JTextField jtfRM;
    private javax.swing.JTextField jtfRS;
    private javax.swing.JTextField jtfResult;
    private javax.swing.JTextField jtfSF;
    private javax.swing.JTextField jtfSMat;
    private javax.swing.JTextField jtfSName;
    private javax.swing.JTextField jtfSname;
    private javax.swing.JTextField jtfSname2;
    private javax.swing.JTextField jtfUsername;
    private javax.swing.JMenu option;
    private javax.swing.JButton payment;
    private javax.swing.JButton result;
    // End of variables declaration//GEN-END:variables
}

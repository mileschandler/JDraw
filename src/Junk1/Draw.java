/*
 *TODO
 *need to make the server game loop reset if there are 0 players
 *
 *change colors of pens
 *
 **/
package Junk1;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import java.io.*;   //for files
public class Draw extends JFrame
{
    final static int SCREENHEIGHT = 768;
    final static int SCREENWIDTH = 1024;
    public static boolean outOpen = true;
    public static Socket socket;
    public static InetAddress addr;
    public static int PORT = 8080;
    public static String ServerAddress = "100.65.20.7";//1.55";
    public static InetAddress localAddr;
    public static BufferedReader in;
    public static PrintWriter out;
    JPanel jPanel1 = new javax.swing.JPanel();
    PadDraw drawPad = new PadDraw();
    JPanel txtpanel = new javax.swing.JPanel();
    JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    JTextArea txtOut = new javax.swing.JTextArea();
    JTextField txt = new javax.swing.JTextField();
    JPanel thkpanel = new javax.swing.JPanel();
    JButton midThickButton = new javax.swing.JButton();
    JButton incThickButton = new javax.swing.JButton();
    JButton decThckButton = new javax.swing.JButton();
    JPanel colPanel = new javax.swing.JPanel();
    JButton jButton1 = new javax.swing.JButton();
    JButton redButton = new javax.swing.JButton();
    JButton yellowButton = new javax.swing.JButton();
    JButton jButton8 = new javax.swing.JButton();
    JButton jButton11 = new javax.swing.JButton();
    JButton greenButton = new javax.swing.JButton();
    JButton jButton14 = new javax.swing.JButton();
    JButton blueButton = new javax.swing.JButton();
    JButton jButton18 = new javax.swing.JButton();
    JButton jButton21 = new javax.swing.JButton();
    JButton jButton23 = new javax.swing.JButton();
    JButton grayButton = new javax.swing.JButton();
    JButton jButton25 = new javax.swing.JButton();
    JButton brownButton = new javax.swing.JButton();
    JButton clearButton = new javax.swing.JButton();
    public Draw()

    {



        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(145, 173, 194));

        drawPad.setBackground(new java.awt.Color(247, 244, 237));

        javax.swing.GroupLayout drawPadLayout = new javax.swing.GroupLayout(drawPad);
        drawPad.setLayout(drawPadLayout);
        drawPadLayout.setHorizontalGroup(
                drawPadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 894, Short.MAX_VALUE)
        );
        drawPadLayout.setVerticalGroup(
                drawPadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 768, Short.MAX_VALUE)
        );

        txtpanel.setBackground(new java.awt.Color(127, 145, 131));

        txtOut.setBackground(new java.awt.Color(247, 244, 237));
        txtOut.setColumns(20);
        txtOut.setRows(5);
        jScrollPane1.setViewportView(txtOut);

        txt.setBackground(new java.awt.Color(247, 244, 237));
        txt.requestFocus();
        javax.swing.GroupLayout txtpanelLayout = new javax.swing.GroupLayout(txtpanel);
        txtpanel.setLayout(txtpanelLayout);
        txtpanelLayout.setHorizontalGroup(
                txtpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(txtpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(txtpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
                                .addContainerGap())
        );
        txtpanelLayout.setVerticalGroup(
                txtpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(txtpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addContainerGap())
        );

        thkpanel.setBackground(new java.awt.Color(178, 144, 137));

        midThickButton.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        midThickButton.setText("Mid");
        midThickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midThickButtonActionPerformed(evt);
            }
        });

        incThickButton.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        incThickButton.setText("Thick");
        incThickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incThickButtonActionPerformed(evt);
            }
        });

        decThckButton.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        decThckButton.setText("Thin");
        decThckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decThckButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout thkpanelLayout = new javax.swing.GroupLayout(thkpanel);
        thkpanel.setLayout(thkpanelLayout);
        thkpanelLayout.setHorizontalGroup(
                thkpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(thkpanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(thkpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(decThckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(incThickButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(midThickButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        thkpanelLayout.setVerticalGroup(
                thkpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(thkpanelLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(decThckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(159, 159, 159)
                                .addComponent(midThickButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(incThickButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))
        );

        colPanel.setBackground(new java.awt.Color(255, 153, 153));

        jButton1.setBackground(new java.awt.Color(153, 0, 51));
        jButton1.setForeground(new java.awt.Color(255, 0, 51));

        redButton.setBackground(new java.awt.Color(255, 0, 51));
        redButton.setText("jButton1");
        redButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButtonActionPerformed(evt);
            }
        });

        yellowButton.setBackground(new java.awt.Color(255, 204, 0));
        yellowButton.setForeground(new java.awt.Color(255, 204, 0));
        yellowButton.setText("jButton1");
        yellowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowButtonActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(102, 204, 0));
        jButton8.setText("jButton1");

        jButton11.setForeground(new java.awt.Color(0, 204, 153));
        jButton11.setText("jButton1");

        greenButton.setBackground(new java.awt.Color(0, 153, 51));
        greenButton.setText("jButton1");
        greenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenButtonActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(0, 255, 255));
        jButton14.setText("jButton1");

        blueButton.setBackground(new java.awt.Color(0, 51, 204));
        blueButton.setText("jButton1");
        blueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueButtonActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(102, 0, 204));
        jButton18.setText("jButton1");

        jButton21.setBackground(new java.awt.Color(255, 0, 255));
        jButton21.setText("jButton1");

        jButton23.setBackground(new java.awt.Color(204, 0, 51));
        jButton23.setText("jButton1");

        grayButton.setBackground(new java.awt.Color(0, 0, 0));
        grayButton.setText("jButton1");
        grayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grayButtonActionPerformed(evt);
            }
        });

        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("jButton1");

        brownButton.setBackground(new java.awt.Color(102, 0, 51));
        brownButton.setText("jButton1");
        brownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brownButtonActionPerformed(evt);
            }
        });

        clearButton.setText("jButton2");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout colPanelLayout = new javax.swing.GroupLayout(colPanel);
        colPanel.setLayout(colPanelLayout);
        colPanelLayout.setHorizontalGroup(
                colPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(colPanelLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(grayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(brownButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))
                        .addGroup(colPanelLayout.createSequentialGroup()
                                .addGap(485, 485, 485)
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        colPanelLayout.setVerticalGroup(
                colPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(colPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(colPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(colPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(grayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(brownButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearButton)
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(thkpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8)
                                                .addComponent(drawPad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(colPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(colPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(drawPad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(thkpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        txt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                out.println(1+" "+txt.getText());
                txt.setText("");
            }
        });

        pack();

}
        private void incThickButtonActionPerformed(java.awt.event.ActionEvent evt) {


        out.println("6");
    }

        private void midThickButtonActionPerformed(java.awt.event.ActionEvent evt) {
        out.println("8");        // TODO add your handling code here:
    }

        private void decThckButtonActionPerformed(java.awt.event.ActionEvent evt) {
        out.println("7");        // TODO add your handling code here:
    }

        private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {
        out.println("a");        // TODO add your handling code here:
    }

        private void brownButtonActionPerformed(java.awt.event.ActionEvent evt) {
        out.println("b");        // TODO add your handling code here:
    }

        private void blueButtonActionPerformed(java.awt.event.ActionEvent evt) {
        out.println("c");        // TODO add your handling code here:
    }

        private void yellowButtonActionPerformed(java.awt.event.ActionEvent evt) {
        out.println("d");        // TODO add your handling code here:
    }

        private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {
        out.println("e");
        // TODO add your handling code here:
    }

        private void grayButtonActionPerformed(java.awt.event.ActionEvent evt) {
        out.println("f");        // TODO add your handling code here:
    }

        private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        out.println("9");        // TODO add your handling code here:
    }






    // </editor-fold>




    class PadDraw extends JComponent
    {
        boolean enable=true;
        Color red = new Color(182, 33, 45);
        Color brown = new Color(127, 84, 23);
        Color gray = new Color(102, 102, 102);
        Color blue = new Color(51, 102, 153);
        Color yellow = new Color(253, 184, 19);
        Color green = new Color(65, 146, 75);
        Image image;
        Graphics2D graphics2D;
        int currentX, currentY, oldX, oldY;
        public PadDraw()
        {
            setDoubleBuffered(false);
            addMouseListener(new MouseAdapter()
            {
                public void mousePressed(MouseEvent e)
                {
                    if(!enable)
                        return;
                    oldX = e.getX();
                    oldY = e.getY();
                    out.println("2"+oldX);
                    out.println("3"+oldY);
                }
            });
            //if the mouse is pressed it sets the oldX & oldY
            //coordinates as the mouses x & y coordinates
            addMouseMotionListener(new MouseMotionAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                    if(!enable)
                        return;
                    currentX = e.getX();
                    currentY = e.getY();
                    out.println("4"+currentX);
                    out.println("5"+currentY);
                    if(graphics2D != null) {
                        graphics2D.drawLine(oldX, oldY, currentX, currentY);
                        System.out.println("Mouse Event: " + oldX + " " + oldY + " " + currentX + " " + currentY);
                    }//repaint();
                    oldX = currentX;
                    oldY = currentY;
                    out.println("2"+oldX);
                    out.println("3"+oldY);
                }

            });
            //while the mouse is dragged it sets currentX & currentY as the mouses x and y
            //then it draws a line at the coordinates
            //it repaints it and sets oldX and oldY as currentX and currentY
        }
        public void drawLine(int a,int b,int c,int d)
        {
            graphics2D.drawLine(a,b,c,d);
            repaint();
        }
        public void setEnable(boolean n)
        {
            enable=n;
        }
        public void paintComponent(Graphics g)
        {
            if(image == null){
                image = createImage(getSize().width, getSize().height);
                graphics2D = (Graphics2D)image.getGraphics();
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                clear();

            }
            g.drawImage(image, 0, 0, null);
        }



        public void clear()
        {
            graphics2D.setPaint(Color.WHITE);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.BLACK);
            repaint();
        }

        public void red()
        {
            graphics2D.setPaint(red);
            repaint();
        }
        //this is the red paint
        public void brown()
        {
            graphics2D.setPaint(brown);
            repaint();
        }
        //brown paint
        public void green()
        {
            graphics2D.setPaint(green);
            repaint();
        }
        //green paint
        public void blue()
        {
            graphics2D.setPaint(blue);
            repaint();
        }
        //blue paint
        public void yellow()
        {
            graphics2D.setPaint(yellow);
            repaint();
        }
        //blue paint
        public void gray()
        {
            graphics2D.setPaint(gray);
            repaint();
        }
        //gray paint
        public void setThickness(int thick)
        {
            graphics2D.setStroke(new BasicStroke(thick));
        }
    }

    public void mainInput() throws IOException
    {
//*******************************************************network
        localAddr =  InetAddress.getLocalHost();
        addr =InetAddress.getByName(ServerAddress);
        setVisible(true);
        //  initialize network output  **********************
        socket = new Socket(addr,PORT);//server.PORT);
        outOpen = true;
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                socket.getOutputStream())),true);
        in = new BufferedReader ( new InputStreamReader(
                socket.getInputStream()));
        // end network initialize **********************
        while(true)
        {
            int oldX=-1;
            int oldY=-1;
            int currentX=-1;
            int currentY=-1;


                while(oldX==-1||oldY==-1||currentX==-1||currentY==-1)
                {
                    String line = in.readLine();
                    if(line.charAt(0)=='f')
                    {
                        drawPad.gray();
                    }
                    if(line.charAt(0)=='e')
                    {
                        drawPad.green();
                    }
                    if(line.charAt(0)=='d')
                    {
                        drawPad.yellow();
                    }
                    if(line.charAt(0)=='c')
                    {
                       drawPad.blue();
                    }
                    if(line.charAt(0)=='b')
                    {
                        drawPad.brown();
                    }
                    if(line.charAt(0)=='a')
                    {
                        drawPad.red();
                    }
                    if(line.charAt(0)=='9')
                    {
                        drawPad.clear();
                    }
                    if(line.charAt(0)=='8')
                    {
                        drawPad.setThickness(50);
                    }
                    if(line.charAt(0)=='7')
                    {
                        drawPad.setThickness(10);
                    }
                    if(line.charAt(0)=='6')
                    {
                        drawPad.setThickness(100);
                    }
                    if(line.charAt(0)=='5')
                    {
                        currentY=Integer.parseInt(line.substring(1,line.length()));
                    }
                    if(line.charAt(0)=='4')
                    {
                        currentX=Integer.parseInt(line.substring(1,line.length()));
                    }
                    if(line.charAt(0)=='3')
                    {
                        oldY=Integer.parseInt(line.substring(1,line.length()));
                    }
                    if(line.charAt(0)=='2')
                    {
                        oldX=Integer.parseInt(line.substring(1,line.length()));
                    }
                    System.out.println(oldX+" "+oldY+" "+currentX+" "+currentY);

                    if(line.charAt(0)=='1')
                    {
                        line = line.substring(2, line.length());
                        txtOut.append(line + "\n");
                        if(line.equals("You are the Drawer"))
                        {
                            txt.setEnabled(false);
                            drawPad.setEnable(true);
                        }

                        if(line.equals("Guess what the picture is!"))
                        {
                            txt.setEnabled(true);
                            drawPad.setEnable(false);
                            redButton.setEnabled(false);
                        }
                    }
                }
                drawPad.drawLine(oldX,oldY,currentX,currentY);
                drawPad.repaint();
        }
    }// end of mainInput
}

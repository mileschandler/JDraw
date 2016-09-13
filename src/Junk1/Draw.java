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
public class Draw
{
    final static int SCREENHEIGHT = 768;
    final static int SCREENWIDTH = 1024;
    public static boolean outOpen = true;
    public static Socket socket;
    public static InetAddress addr;
    public static int PORT = 8080;
    public static String ServerAddress = "172.24.53.80";//1.55";
    public static InetAddress localAddr;
    public static BufferedReader in;
    public static PrintWriter out;
    TextArea txtOut = new TextArea();
    JPanel txtpanel=new JPanel();
    JTextField txt = new JTextField(25);
    JPanel thkPanel=new JPanel();
    JPanel colPanel=new JPanel();
    JFrame frame=new JFrame();
    PadDraw drawPad = new PadDraw();
    JButton redButton = new JButton("Red");
    //Colors:
    Color navy = new Color(10, 73, 88);

    public Draw()

    {
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        txtpanel.setSize(10,50);
        txtpanel.setLayout(new BorderLayout());
        txtpanel.setBackground(navy);
        txtOut.setEditable(false);
        content.add(txtpanel,BorderLayout.EAST);
        txtpanel.add (txtOut,BorderLayout.NORTH);
        txtpanel.add(txt, BorderLayout.SOUTH);
        frame.setVisible(true);
        txt.setSize(100,100);
        txt.requestFocus();
        drawPad.setLayout(new BorderLayout());
        content.add(drawPad, BorderLayout.CENTER);
        txt.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                out.println(1+" "+txt.getText());
                txt.setText("");
            }



        });


        thkPanel.setBackground(navy);
        drawPad.add(thkPanel, BorderLayout.SOUTH);



        colPanel.setBackground(navy);
        drawPad.add(colPanel,BorderLayout.NORTH);
        JButton incThickButton = new JButton("Thick");
        incThickButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                out.println("6");
            }
        });

        JButton decThickButton = new JButton("Thin");
        incThickButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                out.println("7");

            }
        });

        JButton midThickButton = new JButton("Medium");
        midThickButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                out.println("8");

            }
        });


        JButton clearButton = new JButton("Clear Scrn");
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                out.println("9");

            }
        });
        JButton redButton = new JButton("Red");
        redButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                out.println("a");

            }

        });

        JButton brownButton = new JButton("Brown");
        brownButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                out.println("b");

            }
        });

        JButton blueButton = new JButton("Blue");
        blueButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                out.println("c");

            }
        });

        JButton yellowButton = new JButton("Yellow");

        yellowButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                out.println("d");

            }
        });

        JButton greenButton = new JButton("Green");

        greenButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                out.println("e");

            }
        });

        JButton grayButton = new JButton("Gray");

        grayButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                out.println("f");

            }
        });


        colPanel.add(grayButton);
        colPanel.add(redButton);
        colPanel.add(greenButton);
        colPanel.add(blueButton);
        colPanel.add(brownButton);
        colPanel.add(yellowButton);



        thkPanel.add(clearButton);
        thkPanel.add(decThickButton);
        thkPanel.add(midThickButton);
        thkPanel.add(incThickButton);

        frame.setSize(SCREENWIDTH,SCREENHEIGHT);
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

    }

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
        public boolean getEnable()
        {
            return enable;
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
        //this is the painting bit
        //if it has nothing on it then
        //it creates an image the size of the window
        //sets the value of Graphics as the image
        //sets the rendering
        //runs the clear() method
        //then it draws the image


        public void clear()
        {
            graphics2D.setPaint(Color.WHITE);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.BLACK);
            repaint();
        }
        //this is the clear
        //it sets the colors as white
        //then it fills the window with white
        //thin it sets the color back to black
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
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        addr =InetAddress.getByName(ServerAddress);
        frame.setVisible(true);
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


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductPanel extends Product implements ActionListener{
    Calculation c = new Calculation();
    //combobox
    public static JComboBox product;
    public static JComboBox material;
    public static JComboBox stone;
    //radiobutton
    public static JRadioButton retail;
    public static JRadioButton wholesale;
    //textfields
    public static JTextField hoursT;
    public static JTextField laborT;
    public static JTextField materialcostT;
    //labels
    private static JLabel productl;
    private static JLabel materiall;
    private static JLabel stonel;
    private static JLabel Titlel;
    private static JLabel pricel;
    private static JLabel hoursl;
    private static JLabel laborl;
    private static JLabel materialcostl;

    public void ProductFrame(){
        //f
        JFrame f = new JFrame("Pricing System");
        //p
        JPanel p = new JPanel();
        //l
        productl = new JLabel("Select Product");
        materiall = new JLabel("Select Material");
        stonel = new JLabel("Select stone");
        Titlel = new JLabel("Forever Gems");
        pricel = new JLabel("Select Pricing");
        hoursl = new JLabel("Hours Worked");
        laborl = new JLabel("Labor Cost");
        materialcostl = new JLabel("Material Cost");
        //c
         product = new JComboBox(products);
         product.addActionListener(this);
         material = new JComboBox(materials);
         material.addActionListener(this);
         stone = new JComboBox(stones);
         stone.addActionListener(this);
         //r
         retail = new JRadioButton("Retail");
         retail.addActionListener(this);
         wholesale = new JRadioButton("WholeSale");
         wholesale.addActionListener(this);
         ButtonGroup group = new ButtonGroup();
         group.add(retail);
         group.add(wholesale);
         //t
        hoursT = new JTextField();
        laborT = new JTextField();
        materialcostT = new JTextField();

        //f layout
        f.setSize(300,450);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.add(p);

        //p Layout
        p.setLayout(null);
        p.add(Titlel);
        p.add(productl);
        p.add(materiall);
        p.add(stonel);
        p.add(pricel);
        p.add(product);
        p.add(material);
        p.add(stone);
        p.add(laborT);
        p.add(materialcostT);
        p.add(hoursT);
        p.add(retail);
        p.add(wholesale);
        p.add(laborl);
        p.add(hoursl);
        p.add(materialcostl);

        //l Layout
        Titlel.setBounds(100,10,50,50);
        Titlel.setSize(100,10);
        productl.setBounds(10, 60, 100, 50);
        productl.setSize(100,10);
        materiall.setBounds(10, 110, 100, 50);
        materiall.setSize(100,10);
        stonel.setBounds(10, 160, 100, 50);
        stonel.setSize(100,10);
        hoursl.setBounds(10,210,100,50);
        hoursl.setSize(100,10);
        laborl.setBounds(10,260,100,50);
        laborl.setSize(100,10);
        materialcostl.setBounds(10,310,100,50);
        materialcostl.setSize(100,10);
        pricel.setBounds(10,365,100,50);
        pricel.setSize(100,20);
        //c Layout
        product.setBounds(170,50,100,30);
        material.setBounds(170,100,100,30);
        stone.setBounds(170,150,100,30);
        hoursT.setBounds(170,200,100,30);
        laborT.setBounds(170,250,100,30);
        materialcostT.setBounds(170,300,100,30);
        wholesale.setBounds(170,350,100,30);
        retail.setBounds(170,370,100,30);
}

    @Override
    public void actionPerformed(ActionEvent e) {
     p = (String)product.getSelectedItem();
     m = (String)material.getSelectedItem();
     s = (String)stone.getSelectedItem();
     resultw=solvingw(hoursT.getText(), laborT.getText(), materialcostT.getText());
     resultr=solvingr(hoursT.getText(), laborT.getText(), materialcostT.getText());
      if(wholesale.isSelected()){
        JOptionPane.showMessageDialog(null, "You ordered a "+p +" made of "+m+" with "+s);
        message(String.valueOf(resultw));
      }
      if(retail.isSelected()){
        JOptionPane.showMessageDialog(null, "You ordered a "+p +" made of "+m+" with "+s);
        message(String.valueOf(resultr));
      }
}

    public double solvingw(String hoursworked, String laborcost, String materialcost) {
       double hourswork = Integer.parseInt(hoursworked);
       double laborc= Integer.parseInt(laborcost);
       double matcost=Integer.parseInt(materialcost);
       c.wage(laborc, hourswork);
       c.overhead(matcost);
       return c.finalpriceW(c.wage(laborc, hourswork),c.overhead(matcost));
    }
    public double solvingr(String hoursworked, String laborcost, String materialcost) {
        double hourswork = Integer.parseInt(hoursworked);
        double laborc= Integer.parseInt(laborcost);
        double matcost=Integer.parseInt(materialcost);
        c.wage(laborc, hourswork);
        c.overhead(matcost);
        return c.finalpriceR(c.wage(laborc, hourswork),c.overhead(matcost));
     }
     
    public void message(String Message){
        JOptionPane.showMessageDialog( null, Message, "Pricing System" , JOptionPane.INFORMATION_MESSAGE );
    }   
    }



    

    
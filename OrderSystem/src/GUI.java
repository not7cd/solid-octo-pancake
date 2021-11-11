import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GUI extends UserInterface {
    JFrame f;
    JButton b1;//creating instance of JButton
    JButton b2;

    protected GUI(OrderService orderService) {
        super(orderService);
        JFrame f=new JFrame("OrderService");//creating instance of JFrame

        b1 = new JButton("New Product");
        b2 = new JButton("New Service");

        b1.setBounds(0,0,200, 40);
        b2.setBounds(200,0,200, 40);

        f.add(b1);//adding button in JFrame
        f.add(b2);
        b1.addActionListener(e -> displayDialogService());

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }

    private void displayDialogService() {
        JTextField name = new JTextField(5);
        JTextField price = new JTextField(5);
        JTextField qty = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("name:"));
        myPanel.add(name);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("price:"));
        myPanel.add(price);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("qty:"));
        myPanel.add(qty);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Order a new product", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println("x value: " + name.getText());
            System.out.println("y value: " + price.getText());
            System.out.println("y value: " + qty.getText());
        }
    }

    private void displayMenu() {


//        b1.addActionListener(e -> displayDialogService());
//        displayDialogService();
    }

    @Override
    public void menuloop() {

    }

}
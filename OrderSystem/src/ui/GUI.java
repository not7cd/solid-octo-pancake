package ui;

import enitites.Service;
import models.Item;

import javax.swing.*;

public class GUI extends UserInterface {
    JFrame f;
    JList<String> stringJList;
    JButton b1;//creating instance of JButton
    JButton b2;

    public GUI(Service orderService) {
        super(orderService);
        JFrame f=new JFrame("enitites.ItemFactory.OrderService");//creating instance of JFrame

        b1 = new JButton("New Product");
        b2 = new JButton("New enitites.Service");
        JButton b3 = new JButton("Finish Order");

        stringJList = new JList< >();
        stringJList.setBounds(0,80,400,400);
        f.add(stringJList);

        b1.setBounds(0,0,200, 40);
        b2.setBounds(200,0,200, 40);
        b3.setBounds(0,40,400, 40);
        
        f.add(b1);//adding button in JFrame
        f.add(b2);
        f.add(b3);

        b1.addActionListener(e -> displayDialogProduct());
        b2.addActionListener(e -> displayDialogService());
        b3.addActionListener(e -> displayFinishOrder());

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers

        f.setVisible(true);//making the frame visible
    }

    private void displayDialogProduct() {
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
            String s = name.getText();
            int i = Integer.parseInt(price.getText());
            int i1 = Integer.parseInt(qty.getText());
            orderService.orderProduct(s,i,i1);
            displayOrder();
        }
    }

    private void displayDialogService() {
        JTextField name = new JTextField(5);
        JTextField price = new JTextField(5);
        JTextField qty = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("name:"));
        myPanel.add(name);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("persons:"));
        myPanel.add(price);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("hours:"));
        myPanel.add(qty);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Order a new service", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String s = name.getText();
            int i = Integer.parseInt(price.getText());
            int i1 = Integer.parseInt(qty.getText());

            orderService.orderService(s,i,i1);
            displayOrder();
        }
    }

    private void displayOrder() {
        DefaultListModel<String> l = new DefaultListModel< >();
        for (Item item : orderService.getOrder()) {
            l.addElement(item + " = " + formatPrice(item.getPrice()));
        }
        stringJList.setModel(l);
    }

    private void displayFinishOrder() {
        DefaultListModel<String> l = new DefaultListModel< >();
        int sum = 0;
        for (Item item : orderService.finishOrder()) {
            sum += item.getPrice();
            l.addElement(item + " = " + formatPrice(item.getPrice()));
        }
        l.addElement("Sum: "+ formatPrice(sum));
        stringJList.setModel(l);
    }

    @Override
    public void menuloop() {

    }

}
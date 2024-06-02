import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;


public class Cframe extends JFrame implements ActionListener {

    JLabel title,name,mobile,gender,dob,address,message; //define text labels

    JTextField nametext,mobiletext; // define text area for input name and phone no:

    JRadioButton male,female; // create radio buttons
    ButtonGroup group ; // create button group for select only one option (male or female)

    JComboBox date,month,year; // define combo boxes for day,month and year
    Integer [] d = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};// variables for day
    String[] m = {"JAN","FEB","MAR","APR",",MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};// variables for month
    Integer[] y = {1995,1996,1997,1998,1999,2000,2001,2002,2003};// variables for year

    JCheckBox terms;// define terms and condition check box

    JButton sumbit,reset;//define sumbit and reset button

    JTextArea addarea,outputarea; // define address text area and output text area

    Cframe(){
        // Labels
        title=new JLabel("Registration Form");       // add the tittle
        title.setBounds(280,0,300,50); // figure the x and y position and size of title area
        title.setHorizontalTextPosition(JLabel.CENTER);  // set the title position as the center
        title.setFont(new Font("Arial",Font.BOLD,30));// format the font
        name=new JLabel("Name");  // add name text
        name.setBounds(50,50,150,50);
        name.setFont(new Font("Arial",Font.BOLD,20));
        mobile=new JLabel("Mobile");// add mobile text
        mobile.setBounds(50,100,150,50);
        mobile.setFont(new Font("Arial",Font.BOLD,20));
        gender=new JLabel("Gender");//add gender text
        gender.setBounds(50,150,150,50);
        gender.setFont(new Font("Arial",Font.BOLD,20));
        dob=new JLabel("DOB");// add DOB text
        dob.setBounds(50,200,150,50);
        dob.setFont(new Font("Arial",Font.BOLD,20));
        address=new JLabel("Address"); // add address text
        address.setBounds(50,250,150,50);
        address.setFont(new Font("Arial",Font.BOLD,20));
        message=new JLabel(""); // define message text to output (please accept the terms and condition) or (registration successfully)
        message.setBounds(50,510,500,50);
        message.setFont(new Font("Arial",Font.PLAIN,20));
        // Text fields
        nametext=new JTextField();
        nametext.setBounds(150,65,200,25);
        mobiletext=new JTextField();
        mobiletext.setBounds(150,115,150,25);
        //radio buttons
        male=new JRadioButton("Male");
        male.setBounds(150,150,100,50);
        female=new JRadioButton("Female");
        female.setBounds(260,150,100,50);
        // button group
        group = new ButtonGroup();
        group.add(male); // adding male and female buttons to group
        group.add(female);
        // combo boxes
        date=new JComboBox(d);
        date.setBounds(150,215,50,20);
        month=new JComboBox(m);
        month.setBounds(200,215,50,20);
        year=new JComboBox(y);
        year.setBounds(254,215,70,20);
        // check box
        terms=new JCheckBox("Accept Terms and Conditions");
        terms.setFont(new Font("Arial",Font.PLAIN,14));
        terms.setBounds(120,400,300,50);
        //buttons
        sumbit=new JButton("Sumbit");
        sumbit.setBounds(80,480,100,25);
        sumbit.addActionListener(this);// command for do a action when click the button
        reset=new JButton("Reset");
        reset.setBounds(280,480,100,25);
        reset.addActionListener(this);
        // text areas
        addarea = new JTextArea();
        addarea.setBounds(150,270,200,100);
        outputarea = new JTextArea();
        outputarea.setFont(new Font("Arial",Font.PLAIN,15));
        outputarea.setBounds(500,55,300,500);
        // frame
        this.setSize(900,700); // set the frame size
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close option
        this.setLayout(null);
        this.setResizable(false);
        //adding all the define elements to the frame
        this.add(title);
        this.add(name);
        this.add(mobile);
        this.add(gender);
        this.add(dob);
        this.add(address);
        this.add(nametext);
        this.add(mobiletext);
        this.add(addarea);
        this.add(male);
        this.add(female);
        this.add(date);
        this.add(month);
        this.add(year);
        this.add(terms);
        this.add(sumbit);
        this.add(reset);
        this.add(outputarea);
        this.add(message);

    }

    // define the actions when the button clicked
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clicked = (JButton) e.getSource();
        if(clicked == sumbit){                      // if sumbit button get clicked
            String name = nametext.getText();       // getting input text(for name)and assign into name variable
            String mobile = mobiletext.getText();   // getting input text(for mobile) and assign into mobile variable
            String gen;
            if(male.isSelected()){
                gen = "male";
            }else if (female.isSelected()){
                gen = "female";
            }else{
                gen = "None";                 // get radio button result to gen var.
            }
            Integer date1 = d[date.getSelectedIndex()];
            String month1 =m[month.getSelectedIndex()];
            Integer year1 = y[year.getSelectedIndex()];  // getting combo box results and assign to variables
            String Address = addarea.getText();   // getting address input


            if(terms.isSelected()){
                outputarea.setText(
                      "NAME         :" + name+"\n"+"\n"+
                      "MOBILE     :" + mobile+"\n"+"\n"+
                      "GENDER   :" + gen+"\n"+"\n"+
                      "DOB           :" + date1+" - "+month1+" - "+year1+"\n"+"\n"+
                      "ADDRESS :" + Address

                ); // output command
                message.setText("--- Registration Successfully ---"); // message output

            }

            else{
                message.setText("Please Accept the Terms and Conditions"); // message output
            }}
            else if (clicked == reset){

                nametext.setText(null);
                mobiletext.setText(null);
                message.setText(null);
                group.clearSelection();
                date.setSelectedIndex(0);
                month.setSelectedIndex(0);
                year.setSelectedIndex(0);
                terms.setSelected(false);
                addarea.setText(null);
                outputarea.setText(null); // clearing all element values when reset button clicked

            }



        }


    }


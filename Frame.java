import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


//implement TableModelListener
public class Frame extends JFrame implements MenuListener, ActionListener{

    private JMenuBar menuBar = new JMenuBar();
    private JMenu about = new JMenu("About");
    private JMenu file = new JMenu("File");
    private JMenuItem load = new JMenuItem("Load a Roster");
    private JMenuItem add_att = new JMenuItem("Add Attendance");
    private JMenuItem save = new JMenuItem("Save");
    private JMenuItem plot = new JMenuItem("Plot Data");
    private JPanel pane = new JPanel();
    private Student[] studentArray; // declare a student array
    private JScrollPane scroll;
    private Load loadObject = new Load(); // declare an object of Load class to call Load operations
    private Add addObject = new Add();
    private Save saveObject = new Save();

    JFrame window;
    JTable table;

    Frame() {
        window = new JFrame("CSE360 Final Project");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //table.getModel().addTableModelListener(this);

        table = createTable();
        scroll = new JScrollPane(table);

        pane.setLayout(new BorderLayout());
        pane.add(scroll, BorderLayout.CENTER);

        pane.setLayout(new BorderLayout());
        pane.add(scroll, BorderLayout.CENTER);

        about.addMenuListener(this);
        load.addActionListener(this);
        add_att.addActionListener(this);
        save.addActionListener(this);
        plot.addActionListener(this);

        menuBar.add(file);
        menuBar.add(about);

        file.add(load);
        file.add(add_att);
        file.add(save);
        file.add(plot);

        window.add(pane);
        window.setJMenuBar(menuBar);
        window.setSize(500, 400);
        window.setVisible(true);

        //JFrame tempFrame = new JFrame("About");
        //JOptionPane about_message = new JOptionPane("Project Contributors:\nSamia Muraweh,\nZack Sanchez,\nJacob Sumner");
        //about_message.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //tempFrame.add(about_message);
        //tempFrame.setSize(150, 150);
        //about_message.setVisible(true);
    }

    public JTable createTable() {
        String[][] fileContents = new String[0][6];
            //sample data for testing purposes
            //String fileContents[][] = {{"1214289933", "Samia", "Muraweh", "Computer Science", "Junior", "smuraweh"}, {"Test", "Test", "Test", "Test", "Test", "Test"}};
            //String column[] = {"ID", "First Name", "Last Name", "Program", "Level", "ASUrite"};
        String[] column = {"ID", "First Name", "Last Name", "Program", "Level", "ASUrite"};
            //table = new JTable(fileContents, column);
        TableModel tblMod = new DefaultTableModel(column, 0);
        table = new JTable(tblMod);
        table.setBounds(30, 40, 200, 300);
        return table;
    }

    public void refresh(Student[] array){
        String[][] fileContents;
        String[] column = {"ID", "First Name", "Last Name", "Program", "Level", "ASUrite"};
        if(array != null) {
            fileContents = new String[array.length][6];

            for (int i = 0; i < array.length; i++) {
                fileContents[i][0] = array[i].getID();
                fileContents[i][1] = array[i].getFirst();
                fileContents[i][2] = array[i].getLast();
                fileContents[i][3] = array[i].getProg();
                fileContents[i][4] = array[i].getLevel();
                fileContents[i][5] = array[i].getASUrite();
            }
        }
        else
            fileContents = new String[0][6];
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setDataVector(fileContents, column);
        model.fireTableDataChanged();
        //model.fireTableDataChanged();
        //fireTableChanged();
    }

    public static void main(String[] args){
        new Frame();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == load){
            Student[] sArray = loadObject.loadRoster();
            refresh(sArray);
            studentArray = sArray;
            //JTable newTable = createTable();
            //scroll.remove(table);
            //scroll.add(newTable);
        }
        else if(e.getSource() == add_att) {
            addObject.addAttendance();
        }
        else if(e.getSource() == save) {

        }
        else if(e.getSource() == plot) {

        }
    }

    public void menuSelected (MenuEvent e) {
        if(e.getSource() == about)
            JOptionPane.showMessageDialog(null, "Project Contributors:\nSamia Muraweh,\nZack Sanchez,\nJacob Sumner");
    }

    public void menuDeselected (MenuEvent e) {

    }

    public void menuCanceled (MenuEvent e) {

    }

    //implemented from example
    /*public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel m = (TableModel)e.getSource();
        String columnName = m.getColumnName(column); //input specific int?
        Object data = m.getValueAt(row, column); //input specific numbers
    }*/

}

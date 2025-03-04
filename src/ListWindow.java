import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ListWindow {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel membersPanel;
    private JPanel tasksPanel;
    private JTable workersTable;
    private JTable tasksTable;
    private JTextField employeeNameTextField;
    private JTextField employeePositionTextField;
    private JTextField employeeSurnameTextField;
    private JButton EmployeeCreateButton;
    private JTextField taskNameTextField;
    private JButton TaskCreateButton;
    private JRadioButton toDoRadioButton;
    private JComboBox taskEmployeeComboBox;
    private JRadioButton inProgressRadioButton;
    private JRadioButton doneRadioButton;
    private JComboBox taskDueDateMonthCombo;
    private JComboBox taskDueDateHourCombo;
    private JComboBox taskDueDateYearCombo;
    private JComboBox taskDueDateDayCombo;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ListWindow");
        frame.setContentPane(new ListWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Task task1 = new Task("Napisać program w Java", Task.TaskStatus.IN_PROGRESS);
        Task task2 = new Task("Wystawić fakturę", Task.TaskStatus.TODO);
        Task task3 = new Task("Zaprojektować logo", Task.TaskStatus.TODO);

        Employee employee1 = new Employee("Polina", "Rybachuk", "Programmer");
        Employee employee2 = new Employee("Konrad", "Cepryński", "Designer");
        Employee employee3 = new Employee("Kacper", "Molewski", "Manager");

    }

    private Task.TaskStatus getRadioTaskStatus (){
        if (toDoRadioButton.isSelected()){
            return Task.TaskStatus.TODO;
        } else if (inProgressRadioButton.isSelected()) {
            return  Task.TaskStatus.IN_PROGRESS;
        } else if (doneRadioButton.isSelected()) {
            return Task.TaskStatus.FINISHED;
        }
        return null;
    }

    private void createUIComponents() {
        workersTable = new JTable();
        workersTable.setModel(new EmployeeTableModel());

        tasksTable = new JTable();
        tasksTable.setModel(new TasksTableModel());
        tasksTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    TaskEditPopUp dialog = new TaskEditPopUp(Task.getAllTasks().get(row));
                    dialog.pack();
                    dialog.setVisible(true);
                }
            }
        });

        EmployeeCreateButton = new JButton();
        EmployeeCreateButton.addActionListener(e -> {
            String name = employeeNameTextField.getText();
            String surname = employeeSurnameTextField.getText();
            String position = employeePositionTextField.getText();
            new Employee(name, surname, position);
            employeeNameTextField.setText("");
            employeeSurnameTextField.setText("");
            employeePositionTextField.setText("");
            panel1.repaint();
            workersTable.revalidate();
        });

        EmployeeComboBoxModel mode = new EmployeeComboBoxModel();
        taskEmployeeComboBox = new JComboBox(mode);

        taskDueDateMonthCombo = new JComboBox(Calendar.getMonth());
        taskDueDateHourCombo = new JComboBox(Calendar.getHours());
        taskDueDateYearCombo = new JComboBox(Calendar.getYear());
        taskDueDateDayCombo = new JComboBox(Calendar.getDay());
        taskDueDateDayCombo.setSelectedItem(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd")));
        taskDueDateMonthCombo.setSelectedItem(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("MM")));
        taskDueDateYearCombo.setSelectedItem(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy")));


        TaskCreateButton = new JButton();
        TaskCreateButton.addActionListener(e -> {
           String name = taskNameTextField.getText();
           String taskDueDateTextField = taskDueDateDayCombo.getSelectedItem() + "." + taskDueDateMonthCombo.getSelectedItem() + "." + taskDueDateYearCombo.getSelectedItem() + " " + taskDueDateHourCombo.getSelectedItem();
           Task task = new Task(name, getRadioTaskStatus(), LocalDateTime.parse(taskDueDateTextField, DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm")) );
           task.assignEmployee(Employee.getAllEmployees().get(taskEmployeeComboBox.getSelectedIndex()));
           taskNameTextField.setText("");
           panel1.repaint();
           tasksTable.revalidate();
        });

    }
}

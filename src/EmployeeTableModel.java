import javax.swing.table.AbstractTableModel;

public class EmployeeTableModel extends AbstractTableModel {

    private final String[] employeeColumnNames = {"Name", "Surname", "Position",
            "Assigned Tasks"};

    public EmployeeTableModel() {
    }


    @Override
    public String getColumnName(int columnIndex) {
        return employeeColumnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return Employee.getEmployeesCount();
    }

    @Override
    public int getColumnCount() {
        return employeeColumnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee e = Employee.getAllEmployees().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return e.getEmployeeName();
            case 1:
                return e.getSurname();
            case 2:
                return e.getPosition();
            case 3:
                return e.getAssignedTasksCount();
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
        }
        return null;
    }
}
/**
 * 
 */
package presentation;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author ingri
 *
 */
public class Print_Students extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GridBagConstraints c = new GridBagConstraints();
	private boolean DEBUG = false;
	JScrollPane scrollPane;
	JTable table;
	String header[] = {"ID", "Name","Email"};
	public Print_Students(String[][]students) {
		// TODO Auto-generated constructor stub
		super(new GridLayout(1,0));
		table = new JTable(students,header);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setFillsViewportHeight(true);
 
        if (DEBUG) {table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }
        //Create the scroll pane and add the table to it.
        scrollPane = new JScrollPane(table);
        //Add the scroll pane to this panel.
        add(scrollPane);
	}
	private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
        this.repaint();
    }
	

}

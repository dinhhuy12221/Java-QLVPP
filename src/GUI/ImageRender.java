package GUI;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageRender extends DefaultTableCellRenderer{
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//			System.out.print(value.toString());
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(value.toString()).getImage().getScaledInstance(100,70, Image.SCALE_SMOOTH));
		return new JLabel(imageIcon);
	}
}

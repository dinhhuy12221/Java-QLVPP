
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javax.swing.SwingUtilities;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test extends JFrame {

	final static JFXPanel fxPanel = new JFXPanel();
	public Test() {
		add(fxPanel);
		setSize(880,585);
		
//		JButton btnDoanhThu = new JButton("Doanh thu");
//		btnDoanhThu.addActionListener(new ActionListener() {
////			public void actionPerformed(ActionEvent e) {
////				SwingUtilities.invokeLater(new Runnable() {
////			        @Override
////			        public void run() {
////			        	initAndShowGUI();
////			        }
////			    });
////			}
////		});
//		btnDoanhThu.setBounds(772, 20, 85, 21);
//		add(btnDoanhThu);
		setVisible(true);
    }
	
	private static void initAndShowGUI() {
		Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	new Test();
                initFX(fxPanel);
            }
		});
	}

    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private static Scene createScene() {
    	// Defining axis
        final NumberAxis xaxis = new NumberAxis(2008,2018,1);
        final NumberAxis yaxis = new NumberAxis(10,80,5);

        // Defining label for axis
        xaxis.setLabel("Year");
        yaxis.setLabel("Price");

        // Creating the instance of line chart with the specified axis
        LineChart lineChart = new LineChart(xaxis, yaxis);

        // Creating series
        XYChart.Series series = new XYChart.Series();

        // Setting name and the date to Linechart
        series.setName("Doanh số bán hàng");
        series.getData().add(new XYChart.Data(2009,25));
        series.getData().add(new XYChart.Data(2010,15));
        series.getData().add(new XYChart.Data(2011,68));
        series.getData().add(new XYChart.Data(2012,60));
        series.getData().add(new XYChart.Data(2013,35.5));
        series.getData().add(new XYChart.Data(2014,55));
        series.getData().add(new XYChart.Data(2015,45));
        series.getData().add(new XYChart.Data(2016,67));
        series.getData().add(new XYChart.Data(2017,78));

        // Adding series to the linechart
        lineChart.getData().add(series);

        // Setting group and scene
        Group group = new Group(lineChart);
        Scene scene = new Scene(group);

        return (scene);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();
            }
        });
    }
}

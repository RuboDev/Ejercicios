package swing_avanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import java.sql.ResultSetMetaData;
import java.sql.DatabaseMetaData;

public class TablaProductos {
    public static void main(String[] args) {
        JFrame mimarco = new MarcoProductos();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

class MarcoProductos extends JFrame {
    private JComboBox<String> nombresDeTablas;
    private DatabaseMetaData metadataDB;
    private ResultSet rs;
    private Connection miConexion;
    private String sql;
    private Statement mistatement;
    private ResultSetModeloTabla modeloTabla;

    public MarcoProductos() {
        setTitle("Productos");
        setBounds(500, 300, 1000, 800);

        JPanel superior = new JPanel();
        nombresDeTablas = new JComboBox<String>();

        try {
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Curso_SQL", "phpmyadmin",
                    ".admin1234.");
            metadataDB = miConexion.getMetaData();
            rs = metadataDB.getTables("Curso_SQL", null, null, null);

            while (rs.next()) {
                nombresDeTablas.addItem(rs.getString("TABLE_NAME"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTable tabla = new JTable();
        JScrollPane miscroll = new JScrollPane(tabla);

        nombresDeTablas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String tablaSeleccionada = (String) nombresDeTablas.getSelectedItem();
                sql = "SELECT * FROM " + tablaSeleccionada;
                try {
                    mistatement = miConexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
                    rs = mistatement.executeQuery(sql);
                    /*while (rs.next()) {
                        System.out.println(rs.getString("NOMBREARTÍCULO") + " " + rs.getString("CÓDIGOARTÍCULO"));
                        
                    }*/
                    modeloTabla = new ResultSetModeloTabla(rs);
                    tabla.setModel(modeloTabla);
                    add(miscroll, BorderLayout.CENTER);
                    validate();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        superior.add(nombresDeTablas);
        add(superior, BorderLayout.NORTH);
    }
}

class ResultSetModeloTabla extends AbstractTableModel {
    private ResultSet rs;
    private ResultSetMetaData rsmetadata;

    public ResultSetModeloTabla(ResultSet rs) {
        this.rs = rs;
        try {
            rsmetadata = this.rs.getMetaData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public int getRowCount() {
        try {
            rs.last();
            return rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        try {
            return rsmetadata.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rs.absolute(rowIndex + 1);
            return rs.getObject(columnIndex + 1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getColumnName(int c){
        try {
            return rsmetadata.getColumnName(c+1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
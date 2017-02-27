/**
Rodrigo Corona 15102
Daniel Morales 15526
GUI de la calculadora 
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Calculadora extends JFrame {

	private JPanel contentPane;
    private String expresion;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setTitle("La Calculadora Manca.");
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calculadora() {

	expresion = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(245, 245, 245));
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(null);


        JTextPane txtpnResultado = new JTextPane();
        txtpnResultado.setEditable(false);
        txtpnResultado.setText("Esperando ingreso de datos.");
        txtpnResultado.setBounds(12, 60, 200, 74);
        panelMain.add(txtpnResultado);


		JButton btnCargarArchivo = new JButton("Cargar Archivo");

		btnCargarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("./src"));
				fc.setDialogTitle("Seleccione su archivo");
				fc.setFileFilter(new FileNameExtensionFilter("Text files (.txt)", "txt"));
				if(fc.showOpenDialog(btnCargarArchivo) == JFileChooser.APPROVE_OPTION){
					try{

						byte [] in = Files.readAllBytes(Paths.get(fc.getSelectedFile().getAbsolutePath()));

						expresion = new String(in, Charset.defaultCharset());
					} catch(Exception j){
						j.printStackTrace();
					}
				}
			}
		});
		btnCargarArchivo.setBounds(224, 68, 196, 25);
		panelMain.add(btnCargarArchivo);
		

		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.setBounds(224, 109, 196, 25);
		panelMain.add(btnProcesar);


        btnProcesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double resultado = evaluar(expresion);
                if (resultado != null){
                    txtpnResultado.setText(resultado.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Expresion invalida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
		

		

		JLabel lblTitulo = new JLabel("LA CALCULADORA MANCA");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitulo.setBounds(83, 23, 257, 25);
		panelMain.add(lblTitulo);
		

		JTextPane tpnInstrucciones = new JTextPane();
		tpnInstrucciones.setBackground(new Color(220, 220, 220));
		tpnInstrucciones.setEditable(false);
		tpnInstrucciones.setFont(new Font("Dialog", Font.PLAIN, 11));
		tpnInstrucciones.setText("Instrucciones:\r\n1. De click en el bot\u00F3n \"Cargar Archivo\" y seleccione" +
				" su archivo con la expresi\u00F3n a evaluar. Solamente se admiten archivos con extensi\u00F3n" +
				" .txt\r\n2. De click en el bot\u00F3n \"Procesar\" y vea su resultado en el panel de la izquierda." +
				"\r\n\r\n2016. TEAM MANCO\r\n");
		tpnInstrucciones.setBounds(12, 146, 408, 99);
		panelMain.add(tpnInstrucciones);
	}


    public static Double evaluar(String expresionPOST){
        if (expresionPOST != null){

			Stack<Double>  stack= new StackVector<Double>();

            for (char c : expresionPOST.toCharArray()){
                try {

					if (c != ' ') {
                        switch (c) {
                            case '+': {
                                stack.push(stack.pop() + stack.pop());
                            }
                            break;
                            case '-': {
                                Double num1 = stack.pop();
                                Double num2 = stack.pop();
                                stack.push(num2 - num1);
                            }
                            break;
                            case '*': {
                                stack.push(stack.pop() * stack.pop());
                            }
                            break;
                            case '/': {
                                Double num1 = stack.pop();
                                Double num2 = stack.pop();
                                stack.push(num2 / num1);
                            }
                            break;

                            default: {

								if(c >= '0' && c <= '9') {
                                    Double num = Double.parseDouble(String.valueOf(c));
                                    stack.push(num);
                                }else{

									return null;
                                }
                            }
                        }
                    }
                }catch (Exception ex){

					return null;
                }
            }

            Double resultado = (stack.size() > 1) ?  null : stack.pop();
            return  resultado;

        }else{
            JOptionPane.showMessageDialog(null, "No ingreso una expresion", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
}
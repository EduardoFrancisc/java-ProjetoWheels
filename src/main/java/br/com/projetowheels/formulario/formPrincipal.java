package br.com.projetowheels.formulario;

import br.com.projetowheels.controles.Gravacao;
import br.com.projetowheels.controles.IssueBikeUI;
import br.com.projetowheels.controles.ReciboPDF;
import br.com.projetowheels.util.FiltroIntUtil;
import br.com.projetowheels.util.FiltroStringUtil;
import br.com.projetowheels.util.TextFieldUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class formPrincipal extends JDialog {
    private JComboBox bikenNum;
    private JTextField numeroDias;
    private JButton calcularCustoButton;
    private JTextField nomeDoCliente;
    private JTextField codigoPostal;
    private JTextField numeroTel;
    private JTextArea display;
    private JButton cancelarButton;
    private JButton alugar;
    private JPanel frame;

    public formPrincipal(JFrame parent) {
        super(parent);
        setLocationRelativeTo(null);
        setResizable(true);
        setTitle("WHEELS");
        setModal(true);
        setContentPane(frame);
        setLocationRelativeTo(parent);
        setSize(600, 600);

//      DESIGN DA BORDA DOS TextField
        nomeDoCliente.setBorder(new TextFieldUtil());
        codigoPostal.setBorder(new TextFieldUtil());
        numeroDias.setBorder(new TextFieldUtil());
        numeroTel.setBorder(new TextFieldUtil());


//      VALIDAÇÕES
        numeroDias.setDocument(new FiltroIntUtil());
        nomeDoCliente.setDocument(new FiltroStringUtil());
        codigoPostal.setDocument(new FiltroIntUtil());
        numeroTel.setDocument(new FiltroIntUtil());

        IssueBikeUI ui = new IssueBikeUI();

        calcularCustoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Verifica se os campos estão em branco
                Object comboSelecionado = bikenNum.getSelectedItem();
                if (!comboSelecionado.equals("") & !numeroDias.getText().isBlank()) {

                    //Converções
                    String stringDoCombo = (String) comboSelecionado;
                    int bikeId = Integer.parseInt(stringDoCombo);
                    String StringDiasAluguel = numeroDias.getText();
                    int IntDiasAluguel = Integer.parseInt(StringDiasAluguel);

                    //Calculo do aluguel
                    display.setText(ui.mostrarDetalhesDaBicicleta(bikeId) + "\n" + ui.calcularCusto(IntDiasAluguel));

                } else {
                    //Alerta de Erro
                    JOptionPane.showMessageDialog(parent, "Preencha os Campos para Calcular o Aluguel.", "Tente Novamente", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        alugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object comboSelecionado = bikenNum.getSelectedItem();
                //Verifica se algum campo está em branco e codigoPostal = 8 e telefone = 11
                if (!comboSelecionado.equals("") && !numeroDias.getText().isBlank() && !nomeDoCliente.getText().isBlank() && !codigoPostal.getText().isBlank() && codigoPostal.getText().length() == 8 && !numeroTel.getText().isBlank() && numeroTel.getText().length() == 11) {

                    String stringNumeroTel = numeroTel.getText();
                    long IntNumeroTel = Long.parseLong(stringNumeroTel);

                    String StringDiasAluguel = numeroDias.getText();
                    int IntDiasAluguel = Integer.parseInt(StringDiasAluguel);

                    String stringDoCombo = (String) comboSelecionado;

                    display.setText("\n NOME: " + nomeDoCliente.getText() + "\n CÓDIGO POSTAL: " + codigoPostal.getText() + "\n TELEONE: " + IntNumeroTel);

                    //Criação do cliente
                    ui.criarCliente(nomeDoCliente.getText(), codigoPostal.getText(), IntNumeroTel);

                    display.setText(ui.calcularPagamentoTotal() + "\n" + ui.calcularCusto(IntDiasAluguel));

                    Object[] opcoes = {"Arquivo CSV", "PDF"};

                    int resultado = JOptionPane.showOptionDialog(null, "Como deseja Salvar o Recibo?", "Salvar Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

                    switch (resultado) {
                        case 0:
                            List<String> dados = Arrays.asList(
                                    nomeDoCliente.getText(),
                                    stringDoCombo,
                                    StringDiasAluguel,
                                    ui.calcularCusto(IntDiasAluguel).substring(18),
                                    codigoPostal.getText(),
                                    stringNumeroTel
                            );
                            Gravacao.SalvarEmArquivo(nomeDoCliente.getText(), dados);
                            limparSessoes();
                            break;

                        case 1:
                            //PDF
                            ReciboPDF reciboPDF = new ReciboPDF(stringDoCombo, ui.calcularCusto(IntDiasAluguel).substring(18), StringDiasAluguel, nomeDoCliente.getText(), codigoPostal.getText());
                            reciboPDF.gerarNotaFiscal("arquivos/"+nomeDoCliente.getText() + "Recibo.pdf");
                            limparSessoes();
                            break;

                        default:
                            System.out.println("Nenhum botão pressionado");
                            break;
                    }
                } else {
                    //Alerta de Erro
                    JOptionPane.showMessageDialog(parent, "Preencha os Campos Corretamente.", "Tente Novamente", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikenNum.setSelectedItem("");
                numeroDias.setText("");
                nomeDoCliente.setText("");
                codigoPostal.setText("");
                numeroTel.setText("");
                display.setText("");
            }
        });

        setVisible(true);
    }
    private void limparSessoes(){
        bikenNum.setSelectedItem("");
        numeroDias.setText("");
        nomeDoCliente.setText("");
        codigoPostal.setText("");
        numeroTel.setText("");
        display.setText("");
    }
}
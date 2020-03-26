package janela;
import java.awt.FlowLayout;
import java.beans.PropertyVetoException;
import javax.swing.*;

/**
 *
 * @author msouza
 */
public class GerenciadorDeJanelas {

    private static GerenciadorDeJanelas instancia;

    private JDesktopPane areaDeTrabalho;
    private JTextField numFrame;

    GerenciadorDeJanelas() {
    }

    public static synchronized GerenciadorDeJanelas getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorDeJanelas();
            System.out.println("[INFO]: INSTANCIOU O GERENCIADOR");
        } else {
            System.out.println("[INFO]: RETORNOU INSTÂNCIA EXISTENTE");
        }
        return instancia;
    }

    public void executar() {
        final JFrame janelaPrincipal = new JFrame("Gerenciador de Janelas");
        janelaPrincipal.setBounds(100, 100, 800, 600);
        janelaPrincipal.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        areaDeTrabalho = new JDesktopPane();
        areaDeTrabalho.add(montarPainel());

        adicionarJanela("1");

        janelaPrincipal.setContentPane(areaDeTrabalho);
        janelaPrincipal.setVisible(true);
    }

    private JInternalFrame montarPainel() {
        final JPanel painel = new JPanel(new FlowLayout());
        numFrame = new JTextField(6);
        final JButton addFrameButton = new JButton("Adicionar Janela");
        painel.add(new JLabel("ID da Janela:"));
        painel.add(numFrame);
        painel.add(addFrameButton);

        numFrame.addActionListener(actionEvent -> adicionarJanela());
        addFrameButton.addActionListener(actionEvent -> adicionarJanela());

        final JInternalFrame controlFrame = new JInternalFrame("Adicionar Nova Janela Interna");
        controlFrame.add(painel);
        controlFrame.setBounds(10, 10, 760, 90);
        controlFrame.setVisible(true);

        return controlFrame;
    }

    private void adicionarJanela() {
        adicionarJanela(numFrame.getText());
    }

    private void adicionarJanela(final String numFrame) {
        final String titulo = "Janela " + numFrame;

        JInternalFrame janelaExistente = null;
        for (final JInternalFrame janela : areaDeTrabalho.getAllFrames()) {
            if (titulo.equals(janela.getTitle())) {
                janelaExistente = janela;
                janelaExistente.setClosable(true);
                janelaExistente.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                break;
            }
        }

        if (janelaExistente != null) {
            try {
                janelaExistente.setSelected(true);
            } catch (final PropertyVetoException e) {
            }
        } else {
            final int numeroDeJanelas = areaDeTrabalho.getAllFrames().length;
            final JInternalFrame janela = new JInternalFrame(titulo);
            janela.setBounds(20 * numeroDeJanelas, 110 + 40 * numeroDeJanelas, 400, 200);
            janela.setVisible(true);
            janela.setClosable(true);
            janela.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            areaDeTrabalho.add(janela);
            janela.moveToFront();
        }
    }
    
}